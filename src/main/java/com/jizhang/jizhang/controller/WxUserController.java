package com.jizhang.jizhang.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jizhang.jizhang.utils.UUIDS;
import com.jizhang.jizhang.utils.WxUtils;
import com.jizhang.jizhang.utils.Result;
import com.jizhang.jizhang.utils.ResultGenerator;
import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.service.WxUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 代码生成器 on 2019/03/08.
 */
@RestController
@RequestMapping("/user")
public class WxUserController {
    private final Logger log = LoggerFactory.getLogger(WxUserController.class);
    @Resource
    private WxUserService wxUserService;

    @PostMapping("/add")
    public Result add(WxUser wxUser) {
        wxUserService.save(wxUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        wxUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WxUser wxUser) {
        wxUserService.update(wxUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WxUser wxUser = wxUserService.findById(id);
        return ResultGenerator.genSuccessResult(wxUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WxUser> list = wxUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/login")
    public Result doLogin(@RequestParam String code,
                          @RequestParam String rawData,
                          @RequestParam String signature,
                          @RequestParam String encrypteData,
                          @RequestParam String iv) throws Base64DecodingException {
        log.info( "Start get SessionKey" );
        Map<String,Object> map = new HashMap<String, Object>(  );
        System.out.println("用户非敏感信息"+rawData);
        JSONObject rawDataJson = JSON.parseObject( rawData );
        System.out.println("签名"+signature);
        JSONObject SessionKeyOpenId = WxUtils.getSessionKeyOrOpenId( code );
        System.out.println("post请求获取的SessionAndopenId="+SessionKeyOpenId);
        String openid = SessionKeyOpenId.getString("openid" );
        String sessionKey = SessionKeyOpenId.getString( "session_key" );
        System.out.println("openid="+openid+",session_key="+sessionKey);
        //Condition condition = new Condition(WxUser.class);
        //condition.createCriteria().andCondition("id ="+"'"+openid+"'");
        //condition.setOrderByClause("createtime desc");
        //List<WxUser> list =  wxUserService.findByCondition( condition );
        WxUser user = wxUserService.getUser(openid);
        //uuid生成唯一key
        String skey = UUID.randomUUID().toString();

        WxUser wxUser=new WxUser();
        if(user==null){
            //入库
            String nickName = rawDataJson.getString( "nickName" );
            String avatarUrl = rawDataJson.getString( "avatarUrl" );
            String gender  = rawDataJson.getString( "gender" );
            String city = rawDataJson.getString( "city" );
            String country = rawDataJson.getString( "country" );
            String province = rawDataJson.getString( "province" );

            wxUser.setNickname(nickName);
            wxUser.setGender(Integer.parseInt(gender));
            wxUser.setCity(city);
            wxUser.setCountry(country);
            wxUser.setProvince(province);
            wxUser.setAvatarurl(avatarUrl);
            wxUser.setCtime(UUIDS.getDateTime());
            wxUser.setOpenid(openid);
            wxUser.setId(UUIDS.getDateUUID());
            System.out.println(UUIDS.getDateUUID());
            wxUserService.save(wxUser);
        }else {
            //已存在
            log.info( "用户openid已存在,不需要插入" );
            Condition condition = new Condition(WxUser.class);
            condition.createCriteria().andCondition("openid ="+"'"+openid+"'");
            //condition.setOrderByClause("createtime desc");
            List list = wxUserService.findByCondition( condition );
            wxUser= (WxUser) list.get(0);
        }
        /*//根据openid查询skey是否存在
        String skey_redis = (String) redisTemplate.opsForValue().get( openid );
        if(StringUtils.isNotBlank( skey_redis )){
            //存在 删除 skey 重新生成skey 将skey返回
            redisTemplate.delete( skey_redis );

        }
        //  缓存一份新的
        JSONObject sessionObj = new JSONObject(  );
        sessionObj.put( "openId",openid );
        sessionObj.put( "sessionKey",sessionKey );
        redisTemplate.opsForValue().set( skey,sessionObj.toJSONString() );
        redisTemplate.opsForValue().set( openid,skey );
*/
        //把新的sessionKey和oppenid返回给小程序
        map.put( "skey",skey );
        JSONObject userInfo = WxUtils.getUserInfo( encrypteData, sessionKey, iv );
        System.out.println("根据解密算法获取的userInfo="+userInfo);
        map.put( "userInfo",wxUser);
        System.out.println(encrypteData);
        return ResultGenerator.genSuccessResult(map);
    }
    @PostMapping("/dologin")
    public Result login(@RequestParam String code){
        JSONObject SessionKeyOpenId = WxUtils.getSessionKeyOrOpenId( code );
        System.out.println("post请求获取的SessionAndopenId="+SessionKeyOpenId);
        String openid = SessionKeyOpenId.getString("openid" );
        Condition condition = new Condition(WxUser.class);
        condition.createCriteria().andCondition("openid ="+"'"+openid+"'");
        //condition.setOrderByClause("createtime desc");
        List user = wxUserService.findByCondition( condition );
        return ResultGenerator.genSuccessResult(user.get(0));
    }
}

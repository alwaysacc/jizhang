package com.jizhang.jizhang.model;

import javax.persistence.*;

@Table(name = "wx_user")
public class WxUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 小程序用户openid
     */
    private String openid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatarurl;

    /**
     * 性别   0 男  1  女  2 人妖
     */
    private int gender;

    /**
     * 所在国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    private String language;

    /**
     * 创建时间
     */
    private String ctime;

    /**
     * 手机类型
     */
    private String mobile;

    /**
     * 手机号码
     */
    private String telnum;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取小程序用户openid
     *
     * @return openid - 小程序用户openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置小程序用户openid
     *
     * @param openid 小程序用户openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取用户头像
     *
     * @return avatarurl - 用户头像
     */
    public String getAvatarurl() {
        return avatarurl;
    }

    /**
     * 设置用户头像
     *
     * @param avatarurl 用户头像
     */
    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    /**
     * 获取性别   0 男  1  女  2 人妖
     *
     * @return gender - 性别   0 男  1  女  2 人妖
     */
    public int getGender() {
        return gender;
    }

    /**
     * 设置性别   0 男  1  女  2 人妖
     *
     * @param gender 性别   0 男  1  女  2 人妖
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获取所在国家
     *
     * @return country - 所在国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置所在国家
     *
     * @param country 所在国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取创建时间
     *
     * @return ctime - 创建时间
     */
    public String getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime 创建时间
     */
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取手机类型
     *
     * @return mobile - 手机类型
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机类型
     *
     * @param mobile 手机类型
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取手机号码
     *
     * @return telnum - 手机号码
     */
    public String getTelnum() {
        return telnum;
    }

    /**
     * 设置手机号码
     *
     * @param telnum 手机号码
     */
    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }
}

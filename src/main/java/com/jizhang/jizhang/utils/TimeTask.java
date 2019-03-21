package com.jizhang.jizhang.utils;

import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.service.IncomeOutlayService;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TimeTask {
    private final Logger log = LoggerFactory.getLogger(TimeTask.class);
    @Autowired
    private SolrUtils solrUtils;
    @Resource
    private IncomeOutlayService incomeOutlayService;
    //定时更新solr索引
    @Scheduled(cron = "10 * * * * ?")
    public void timer() throws Exception {
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        //输出当前时间
        log.info("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //调用删除索引的方法
        solrUtils.deleteAll();
        Thread.sleep(5000);
        //调用数据新增到索影库的方法
        //先去数据库查数据
        List<IncomeOutlay> list = incomeOutlayService.findAll();
        for (IncomeOutlay items : list) {
            SolrInputDocument document = new SolrInputDocument();
            //创建文档对象
            //添加域
            System.out.println(items);
            document.addField("id",items.getId().toString());
            document.addField("amount", items.getAccount().toString());
            document.addField("address", items.getAddress());
            document.addField("category", items.getCategory());
            document.addField("userId", items.getUserid());
            document.addField("remarks", items.getRemarks());
            solrUtils.save(document);
        }
        log.info("索引已更新");
    }
}

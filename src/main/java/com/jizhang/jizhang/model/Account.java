package com.jizhang.jizhang.model;

import java.math.BigDecimal;
import javax.persistence.*;

public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal money;

    private BigDecimal bank;

    private BigDecimal credit;

    private BigDecimal alipay;

    private BigDecimal huabei;

    @Column(name = "WeChat")
    private BigDecimal wechat;

    private BigDecimal jingdong;

    private BigDecimal other;
    @Id
    private String userid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * @return bank
     */
    public BigDecimal getBank() {
        return bank;
    }

    /**
     * @param bank
     */
    public void setBank(BigDecimal bank) {
        this.bank = bank;
    }

    /**
     * @return credit
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * @param credit
     */
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    /**
     * @return alipay
     */
    public BigDecimal getAlipay() {
        return alipay;
    }

    /**
     * @param alipay
     */
    public void setAlipay(BigDecimal alipay) {
        this.alipay = alipay;
    }

    /**
     * @return huabei
     */
    public BigDecimal getHuabei() {
        return huabei;
    }

    /**
     * @param huabei
     */
    public void setHuabei(BigDecimal huabei) {
        this.huabei = huabei;
    }

    /**
     * @return WeChat
     */
    public BigDecimal getWechat() {
        return wechat;
    }

    /**
     * @param wechat
     */
    public void setWechat(BigDecimal wechat) {
        this.wechat = wechat;
    }

    /**
     * @return jingdong
     */
    public BigDecimal getJingdong() {
        return jingdong;
    }

    /**
     * @param jingdong
     */
    public void setJingdong(BigDecimal jingdong) {
        this.jingdong = jingdong;
    }

    /**
     * @return other
     */
    public BigDecimal getOther() {
        return other;
    }

    /**
     * @param other
     */
    public void setOther(BigDecimal other) {
        this.other = other;
    }

    /**
     * @return userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
}

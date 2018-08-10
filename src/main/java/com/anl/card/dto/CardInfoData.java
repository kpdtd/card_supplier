package com.anl.card.dto;

/**
 * Created by LianZhiFei on 17/12/8.
 */
public class CardInfoData {

    private String msisdn; // 卡号
    private String iccid;
    private String imsi;
    private String imei;
    private String mobile; //终端用户手机号码
    private String meals; // 套餐信息
    private String flow; // 套餐流量 单位:KB
    private String activationdate; // 开卡日期
    private String testenddate; // 测试截止日期
    private String silenceenddate; // 沉默截止日期
    private String billingcycle; // 计费周期单位:月
    private String billingdate; // 套餐生效日期
    private String billingenddate; // 套餐失效日期
    private String paytype; //1:统付 2:个付

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getActivationdate() {
        return activationdate;
    }

    public void setActivationdate(String activationdate) {
        this.activationdate = activationdate;
    }

    public String getTestenddate() {
        return testenddate;
    }

    public void setTestenddate(String testenddate) {
        this.testenddate = testenddate;
    }

    public String getSilenceenddate() {
        return silenceenddate;
    }

    public void setSilenceenddate(String silenceenddate) {
        this.silenceenddate = silenceenddate;
    }

    public String getBillingcycle() {
        return billingcycle;
    }

    public void setBillingcycle(String billingcycle) {
        this.billingcycle = billingcycle;
    }

    public String getBillingdate() {
        return billingdate;
    }

    public void setBillingdate(String billingdate) {
        this.billingdate = billingdate;
    }

    public String getBillingenddate() {
        return billingenddate;
    }

    public void setBillingenddate(String billingenddate) {
        this.billingenddate = billingenddate;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

	@Override
    public String toString() {
	    return "CardInfoData [msisdn=" + msisdn + ", iccid=" + iccid + ", imsi=" + imsi + ", imei=" + imei + ", mobile=" + mobile + ", meals=" + meals + ", flow=" + flow + ", activationdate=" + activationdate + ", testenddate=" + testenddate + ", silenceenddate=" + silenceenddate + ", billingcycle=" + billingcycle + ", billingdate=" + billingdate + ", billingenddate=" + billingenddate + ", paytype=" + paytype + "]";
    }
    
}

package com.sup.pack.dto;

/**
 * Created by yangyiqiang on 2018/8/20.
 * 调用上游接口通用请求数据
 */
public class SupplierReqData {

    private  String seqId;//序列号,执行接口结果异步查询时使用
    //卡相关
    private Integer cardId;
    private String iccid;
    private String msisdn;
    private String imsi;
    private Integer cardState;
    //上游接口相关
    private String signKey;
    private String invokeToken;
    private String ecCode;
    private String ecExtensionInfo;
    //接口执行相关
    private String interfaceInfo;
    private String className;
    private String url;
    private  String action;//执行动作,接口细分时用到,比如"开机|关机"

    //private String operateInfo;//接口操作说明,在上游接口调用时可能作为参数之一

    //流量相关
    private  String month;//查询月份,默认为当前月.
    private Integer usedFlow;//该用户当前月已经使用的流量,为null说明没有使用,流量查询时必填.

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Integer getCardState() {
        return cardState;
    }

    public void setCardState(Integer cardState) {
        this.cardState = cardState;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public String getInvokeToken() {
        return invokeToken;
    }

    public void setInvokeToken(String invokeToken) {
        this.invokeToken = invokeToken;
    }

    public String getEcCode() {
        return ecCode;
    }

    public void setEcCode(String ecCode) {
        this.ecCode = ecCode;
    }

    public String getEcExtensionInfo() {
        return ecExtensionInfo;
    }

    public void setEcExtensionInfo(String ecExtensionInfo) {
        this.ecExtensionInfo = ecExtensionInfo;
    }

    public String getInterfaceInfo() {
        return interfaceInfo;
    }

    public void setInterfaceInfo(String interfaceInfo) {
        this.interfaceInfo = interfaceInfo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public String getOperateInfo() {
//        return operateInfo;
//    }
//
//    public void setOperateInfo(String operateInfo) {
//        this.operateInfo = operateInfo;
//    }

    public Integer getUsedFlow() {
        return usedFlow;
    }

    public void setUsedFlow(Integer usedFlow) {
        this.usedFlow = usedFlow;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

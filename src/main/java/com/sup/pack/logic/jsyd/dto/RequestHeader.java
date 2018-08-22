package com.sup.pack.logic.jsyd.dto;

import com.sup.pack.util.DateUtil;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author lianzf
 * @Description:
 * @date 18/4/13下午2:34
 */
@XmlRootElement(name = "operation_in")
@XmlAccessorType( XmlAccessType.FIELD)
@XmlSeeAlso({CardFlowRequestData.class, CardInfoRequestData.class, CardSwitchData.class, ResultData.class, CardAttachData.class, CardTestEndData.class, CardCycleData.class,CardPoolRequestData.class})
public class RequestHeader implements Serializable {
    /**
     * 接口服务名
     * 必须填写,对应业务报文定义中“业务功能代码”
     */
    @XmlElement(name = "process_code")
    private String processCode;

    @XmlElement(name = "log_debug")
    private String logDebug = "4";
    /**
     * 应用标识
     * 向移动省公司申请分配
     */
    @XmlElement(name = "app_id")
    private String appId = "109000000224";
    /**
     * 令牌
     * 通过令牌申请接口获得
     */
    @XmlElement(name = "access_token")
    private String accessToken = "vjU47Schsh1fL2D7oSql";
    /**
     * 签名信息
     * 暂时不用，填空
     */
    @XmlElement(name = "sign")
    private String sign = "";
    /**
     * 验证码
     * 填空
     */
    @XmlElement(name = "verify_code")
    private String verifyCode = "";
    /**
     * 请求类型
     * 必须填写,对应业务报文定义中“请求类型”
     * 查询  01  查询不涉及数据变更
     * 交易  02  业务涉及到数据变更
     */
    @XmlElement(name = "req_type")
    private Integer reqType = 1;
    /**
     * 终端标识
     * 填写设备终端号或用户账号或操作员ID
     * 可填空
     */
    @XmlElement(name = "terminal_id")
    private String terminalId = "";
    /**
     * 业务流水号
     * 业务流水,唯一
     * 查询类业务，填空
     */
    @XmlElement(name = "accept_seq")
    private String acceptSeq = "";
    /**
     * 请求流水号
     * 本次调用请求流水.
     */
    @XmlElement(name = "req_seq")
    private String reqSeq;
    /**
     * 请求时间
     * YYYYMMDDHH24MISS
     */
    @XmlElement(name = "req_time")
    private String reqTime = DateUtil.getCurDateTime(DateUtil.DATE_FORMAT_COMPACTFULL);
    /**
     * 请求内容
     * XML格式的字符串
     * 参考业务接口定义
     */
    @XmlMixed
    private Object content;

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getReqType() {
        return reqType;
    }

    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAcceptSeq() {
        return acceptSeq;
    }

    public void setAcceptSeq(String acceptSeq) {
        this.acceptSeq = acceptSeq;
    }

    public String getReqSeq() {
        return reqSeq;
    }

    public void setReqSeq(String reqSeq) {
        this.reqSeq = reqSeq;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public Object getContent() {
        return content;
    }

    public String getLogDebug() {
        return logDebug;
    }

    public void setLogDebug(String logDebug) {
        this.logDebug = logDebug;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}

package com.yl.ms.utils.qiyeweixinchat;

/**
 * @author yl on 2021/6/21
 */
public class WeChatData {
    //发送微信消息的URLString sendMsgUrl="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
    /**
     * 成员账号
     */
    private String touser;

    /**
     * 消息类型
     */
    private String msgtype;

    /**
     * 企业用用的agentid
     */
    private String agentid;

    /**
     * 十几接收map类型数据
     */
    private Object text;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }

}

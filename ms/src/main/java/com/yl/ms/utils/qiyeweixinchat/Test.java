package com.yl.ms.utils.qiyeweixinchat;

/**
 * @author yl on 2021/6/21
 */
public class Test {

    public static void main(String[] args) {
        WeChatMsgSend swx = new WeChatMsgSend();
        try {
            String token = swx.getToken("wwbeba9fd61e5adb5a","oocI8kOTvQhS6JcQHyX86hEuifH-F4yq0eFsMGBZf0Y");
            String postdata = swx.createpostdata("YangLei", "text", 1000002, "content","这是一条测试信息");
            String resp = swx.post("utf-8", "Content-Type",(new WeChatUrlData()).getSendMessage_Url(), postdata, token);
            System.out.println("获取到的token======>" + token);
            System.out.println("请求数据======>" + postdata);
            System.out.println("发送微信的响应数据======>" + resp);
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}

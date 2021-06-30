package com.yl.ms.utils.weixinChat;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author yl on 2021/6/21
 */
public class SendWechat {

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 单独给用户发消息（新版）- 推荐
     * @param title
     * @param content
     * @param remark
     * @throws Exception
     */
    public static void sendMsg(String title, String content, String remark) {
        // 创建一个httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建一个post对象
        HttpPost post = new HttpPost("http://jy.erpit.cn/api/message/send");
        // 创建一个Entity，模拟表单数据
        List<NameValuePair> formList = new ArrayList<NameValuePair>();
        // 添加表单数据
        formList.add(new BasicNameValuePair("secret", "2f149a1156d04a84c504a6c833665e01"));
        formList.add(new BasicNameValuePair("app_key", "37fd13a6517a9ae647baf68861c1af0d"));
        formList.add(new BasicNameValuePair("template_id", "RV-jBDQSNen0J92hKn5GGE4id6We5Xu2vDgpbXbWe2I"));

        JSONObject obj = new JSONObject();
        JSONObject firstObj = new JSONObject();
        firstObj.put("value", title);
        obj.put("first", firstObj);
        JSONObject remarkObj = new JSONObject();
        remarkObj.put("value", remark);
        obj.put("remark", remarkObj);


        JSONObject keyword1Obj = new JSONObject();
        keyword1Obj.put("value", title);
        obj.put("keyword1", keyword1Obj);

        JSONObject keyword2Obj = new JSONObject();
        keyword2Obj.put("value", "统一监管系统");
        obj.put("keyword2", keyword2Obj);

        JSONObject keyword3Obj = new JSONObject();
        keyword3Obj.put("value", "监管监控人员");
        obj.put("keyword3", keyword3Obj);

        JSONObject keyword4Obj = new JSONObject();
        keyword4Obj.put("value", content);
        obj.put("keyword4", keyword4Obj);

        JSONObject keyword5Obj = new JSONObject();
        keyword5Obj.put("value", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
        obj.put("keyword5", keyword5Obj);

        formList.add(new BasicNameValuePair("data", obj.toString()));
        System.out.println( obj.toString());
        try {
            // 包装成一个Entity对象
            StringEntity entity = new UrlEncodedFormEntity(formList, "utf-8");
            // 设置请求的内容
            post.setEntity(entity);
            // 设置请求的报文头部的编码
            // post.setHeader(new BasicHeader("Content-Type",
            // "application/x-www-form-urlencoded; charset=utf-8"));
            // 设置期望服务端返回的编码
            // post.setHeader(new BasicHeader("Accept",
            // "text/plain;charset=utf-8"));
            // 执行post请求
            CloseableHttpResponse response = client.execute(post);
            // 获取响应码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // 获取数据
                String resStr = EntityUtils.toString(response.getEntity());
                // 输出
                System.out.println(resStr);
            } else {
                // 输出
                System.out.println(statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        sendMsg("增量数据未及时报送通知", "今日增量数据还未报送，请及时报送", "备注");
    }
}

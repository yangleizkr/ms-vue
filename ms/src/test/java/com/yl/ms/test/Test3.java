package com.yl.ms.test;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author yl on 2021/6/11
 */
public class Test3 {

    @Test
    public void test1(){
        Properties p = new Properties();

        // 加载classpath目录下的vm文件
        p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // 定义字符集
        p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UFT-8");
        // 初始化Velocity引擎，指定配置Properties
        Velocity.init(p);
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("packageName","com.yl.ms");
        velocityContext.put("ClassName","SysUser");
        velocityContext.put("className","sysUser");
        velocityContext.put("classMapping","sys_user");

        List<String> templates = new ArrayList<>();
        templates.add("/vm/java/entity.java.vm");
        templates.add("/vm/java/service.java.vm");
        templates.add("/vm/java/service.impl.java.vm");
        templates.add("/vm/java/controller.java.vm");

        for(String template : templates){
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template,"UTF-8");
            tpl.merge(velocityContext, sw);
            System.out.println(sw.toString());
            IOUtils.closeQuietly(sw);

        }

    }
}

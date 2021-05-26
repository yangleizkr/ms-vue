package com.yl.ms.test;

import cn.hutool.system.SystemUtil;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author yl on 2021/3/22
 */
public class Test1 {

    private int count = 10;
    private Object object = new Object();
    List<String> list = new ArrayList<>();
    @Before
    public void test1() {
        System.out.println(SystemUtil.getHostInfo());
    }

    @Test
    public void test2() {
        double db = 900000000.22;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        System.out.println(nf.format(db));



        if (System.out.printf("true") == null){

        }else{
            System.out.println("");
            System.out.println("false");
        }

    }

    @Test
    public void test3(){
        synchronized (object){
            count--;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "  count =" + count);
        }
    }
    @Test
    public void test4(){
        count--;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  count =" + count);
    }
    @Test
    public void test5() {
        synchronized (object){
            if (list.contains("Tom")){
                System.out.println(Thread.currentThread().getName()+"Tom已存在");
            }else {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("Tom");
                System.out.println(Thread.currentThread().getName()+"Tom添加成功");
            }
        }
    }

    @Test
    public void test6() {
        if (list.contains("Tom")){
            System.out.println(Thread.currentThread().getName()+"已存在");
        }else {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("Tom");
            System.out.println(Thread.currentThread().getName()+"添加成功");
        }
    }
    @Test
    public void test7() {
        synchronized (object) {
            if (list.contains("Tom1")) {
                System.out.println(Thread.currentThread().getName() + "Tom1已存在");
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("Tom1");
                System.out.println(Thread.currentThread().getName() + "Tom1添加成功");
            }
        }
    }

    public void test(String s){
        System.out.println(s);
    }

    public static void main1(String[] args) {
        Test1 test1 = new Test1();

        List<String> list = Arrays.asList("1", "1", "232", "3453");
        HashMap<String,String> map = new HashMap<>(16);
        map.put("1", "Tome");
        map.put("2", "Jone");
        map.put("3", "Sir");
        list.forEach(System.out::println);
        list.stream().distinct().forEach(System.out::println);
        map.forEach((k,v)->{
            System.out.println("k"+k);
            System.out.println("v"+v);
        });





/*
        for (int i = 0; i < 150; i++) {
            new Thread(test1::test5,"test"+i).start();
            new Thread(test1::test7,"test"+i).start();
        }*/
    }

    @Test
    public void test434(){
        System.out.println(ExcelDoubleToDate("43481") + "  " +"43481");
        System.out.println(ExcelDoubleToDate("43709") + "  " +"43709");

    }

    public static String ExcelDoubleToDate(String strDate) {
        if(strDate.length() == 5){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date tDate = DoubleToDate(Double.parseDouble(strDate));
                return sdf.format(tDate);
            }catch (Exception e){
                e.printStackTrace();
                return strDate;
            }
        }
        return strDate;
    }

    public static Date DoubleToDate(Double dVal) {
        Date tDate = new Date();
        long localOffset = tDate.getTimezoneOffset() * 60000; //系统时区偏移 1900/1/1 到 1970/1/1 的 25569 天
        tDate.setTime((long) ((dVal - 25569) * 24 * 3600 * 1000 + localOffset));

        return tDate;
    }

    @Test
    public void test8() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("123");
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        System.out.println("123123");
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        test.test8();
    }
}

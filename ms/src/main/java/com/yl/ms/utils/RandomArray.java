package com.yl.ms.utils;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;

/**
 * @author yl on 2021/6/2
 */
public class RandomArray {

    public static int[] randomIntArray(int length,int maxInt){
        Instant start = Instant.now();

        int[] ints = new int[length];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            ints[i] = random.nextInt(maxInt);
        }
        Instant end = Instant.now();
        System.out.println("生成随机数组耗费时间"+ Duration.between( start,end ).toMillis()/1000 + "秒");
        return ints;
    }
}

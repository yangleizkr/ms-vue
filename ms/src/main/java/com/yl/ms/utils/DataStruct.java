package com.yl.ms.utils;

import java.time.Duration;
import java.time.Instant;

/**
 * @author yl on 2021/6/2
 * 数据结构
 */
public class DataStruct {
    private static int length = 1000000;
    private static int maxInt = 2000000;
    private static int[] ints = RandomArray.randomIntArray(length,maxInt);


    public static void main(String[] args) {
        DataStruct dataStruct = new DataStruct();
        Instant start = Instant.now();
/*
        int[] maopao = dataStruct.maopao();
*/

        dataStruct.quicksort(0,length-1);
        for (int i = 0; i < length; i++) {
            System.out.println(ints[i]);
        }
        Instant end = Instant.now();
        System.out.println("耗费时间"+ Duration.between( start,end ).toMillis()/1000 + "秒");


    }

    /**
     * 冒泡排序 耗费时间18秒
     * @return
     */
    public int[] maopao(){
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (ints[i] > ints[j]){
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        return ints;
    }

    /**
     * 桶排序
     * @return
     */
    public int[] bucketSort(){

        return ints;
    }

    /**
     * 快排牛逼
     * @param left
     * @param right
     */
    public void quicksort(int left ,int right){
        int i,j,t,temp;
        if (left > right){
            return;
        }
        temp = ints[left];
        i = left;
        j = right;
        while (i != j){
            while (ints[j] >=temp && i < j){
                j--;
            }
            while (ints[i] <=temp && i<j){
                i++;
            }
            if (i < j){
                t = ints[i];
                ints[i] = ints[j];
                ints[j] = t;
            }
        }
        ints[left] = ints[i];
        ints[i] = temp;
        quicksort(left,i-1);
        quicksort(i+1,right);

    }
}

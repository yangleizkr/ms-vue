package com.yl.ms.utils;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * @author yl on 2021/6/25
 */
public class MyHashMap<K,V> {


    NodeList<K,V>[] tables = new NodeList[32];

    static class NodeList<K,V>{
        int hash;
        K key;
        V value;
        NodeList<K,V> pre;
        NodeList<K,V> next;

        public NodeList(int hash,K key,V value,NodeList<K,V> pre,NodeList<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        public V setValue(V newValue){
            V oldValue = value;
            value = newValue;
            return value;
        }

    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("123","123123");
        map.put("测试","测试2");
        map.put("测试1","测试21");
        map.put("测试2","测试22");
        map.put("测试3","测试23");
        map.put("测试4","测试24");
        map.put("测试5","测试25");
        map.put("测试6","测试26");
        map.put("测试7","测试27");
        map.delK("测试3");
        System.out.println(map.getV("123"));
        System.out.println(map.getV("测试"));
        System.out.println(map.getV("测试1"));
        System.out.println(map.getV("测试2"));
        System.out.println(map.getV("测试3"));
        System.out.println(map.getV("测试4"));
        System.out.println(map.getV("测试5"));
        System.out.println(map.getV("测试6"));
        System.out.println(map.getV("测试7"));

    }

    public int hash(K key){
        byte[] bytes = DigestUtil.md5(key.toString());
        for (int i = 0; i < bytes.length-1; i++) {
            bytes[i+1] += bytes[i] /16 ;
        }
        bytes[15] = (byte) (bytes[14]/16+ bytes[15]);
        int hash = bytes[15]/16+16;
        return hash;
    }
    public void put(K key, V value){
        int hash = hash(key);
        NodeList<K,V> tab = new NodeList<K,V>(hash,key,value,null,null);

        if (tables[hash] == null ){
            tables[hash] = new NodeList<K,V>(hash,key,value,null,null);
        }else {
            tables[hash].next = tab;
            tab.pre = tables[hash];
        }
    }

    public V getV(K key){
        int hash = hash(key);
        if (tables[hash] == null){
            System.out.println("key:"+key+"不存在");
            return null;
        }else{
            if (key.equals(tables[hash].getKey())){
                return tables[hash].getValue();
            }else {
                return getV(tables[hash].next,key);
            }
        }
    }

    public V getV(NodeList nodeList,K key){
        if (nodeList == null){
            System.out.println("Key:"+key+"不存在");
            return null;
        }
        if (key.equals(nodeList.getKey())){
            return (V) nodeList.getValue();
        }else {
            return getV(nodeList.next,key);
        }
    }

    public void delK(K key){
        int hash = hash(key);
        if (tables[hash] == null) {
            System.out.println("待删除的KEY不存在");
        }else{
            if (key.equals(tables[hash].getKey())){
                tables[hash] = null;
            }else {
                delK(tables[hash].next,key);
            }
        }
    }

    private void delK(NodeList nodeList,K key){
        if (key.equals(nodeList.getKey())){
            nodeList.pre.next = null;

        }else {
            delK(nodeList.next,key);
        }
    }

}

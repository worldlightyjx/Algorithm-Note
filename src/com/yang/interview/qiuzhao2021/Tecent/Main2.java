package com.yang.qiuzhao2021.Tecent;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i <str.length() ; i++) {
            for (int j = i+1; j <=str.length() ; j++) {
                String subStr = str.substring(i,j);
                if(set.size()==k){
                    if(!set.contains(subStr)&&subStr.compareTo(set.last())<0){
                        set.remove(set.last());
                        set.add(subStr);
                    }
                }else{
                    set.add(subStr);
                }
            }
        }

        System.out.println(set.last());
    }
}

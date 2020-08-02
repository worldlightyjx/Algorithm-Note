package com.yang.huaweitest;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip1 = sc.next();
        String ip2 = sc.next();
        String mask = sc.next();
        String[] ip1arr = ip1.split("\\.");
        String[] ip2arr = ip2.split("\\.");
        String[] maskarr = mask.split("\\.");
        int res = 0;
        if(and(ip1arr[0],maskarr[0])==and(ip2arr[0],maskarr[0])&&
                and(ip1arr[1],maskarr[1])==and(ip2arr[1],maskarr[1])&&
                and(ip1arr[2],maskarr[2])==and(ip2arr[2],maskarr[2])&&
                and(ip1arr[3],maskarr[3])==and(ip2arr[3],maskarr[3])){
            res = 1;
        }
        System.out.println(res + " "+and(ip1arr[0],maskarr[0])+"."+and(ip1arr[1],maskarr[1])+"."+and(ip1arr[2],maskarr[2])+"."+and(ip1arr[3],maskarr[3]));
        
        
    }
    public static int and(String s1, String s2){
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        return a & b;
    }
}

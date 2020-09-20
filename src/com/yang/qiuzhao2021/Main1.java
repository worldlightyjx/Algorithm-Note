package com.yang.qiuzhao2021;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int dist = k, backCnt = 0;
            for (int i = 0; i <n ; i++) {
                int d = sc.nextInt();
                dist-=d;
                if (i!=n-1&&dist==0){
                    System.out.println("paradox");
                    break;
                }
                if(dist<0){
                    backCnt++;
                    dist = Math.abs(dist);
                }
            }
            if (backCnt>0||dist>=0){
                System.out.println(Math.abs(dist)+" "+backCnt);
            }


        }


    }
}

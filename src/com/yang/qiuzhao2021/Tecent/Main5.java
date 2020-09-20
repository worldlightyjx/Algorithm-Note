package com.yang.qiuzhao2021.Tecent;

import java.util.Scanner;
import java.util.TreeSet;

public class Main5 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        dp = new int[str.length()];
        minCutString(str,dp);
        int k = sc.nextInt();
        for (int i = 0; i <k ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (b-a+1<2){
                System.out.println(0);
            }
            System.out.println(dp[b-1]+1);
        }
    }

    private static void minCutString(String s,int[] dp){
        int len = s.length();
        for (int i = 0; i <len ; i++) {
            dp[i] = i;
        }

        boolean[][] check = new boolean[len][len];
        for(int r = 0 ; r<len;r++){
            for(int l = 0; l<=r;l++){
                if(s.charAt(l)==s.charAt(r)&&(r-l)<=2||check[l+1][r-1]){
                    check[l][r] = true;
                }
            }
        }
        for (int i = 1; i <len ; i++) {
            if(check[0][i]){
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j <i ; j++) {
                if(check[j+1][i]){
                    dp[i] = Math.min(dp[i],dp[j+1]);
                }
            }
        }
    }
}

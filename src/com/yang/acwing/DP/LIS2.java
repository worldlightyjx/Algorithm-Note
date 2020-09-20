package com.yang.acwing.DP;

import java.util.Scanner;

public class LIS2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <=n ; i++) {
            dp[i] = 1;
            for (int j = 1; j <i ; j++) {
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <=n ; i++) {
            res = Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}

package com.yang.acwing.DP;

import java.util.Scanner;

public class LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str1 = sc.next();
        String str2 = sc.next();
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        char[] a = new char[n+1];
        char[] b = new char[m+1];
        System.out.println(a[0]);
        for (int i = 1; i <=n ; i++) {
            a[i] = str1Arr[i-1];
        }
        for (int i = 1; i <=m ; i++) {
            b[i] = str2Arr[i-1];
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(a[i]==b[j]) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
            }
        }
        System.out.println(dp[n][m]);
    }
}

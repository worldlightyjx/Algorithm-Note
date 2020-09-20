package com.yang.acwing.DP;

import java.util.Scanner;

public class ShortestEditDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str1 = sc.next();
        int m = sc.nextInt();
        String str2 = sc.next();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <=m ; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                if(a[i-1]==b[j-1]){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        System.out.println(dp[n][m]);
    }

}

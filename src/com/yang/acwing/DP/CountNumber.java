package com.yang.acwing.DP;

import java.util.Scanner;

public class CountNumber {

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <=n ; i++) {
            for (int j = i; j <=n ; j++) {
                dp[j] = (dp[j]+dp[j-1])%1000000007;
            }
        }
        System.out.println(dp[n]);
    }*/
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[][] dp = new int[n+1][n+1];
       dp[0][0] = 1;
       for (int i = 1; i <=n ; i++) {
           for (int j = 1; j <=i ; j++) {
               dp[i][j] = (dp[i-1][j-1]+dp[i-j][j])%1000000007;
           }
       }
       int res = 0;
       for (int i = 1; i <=n ; i++) {
           res = (res+dp[n][i])%1000000007;
       }
       System.out.println(res);
   }

}

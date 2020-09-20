package com.yang.acwing.DP;

import java.util.Scanner;

public class MergeStone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] s = new int[n+1];
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <=n ; i++) {
            s[i]  = s[i-1]+arr[i];
        }

        for (int len = 2; len <=n ; len++) {
            for (int i = 1; i+len-1 <=n ; i++) {
                int l = i, r = i+len-1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l; k <r ; k++) {
                    dp[l][r] = Math.min(dp[l][r],dp[l][k]+dp[k+1][r]+s[r]-s[l-1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }

}

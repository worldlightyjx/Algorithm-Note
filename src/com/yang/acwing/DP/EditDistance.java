package com.yang.acwing.DP;

import java.util.Scanner;

public class EditDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] inputStr = new String[n];
        for (int i = 0; i <n ; i++) {
            inputStr[i] = sc.next();
        }
        while (m--!=0){
            String checkStr = sc.next();
            int limit = sc.nextInt();
            int cnt = 0;
            for (int i = 0; i <n ; i++) {
                if(editDistance(inputStr[i],checkStr)<=limit){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    private static int editDistance(String input, String check){
        int n = input.length(), m = check.length();
        char[] a = input.toCharArray();
        char[] b = check.toCharArray();
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
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+(a[i-1]==b[j-1]?0:1));
            }
        }
        return dp[n][m];
    }

}

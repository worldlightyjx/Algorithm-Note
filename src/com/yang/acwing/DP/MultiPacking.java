package com.yang.acwing.DP;

import java.util.Scanner;

public class MultiPacking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        int[] s = new int[n+1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                for (int k = 0; k <=s[i]&&k*v[i]<=j ; k++) {
                    f[i][j] = Math.max(f[i][j],f[i-1][j-k*v[i]]+k*w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}

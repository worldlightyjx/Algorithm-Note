package com.yang.acwing.DP;

import java.util.Scanner;

public class InfinitePacking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                for (int k = 0; k*v[i] <=m ; k++) {
                    f[i][j] = Math.max(f[i][j],f[i-1][j-v[i]*k]+k*w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }

}

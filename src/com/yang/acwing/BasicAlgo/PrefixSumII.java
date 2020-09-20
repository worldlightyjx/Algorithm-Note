package com.yang.acwing.BasicAlgo;

import java.util.Scanner;

public class PrefixSumII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] sum = new int[n+1][m+1];
        //prefixSum
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1]-sum[i-1][j-1]+arr[i][j];
            }
        }
        while (q--!=0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int res = sum[x2][y2] - sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];
            System.out.println(res);
        }
    }

}

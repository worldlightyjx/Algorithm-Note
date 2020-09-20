package com.yang.acwing.DP;



import java.util.Scanner;

public class Triangle {
    static final int N = 510;
    static final int INF = 100000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n+1][n+1];
        int[][] f = new int[N][N];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=i+1 ; j++) { //要多初始化一下右上角的点，有可能不存在的点，但是要初始化
                f[i][j] = -INF;
            }
        }
        f[1][1] = a[1][1];
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                f[i][j] = Math.max(f[i-1][j-1]+a[i][j],f[i-1][j]+a[i][j]);
            }
        }

        int res = -INF;
        for (int i = 1; i <=n ; i++) {
            res = Math.max(res,f[n][i]);
        }

        System.out.println(res);
    }

}

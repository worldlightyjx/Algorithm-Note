package com.yang.acwing.DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Skining {

    static final int N = 310;
    static int[][] h = new int[N][N];
    static int n, m;
    static int[][] dp = new int[N][N];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dp(i, j));
            }
        }
        System.out.println(res);
    }

    private static int dp(int x, int y) {

        if (dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && h[xx][yy] < h[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dp(xx, yy) + 1);
            }
        }
        return dp[x][y];
    }
}

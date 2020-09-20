package com.yang.acwing.DP;

import java.util.Arrays;
import java.util.Scanner;

public class TreeDP {

    static final int N=6010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int idx = 0;
    static int[][] dp =new int[N][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] happy = new int[n+1];
        boolean[] has_father = new boolean[n+1];
        for (int i = 1; i <=n ; i++) {
            happy[i] = sc.nextInt();
        }
        Arrays.fill(h,-1);
        for (int i = 0; i <n-1 ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            has_father[a] = true;
            add(b,a);
        }
        int root = 1;
        while (has_father[root]) root++;
        dfs(root,happy);

        System.out.println(Math.max(dp[root][0],dp[root][1]));

    }
    private static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a]=idx++;
    }

    private static void dfs(int root, int[] happy){
        dp[root][1] = happy[root];
        for (int i = h[root]; i !=-1 ; i=ne[i]) {
            int j = e[i];
            dfs(j,happy);
            dp[root][0] += Math.max(dp[j][0],dp[j][1]);
            dp[root][1] +=dp[j][0];
        }
    }
}

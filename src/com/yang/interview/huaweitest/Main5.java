package com.yang.huaweitest;

import java.util.Scanner;

public class Main5 {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int step = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        if(n<step||m<step){
            System.out.println(0);
            return;
        }
        int[][] G = new int[n][m];
        int[][] vis = new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                G[i][j] = sc.nextInt();
            }
        }
        int[] dx = {0,0,-step,step};
        int[] dy = {step,-step,0,0};
        vis[0][0] = 1;
        dfs(G,vis,dx,dy,0,0);
        System.out.println(vis[n-1][m-1]);
    }

    public static void dfs(int[][] G, int[][] vis, int[] dx, int[] dy, int startX, int startY){
        for (int i = 0; i <4 ; i++) {
            int newX = startX+dx[i];
            int newY = startY+dy[i];
            if(newX<0||newX>=n||newY>=m||newY<0||G[newX][newY]==0||vis[newX][newY]==1){
                continue;
            }
            vis[newX][newY] = 1;
            dfs(G,vis,dx,dy,newX,newY);
        }


    }

}

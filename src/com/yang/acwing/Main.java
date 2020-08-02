
package com.yang.acwing;
import java.util.*;

class Main{
    private static final int N = 20;
    private static int n;
    private static char[][] path = new char[N][N];
    private static boolean[] col = new boolean[N];
    private static boolean[] row = new boolean[N];
    private static boolean[] dg = new boolean[N];
    private static boolean[] udg = new boolean[N];



    private static void dfs(int u){
        if(u==n){

            for(int i = 0;i<n;i++) {
                String val = String.valueOf(path[i]);
                System.out.println(val);

            }
            System.out.println();
            return;
        }
        for(int i = 0; i<n;i++){
            if(!col[i]&&!dg[u+i]&&!udg[n+i-u]){
                path[u][i] = 'Q';
                col[i]=dg[u+i]=udg[n+i-u] = true;
                dfs(u+1);
                col[i]=dg[u+i]=udg[n+i-u] = false;
                path[u][i] = '.';
            }
        }
    }

    private static void dfs2(int x, int y, int s){
        if(y==n) {
            y = 0;
            x++;

        }
        if(x==n){
            if(s==n){
                for(int i = 0;i<n;i++) {
                    String val = String.valueOf(path[i]);
                    System.out.println(val);
                }
                System.out.println();

            }
            return;
        }
        //不放皇后
        dfs2(x,y+1,s);

        //放皇后
        if(!row[x]&&!col[y]&&!dg[x+y]&&!udg[n+y-x]){
            path[x][y] = 'Q';
            row[x]=col[y]=dg[x+y]=udg[n+y-x]=true;
            dfs2(x,y+1,s+1);
            row[x]=col[y]=dg[x+y]=udg[n+y-x]=false;
            path[x][y] = '.';
        }
    }





    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i =0;i<n;i++)
            for(int j = 0; j<n;j++)
                path[i][j] = '.';
        //dfs(0);
        dfs2(0,0,0);
    }
}

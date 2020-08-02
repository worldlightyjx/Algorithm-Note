package com.yang.acwing;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Puzzel{
    static class Pair{
        int first, last;
        Pair(int first, int last){
            this.first = first;
            this.last = last;
        }
    }
    private static final int N = 110;
    private static int n, m;
    private static int[][] g = new int[N][N];
    private static int[][] d = new int[N][N];

    private static void initDistance(){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                d[i][j] = -1;
    }

    private static int bfs(){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,0));
        initDistance();
        d[0][0] = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!queue.isEmpty()){
            Pair t = queue.poll();
            for(int i =0; i<4;i++){
                int x = t.first + dx[i];
                int y = t.last + dy[i];
                if(x>=0&&x<n&&y>=0&&y<m&&g[x][y]==0&&d[x][y]==-1){
                    d[x][y] = d[t.first][t.last] + 1;
                    queue.offer(new Pair(x,y));
                }
            }

        }
        return d[n-1][m-1];

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i<n;i++){
            for(int j =0;j<m;j++){
                g[i][j] = sc.nextInt();
            }
        }
        int res = bfs();
        System.out.println(res);


    }
}
package com.yang.pduoduo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main4 {
    static class Node{
        int x;
        int y;
        int key;
        int step;

        public Node(int x, int y, int key, int step){
            this.x=x;
            this.y=y;
            this.key=key;
            this.step=step;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] G = new char[n][m];
        for(int i=0;i<n;i++){
            G[i] = sc.nextLine().toCharArray();
        }
        for(int i=0;i<n;i++){
            for(int j = 0; j<m;j++){
                if(G[i][j] == '2'){
                    System.out.println(bfs(i,j,n,m,G));
                    return;
                }
            }
        }
    }
    private static int bfs(int sx, int sy, int n, int m,char[][] G){
        Queue<Node> queue = new LinkedList<>();
        boolean status[][][] = new boolean[101][101][1200];
        int next[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        queue.offer(new Node(sx,sy,0,0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int i=0;i<4;i++){
                int x = node.x + next[i][0];
                int y = node.y+next[i][1];
                int key = node.key;
                if(x<0||x>=n||y<0||y>=m||G[x][y]=='0') continue;
                else if(G[x][y]=='3') return node.step+1;
                else if(G[x][y]<='z'&&G[x][y]>='a') key = key | (1<<(G[x][y] - 'a'));
                else if(G[x][y]<='Z'&&G[x][y]>='A' && (key &(1<<(G[x][y]-'A')))==0) continue;
                if(status[x][y][key] == false){
                    status[x][y][key] = true;
                    queue.offer(new Node(x,y,key,node.step + 1));
                }

            }
        }

        return -1;

    }
}

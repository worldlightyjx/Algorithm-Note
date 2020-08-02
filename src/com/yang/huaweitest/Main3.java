package com.yang.huaweitest;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {

    static class Node {

        int x;
        int y;
        int step;

        public Node(int x, int y, int key, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = 0;
        char[][] G = new char[55][55];
        while (!sc.hasNext("#")){
            String str = sc.next();
            String[] strarr = str.split(" ");
            for(int j=0;j<strarr.length;j++ ){
               G[len][j] = strarr[j].toCharArray()[0];
            }
            len++;
        }
        System.out.println(G[0][0]);
    }
    private static int bfs(int sx, int sy, int m, char[][] G) {
        Queue<Node> queue = new LinkedList<>();
        boolean status[][] = new boolean[55][55];
        int next[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        queue.offer(new Node(sx, sy, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node.x + next[i][0];
                int y = node.y + next[i][1];
                if (x < 0 || x >= m || y < 0 || y >= m || G[x][y] == '0') continue;
                else if (G[x][y] == '3') return node.step + 1;
                if (status[x][y] == false) {
                    status[x][y] = true;
                    //queue.offer(new Node(x, y, node.step + 1));
                }

            }
        }
        return -1;
    }


}

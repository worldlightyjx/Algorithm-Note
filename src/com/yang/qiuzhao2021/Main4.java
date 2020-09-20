package com.yang.qiuzhao2021;

import java.util.Scanner;

public class Main4 {
    static char[] food = {'a','b','c','d','e','f'};
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[6];
        char[][] board = new char[6][6];
        int land = 0;
        for (int i = 0; i <6 ; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i <6 ; i++) {
            char[] charArr = arr[i].toCharArray();
            for (int j = 0; j <6 ; j++) {
                board[i][j] = charArr[j];
                if (board[i][j]=='#'){
                    land++;
                }
            }
        }
        dfs(board,0,0,land,food);
        System.out.println(cnt);


    }
    public static void dfs(char[][] board, int startX,int startY,int land, char[] food){
        if(land==0){
            cnt++;
        }
        if (startX<0||startX>6||startY<0||startY>6||board[startX][startY]=='*'){
            return;
        }
        for (int i = 0; i <4 ; i++) {
            int x = startX+dx[i];
            int y = startY+dy[i];
            for (int j = 0; j <food.length ; j++) {
                dfs(board,x,y,land-1,food);
            }
        }
    }
}

package com.yang.recursion;

import java.util.Scanner;

public class TowersofHanoi {
    static int cnt = 0;
    public static void move(int disk, char N, char M){
        cnt +=1;
        System.out.println("第"+ cnt +"次移动： "+ "把" + disk +"号盘从" + N + "移动到" + M);
    }

    public static void hanoi(int n, char A, char B, char C){
        if(n==1){
            move(1,A,C);
        }else{
            hanoi(n-1, A,C,B);
            move(n,A,C);
            hanoi(n-1,B,A,C);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入圆盘个数：");
        char A = 'A', B = 'B', C='C';
        int n = sc.nextInt();

        hanoi(n,A,B,C);

        System.out.println("一共移动了："+ cnt + "次");
    }
}

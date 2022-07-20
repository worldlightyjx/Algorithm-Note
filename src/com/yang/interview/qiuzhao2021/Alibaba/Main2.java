package com.yang.qiuzhao2021.Alibaba;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] fa = new int[n+2];
        fa[1] = 1;
        for (int i = 2; i <n+1 ; i++) {
            fa[i] = sc.nextInt();
        }
        for (int i = 0; i <q ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int stepA = findFa(a,fa);

            if(fa[a]==1){
                if(b==1&&a!=1){
                    System.out.println("B");
                }else{
                    System.out.println("A");
                }
            }else if (b==1){
                System.out.println("B");
            }else{
                System.out.println("B");
            }
        }
    }

    private static int findFa(int x,int[] fa){
        int step = 0;
        while (fa[x]!=1){
            step++;
        }
        return step;
    }

}

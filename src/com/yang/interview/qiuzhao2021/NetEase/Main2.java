package com.yang.qiuzhao2021.NetEase;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i <m ; i++) {
            arr[i] = sc.nextInt();
        }
        if(m==n){
         printArr(arr);
         return;
        }

    }
    private static void printArr(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("%d",arr[i]);
            if (i!=arr.length-1){
                System.out.printf(" ");
            }
        }
    }
}

package com.yang.qiuzhao2021.Alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        minDis3(arr);

    }
    
    public static int disSum(int[] arr, int x){
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=x){
                sum+=Math.abs(arr[i]-x);
            }
        }
        return sum;
    }

    public static void minDis(int[] arr, int n){
        int MIN = Integer.MAX_VALUE;

        for (int i = 0; i <n ; i++) {
            int sum = disSum(arr,arr[i]);
            if(sum<MIN){
                MIN = sum;

            }
        }
        System.out.println(MIN);
    }

    public static void minDis2(int[] arr, int n){
        Arrays.sort(arr);
        int mid = 0;
        if(n%2==0){
            mid = (arr[n/2-1]+arr[n/2])/2;
        }else{
            mid = (arr[n/2])+1;
        }
        int res = disSum(arr,mid);
        System.out.println(res);
    }
    
    public  static void minDis3(int[] arr){
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i <arr.length/2 ; i++) {
            res +=(arr[arr.length-1-i]-arr[i]);
        }
        System.out.println(res);
    }
}

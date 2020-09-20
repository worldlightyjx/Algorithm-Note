package com.yang.qiuzhao2021.Tecent;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr= new long[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = sc.nextInt();
        }
        long res = paint(arr,1,n,0);
        System.out.println(res);
    }

    private static long paint(long[] arr, int l, int r, long h){
        if(l>r) return 0;
        long min = Long.MAX_VALUE;
        int index = -1;
        int sum  = 0;
        for (int i = l; i <=r ; i++) {
            if(arr[i]<min){
                min = arr[i];
                index = i;
            }
            if(arr[i]>h) sum++;
        }

        long num = min - h;
        long nextH = min;
        long resL = paint(arr,l,index-1,nextH);
        long resR = paint(arr,index+1,r,nextH);
        long res = Math.min(sum,resL+resR+num);
        return res;
    }
}

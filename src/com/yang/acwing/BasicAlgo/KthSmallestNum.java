package com.yang.acwing.BasicAlgo;

import java.util.Scanner;

public class KthSmallestNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(q_sort(arr,k,0,n-1));
    }

    public static int q_sort(int[] arr, int k,int l ,int r){
        if(l>=r) return arr[l];
        int piv = arr[l+r>>1];
        int i = l-1, j = r+1;
        while (i<j){
            while (arr[++i]<piv);
            while (arr[--j]>piv);
            if(i<j){
                swap(arr,i,j);
            }
        }
        int numLen = j - l +1;
        if(k<=numLen){
            return q_sort(arr,k,l,j);
        }
        return q_sort(arr,k-numLen,j+1,r);
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

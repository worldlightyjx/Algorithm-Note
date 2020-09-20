package com.yang.acwing.mergesort;

import java.util.Scanner;

public class mergeSort {
    static int[] tmp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        tmp = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        merge_sort(arr,0,n-1);
        for (int i = 0; i <n ; i++) {
            System.out.printf("%d ",arr[i]);
        }
    }

    private static void merge_sort(int[] arr, int l, int r){
        if(l>=r) return;
        int mid = (l+r)/2;
        merge_sort(arr,l,mid);
        merge_sort(arr,mid+1,r);
        int i = l, j= mid+1;
        int k = 0;
        while (i<=mid&&j<=r){
            if(arr[i]<=arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }
        while (i<=mid) tmp[k++] = arr[i++];
        while (j<=r) tmp[k++] = arr[j++];

        for (int s = l, m = 0; s <=r ; s++,m++) {
            arr[s] = tmp[m];
        }
    }

}

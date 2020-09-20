package com.yang.acwing.mergesort;

import java.util.Scanner;

public class reversedPairs {
    static int[] tmp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(merge_sort(arr,0,n-1));
    }

    private static long merge_sort(int[] arr, int l, int r){
        if(l>=r) return 0;
        int mid = (l+r)/2;
        long res = merge_sort(arr,l,mid)+merge_sort(arr,mid+1,r);
        int i = l, j = mid+1;
        int k = 0;
        while (i<=mid&&j<=r){
            if(arr[i]<=arr[j]){
                tmp[k++] = arr[i++];
            }else{
                res += mid - i +1;
                tmp[k++] = arr[j++];
            }
        }
        while (i<=mid) tmp[k++] = arr[i++];
        while (j<=r) tmp[k++] = arr[j++];
        for (int m = l, s = 0; m <=r ; m++,s++) {
            arr[m] = tmp[s];
        }
        return res;
    }
}

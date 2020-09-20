package com.yang.acwing.BinarySearch;

import java.util.Scanner;

public class NumberRange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        while (k--!=0){
            int x = sc.nextInt();
            int l = 0, r = n-1;
            while (l<r){
                int mid = l+r>>1;
                if(arr[mid]>=x){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            if(arr[l]!=x){
                System.out.printf("%d %d",-1,-1);
            }else{
                System.out.printf("%d ",l);
                l = 0;
                r = n-1;
                while (l<r){
                    int mid = l+r+1>>1;
                    if(arr[mid]<=x){
                        l = mid;
                    }else{
                        r = mid-1;
                    }
                }
                System.out.printf("%d",l);
            }
            System.out.println();
        }
    }

}

package com.yang.acwing.DP;

import java.util.Scanner;

public class LIS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] q = new int[n+1];
        q[0] = -2000000001;
        int len = 0;

        for (int i = 0; i <n ; i++) {
            int l = 0, r=len;
            while (l<r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < arr[i])
                    l = mid;
                else
                    r = mid - 1;


            }
            len = Math.max(len,r+1);
            q[r+1] = arr[i];

        }
        System.out.println(len);


    }
}

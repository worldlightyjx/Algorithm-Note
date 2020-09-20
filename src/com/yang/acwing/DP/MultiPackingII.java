package com.yang.acwing.DP;

import java.util.Scanner;

public class MultiPackingII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[25000];
        int[] v = new int[25000];

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int vi,wi,si;
            vi= sc.nextInt();
            wi=sc.nextInt();
            si = sc.nextInt();
            int k = 1;
            while (k<=si){
                cnt++;
                v[cnt] = vi*k;
                w[cnt] = wi*k;
                si-=k;
                k*=2;
            }
            if(si>0){
                cnt++;
                v[cnt] = vi*si;
                w[cnt] = wi*si;
            }
        }
        int[] f = new int[m+1];
        for (int i = 1; i <=cnt ; i++) {
            for (int j = m; j >=v[i]; j--) {
                    f[j] = Math.max(f[j],f[j-v[i]]+w[i]);

            }
        }
        System.out.println(f[m]);
    }
}

package com.yang.bytedance;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorSum(n));
    }
    private static long factorSum(int n){
        int[] fac = new int[n+1];
        int sum = 0;
        fac[0] = 1;
        for(int i = 1; i<=n;i++){
            fac[i] = fac[i-1]*i;
        }
        for(int i = 1; i<=n;i++){
            sum+=fac[i];
        }
        return sum;
    }


}

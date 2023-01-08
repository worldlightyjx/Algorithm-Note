package com.yang.saptest;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            double tmp = n;
            double sum = (double) n;
            for (int i = 0; i <m - 1 ; i++) {
                sum  = sum + Math.sqrt(tmp);
                tmp = Math.sqrt(tmp);

            }
            System.out.printf("%.2f",sum);
            System.out.println();
        }
    }
}

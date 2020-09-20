package com.yang.acwing.BinarySearch;

import java.util.Scanner;

public class CubeRoot {
    static final double SIGMA = 1E-8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double l = -100.0, r = 100.0;
        while (r-l>SIGMA){
            double mid  = (l+r)/2;
            if(mid*mid*mid<n){
                l = mid;
            }else{
                r = mid;
            }
        }
        System.out.printf("%.6f",l);
    }

}

package com.yang.qiuzhao2021.Tecent;


import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = (n/2)/10 * 10 + 9;
        int b = n - a;
        int sum = 0;
        while (a!=0){
            sum += a%10;
            a/=10;
        }
        while (b!=0){
            sum+=b%10;
            b/=10;
        }
        System.out.println(sum);

    }


}

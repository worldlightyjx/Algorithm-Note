package com.yang.bitoperation;

import java.util.Scanner;

public class AddMinusMultiDiv {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("ADD result： "+add(a,b));
        System.out.println("Minus result: "+minus(a,b));
        System.out.println("Multi result:" + multi(a,b));
    }


    public static int add(int a, int b){
        int sum = a;
        while (b!=0){
            sum = a ^ b;
            b = (a&b)<<1;
            a = sum;
        }
        return sum;
    }

    private static int negNum(int n){
        return add(~n, 1);
    }

    public static int minus(int a, int b){
        return add(a,negNum(b));
    }
    public static int multi(int a, int b){
        int res = 0;
        while (b!=0){
            if((b&1)!=0){
                res = add(res,a);
            }
            a= a<<1;
            b = b>>>1;
        }
        return res;
    }

    public static int divide(int a, int b){
        //TODO
        return  0;
    }

}

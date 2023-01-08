package com.yang.saptest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("#")){
            int num = sc.nextInt();
            int sum = 0;
            for(int i=2;i<num;i++){
                sum += getDigitSum(num,i);
            }
            int gcd = gcd(sum, num - 2);
            System.out.println(sum/gcd + "/" + (num-2)/gcd);
        }
    }
    public static int getDigitSum(int num, int index){
        int sum = 0;
        do{
            sum+=num % index;
            num /= index;
        }while (num!=0);
        return sum;
    }

    public static int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}

package com.yang.acwing.BasicAlgo;
import java.util.Scanner;
public class NumberOfBitOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]= sc.nextInt();

        }
        for (int num:arr){
            int res = 0;
            while (num!=0){
                num-=lowbit(num);
                res++;
            }
            System.out.printf("%d ",res);
        }
    }
    
    private static int lowbit(int x){
        return x&(-x);
    }
    

}

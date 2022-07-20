package com.yang.qiuzhao2021.shopee;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.next();
        char[] arr = numStr.toCharArray();
        int index = 0;
        for (int i = arr.length-1; i >0 ; i--) {
            if((int)arr[i]-'0'<(int)arr[i-1]-'0'){
                index = i;
                break;
            }
        }
        if (index==0){
            System.out.println(0);
            return;
        }
        reverseChar(arr,index,arr.length-1);
        for (int i = index-1; i <arr.length ; i++) {
            char num = arr[index-1];
            if((int)arr[i]-'0'<(int)num-'0'){
                arr[index-1] = arr[i];
                arr[i] = num;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        if(sb.toString().charAt(0)=='0'){
            System.out.println(0);
            return;
        }
        System.out.println(sb.toString());
        
    }

    private static void reverseChar(char[] arr, int l, int r){
        while (l<r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }


}

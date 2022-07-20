package com.yang.qiuzhao2021.cisco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] straArr = input.trim().replace("[","").replace("]","").split(",");
        int[] arr = new int[straArr.length];
        for (int i=0;i<straArr.length;i++){
            arr[i] = Integer.parseInt(straArr[i]);
        }
        System.out.println(jump(arr));
    }
    
    public static boolean jump(int[] arr){
        int step = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(i>step) return false;
            step = Math.max(step,i+arr[i]);
        }
        return true;
    }

}

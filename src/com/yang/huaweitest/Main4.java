package com.yang.huaweitest;

import java.util.Scanner;

public class Main4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        int five = 0, ten =0;
        String input = sc.next();
        String[] arr = input.split(",");
        for (int i = 0; i < arr.length; i++) {
            int bill = Integer.parseInt(arr[i]);
            index++;
            if(bill!=5&&bill!=10&&bill!=20){
                System.out.println("false,"+index);
                return;
            }
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five==0){
                    System.out.println("false,"+index);
                    return;
                }
                ten++;
                five--;
            }else{
                if (ten>=1&&five>=1){
                    ten--;
                    five--;
                }else if(ten==0&&five>=3){
                    five-=3;
                }else{
                    System.out.println("false,"+index);
                    return;
                }
            }
        }
        System.out.println("true,"+index);
    }
}

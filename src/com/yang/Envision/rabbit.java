package com.yang.Envision;

import java.util.Scanner;

public class rabbit {
    static int sum = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int month = sc.nextInt();

            /*long sum = 1;
            long x = 1, y = 1;
            if(month > 2){
                for(int i = 3; i<=month;i++){
                    sum = x + y;
                    x = y;
                    y = sum;
                }
            }*/


            System.out.println(getCount(month));
        }
    }

    public static int getCount(int month){
        if(month==1||month==2){
            return 1;
        }
        if(month>2){
            sum =  getCount(month -  1) + getCount(month-2);
        }
        return sum;
    }
    
}

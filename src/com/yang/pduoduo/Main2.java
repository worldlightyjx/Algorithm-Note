package com.yang.pduoduo;

import java.util.Scanner;

public class Main2{
    private static int[] strTonum(String str){
        int[] num = new int[str.length()];
        for(int i=0;i <str.length();i++){
            num[i] = str.charAt(str.length()-1-i) - '0';
            
        }
        return num;
    }
    private static String numToString(int[] num){
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<num.length;i++){
            int digit = num[i] % 10;
            int carry = num[i] /10;
            sb.insert(0,digit);
            if(i<num.length - 1){
                num[i+1] += carry;
            }

        }
        while (sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()==0? "0" : sb.toString();
    }
    private static int[] bigmulti(int[] num1, int[] num2){
        int[] res = new int[num1.length + num2.length];
        for(int i=0;i<num1.length;i++){
            for(int j=0;j<num2.length;j++){
                res[i+j] += num1[i] * num2[j];
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        //System.out.println(str1 + "  "+str2);
        int[] num1 = strTonum(str1);
        int[] num2 = strTonum(str2);
        //System.out.println(num1[3]);
        int[] res = bigmulti(num1,num2);
        System.out.println(numToString(res));
 
    }
}
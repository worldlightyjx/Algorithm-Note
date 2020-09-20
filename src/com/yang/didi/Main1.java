package com.yang.didi;


import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String k = sc.nextLine();
        String str = sc.nextLine();
        System.out.println(reverseByNum(str,Integer.parseInt(k)));
    }
    public static String reverseByNum(String str, int k){
        if(str==null||str.length()==0){
            return "";
        }
        char[] ch = str.toCharArray();
        int n = ch.length;
        if(n<=k){
            reverseHelper(ch,0,n-1);
        }else{
            int step = 1;
            int start = 0;
            while (n>k){
                reverseHelper(ch,start,start+k-1);
                n -= k;
                start=step*k;
                step++;
            }
            if(n>0){
                reverseHelper(ch,start,ch.length-1);
            }

        }

        return String.valueOf(ch);

    }

    public static void reverseHelper(char[] ch, int l ,int r){
        int i = l, j = r;
        while (i<j){
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++;
            j--;
        }
    }


}

package com.yang.test;

import java.util.Scanner;
import java.util.TreeSet;

public class Main22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] strc = str.toCharArray();
        TreeSet<Character> set  = new TreeSet<>();
        for(int i=0;i<strc.length;i++){
            /*if(strc[i]<='Z'&&strc[i]>='A'){
                strc[i] = Character.toLowerCase(strc[i]);
            }*/
            if(strc[i]<='z'&&strc[i]>='a'||strc[i]<='Z'&&strc[i]>='A'){
                set.add(Character.toLowerCase(strc[i]));
            }

        }
        char[] a = new char[55];
        char[] b = new char[55];
        for(int i=0; i<strc.length;i++){
            int len = 0;
            if(strc[i]<='Z'&&strc[i]>='A' && set.contains(Character.toLowerCase(strc[i]))){
                continue;
            }
            if(set.contains(strc[i]))
                a[len++] = strc[i];
        }
        for(int i=0; i<strc.length;i++){
            int len = 0;
            if(strc[i]<='z'&&strc[i]>='a' && set.contains(strc[i])){
                continue;
            }
            if(set.contains(Character.toLowerCase(strc[i])))
                b[len++] = Character.toLowerCase(strc[i]);
        }
        if(a[0] < b[0]){
            System.out.println(a[0]);
        }else{
            System.out.println(b[0]);
        }
        //System.out.println(Character.toLowerCase(set.first()));
    }

}

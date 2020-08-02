package com.yang.test;


import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] strc = str.toCharArray();
        TreeSet<Character> set  = new TreeSet<>();
        for(int i=0;i<strc.length;i++){
            /*if(strc[i]<='Z'&&strc[i]>='A'){
                strc[i] = Character.toLowerCase(strc[i]);
            }*/
            if(strc[i]<='z'&&strc[i]>='a'&&strc[i]<='Z'&&strc[i]>='A'){
                set.add(strc[i]);
            }

        }
        for (Character c : set){
            System.out.printf("%c\n",c);
        }
        System.out.println(Character.toLowerCase(set.first()));
    }
    
    
}

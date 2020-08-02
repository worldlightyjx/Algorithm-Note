package com.yang.bytedance;

import java.util.*;

public class FixCharacter{
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i<n;i++){
            String str = sc.next();
            fix(str);

        }
    }

    private static void fix(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            if(sb.length()<2){
                sb.append(c);
                continue;
            }
            if(sb.length()>=2){
                if(c==sb.charAt(sb.length()-1)&&c==sb.charAt(sb.length()-2))
                    continue;
            }
            if(sb.length()>=3){
                if(c==sb.charAt(sb.length()-1)&&c==sb.charAt(sb.length()-2)&&
                        c==sb.charAt(sb.length()-3))
                    continue;
            }

            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
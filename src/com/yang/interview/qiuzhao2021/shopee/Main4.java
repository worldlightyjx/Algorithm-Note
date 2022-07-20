package com.yang.qiuzhao2021.shopee;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String a = str.replaceAll("[^A-Za-z0-9]"," ");
        String[] arr = a.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <arr.length ; i++) {

                    String tmpstr = arr[i].trim().toLowerCase();

                        if (i==0){
                            sb.append(tmpstr);
                        }else{
                            char[] chars = tmpstr.toCharArray();
                            if (chars.length!=0){
                                chars[0] = Character.toUpperCase(chars[0]);
                                sb.append(chars);
                            }

                        }






        }
        System.out.println(sb.toString());
    }
}

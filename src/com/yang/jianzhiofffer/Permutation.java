package com.yang.jianzhiofffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str!=null&&str.length()>0){
            permute(str.toCharArray(),0,res);
            Collections.sort(res);
        }

        return res;
    }

    public static void permute(char[] chars, int i, ArrayList<String> list){
        if(i==chars.length-1){
            if(!list.contains(String.valueOf(chars))) //排除“aa”这种情况会输出“aa”和“aa”
                list.add(String.valueOf(chars));
        }
        else{
            for(int j=i;j<chars.length;j++){
                swap(chars,i,j);
                permute(chars,i+1,list);
                swap(chars,j,i);
            }
        }
    }

    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static ArrayList<String> Permutation2(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str!=null&&str.length()>0){
            permute2(str.toCharArray(),0,res);
            Collections.sort(res);
        }

        return res;
    }
    private static HashMap<Character,Boolean> map = new HashMap<>();
    static char[] dup = new char[100];
    public static void permute2(char[] chars, int index, ArrayList<String> list){
        if(index == chars.length){
            list.add(String.valueOf(dup,0,chars.length));
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])==null||map.get(chars[i])==false){
                dup[index] = chars[i];
                map.put(chars[i],true);
                permute2(chars,index+1,list);
                map.put(chars[i],false);
            }
        }

    }

    public static void main(String[] args) {
        for(char i : dup){
            System.out.println(i);
        }
        ArrayList<String> list = Permutation2("a");
        for(String str : list){
            System.out.println(str);
        }

    }
}

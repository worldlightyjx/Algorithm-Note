package com.yang.sina;

import com.yang.sort.SortUtil;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isUnique(str));
    }
    public static boolean isUnique(String str){
        if(str.length()==0|| str.length()==1)
            return true;
        char[] ch = str.toCharArray();
        heapSort(ch);
        for (int i = 1; i <ch.length ; i++) {
            if(ch[i]==ch[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void heapSort(char[] ch){
        for (int i = ch.length/2; i >=0 ; i--) {
            downAdjust(ch,i,ch.length);
        }

        for (int i = ch.length-1; i >=0 ; i--) {
            swap(ch,i,0);
            downAdjust(ch,0,i);
        }
    }

    public static void downAdjust(char[] ch, int index,int size){
        int i = index, j = index*2+1;
        while (j<size){
            if (j+1<size&&ch[j+1] > ch[j]){
                j = j+1;
            }
            if(ch[j] > ch[i]){
               swap(ch,j,i);
                i = j;
                j = i * 2+1;
            }else{
                break;
            }
        }
    }


    public static void swap(char[] ch, int i, int j){
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

}

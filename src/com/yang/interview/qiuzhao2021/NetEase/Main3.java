package com.yang.qiuzhao2021.NetEase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i <t ; i++) {
            int n = sc.nextInt();
            int res = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j <n ; j++) {
                int num = sc.nextInt();
                arr.add(num);
            }
            Collections.sort(arr);
            if (arr.size()<3&&isTwoPartEqual(arr)){
                System.out.println(res);
            }
            while (arr.size()>=3){
                res+=arr.get(0);
                arr.remove(0);
                if(isTwoPartEqual(arr)){
                    System.out.println(res);
                    break;
                }
            }

        }
    }

    private static boolean isTwoPartEqual(ArrayList<Integer> arr) {
        int sum = 0;
        for(int num:arr){
            sum+=num;
        }
        if (sum%2!=0){
            return false;
        }
        int target = sum/2;
        int cur = 0;
        for (int i = 0; i <arr.size()-1 ; i++) {
            cur+=arr.get(i);
            if(cur==target){
                return true;
            }
        }
        return false;
    }
}

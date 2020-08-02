package com.yang.pduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static long maxMulti(List<Long> arr){
        long max1,max2,max3;
        max1=max2=max3=Long.MIN_VALUE;
        long min1,min2;
        min1 = min2 = Long.MAX_VALUE;
        int index1=-1, index2=-1, index3=-1,index4=-1;
        for(int i=0; i<arr.size();i++){
            if(arr.get(i) > max1){
                max1 = arr.get(i);
                index1 = i;
            }
            if(arr.get(i) < min1 ){
                min1 = arr.get(i);
                index2 = i;
            }
        }
        for(int i=0; i<arr.size();i++){
            if(i==index1||i==index2) continue;
            if(arr.get(i) > max2 ){
                max2 = arr.get(i);
                index3 = i;
            }
            if(arr.get(i) < min2 ){
                min2 = arr.get(i);
                index4 = i;
            }
        }
        for(int i=0; i<arr.size();i++){
            if(i==index1||i==index3) continue;
            if(arr.get(i) > max3) {
                max3 = arr.get(i);
            }
        }
        long maxPos = max1*max2*max3;
        long maxNeg = min1 * min2 * max1;
        return maxPos > maxNeg ? maxPos : maxNeg;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> arr = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0; i<n;i++){
            long a = sc.nextLong();
            arr.add(a);
        }
        long res = maxMulti(arr);
        System.out.println(res);
    }
}

package com.yang.hihocoder;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShorteningSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
            int n = sc.nextInt();
            ArrayList<Long> arr = new ArrayList<>();
            for(int i = 0; i<n; i++){
                long value = sc.nextInt();
                arr.add(i,value);

            shortSeq(arr,n);
        }

    }
    private static void shortSeq(List<Long> arr, int n){
        int cnt = 0;
        int i = 0;
        while (i<n){
            if((arr.get(i)+arr.get(i+1))%2==0){
                i++;
                continue;
            }else{
                cnt+=2;
                i+=2;
            }
        }
        System.out.println(n - cnt);
    }



}

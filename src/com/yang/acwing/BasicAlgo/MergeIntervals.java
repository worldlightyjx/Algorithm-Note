package com.yang.acwing.BasicAlgo;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Scanner;

public class MergeIntervals {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] arr =new Pair[n];
        for (int i = 0; i <n ; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[i] = new Pair(first,second);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first-o2.first;
            }
        });
        ArrayList<Pair> res = new ArrayList<>();
        int st = Integer.MIN_VALUE, ed = Integer.MIN_VALUE;
        for(Pair p: arr){
            if(ed<p.first){
                if(st!=Integer.MIN_VALUE){
                    res.add(new Pair(st,ed));
                }
                st = p.first;
                ed = p.second;
            }else{
                ed = Math.max(ed,p.second);
            }
        }
        if(st!=Integer.MIN_VALUE){
            res.add(new Pair(st,ed));
        }
        System.out.println(res.size());

    }

}

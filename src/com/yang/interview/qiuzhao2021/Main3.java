package com.yang.qiuzhao2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {

    static class node {

        int hot;
        int taste;
        int rank;

        public node(int hot, int taste, int rank) {
            this.hot = hot;
            this.taste = taste;
            this.rank = rank;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            if (t == 0) {
                System.out.println(0);
                continue;
            }
            node[] originalLunch = new node[n];
            node[] originalDinner = new node[m];

            int sum = 0;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                sum += b;
                int rank = Math.abs(b - t);
                originalLunch[i] = new node(a, b, rank);
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                sum += b;
                int rank = Math.abs(b - t);
                originalDinner[i] = new node(a, b, rank);
            }
            if (sum < t) {
                System.out.println(-1);
                continue;
            }
            node[] lunch = Arrays.copyOf(originalLunch, originalLunch.length);
            node[] dinner = Arrays.copyOf(originalDinner, originalDinner.length);
            int res1 = 0, res2 = 0;
            Arrays.sort(lunch, new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    return o1.rank - o2.rank;
                }
            });
            int resT = t - lunch[0].taste;
            if (resT <= 0) {
                res1 = lunch[0].hot;
            } else {
                for (int i = 0; i < m; i++) {
                    int rank = Math.abs(dinner[i].taste - resT);
                    dinner[i].rank = rank;
                }
                Arrays.sort(dinner, new Comparator<node>() {
                    @Override
                    public int compare(node o1, node o2) {
                        return o1.rank - o2.rank;
                    }
                });
                resT -= dinner[0].taste;
                if (resT <= 0) {
                    res1 = lunch[0].hot + dinner[0].hot;
                }else{
                    res1 = Integer.MAX_VALUE;
                }
            }

            Arrays.sort(originalDinner, new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    return o1.rank-o2.rank;
                }
            });

            int resT2 = t - dinner[0].taste;
            if(resT2<=0) {
                res2 = dinner[0].hot;
            }else{
                res2 = Integer.MAX_VALUE;
            }

            if (res1==Integer.MAX_VALUE&&res2==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(Math.min(res1,res2));
            }
        }


    }

}

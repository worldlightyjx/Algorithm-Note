package com.yang.didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--!=0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i <m ; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int exp = sc.nextInt();
                if(exp<=k){
                    set.add(a);
                    set.add(b);
                }
            }
            if(set.size()==n){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

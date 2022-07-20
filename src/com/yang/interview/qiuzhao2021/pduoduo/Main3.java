package com.yang.qiuzhao2021.pduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] hungry = new int[n];
        for (int i=0; i<n;i++){
            hungry[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Arrays.sort(hungry);
        int[] w = new int[m];
        for(int i =0; i<m;i++){
            w[i] = sc.nextInt();
        }
        Arrays.sort(w);
        int stu = stuNum(n,m,hungry,w);
        System.out.println(stu);
    }
    private static int stuNum(int n, int m, int[] hungry, int w[]){
        int count = 0;
        for(int i =0; i<m;i++) {
            if(w[i]==0) continue;
            for(int j=0;j<n;j++){
                if(hungry[j]>0&&w[i] >= hungry[j] ){
                    w[i] = 0;
                    hungry[j] = -1;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

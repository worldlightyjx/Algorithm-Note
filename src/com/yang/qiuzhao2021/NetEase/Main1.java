package com.yang.qiuzhao2021.NetEase;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i <n ; i++) {
            int num = sc.nextInt();
            if (num==3){
                cnt++;
            }else if(num==1){
                cnt+=0;
            }else{
                cnt+=(num/2);
            }
        }
        System.out.println(cnt);

    }
}

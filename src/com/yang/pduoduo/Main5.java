package com.yang.pduoduo;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int offset, n, l1, l2;
            int s1=0,e1=0,s2=0,e2=0;
            offset = sc.nextInt();
            n=sc.nextInt();
            l1=sc.nextInt();
            l2=sc.nextInt();
            int l1Left = l1 - offset;

            if(l1Left<0){
                s1=e1=l1;
                if(l2-n+l1Left<0&&l1!=0){
                    s2=l2;
                    e2=l2;
                }else if (l2-n+l1Left<0&&l1==0){
                    s2 = -l1Left;
                    e2=l2;
                }else{
                    s2 = -l1Left;
                    e2 = -l1Left + n;
                }


            }else if(l1Left>0){
                if(l1Left>=n){
                    s1=offset;
                    e1=offset+n;
                    s2=e2=0;

                }else{
                    s1=offset;
                    e1=l1;
                    s2=0;
                    e2 = n-l1Left;
                }
            }else{
                s1=e1=l1;
                if(l2<=n){
                    s2=-l1Left;
                    e2=l2;
                }else if(l2>n){
                    s2=0;
                    e2=n;
                }
            }
            System.out.printf("%d %d %d %d",s1,e1,s2,e2);
        }

    }
}

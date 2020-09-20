package com.yang.acwing.datastructure;

import java.util.Scanner;

public class UnionFind3 {

    static int[]p;
    static int[]d;
    public static int find(int x){
        if(p[x]!=x){
            int t = find(p[x]);
            d[x]+=d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        p = new int[n+1];
        d = new int[n+1];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        int res = 0;
        while (m--!=0){
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x>n||y>n)
                res++;
            else{
                int px = find(x), py = find(y);
                if(t==1){
                    if(px==py&&(d[x]-d[y])%3!=0)
                        res++;
                    else if(px!=py){
                        p[px] = py;
                        d[px] = d[y]-d[x];
                    }
                }else{
                    if(px==py&&(d[x]-d[y]-1)%3!=0)
                        res++;
                    else if(px!=py){
                        p[px] = py;
                        d[px] = (d[y]-d[x]+1);
                    }
                }
            }


        }
        System.out.println(res);
    }

}

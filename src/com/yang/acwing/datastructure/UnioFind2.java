package com.yang.acwing.datastructure;

import java.util.Scanner;

public class UnioFind2 {
    static int[] p;
    static int[] size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] parts = str.split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        p = new int[n+1];
        size = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            p[i] = i;
            size[i] = 1;
        }
        while (m--!=0){
            String input= sc.nextLine();
            parts = input.split(" ");
            String op = parts[0];
            if(parts.length==3){
                int a = Integer.parseInt(parts[1]);
                int b = Integer.parseInt(parts[2]);
                if(op.equals("C")){
                    if(find(a)==find(b)) continue;
                    size[find(a)]+=size[find(b)];
                    p[find(b)] = find(a);
                }else if (op.equals("Q1")){
                    if(find(a)==find(b)){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No");
                    }
                }
            } else {
                int c = Integer.parseInt(parts[1]);
                System.out.println(size[find(c)]);
            }
        }
    }

    public static int find(int x){
        if (p[x]!=x){
            p[x] = find(p[x]);
        }
        return p[x];
    }

}

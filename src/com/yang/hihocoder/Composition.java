package com.yang.hihocoder;

import java.util.Scanner;

public class Composition {
    static int[][] G  = new int[100][100];
    static int[] f = new int[27];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        String str = null;
        while (sc.hasNext()){
            n = sc.nextInt();
            str = sc.next();
            m = sc.nextInt();

            for(int i = 0; i<m; i++){
                String pair = sc.next();
                G[pair.charAt(0)-'a'][pair.charAt(1)-'a'] = 1;
                G[pair.charAt(1)-'a'][pair.charAt(0)-'a'] = 1;
            }

            int ans = helper(n,str);
            System.out.println(n-ans);
        }
    }

    private static int helper(int n,String str){
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            int v = f[str.charAt(i)-'a'];
            for (int j = 0; j <=26 ; j++) {
                if(G[j][str.charAt(i)-'a']==0)
                    v = Math.max(v,f[j]+1);
            }

            f[str.charAt(i)-'a'] = Math.max(1,v);
            MAX = Math.max(MAX,f[str.charAt(i)-'a']);

        }
        return MAX;
    }

}

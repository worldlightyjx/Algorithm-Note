package com.yang.saptest;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    private static final long MOD = 1000000007L;
    static long[] a = new long[100005];
    static long[] b = new long[100005];
    static long[] num = new long[100005];
    static long[] fac = new long[100005];
    static long[] dp = new long[100005];
    static long n, k, count, tot;

    public static long Mypow(long a, long n){
        long res = 1, t = a;
        while(n!=0){
            if((n&1)!=0){
                res = (res * t) % MOD;
            }
            t = (t*t) % MOD;
            n/=2;
        }
        return res;
    }

    public  static long inv_res(long x){
        return Mypow(x, MOD - 2);
    }

    public static boolean isLucky(long x){
        while (x!=0){
            if((x%10)!=6&&(x%10)!=9)
                return false;
            x/=10;
        }
        return true;
    }

    public static long helper(long x, long y){
        if(y==0) return 1;
        if(x<y) return 0;
        long res = (fac[(int) x] * inv_res(fac[(int)y])) % MOD;
        res = (res * inv_res(fac[(int)(x-y)]))%MOD;
        return res;
    }
    public static void main(String[] args) {
        fac[0] = 1;
        for(long i = 1; i<=100000;i++){
            fac[(int)i] = (fac[(int)(i - 1)] * i) % MOD;
        }
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        for(int i = 1; i<=n;i++){
            a[i] = sc.nextInt();
            if(isLucky(a[i])) b[(int)(++count)] = a[i];
        }
        Arrays.sort(b,1,b.length);
        long sum = 0;
        dp[0] = 1;
        for(int i = 1; i<=count; i++){
            sum++;
            if(b[i]!=b[i+1] || i == count){
                tot++;
                for(int j = (int) tot;j>=1;j--){
                    dp[j] = (dp[j] + dp[j -1]*sum % MOD) %MOD;
                }
                sum = 0;
            }
        }
        long ans = 0;
        for(int i = 0; i<=k; i++){
            long tmp = dp[i] * helper(n - count,k - i) % MOD;
            ans = (ans + tmp) & MOD;
        }
        System.out.println(ans);
    }
}

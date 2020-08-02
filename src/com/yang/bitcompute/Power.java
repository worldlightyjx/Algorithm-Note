package com.yang.bitcompute;

public class Power {
    public static boolean is2Power(int n){
        return (n &(n-1)) == 0;
    }

    public static boolean is4Power(int n){
        return (n &(n-1)) == 0 && (n & 0x55555555) !=0; //0x55555555表示奇数位上为1，其他位上为0
    }
}

package com.yang.bitcompute;

import java.security.PublicKey;

/**
 * 使用位运算得到两个数最大的一个
 */
public class GetMax {
    //请保证参数不是一就是0，让1变零，零变1
    public static int flip(int n){
        return n^1;
    }
    //(n>>31) &1 使负数为1，正数变0，用flip函数使得让1变零，零变1，即负数为0，非负数为1
    public static int sign(int n){
        return flip((n>>31)&1);
    }

    public static int getMax1(int a, int b){
        int c = a- b; //不完美，它的结果可能会溢出
        /**
         * 下面的逻辑做了这样一件事
         * if(a-b >=0) return a
         * else return b
         */
        int scA = flip(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b){
        int c = a-b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffSab = sa ^ sb; //符号不一样为1，一样为0
        int sameSab = flip(diffSab); //a跟b的符号一样为 1， 不一样为0
        //当a，b符号不一样时，sa为正，返回sa，当符号一样时，sc即a与b的差为正时，返回a
        int returnA = diffSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;

    }
}

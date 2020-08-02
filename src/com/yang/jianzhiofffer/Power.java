package com.yang.jianzhiofffer;

public class Power {
    public static double Power(double base, int exponent){
        int e = 1;
        if(exponent==0){
            return 1;
        }else{
            e = exponent > 0? exponent:-exponent;
        }
        double multi = 1.00;
        while(e!=0){
            if((e&1)==1)
                multi *= base;
            base*=base;
            e >>= 1;
        }
        /*for(int i = 0; i<e;i++){
            multi *=base;
        }*/
        return exponent>0?multi : 1.0/multi;
    }

    public static void main(String[] args) {
        double res = Power(2,-3);
        System.out.println(res);
    }
}

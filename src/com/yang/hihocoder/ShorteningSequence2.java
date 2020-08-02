package com.yang.hihocoder;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class ShorteningSequence2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if(sc.nextInt()%2==0){
                even++;
            }else{
                odd++;
            }
        }
        System.out.println(Math.abs(even - odd));

    }




}

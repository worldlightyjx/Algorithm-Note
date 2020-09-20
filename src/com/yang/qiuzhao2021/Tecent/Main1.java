package com.yang.qiuzhao2021.Tecent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split("\\s+");

        int n = Integer.parseInt(values[0]);
        int k= Integer.parseInt(values[1]);
        String[] arr = br.readLine().split("\\s+");

        for (int i = 0; i <n ; i++) {
            if(i==k-1){
                continue;
            }
            System.out.printf("%s ",arr[i]);
        }


    }
}

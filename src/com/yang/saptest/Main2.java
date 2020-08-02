package com.yang.saptest;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numPeople = sc.nextInt();
        for(int i=0;i<n;i++){
            int ai = sc.nextInt();
            int bi = sc.nextInt();
            numPeople = numPeople + ai - bi;
            if(numPeople<0) numPeople = 0;
            System.out.println(numPeople);
        }
    }
}

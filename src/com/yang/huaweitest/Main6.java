package com.yang.huaweitest;

import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] stringArr =  input.split(",");
        int numCol = Integer.parseInt(stringArr[1]);
        String str = stringArr[0];
        int len = str.length();
        char[] strArr = str.toCharArray();
        int numRow = (len/numCol)*(numCol/2+1)+1;
        char[][] res = new char[numRow][numCol];
        for (int i = 0; i <numRow ; i++) {
            for (int j = 0; j <numCol ; j++) {
                res[i][j] = '#';
            }
        }
        int index = 0;
        while (index<len){
            int l = 0, r = numCol;
            int row = 0;
            while (l<r){
                res[row][l++] = strArr[index++];
                res[row][r--] = strArr[index++];
                if(index%2==0){
                    row++;
                }
            }
            if(l==r){
                res[row][l] = strArr[index];
                l--;
                r++;
            }
            while (l>=0){
                res[row][l--] = strArr[index++];
                res[row][r++] = strArr[index++];
                if(index%2==0){
                    row++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <res[0].length ; j++) {
            for (int i = 0; i <res.length ; i++) {
                if(res[i][j]!='#'){
                    sb.append(res[i][j]);
                }

            }
        }
        System.out.println(sb.toString());
    }
}

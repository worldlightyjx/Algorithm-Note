package com.yang.jianzhiofffer;

import java.util.ArrayList;

public class SpiralMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0)
            return res;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while(start * 2 < rows && start * 2 < columns){
            printMatrixHelper(matrix,rows,columns,start,res);
            start++;
        }
        return res;
    }

    public static void printMatrixHelper(int[][] matrxi,int rows,int columns,int start,ArrayList<Integer> res){
        int endX = columns - 1 - start; //终止列号
        int endY = rows - 1 - start;    //终止行号
        //不管剩余情况是怎样，第一行都会自己判断如何打印，也就说第一行怎么都会有的
        for (int i = start; i <=endX; i++) {
            res.add(matrxi[start][i]);
        }
        //有没有第第二次列的打印完全取决于终止行号是否大于起始号
        if(start < endY){
            for(int i=start + 1; i<=endY;i++){
                res.add(matrxi[i][endX]);
            }
        }
        //有没有第三次底部行的打印在第二次成立的基础上还得判断终止列号是否大于起始号
        if(start<endY&&start<endX){
            for (int i = endX-1; i >=start ; i--) {
                res.add(matrxi[endY][i]);
            }
        }

        //有没有第四次取决于是否终止行号比start多2并且终止列号大于start
        if(start< endY - 1 && start < endX){
            for (int i = endY - 1; i >start ; i--) {
                res.add(matrxi[i][start]);
            }
        }


    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8}};
        ArrayList<Integer> res = printMatrix(matrix2);
        for(int i : res){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}

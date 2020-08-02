package com.yang.jianzhiofffer;

public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++){
            for(int j = 0; j<array.length -1 -i;j++){
                if(!isOdd(array[j])&&isOdd(array[j+1])){
                    swap(array,j,j+1);
                }
            }
        }

    }
    public static boolean isOdd(int num){
        return (num%2) !=0;
    }
    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,6,7,9,7,5,13,6,8,4};
        reOrderArray(array);
        for(int i : array){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}

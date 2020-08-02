package com.yang.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestSort {
    private static void reverseArray(int[] nums){
        
        for(int i=0;i<nums.length/2;i++){
            int tmp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,0,34,34,23,56,19,18};
        //quickSort(arr);
        //QuickSort.threeWayQuickSort(arr,0,arr.length-1);
        //BubbleSort.bubbleSort(arr);
        //ShellSort.shellSort(arr);
        MergeSort.mergeSort(arr);

//        Arrays.sort(arr);
//        reverseArray(arr);
        SortUtil.pringArr(arr);

    }
}

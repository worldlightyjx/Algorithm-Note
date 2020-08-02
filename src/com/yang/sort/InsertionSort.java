package com.yang.sort;

public class InsertionSort {
    public static void insertionSort(int[] nums){
        for(int i = 1; i<nums.length;i++){
            for(int j=i;j>0;j--){
                if(nums[j] < nums[j-1])
                    SortUtil.swap(nums,j-1,j);
            }
        }
    }
}

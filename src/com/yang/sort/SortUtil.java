package com.yang.sort;

public class SortUtil {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void pringArr(int[] nums){
        if(nums==null) throw new RuntimeException("error");
        for(int num: nums){
            System.out.print(num+"-");
        }
    }
}

package com.yang.sort;

public class BubbleSort {
    public static void bubbleSort(int[] nums){
        int length = nums.length;
        boolean flag = false;
        for(int i=length - 1;i>=0;i--){
            flag = true;
            for (int j = 0; j<i;j++){
                if(nums[j+1] < nums[j]){
                    flag = false;
                    SortUtil.swap(nums,j,j+1);
                }
            }
            if(flag) break;
        }
    }


}

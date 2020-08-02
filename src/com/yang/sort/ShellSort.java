package com.yang.sort;

public class ShellSort {
    public static void shellSort(int[] nums){
        int N = nums.length;
        int h = 1;
        while(h < N/3){
            h = h * 3 +1;
        }

        while (h>=1){
            for(int i = h; i<N;i++){
                for(int j = i; j>=h;j-=h){
                    if(nums[j] < nums[j-h]){
                        SortUtil.swap(nums,j,j-h);
                    }
                }
            }
            h = h/3;
        }
    }
}

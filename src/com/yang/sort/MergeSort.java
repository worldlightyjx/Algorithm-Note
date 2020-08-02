package com.yang.sort;


public class MergeSort {
    public static void mergeSort(int[] nums){
        //mergeSortHelperRecursive(nums,0, nums.length - 1);
        mergeSortHelperIterative(nums);
    }

    public static void mergeSortHelperRecursive(int[] nums, int l, int r){
        if(l<r){
            int mid = (l + r) /2;
            mergeSortHelperRecursive(nums,l,mid);
            mergeSortHelperRecursive(nums,mid+1,r);
            merge(nums,l,mid,r);
        }
    }
    public static void mergeSortHelperIterative(int[] nums) {
        int len = 1;
        while (nums.length>len){
            for (int i = 0; i +len<=nums.length-1 ; i+=len*2) {
                int l = i;
                int mid = i + len - 1;
                int r  = i+len*2-1;
                if(r>nums.length-1) r= nums.length-1;

                merge(nums,l,mid,r);


            }
            len*=2;
        }
    }

    public static void merge(int[] nums, int l, int mid, int r){
        int i = l, j = mid+1;
        int[] tmp = new int[r-l + 1];
        int index = 0;
        while (i <= mid && j<=r){
            if(nums[i] <= nums[j]){
                tmp[index++] = nums[i++];
            }else{
                tmp[index++] = nums[j++];
            }
        }
        while (i<=mid) tmp[index++] = nums[i++];
        while (j<=r) tmp[index++] = nums[j++];

        for (int k = 0; k <index ; k++) {
            nums[l+k] = tmp[k];
        }
    }
}

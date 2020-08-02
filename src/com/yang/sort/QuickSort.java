package com.yang.sort;

public class QuickSort {
    public static void quickSort(int[] nums){
        quicksortHelper(nums,0,nums.length - 1);
    }
    public static void quicksortHelper(int[] nums, int l, int r){
        if(l<r){
            int pivot = patrition(nums,l,r);
            quicksortHelper(nums,l,pivot - 1);
            quicksortHelper(nums,pivot+1,r);
        }

    }

    public static int patrition(int[] nums,int l, int r){
        int target = nums[l];
        while (l<r){
            while (l<r&&nums[r]>target) r--;
            nums[l] = nums[r];
            while (l<r&&nums[l] <= target) l++;
            nums[r] = nums[l];
        }
        nums[l] = target;
        return l;

    }
    public static void threeWayQuickSort(int[] nums, int l, int r){
        if(r<=l) return;
        int lt = l, i = l + 1, gt = r;
        int target = nums[l];
        while(i<=gt){
            if(nums[i] < target) swap(nums,lt++,i++);
            else if(nums[i] > target) swap(nums,i,gt--);
            else i++;
        }
        threeWayQuickSort(nums,l,lt - 1);
        threeWayQuickSort(nums,gt+1,r);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {


    }


}

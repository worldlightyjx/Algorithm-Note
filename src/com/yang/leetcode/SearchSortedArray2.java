package com.yang.leetcode;

public class SearchSortedArray2 {
    public static boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]==target) return true;

            if(nums[lo]<nums[mid]||nums[hi]<nums[mid]){
                if((nums[lo]<=target)&&(target<nums[mid])){
                    hi = mid - 1;
                }else{
                    lo = mid +1;
                }
            }else if(nums[lo]>nums[mid]||nums[hi]>nums[mid]){
                if((nums[hi]>=target)&&(target>nums[mid])){
                    lo = mid +1;
                }else{
                    hi = mid - 1;
                }
            }else{
                hi--;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search(nums,target));
    }

}

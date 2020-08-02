package com.yang.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        helper1(res,nums,new ArrayList<Integer>(),new boolean[nums.length]);
        return res;

    }

    public static ArrayList<ArrayList<Integer>> permuteUnique2(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        helper2(res,nums,0);
        return res;

    }
    public static void helper2(ArrayList<ArrayList<Integer>> res, int[] nums, int start){
        if(start==nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            if(!res.contains(list)){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <nums.length ; i++) {
            swap(nums,start,i);
            helper2(res,nums,start + 1);
            swap(nums,start,i);
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;

    }
    public static void helper1(ArrayList<ArrayList<Integer>> res, int[] nums, ArrayList<Integer> list,boolean[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            helper1(res,nums,list,used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res = permuteUnique2(new int[]{1,2,2,3});
        for(ArrayList<Integer> list : res){
            for(int num : list){
                System.out.print(num);
            }
            System.out.println();
        }
    }
}

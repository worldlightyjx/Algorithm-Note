package com.yang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        permuteHelper(res, 0, nums);
        return res;
    }

    public static void permuteHelper(List<List<Integer>> res, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteHelper(res, start + 1, nums);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;

    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res = permute(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

}

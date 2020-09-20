package com.yang.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution491 {
    static List<List<Integer>> ans;

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> res = findSubsequences(nums);
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        ans = new LinkedList<>();
        if(nums==null){
            return ans;
        }
        dfs(nums,new LinkedList<Integer>(),0);
        return ans;
    }

    private static void dfs(int[] nums,List<Integer> tmp, int start){
        if(tmp.size()>=2){
            ans.add(new LinkedList<>(tmp));

        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if(tmp.size()>0&&nums[i]<tmp.get(tmp.size()-1)||set.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

}

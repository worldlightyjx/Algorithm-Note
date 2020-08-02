package com.yang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation2Test {
    static int n;
    static List<List<Integer>> res;
    static LinkedList<Integer> tmp;
    static boolean[] vis;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        vis = new boolean[n];
        tmp = new LinkedList<>();
        dfs(nums,0);
        return res;
    }

    private static void dfs(int[] nums, int u){
        if(u==n){
            res.add(new LinkedList<>(tmp));
            return;
        }

        for(int i = 0; i<n; i++){
            if(!vis[i]){
                if(i>=1&&nums[i]==nums[i-1]&&!vis[i-1]) continue;
                vis[i] = true;
                tmp.add(nums[i]);
                dfs(nums,u+1);
                vis[i] = false;
                tmp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,2,3};
        List<List<Integer>> list = permuteUnique(nums);
        System.out.println(list);
    }

}

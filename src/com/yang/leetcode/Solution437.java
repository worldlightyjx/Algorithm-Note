package com.yang.leetcode;

import java.util.HashMap;

public class Solution437 {


    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int sum) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return preOrder(root,sum,0,map);

    }

    public int preOrder(TreeNode root, int sum,int curSum,HashMap<Integer,Integer> map){
        if(root==null){
            return 0;
        }
        int res = 0;
        curSum += root.val;
        res+=map.getOrDefault(curSum-sum,0);
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        res+=preOrder(root.left,sum,curSum,map);
        res+=preOrder(root.right,sum,curSum,map);

        map.put(curSum,map.get(curSum)-1);
        return res;
    }
}

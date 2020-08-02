package com.yang.jianzhiofffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

    static class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int level = 0;
        int tobePrinted = 1;
        queue.offer(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if(tmp.left!=null){
                queue.offer(tmp.left);
                level++;
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
                level++;
            }

            tobePrinted--;
            if(tobePrinted==0){
                res.add(new ArrayList<>(list));
                list.clear();
                tobePrinted = level;
                level=0;
            }
        }
        return res;

    }


}

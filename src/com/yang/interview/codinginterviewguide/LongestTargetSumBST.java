package com.yang.codinginterviewguide;

import java.util.HashMap;

public class LongestTargetSumBST {

    static class Tree {

        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(-3);
        Tree secondeLeft = tree.left = new Tree(3);
        Tree secodeRight = tree.right = new Tree(-9);
        secondeLeft.left = new Tree(1);
        secondeLeft.right = new Tree(0);
        secodeRight.left = new Tree(2);
        secodeRight.right = new Tree(1);
        secondeLeft.right.left = new Tree(1);
        secondeLeft.right.right = new Tree(6);

        int maxLength = getMaxLenght(tree,6);
        System.out.println(maxLength);
    }

    public static int getMaxLenght(Tree head, int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        return preOrder(head,sum,0,1,0,map);
    }


    public static int preOrder(Tree head, int sum, int preSum, int level, int maxLen, HashMap<Integer,Integer> map){
        if(head==null){
            return maxLen;
        }
        int curSum = preSum + head.val;
        if(!map.containsKey(curSum)){
            map.put(curSum,level);
        }
        if(map.containsKey(curSum-sum)){
            maxLen = Math.max(maxLen,level-map.get(curSum-sum));
        }
        maxLen = preOrder(head.left,sum,curSum,level+1,maxLen,map);
        maxLen = preOrder(head.right,sum,curSum,level+1,maxLen,map);

        if(map.containsKey(curSum)){
            map.remove(curSum);
        }
        return  maxLen;
    }

}

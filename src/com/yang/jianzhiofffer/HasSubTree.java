package com.yang.jianzhiofffer;

public class HasSubTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean hasSubtree(TreeNode root1, TreeNode root2){
        boolean result = false;
        if(root1!=null && root2!=null){
            result = hasSubtreehelper(root1,root2);
            if(!result)
                result = hasSubtree(root1.left,root2);
            if(!result)
                result = hasSubtree(root1.right,root2);
        }
        return result;
    }

    private boolean hasSubtreehelper(TreeNode root1, TreeNode root2) {

        if(root2==null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val){
            return false;
        }
        return hasSubtreehelper(root1.left,root2.left) && hasSubtreehelper(root1.right,root2.right);
    }

}

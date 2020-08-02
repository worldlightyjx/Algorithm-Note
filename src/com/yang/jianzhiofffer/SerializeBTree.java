package com.yang.jianzhiofffer;

public class SerializeBTree {
    int index = -1;
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

    static String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb,root);
        String res = null;
        if(sb.length()!=0){
            sb.deleteCharAt(sb.length() - 1);
            res = sb.toString();
        }
        return res;

    }
    public static void serializeHelper(StringBuilder sb, TreeNode root){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val+",");
        serializeHelper(sb,root.left);
        serializeHelper(sb,root.right);
    }

    TreeNode Deserialize(String str) {
        index++;

        TreeNode node = null;
        String[] value = str.split(",");
        if(value[index]!="#"){
            node = new TreeNode(Integer.parseInt(value[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(8);
        node1.left = node3;
        node1.right = node4;
        
        String str = Serialize(root);
        System.out.println(str);
    }

}



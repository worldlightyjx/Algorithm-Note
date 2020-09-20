package com.yang.sina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main1 {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line=in.readLine())!=null){
            TreeNode root = stringToTree(line);

            TreeNode ret = upsideDown(root);
            System.out.println(leveOrder(ret));
        }
    }

    public static String leveOrder(TreeNode root){
        if(root==null){
            return "";
        }
        String output = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node==null){
                continue;
            }
            output+=String.valueOf(node.val)+",";
            queue.add(node.left);
            queue.add(node.right);
        }

        return output.substring(0,output.length()-1);


    }

    public static TreeNode upsideDown(TreeNode root){
        TreeNode p = null, pr = null;
        while (root!=null){
            TreeNode rleft = root.left;
            root.left = pr;
            pr = root.right;
            root.right = p;
            p = root;
            root = rleft;
        }
        return p;
    }

    public static TreeNode stringToTree(String input){
        input = input.trim();
        if(input.length()==0){
            return null;
        }
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();

            if(index == parts.length){
                break;
            }
            item = parts[index++];
            item=item.trim();
            if(!item.equals("null")){
                node.left = new TreeNode(Integer.parseInt(item));
                queue.add(node.left);
            }


            if(index == parts.length){
                break;
            }
            item = parts[index++];
            item=item.trim();
            if(!item.equals("null")){
                node.right = new TreeNode(Integer.parseInt(item));
                queue.add(node.right);
            }
        }

        return root;
    }
}

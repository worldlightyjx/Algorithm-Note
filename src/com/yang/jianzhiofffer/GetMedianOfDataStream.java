package com.yang.jianzhiofffer;

public class GetMedianOfDataStream {

    class TreeNode {

        int val;
        int height;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }
    private TreeNode root;
    private int getHeight(TreeNode root) {
        return root == null ? 0 : root.height;
    }
    private void updateHeight(TreeNode root){
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
    private int getBanlanceFactor(TreeNode root){
        return getHeight(root.left) - getHeight(root.right);
    }
    //将LL型树反转回平衡
    private TreeNode rotateLL(TreeNode root){
        TreeNode tmp = root.left;
        root.left = tmp.right;
        tmp.right = root;
        updateHeight(root);
        updateHeight(tmp);
        return tmp;
    }

    //将RR型反转回平衡
    private TreeNode rotateRR(TreeNode root){
        TreeNode tmp = root.right;
        root.right = tmp.left;
        tmp.left = root;
        updateHeight(root);
        updateHeight(tmp);
        return tmp;
    }

    TreeNode insert(TreeNode root, int num){
        if(root==null){
            return new TreeNode(num);
        }
        if(num < root.val){
            root.left = insert(root.left,num);
            updateHeight(root);
            if(getBanlanceFactor(root) == 2){
                if(getBanlanceFactor(root.left) == 1){ // LL
                    root = rotateLL(root);
                }else if(getBanlanceFactor(root.left)==-1){ // LR, 先 rotateRR（root.left）再rotateLL（root）
                    root.left = rotateRR(root.left);
                    root = rotateLL(root);

                }
            }
        }else{
            root.right = insert(root.right,num);
            updateHeight(root);
            if(getBanlanceFactor(root) == -2){
                if(getBanlanceFactor(root.right) == -1){ // RR
                    root = rotateRR(root);
                }else if(getBanlanceFactor(root.right)==1){ // RL, 先 rotateLL（root.right）再rotateLL（root）
                    root.right = rotateLL(root.right);
                    root = rotateRR(root);

                }
            }
        }
        return root;
    }



    private void preorder(TreeNode root){
        if(root!=null){
            System.out.print(root.val+ " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void Insert(Integer num) {
        root = insert(root, num);
    }

    public Double GetMedian() {
        int lc = countNodeNume(root.left), rc = countNodeNume(root.right);
        if(lc == rc) return (double)root.val;
        else{
            TreeNode tmp;
            if(lc > rc){
                tmp = root.left;
                while (tmp.right!=null){
                    tmp = tmp.right;
                }
            }else{
                tmp = root.right;
                while (tmp.left!=null){
                    tmp = tmp.left;
                }
            }
            return (root.val+tmp.val)/2.0;
        }

    }

    private int countNodeNume(TreeNode root){
        if(root == null) return 0;
        else
            return countNodeNume(root.left) + countNodeNume(root.right) + 1;
    }



    public static void main(String[] args) {
        //无法用采用高度平衡的AVL树解决数据流的中位数，应当用节点数目平衡的AVL数解决这道题
        GetMedianOfDataStream tree = new GetMedianOfDataStream();
        tree.root = tree.insert(tree.root, 5);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 2);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 3);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 4);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 1);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 6);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 7);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 0);
        System.out.print(tree.GetMedian()+" ");
        tree.root = tree.insert(tree.root, 8);
        System.out.print(tree.GetMedian()+" ");

        System.out.println();
        tree.preorder(tree.root);

    }
}

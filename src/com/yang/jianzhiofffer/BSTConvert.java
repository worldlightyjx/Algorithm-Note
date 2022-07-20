package src.com.yang.jianzhiofffer;


public class BSTConvert {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNode = null;
        lastNode = convertHelper(pRootOfTree,lastNode);
        TreeNode headNode = lastNode;
        while (headNode!=null&&headNode.left!=null){
            headNode = headNode.left;
        }
        return headNode;
    }

    private static TreeNode convertHelper(TreeNode pRootOfTree, TreeNode lastNode) {
        if(pRootOfTree == null){
            return lastNode;
        }
        TreeNode pCur = pRootOfTree;
        if(pCur.left!=null){
            lastNode = convertHelper(pCur.left,lastNode);
        }


        pCur.left = lastNode;
        if(lastNode!=null)
            lastNode.right = pCur;
        lastNode = pCur;

        if(pCur.right!=null){
            lastNode = convertHelper(pCur.right,lastNode);
        }
        return lastNode;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right=node5;

        TreeNode head = Convert(node1);

    }

}

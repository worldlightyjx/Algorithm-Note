package src.com.yang.rbtree;

public class MyRBTree<K extends Comparable<K>, V>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;
    private int count;

    public MyRBTree(){
        root=null;
        count = 0;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }

    private boolean isRed(Node node){
        if(node==null) return BLACK;
        return node.color;
    }

    public void add(K key, V value){
        root = add(root,key,value);
        root.color = BLACK;
    }
    //左旋转
    private Node leftRotate(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }
    //右旋转
    private Node rightRotate(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    private Node add(Node node, K key, V value){
        if(node==null){
            count++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key)>0)
            node.right = add(node.right, key, value);
        else
            node.value = value;

        if(isRed(node.right)&&isRed(node.left)){
            node=leftRotate(node);
        }

        if(isRed(node.left)&& isRed(node.left.left)){
            node= rightRotate(node);
        }
        if(isRed(node.left)&&isRed(node.right)){
            flipColors(node);
        }

        return node;
    }



}
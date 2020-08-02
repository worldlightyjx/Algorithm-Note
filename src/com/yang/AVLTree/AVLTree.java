package com.yang.AVLTree;

/**
 *
 * @param <Key>
 * @param <Value>
 */
public class AVLTree<Key extends Comparable<Key>, Value>{

    private class Node{
        Key key;
        Value value;

        Node left;
        Node right;
        int height;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
            this.height = node.height;
        }
    }

    /*
        根节点
     */
    private Node root;
   /*
        节点数
    */
   private int count;

   public AVLTree(){
       root=null;
       count = 0;
   }

   public int size(){return count;}
   public boolean isEmpty(){return count==0;}
   public void insert(Key key, Value value){

   }



}

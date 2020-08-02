package com.yang.bytedance;

/**
 * 题目描述：一个链表，奇数位升序偶数位降序，让链表变成升序的。
 *
 * 比如：1 8 3 6 5 4 7 2 9，最后输出1 2 3 4 5 6 7 8 9。
 */
class Node{
    int val;
    Node next;
    Node(int x){
        this.val = x;
        this.next = null;
    }
}
public class ReSortOddEvenLinkedList {


    public static void main(String[] args) {
        Node head = init();
        printList(head);
        Node[] headList = getNodeList(head);
        Node head1 = headList[0];
        Node head2 = headList[1];
        head2 = reverseList(head2);
        printList(head1);
        printList(head2);
        printList(mergeTwoSortedList(head1,head2));
    }

    private static Node[] getNodeList(Node head){
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        Node cur1 = dummy1, cur2 = dummy2;
        int count = 1;
        while (head!=null){
            if(count%2==1){
                cur1.next = head;
                cur1 = head;
            }else{
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
            count++;
        }
        cur1.next = null;
        cur2.next = null;
        return new Node[]{dummy1.next,dummy2.next};
    }
    private static Node reverseList(Node head){
        if(head==null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = dummy;
        Node cur = head.next;
        Node last = head;
        while (cur!=null){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return dummy.next;

    }
    private static Node mergeTwoSortedList(Node head1, Node head2){
        Node head = new Node(-1);
        Node cur = head;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur=cur.next;
        }
        if(head1!=null){
            cur.next = head1;
        }
        if(head2!=null){
            cur.next = head2;
        }
        return head.next;
    }
    private static Node init(){
        Node node1 = new Node(1);
        Node node2 = new Node(8);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(5);
        Node node6 = new Node(4);
        Node node7 = new Node(7);
        Node node8 = new Node(2);
        Node node9 = new Node(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }

    private static void printList(Node head){
        Node cur = head;
        while (cur!=null){
            System.out.print(cur.val);
            if(cur.next!=null)
                System.out.print("->");
            cur=cur.next;
        }
        System.out.println();
    }

}

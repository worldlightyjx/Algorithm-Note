package com.yang.codeup;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Jugs {
    static boolean[][] status = new boolean[1001][1001];
    static class Node{
        int a,b;
        int state;
        Node pre;

        Node(int a, int b){
            this.a = a;
            this.b = b;
            this.pre = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            for(int i=0;i<1001;i++){
                for(int j=0;j<1001;j++){
                    status[i][j] = false;
                }
            }
            Node res = BFS(A,B,C);
            Stack<Node> st = new Stack<>();
            while (res.pre!=null){
                st.push(res);
                res=res.pre;
            }
            while (!st.isEmpty()){
                Node tmp = st.pop();
                if(tmp.state==0)
                    System.out.println("fill A");
                else if(tmp.state==1)
                    System.out.println("fill B");
                else if(tmp.state==2)
                    System.out.println("empty A");
                else if(tmp.state==3)
                    System.out.println("empty B");
                else if(tmp.state==4)
                    System.out.println("pour A B");
                else if(tmp.state==5)
                    System.out.println("pour B A");
            }
            System.out.println("success");
        }

    }

    public static Node BFS(int A,int B,int C){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        while (!queue.isEmpty()){
            Node x = queue.poll();
            int a = x.a, b = x.b;
            for(int d=0;d<6;d++){
                int na = -1;
                int nb = -1;
                //fill A
                if(d==0){
                    na = A;
                    nb = b;
                }
                //fill B
                else if(d==1){
                    na = a;
                    nb = B;
                }
                //Drop A
                else if(d==2){
                    na = 0;
                    nb = b;
                }
                else if(d==3){
                    na = a;
                    nb = 0;
                }
                //pour A to B
                else if(d==4){
                    nb = Math.min(B,a+b);
                    na = a+b - nb;
                }
                else if(d==5){
                    na = Math.min(A,a+b);
                    nb = a+b-na;
                }
                if(status[na][nb]==false){
                    status[na][nb]=true;
                    Node next = new Node(na,nb);
                    next.pre = x;
                    next.state = d;
                    queue.offer(next);
                    if(na==C||nb==C)
                        return next;
                }

            }
        }
        return new Node(-1,-1);
    }
}

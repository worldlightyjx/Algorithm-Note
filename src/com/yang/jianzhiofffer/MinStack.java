package com.yang.jianzhiofffer;

import java.util.Stack;

public class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> minst = new Stack<>();
    public void push(int node) {
        st.push(node);
        if(minst.isEmpty()){
            minst.push(node);
        }else if(node<minst.peek()){
            minst.push(node);
        }else{
            minst.push(minst.peek());
        }
    }

    public void pop() {
        st.pop();
        minst.pop();
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return minst.peek();
    }
}

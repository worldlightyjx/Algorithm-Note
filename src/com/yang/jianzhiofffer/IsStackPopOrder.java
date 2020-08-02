package com.yang.jianzhiofffer;

import java.util.Stack;

public class IsStackPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean flag = false;
        Stack<Integer> st = new Stack<>();
        int indexPush = 0, indexPop = 0;
        while(indexPop < popA.length){
            while(st.isEmpty() || st.peek()!=popA[indexPop]){
                if (indexPush == pushA.length) break;
                st.push(pushA[indexPush]);
                indexPush++;
            }
            if(st.peek()!=popA[indexPop]) break;
            st.pop();
            indexPop++;
        }
        if(st.isEmpty()&&indexPop==popA.length) flag = true;
        return flag;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] pushB = {4,5,3,2,1};
        IsStackPopOrder isStackPopOrder = new IsStackPopOrder();
        System.out.println(isStackPopOrder.IsPopOrder(pushA,pushB));
    }
}

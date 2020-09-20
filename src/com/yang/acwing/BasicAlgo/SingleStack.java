package com.yang.acwing.BasicAlgo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SingleStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i <n ; i++) {
            while (!st.isEmpty()&&st.peek()>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        for (int i = 0; i <ans.length ; i++) {
            System.out.printf("%d ",ans[i]);
        }

    }
}

package com.yang.leetcode;

import java.util.HashMap;

public class DecodeWays {
    public static int numDecodings(String s) {
        return s.isEmpty()?0:dfs(s,0);

    }
    private static int dfs(String s, int index){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        int res = dfs(s,index+1);
        if(index<s.length()-1&&(s.charAt(index)=='1'
                ||(s.charAt(index)=='2'&&s.charAt(index+1)<'7'))){
            res += dfs(s, index+2);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(numDecodings(str));

    }

}

package com.yang.bytedance;

import java.util.ArrayList;
import java.util.List;


public class Main3 {
    private final static String[] CHARS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> Phonecombination(String digits, List<String> dict){
        List<String> res = new ArrayList<>();
        if(digits==null||digits.length()==0) return res;
        dfs(0,digits.length(),digits,"",res, dict);
        return res;
    }

    private static void dfs(int start, int end, String digits, String cur, List<String> res, List<String> dict){
        if(start==end){
            if(dict.contains(cur))
                res.add(cur);
            return;
        }
        int idx = digits.charAt(start)-'0';
        for(char c : CHARS[idx].toCharArray()){
            dfs(start+1,end,digits,cur+c,res,dict);
        }
    }


}

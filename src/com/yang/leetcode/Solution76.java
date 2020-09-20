package com.yang.leetcode;

import java.util.HashMap;

public class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> wind= new HashMap<>();
        for(char c : t.toCharArray()){
           if(need.containsKey(c)){
               need.put(c,need.get(c)+1);
           }else{
               need.put(c,1);
           }
        }
        int l = 0, r = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        while (r<t.length()){
            char c = s.charAt(r);
            r++;
            if(need.getOrDefault(c,0)>0){
                if(wind.containsKey(c)){
                    wind.put(c,wind.get(c)+1);
                }else{
                    wind.put(c,1);
                }
                if(wind.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (valid==need.size()){
                if(r-l <len){
                    start = l;
                    len = r- l;
                }
                char d = s.charAt(l);
                l++;
                if(need.getOrDefault(d,0)>0){
                    if(wind.get(d).equals(need.get(d))){
                        valid--;
                    }
                    wind.put(d,wind.get(d)-1);
                }
            }

        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);

    }

}

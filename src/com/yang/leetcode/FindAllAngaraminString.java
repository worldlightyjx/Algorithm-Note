package com.yang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAngaraminString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> wind = new HashMap<>();
        for (char c : p.toCharArray()){
            if(need.containsKey(c)){
                need.put(c,need.get(c)+1);
            }else{
                need.put(c,1);
            }
        }
        int valid = 0;
        int l = 0, r = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                if(wind.containsKey(c)){
                    wind.put(c,wind.get(c)+1);
                }else{
                    wind.put(c,1);
                }
                if(need.get(c).equals(wind.get(c))){
                    valid++;
                }
            }

            while (r-l>=p.length()){
                if(valid==need.size()){
                    res.add(l);
                }
                char d = s.charAt(l);
                l++;
                if(need.containsKey(d)){
                    if(wind.get(d).equals(need.get(d))){
                        valid--;
                    }
                    wind.put(d,wind.getOrDefault(d,0)-1);
                }
            }

        }
        return res;
    }
}

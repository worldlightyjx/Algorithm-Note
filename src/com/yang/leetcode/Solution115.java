package com.yang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution115 {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s,t));
    }

    // public int numDistinct(String s, String t) {
    //     int[][] dp = new int[s.length()+1][t.length()+1];
    //     for (int i = 0; i <=s.length() ; i++) {
    //         dp[i][t.length()] = 1;
    //     }
    //     for (int ti = t.length()-1; ti >= 0; ti--) {
    //         dp[s.length()][ti] = 0;//当s串为0的时候只有0个选法
    //         for (int si = s.length()-1; si >=0;si--) {
    //             if(s.charAt(si)==t.charAt(ti)){
    //                 dp[si][ti] = dp[si+1][ti+1]+dp[si+1][ti];
    //             }else{
    //                 dp[si][ti] = dp[si+1][ti];
    //             }
    //         }
    //     }
    //     return dp[0][0];
    // }

    public static int numDistinct(String s, String t) {
        return dfs(s, t, 0, 0, new HashMap<String, Integer>());
    }

    private static int dfs(String s, String t, int s_start, int t_start, Map<String, Integer> map) {
        if (t_start == t.length()) {
            return 1;
        }
        if (s_start == s.length()) {
            return 0;
        }


        String key = s_start + "@" + t_start;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int count = 0;
        if (s.charAt(s_start) == t.charAt(t_start)) {
            count = dfs(s, t, s_start + 1, t_start + 1, map) +
                    dfs(s, t, s_start + 1, t_start, map);
        } else {
            count = dfs(s, t, s_start + 1, t_start, map);
        }
        map.put(key, count);
        return count;
    }


}

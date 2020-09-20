package com.yang.leetcode;

import java.util.Arrays;

public class Solution940D {

        public int distinctSubseqII(String s) {
            int[] dp = new int[s.length()+1];
            int[] cnt = new int[128];
            Arrays.fill(cnt,-1);
            for (int i = 0; i <s.length() ; i++) {
                if(cnt[s.charAt(i)-'a']<0){
                    //s[i]没有出现过
                    dp[i+1] = dp[i]*2+1;
                }else{
                    dp[i+1] = dp[i]*2-dp[cnt[s.charAt(i)-'a']];
                    if(dp[i+1]<0) dp[i+1] +=1000000007;
                }
                dp[i+1]%=1000000007;
                cnt[s.charAt(i)-'a'] = i;

            }
            return dp[s.length()];
        }


}

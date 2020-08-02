package com.yang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress{

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res;
        res = restoreIpAddresses(s);
        for (String str : res){
            System.out.println(str);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s,res,"",0,0);
        return res;
    }


    private static void dfs(String ip, List<String> res, String cur, int index, int count){
        if(count>4||index>ip.length()) return;
        if(index==ip.length()&&count==4) res.add(cur);

        for (int i = 1; i < 4; i++) {
            if(index+i>ip.length()) break;
            String str = ip.substring(index, index+i);
            if((str.length()>1&&str.startsWith("0"))||(i==3&&Integer.parseInt(str)>=256)) continue;
            dfs(ip, res, cur+str+(count==3?"":"."), index+i, count+1);
        }
    }
}
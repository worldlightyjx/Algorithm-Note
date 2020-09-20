package com.yang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress{

    public static void main(String[] args) {
        String s = "0000";
        List<String> res;
        res = restoreIpAddresses(s);
        for (String str : res){
            System.out.println(str);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs2(s,res,0,0,"");
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

    private static void dfs2(String s, List<String> ans, int u, int cnt, String path){
        if (u==s.length()){
            if(cnt==4){
                ans.add(path.substring(1));
            }
            return;
        }
        if(cnt>4) return;
        if(s.charAt(u)=='0'){
            dfs2(s,ans,u+1,cnt+1,path+".0");
        }else{
            for (int i = u, t = 0; i <s.length() ; i++) {
                t = t * 10 + (s.charAt(i)-'0');
                if(t<256)
                    dfs2(s,ans,i+1,cnt+1,path+"."+t);
                else
                    break;
            }

        }

    }
}
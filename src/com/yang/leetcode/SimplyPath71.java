package com.yang.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SimplyPath71 {

        public String simplifyPath(String path) {
            ArrayList<String> list = new ArrayList<>();
            int i = 0;
            int n = path.length();
            while(i<n){
                while(i<n&&path.charAt(i)=='/') i++; //这是错的，i<n应当放在前面，不然回报错outofbounds
                if(i==n) break;
                int start = i;
                while(i<n&&path.charAt(i)!='/') i++;
                int end = i;
                String tmp = path.substring(start, end);
                if(tmp.equals("..")){
                    if(!list.isEmpty()) list.remove(list.size() - 1);
                }else if(!tmp.equals(".")){
                    list.add(tmp);
                }

            }
            if(list.isEmpty()) return "/";
            String res = "";
            for(String str:list){
                res+="/"+ str;
            }
            return res;
        }





        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                String path = line;

                String ret = new SimplyPath71().simplifyPath(path);

                String out = (ret);

                System.out.print(out);
            }
        }

}

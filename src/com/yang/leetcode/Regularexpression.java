package com.yang.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Regularexpression {
    static final int EDGE= -1;
    public boolean isMatch(String s, String p) {
        return helper(s,p,s.length() - 1,p.length()-1);
    }

    private boolean helper(String s, String p, int i, int j){
        if(j==EDGE){
            if(i==EDGE) return true;

        }else return false;
        //if(i<=EDGE||j<=EDGE) return false;

        if(p.charAt(j)=='*'){
            if(i>EDGE&&(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i))){
                if(helper(s, p, i-1, j)) return true;

            }
            return helper(s, p, i, j-2);
        }
        if(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'){
            return helper(s, p, i-1, j-1);
        }
        return false;
    }
}

class MainClass {
    public static String stringToString(String input) {
        return null;
        //return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String p = stringToString(line);

            boolean ret = new Regularexpression().isMatch(s, p);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
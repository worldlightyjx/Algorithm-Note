package com.yang.KMP;

public class KMP {
    public static int getIndexof(String s, String m){
        if(s==null||m==null||m.length()>s.length()||m.length()<1)
            return -1;
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int x =0, y=0;
        int[] next = getNextArray(str2);
        while (x<str1.length&&y<str2.length){
            if(str1[x]==str2[y]){
                x++;
                y++;
            }else if(next[y]==-1){
                x++;
            }else{
                y = next[y];
            }
        }
        return y==str2.length?x-y:-1;
    }
    public static int[] getNextArray(char[] str2){
        if(str2.length == 1){
            return new int[] {-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i< str2.length){
            if(str2[i - 1] == str2[cn])
                next[i++] = ++cn;
            else if(cn > 0)
                cn = next[cn];
            else
                next[i++] = 0;
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababacccggdgergevdfafgabbfefetabaferfefabbaabarfef";
        String match = "ababa";
        System.out.println(getIndexof(str, match));
    }

    }

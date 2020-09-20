package com.yang.acwing;

import java.util.*;
import java.io.*;

public class Topolgic{
    static int n,m;
    static int idx = 0;
    static int[] h;
    static int[] e;
    static int[] ne;
    static int[] d;
    static List<Integer> res = new ArrayList<>();

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static boolean topsort(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=n;i++){
            if(d[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int t = queue.poll();
            res.add(t);
            for(int i = h[t];i!=-1;i=ne[i]){
                int j = e[i];
                d[j]--;
                if(d[j]==0) {
                    queue.offer(j);
                }
            }
        }

        return res.size() == n;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] values = br.readLine().split("\\s+");
        n = Integer.parseInt(values[0]);
        m = Integer.parseInt(values[1]);

        h = new int[n+1];
        e = new int[m+1];
        ne = new int[m+1];
        d = new int[n+1];
        Arrays.fill(h,-1);

        for(int i = 0; i<m;i++){
            values = br.readLine().split("\\s+");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            add(a,b);
            d[b]++;
        }
        if(topsort()){
            for(Integer val : res){
                log.write(val+" ");
            }
        }else{
            log.write("-1");
            log.flush();
            log.close();
        }
        log.flush();
        log.close();
    }

}
package com.yang.bytedance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main4 {
    static class ResNode{
        int minScore;
        String siteNum;

        public ResNode(int minScore, String siteNum) {
            this.minScore = minScore;
            this.siteNum = siteNum;
        }
    }

    public static List<String> getSiteNumList(int[][][] siteScore, int m){
        List<String> res = new ArrayList<>();
        PriorityQueue<ResNode> maxHeap = new PriorityQueue<>(new Comparator<ResNode>() {
            @Override
            public int compare(ResNode o1, ResNode o2) {
                return o2.minScore - o1.minScore;
            }
        });
        int n = siteScore[0].length;
        int l = siteScore[0][0].length;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j<l; j++){
                int minScore = Math.min(siteScore[0][i][j],siteScore[0][i][j]);
                ResNode resNode = new ResNode(minScore,i+"-"+j);
                if(maxHeap.size()==m&&minScore>maxHeap.peek().minScore){
                    maxHeap.poll();
                    maxHeap.add(resNode);
                }else{
                    maxHeap.add(resNode);
                }
            }
        }
        return res;



    }
}

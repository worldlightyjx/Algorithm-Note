package com.yang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1514Djsktra {
    class Pair implements Comparable<Pair>{
        double probability;
        int node;

        Pair(double probability, int node) {
            this.probability = probability;
            this.node = node;
        }

        @Override
        public int compareTo(Pair p2) {
            if (this.probability==p2.probability){
                return this.node-p2.node;
            }else{
                return this.probability-p2.probability>0?-1:1;//按照概率从大到小
            }
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            graph.add(new ArrayList<Pair>());
        }
        for (int i = 0; i <edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new Pair(succProb[i],e[1]));
            graph.get(e[1]).add(new Pair(succProb[i],e[0]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        double[] prob = new double[n];
        queue.offer(new Pair(1,start));
        prob[start] = 1;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            double pr = pair.probability;
            int node = pair.node;

            if(pr<prob[node]) continue;
            for(Pair adjPair:graph.get(node)){
                double adjPr = adjPair.probability;
                int adjNode = adjPair.node;
                if(prob[node]*adjPr>prob[adjNode]){
                    prob[adjNode] = prob[node]*adjPr;
                    queue.offer(new Pair(prob[adjNode],adjNode));
                }
            }
        }
        return prob[end];
    }




}

package com.yang.jianzhiofffer;

public class VerifyBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return judge(sequence,0,sequence.length);
    }
    public boolean judge(int[] seq, int start, int length){
        int root = seq[length-1];
        int i = start;
        for(;i<length;i++){
            if(seq[i]>root) break;
        }
        int j = i;
        for(;j<length;j++){
            if(seq[j] < root) return false;
        }
        if(i>=length) return true;
        boolean left = true;
        if(i > 0){
            left = judge(seq,0,i);
        }
        boolean right = true;
        if(i < length - 1){
            right = judge(seq,i,length- 1);
        }
        return left&&right;
    }

    public static void main(String[] args) {
        VerifyBST verifyBST = new VerifyBST();
        int[] seq = {5,7,6,9,11,10,8};
        System.out.println(verifyBST.VerifySquenceOfBST(seq));
    }
}

package src.com.yang.heap;

import java.util.Collections;

public class MaxHeap {

    private int[] maxHeap;

    private int n;

    private int index;


    public MaxHeap(int n){
        this.n = n;
        this.maxHeap = new int[n];
        this.index = 0;
    }
    



    public void add(int num){
        if(index>=n){
            throw new RuntimeException("Exceed size");

        }
        maxHeap[index] = num;
        shiftUp(index);
        index++;
    }

    public void printHeap(){
        for(int i=0; i<n; i++){
            System.out.print(maxHeap[i] + " ");
        }
    }

    private void shiftUp(int idx){
        int num = maxHeap[idx];
        while(idx>0){
            int parentIdx = (idx-1)/2;
            int parent = maxHeap[parentIdx];
            if(num>parent){
                swap(maxHeap, parentIdx, idx);
                idx = parentIdx;
            }else{
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    



    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(8);
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(14);
        maxHeap.add(7);
        maxHeap.add(5);
        maxHeap.add(67);
        maxHeap.add(6);
        maxHeap.printHeap();



    }
}

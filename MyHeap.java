package com.microstrategy.DataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyHeap<T> {
    private List<T> data;
    private Comparator<T> cmp;


    public MyHeap(Comparator<T> cmp) {
        this.data = new ArrayList<T>(64);
        this.cmp = cmp;
    }

    public void shiftUp(int idx){
        if(idx<0 || idx>=data.size()){
            throw  new IllegalArgumentException(idx + "");
        }
        T indent = data.get(idx);
        while (idx > 0){
            int parentIdx = (idx - 1) /2;
            T parent = data.get(parentIdx);

            if(cmp.compare(indent,parent) < 0){
                data.set(idx, parent);
                idx = parentIdx;
            }else {
                break;
            }

            data.set(idx,indent);
        }
    }

    public void shiftDown(int idx, int size){
        if(idx<0 || idx>=size){
            throw  new IllegalArgumentException(idx + "");
        }
        T indent = data.get(idx);
        int leftIdx = idx * 2 + 1;
        while (leftIdx < size){
            T maxChild = data.get(leftIdx);
            int maxIdx = leftIdx;
            int rightIdx = leftIdx + 1;
            if(rightIdx < size && cmp.compare(data.get(rightIdx),maxChild)>0){
                maxChild = data.get(rightIdx);
                maxIdx = rightIdx;
            }

            if(cmp.compare(maxChild,indent)<0){
                data.set(idx,maxChild);
                idx = maxIdx;
                leftIdx = 2 * idx + 1;
            }else{
                break;
            }
            data.set(idx,indent);
        }

    }
    public void add(T item){
        data.add(item);
        shiftUp(data.size() - 1);
    }

    public T deleteTop(){
        if(data.isEmpty()){
            throw new RuntimeException("Heap is Empty");
        }
        T first = data.get(0);
        T last = data.remove(data.size() - 1);
        if(data.size() == 0){
            return last;
        }else {
            data.set(0,last);
            shiftDown(0,data.size());
            return first;
        }
    }

    public T getTop(){
        if(data.isEmpty()){
            throw new RuntimeException("Heap is Empty");
        }
        return data.get(0);
    }

    public void sort(){
        for(int i = data.size() - 1; i>0;i--){
            swap(data,0,i);
            shiftDown(0,i);
        }
    }

    private void swap(List<T> data, int i, int j){
        T temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }

    public void printData(){
        for(T item : data){
            System.out.print(item + " ");

        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyHeap minHeap = new MyHeap((o1, o2) -> {
            Integer s1 = (Integer) o1;
            Integer s2 = (Integer) o2;
            return s1.compareTo(s2);
        });
        minHeap.add(2);
        minHeap.add(1);
        minHeap.add(13);
        minHeap.add(12);
        minHeap.add(31);
        minHeap.add(23);
        minHeap.add(15);
        minHeap.printData();
        minHeap.sort();
        minHeap.printData();
    }



}

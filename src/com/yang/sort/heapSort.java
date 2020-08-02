package com.yang.sort;

public class heapSort {
    static int[] heap = new int[]{-9999,2,5,1,0,34,34,23,56,19,18};
    static int n = 10;

    public static void downAdjust(int lo, int hi){
        int i = lo, j = i*2;
        while (j<=hi){
            if (j+1<=hi&&heap[j+1] > heap[j]){
                j = j+1;
            }
            if(heap[j] > heap[i]){
                SortUtil.swap(heap,j,i);
                i = j;
                j = i * 2;
            }else{
                break;
            }
        }

    }

    public static void createHeap(){
        for(int i=n/2;i>=1;i--){
            downAdjust(i,n);
        }

    }

    public static void upAdjust(int lo, int hi){
        int i = hi, j = hi /2;
        while (j>=lo){
            if(heap[j]<heap[i]){
                SortUtil.swap(heap,j,i);
                i = j;
                j = i /2;
            }else{
                break;
            }
        }
    }

    public static void heapSort(){
        createHeap();
        for(int i=n;i>1;i--){
            SortUtil.swap(heap,i,1);
            downAdjust(1,i - 1);
        }
    }

    public static void main(String[] args) {
        heapSort();
        SortUtil.pringArr(heap);
    }
}

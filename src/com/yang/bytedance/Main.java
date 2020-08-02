package com.yang.bytedance;

public class Main {

    public static int deleteDuplicate(int[] arr){
        if(arr==null||arr.length==0) return 0;
        int count = 0;
        int index = 0;
        for(int i = 0; i<arr.length;i++){
            while(i<arr.length-1&&arr[i]==arr[i+1]){
                count++;
                i++;
            }
            arr[index] = arr[i];
            index++;

        }
        return arr.length - count;

    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = deleteDuplicate(nums);
        System.out.println(res);
        for(int num : nums){
            System.out.print(num+" ");
        }
    }
}
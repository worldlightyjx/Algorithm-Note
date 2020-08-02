package com.yang.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.next();
        int target = sc.nextInt();
        nums.replace('[',' ');
        String[] numArray = nums.split(",");
        int[] arr = new int[numArray.length];
        int index = 0;
        for(String s : numArray){
            arr[index++] = Integer.valueOf(s);
        }
        List<List<Integer>> res = getArraySum(arr,target);
        System.out.println(res);


    }

    private static List<List<Integer>> getArraySum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        int i =0, j = nums.length-1;
        while (i<j){
            if(nums[i]+nums[j]==target){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                res.add(tmp);
                i++;
                j++;
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }
}

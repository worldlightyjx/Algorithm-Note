package com.yang.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Mian3 {
    public static class Bank implements Comparable{
        int cor;
        int money;
        
        public Bank(int cor, int money){
            this.cor=cor;
            this.money = money;
        }

        @Override
        public int compareTo(Object o) {
            Bank bank = (Bank) o;
            return bank.money - this.money;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        TreeSet<Bank> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            int cor = sc.nextInt();
            int money = sc.nextInt();
            set.add(new Bank(cor,money));
            
        }

        int maxSum = Integer.MIN_VALUE;
        Queue<Bank> queue = new LinkedList<>();
        for(int i=0;i<set.size();i++){

            if(!set.isEmpty()){
                int sum = 0;
                Bank first = set.pollFirst();
                sum+=first.money;
                Bank cur = null;
                for(Bank bank:set) {
                    if (Math.abs(first.cor - bank.cor) >= d) {
                        sum += bank.money;
                        cur = bank;
                        break;
                    }

                }
                if(sum>maxSum){
                    maxSum = sum;
                }

            }


        }

        System.out.println(maxSum);
        /*for(Bank bank : set){
            System.out.println(bank.cor + ":"+bank.money);

        }*/
    }
}

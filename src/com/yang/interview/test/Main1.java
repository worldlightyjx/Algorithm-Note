package src.com.yang.interview.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i=0;i<n;i++){
            int num = sc.nextInt();
            a[i] = num;
        }
        for (int i=0;i<n;i++){
            int num = sc.nextInt();
            b[i] = num;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for(int i = 0; i<n;i++){
            sum+= a[i] * b[n-i-1];
        }
        System.out.println(sum);

    }


}

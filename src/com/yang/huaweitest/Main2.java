package com.yang.huaweitest;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] matrix = new String[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.next();
        }
        if (n == 1) {
            for (int i = 0; i < matrix[0].length(); i++) {
                if (matrix[0].charAt(i) == '1') {
                    System.out.println("1");
                    return;
                }
            }
            System.out.println("0");
            return;
        } else if (matrix[0].length() == 1) {
            for (int i = 0; i < n; i++) {
                if (matrix[i].charAt(0) == '1') {
                    System.out.println("1");
                    return;
                }
            }
            System.out.println("0");
            return;
        }
        int maxCount = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                int count = 1;
                if (matrix[i].charAt(j) == '1') {
                    int x = j + 1, y = i + 1;
                    while (x < matrix[i].length() && y < n && matrix[i].charAt(x) == matrix[y].charAt(j)) {
                        count++;
                        x++;
                        y++;
                    }
                    if (count > maxCount && isMatrix(count, matrix, i, j))
                        maxCount = count;
                }

            }

        }
        System.out.println(maxCount * maxCount);

    }

    public static boolean isMatrix(int count, String[] matrix, int x, int y) {
        for (int i = x + 1; i < count+x; i++) {
            for (int j = y + 1; j < count+y; j++) {
                if (matrix[i].charAt(j) == '0')
                    return false;
            }
        }
        return true;
    }
}

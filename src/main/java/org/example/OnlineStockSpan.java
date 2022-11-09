package org.example;

import java.util.Scanner;
import java.util.Stack;

public class OnlineStockSpan {
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter number of days");
            int n = sc.nextInt();
            int[] days = new int[n];
            System.out.println("Enter value of stock");
            for (int i = 0; i < n; i++) {
                days[i] = sc.nextInt();
                System.out.print(next(days[i]) + " ");
            }
        }
    }

    public static int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }
}

// 7
// 100 80 60 70 60 75 85
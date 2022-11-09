package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxPerformance {

    static Logger logger = Logger.getLogger(MaxPerformance.class.getName());

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            logger.log(Level.INFO, "Enter values for n and k");
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] speed = new int[n];
            int[] efficiency = new int[n];
            logger.log(Level.INFO, "Enter array of speed");
            for (int i = 0; i < n; i++)
                speed[i] = sc.nextInt();
            logger.log(Level.INFO, "Enter array of efficiency");
            for (int i = 0; i < n; i++)
                efficiency[i] = sc.nextInt();
            System.out.println(maxPerformance(n, speed, efficiency, k));
        }
    }

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i)
            arr[i] = new int[]{efficiency[i], speed[i]};
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        System.out.println(Arrays.deepToString(arr));
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        long res = 0;
        long sum = 0;
        for (int[] ar : arr) {
            System.out.println(pq);
            pq.add(ar[1]);
            sum = (sum + ar[1]);
            System.out.println(sum);
            if (pq.size() > k)
                sum -= pq.poll();
            res = Math.max(res, (sum * ar[0]));
        }
        return (int) (res % (long) (1e9 + 7));
    }
}

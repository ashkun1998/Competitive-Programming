package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContainerWithMostWater {

    static Logger logger = Logger.getLogger(ContainerWithMostWater.class.getName());

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            logger.log(Level.INFO, "Enter length of the container");
            int n = sc.nextInt();
            int[] height = new int[n];
            logger.log(Level.INFO, "Enter heights in the array");
            for (int i = 0; i < n; i++)
                height[i] = sc.nextInt();
            logger.log(Level.INFO, "Max Area : {0}", maxArea(height));
        }
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int aPointer = 0;
        int bPointer = height.length - 1;
        while (aPointer < bPointer) {
            maxArea = Math.max(maxArea, Math.min(height[aPointer], height[bPointer]) * (bPointer - aPointer));
            if (height[aPointer] > height[bPointer])
                bPointer--;
            else
                aPointer++;
        }
        return maxArea;
    }
}

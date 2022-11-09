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
            logger.log(Level.INFO, "Max Area :" + maxArea(height));
        }
    }

    public static int maxArea(int[] height) {
        int max_area = 0;
        int a_pointer = 0;
        int b_pointer = height.length - 1;
        while (a_pointer < b_pointer) {
            max_area = Math.max(max_area, Math.min(height[a_pointer], height[b_pointer]) * (b_pointer - a_pointer));
            if (height[a_pointer] > height[b_pointer])
                b_pointer--;
            else
                a_pointer++;
        }
        return max_area;
    }
}

package org.example;

import java.util.Scanner;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the container");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("Enter heights in the array");
        for (int i = 0; i < n; i++)
            height[i] = sc.nextInt();
        System.out.println("Max Area :" + maxArea(height));
    }

    public static int maxArea(int[] height) {
        int max_area = 0;
        int a_pointer = 0;
        int b_pointer = height.length - 1;
        while (a_pointer < b_pointer) {
            max_area = Math.max(max_area, Math.min(height[a_pointer], height[b_pointer]) * (b_pointer - a_pointer));
            if (height[a_pointer] > height[b_pointer]) b_pointer--;
            else a_pointer++;
        }
        return max_area;
    }
}

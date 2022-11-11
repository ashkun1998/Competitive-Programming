package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveDuplicates {
    static Logger logger = Logger.getLogger(RemoveDuplicates.class.getName());

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            logger.log(Level.INFO, "Enter number of elements: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            logger.log(Level.INFO, "Enter elements in the array: ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            logger.log(Level.INFO, "Result : {0}", removeDuplicates(arr));
        }
    }

    public static int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}

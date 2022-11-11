package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// Java program to find two odd
// occurring elements
public class TwoNumbersWithOddOccurrences {

    static Logger logger = Logger.getLogger(TwoNumbersWithOddOccurrences.class.getName());

    /* Prints two numbers that occur odd
    number of times. The function assumes
    that the array size is at least 2 and
    there are exactly two numbers occurring
    odd number of times. */
    static void printTwoOdd(int[] arr, int size) {
        /* Will hold XOR of two odd occurring elements */
        int xor2 = arr[0];

        /* Will have only single set bit of xor2 */
        int setBitNo;
        int i;
        int x = 0;
        int y = 0;

	/* Get the xor of all elements in arr[].
		The xor will basically be xor of two
		odd occurring elements */
        for (i = 1; i < size; i++)
            xor2 = xor2 ^ arr[i];

	/* Get one set a bit in the xor2. We get
		rightmost set a bit in the following
		line as it is easy to get */
        setBitNo = xor2 & -xor2;

	/* Now divide elements in two sets:
			1) The elements having the
			corresponding bit as 1.
			2) The elements having the
			corresponding bit as 0. */
        for (i = 0; i < size; i++) {
		/* XOR of first set is finally going
			to hold one odd occurring number x */
            if ((arr[i] & setBitNo) > 0)
                x = x ^ arr[i];

		/* XOR of second set is finally going
			to hold the other odd occurring number y */
            else
                y = y ^ arr[i];
        }
        logger.log(Level.INFO, "The two ODD elements are {0} ", x + " & " + y);
    }

    // main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int arrSize = arr.length;
        printTwoOdd(arr, arrSize);
    }
}
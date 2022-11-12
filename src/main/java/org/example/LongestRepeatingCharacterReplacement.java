package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LongestRepeatingCharacterReplacement {
    static Logger logger = Logger.getLogger(LongestRepeatingCharacterReplacement.class.getName());

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            logger.log(Level.INFO, "Enter String");
            String s = sc.next();
            logger.log(Level.INFO, "Enter value of k");
            int k = sc.nextInt();
            logger.log(Level.INFO, "Result : {0}", characterReplacement(s, k));
        }
    }

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int j = 0;
        int maxCount = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(i) - 'A']);
            while (i - j + 1 - maxCount > k) {
                count[s.charAt(j) - 'A']--;
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}

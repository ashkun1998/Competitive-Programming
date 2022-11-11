package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

public class ReverseLinkedListII {

    static Logger logger = Logger.getLogger(ReverseLinkedListII.class.getName());

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ListNode head = new ListNode(1);
            ListNode second = new ListNode(2);
            ListNode third = new ListNode(3);
            ListNode fourth = new ListNode(4);
            ListNode fifth = new ListNode(5);
            head.next = second;
            second.next = third;
            third.next = fourth;
            fourth.next = fifth;
            logger.log(Level.INFO, "Enter Left and right end of the ListNode");
            int left = sc.nextInt();
            int right = sc.nextInt();
            ListNode result = reverseBetween(head, left, right);
            while (result != null) {
                logger.log(Level.INFO, "result {0} ", result.val);
                result = result.next;
            }
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode current = head;
        while (left-- > 1) {
            prev = current;
            current = current.next;
            right--;
        }
        ListNode connection = prev;
        ListNode tail = current;
        while (right-- > 0) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }
        tail.next = current;
        return head;
    }
}

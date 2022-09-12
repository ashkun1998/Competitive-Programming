package org.example;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

public class ReverseLinkedListII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        System.out.println("Enter Left and right end of the ListNode");
        int left = sc.nextInt();
        int right = sc.nextInt();
        ListNode result = reverseBetween(head, left, right);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        while (left-- > 1) {
            prev = current;
            current = current.next;
            right--;
        }
        ListNode leftConnection = prev;
        ListNode rightConnection = current;
        while (right-- > 0) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        if (leftConnection != null) leftConnection.next = prev;
        else head = prev;
        rightConnection.next = current;
        return head;
    }
}

package implementation;

import model.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2) {
        int addOne = 0;

        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                temp.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp.val += l2.val;
                l2 = l2.next;
            }
            temp.val += addOne;
            if (temp.val >= 10) {
                addOne = 1;
                temp.val -= 10;
            } else {
                addOne = 0;
            }
            if (l1 != null || l2!= null) {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        if (addOne == 1) {
            temp.next = new ListNode(1);
        }

        return res;
    }
}

package amazonQuestion;

import model.ListNode;

public class ReverseKGroup {
  public ListNode reverseNode(ListNode head, int k) {
    ListNode res = null;
    ListNode curr = head;
    for (int i = 0; i < k; i++) {
      // For example : 1 -> 2 -> 3
      ListNode next = curr.next; // curr = 1, next = 2, next.next = 3
      curr.next = res; // curr = 1, next = 2, next.next = 3, curr.next = null
      res = curr; // curr = 1, next = 2, next.next = null, curr.next = null
      curr = next; // curr = 1, next = 2, next.next = null
    }
    return res;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode newHead = head;
    ListNode cur = head;

    int count = k;

    while (count > 0 && cur != null) {
      cur = cur.next;
      count--;
    }

    if (count == 0) {
      newHead = this.reverseNode(head, k);

      head.next = this.reverseKGroup(cur, k);
    }
    return newHead;
  }
}

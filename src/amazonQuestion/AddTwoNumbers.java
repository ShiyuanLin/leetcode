package amazonQuestion;

import model.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode res = null;
    ListNode previous = null;
    int extra = 0;
    while (l1 != null || l2 != null || extra !=0) {
      ListNode current;
      int v1 = 0;
      int v2 = 0;
      if (l1 != null) {
        v1 = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        v2 = l2.val;
        l2 = l2.next;
      }
      if (v1 + v2 + extra < 10) {
        current = new ListNode(v1 + v2 + extra);
        extra = 0;
      } else {
        current = new ListNode(v1 + v2 + extra - 10);
        extra = 1;
      }
      if (previous == null) {
        res = current;
        previous = current;
      } else {
        previous.next = current;
        previous = current;
      }
    }
    return res;
  }
}

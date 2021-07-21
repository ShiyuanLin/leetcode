package amazonQuestion;

import model.ListNode;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode res = null;
    ListNode previous = null;

    while (l1 != null || l2 != null) {
      ListNode current;
      if (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          current = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          current = new ListNode(l2.val);
          l2 = l2.next;
        }
      } else if (l1 != null) {
        current = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        current = new ListNode(l2.val);
        l2 = l2.next;
      }
      if (previous == null) {
        previous = current;
        res = previous;
      } else {
        previous.next = current;
        previous = current;
      }
    }
    return res;
  }
}

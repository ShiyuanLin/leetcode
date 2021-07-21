package amazonQuestion;

import model.ListNode;

public class ReverseList {
  public ListNode reverseList(ListNode head) {
    ListNode reverseHead = null;
    ListNode curr = head;

//    while (curr != null) {
//      ListNode temp = reverseHead;
//      reverseHead = curr;
//      reverseHead.next = temp;
//      curr = curr.next;
//    }
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = reverseHead;
      reverseHead = curr;
      curr = temp;
    }
    return reverseHead;
  }
}

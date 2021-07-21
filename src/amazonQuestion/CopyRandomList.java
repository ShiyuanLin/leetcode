package amazonQuestion;

import model.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
  public Node copyRandomList(Node head) {
    Node curr = head;

    while (curr != null) {
      Node newNode = new Node(curr.val);
      newNode.next = curr.next;
      curr.next = newNode;
      curr = newNode.next;
    }

    curr = head;
    while (curr != null) {
      curr.next.random = curr.random == null? null:curr.random.next;
      curr = curr.next.next;
    }

     curr = head;
     Node newPtr = head.next;
     Node newHead = head.next;
     while (curr != null) {
       curr.next = curr.next.next;
       newPtr.next = (newPtr.next != null) ? newPtr.next.next : null;
       curr = curr.next;
       newPtr = newPtr.next;
     }
     return newHead;
  }
}

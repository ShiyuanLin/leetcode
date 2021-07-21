package amazonOA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCacheMisses {
  class DLinkedList {
    int val;
    DLinkedList prev;
    DLinkedList next;
  }

  public int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
    int miss = 0;
    Map<Integer, DLinkedList> dict = new HashMap<>();
    DLinkedList head = new DLinkedList();
    DLinkedList tail = new DLinkedList();
    head.next = tail;
    tail.prev = head;

    for (Integer page: pages) {
      if (dict.containsKey(page)) {
        DLinkedList curr = dict.get(page);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = head.next;
        curr.next.prev = curr;
        head.next = curr;
        curr.prev = head;
      } else {
        DLinkedList newNode = new DLinkedList();
        newNode.val = page;
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        dict.put(page, newNode);
        if (dict.size() > maxCacheSize) {
          DLinkedList oldNode = tail.prev;
          oldNode.prev.next = tail;
          tail.prev = oldNode.prev;
          dict.remove(oldNode.val);
        }
        miss++;
      }
    }
    return miss;
  }
}

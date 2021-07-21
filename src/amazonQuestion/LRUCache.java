package amazonQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
  class DLinkedList {
    int key;
    int val;
    DLinkedList prev;
    DLinkedList next;
  }

  Map<Integer, DLinkedList> cache;
  int capacity;
  DLinkedList head;
  DLinkedList tail;

  public DLinkedList addNode(int key, int val) {
    DLinkedList node = new DLinkedList();
    node.key = key;
    node.val = val;
    node.next = head.next;
    node.prev = head;
    node.next.prev = node;
    head.next = node;
    return node;
  }

  public void removeNode(DLinkedList node) {
    DLinkedList prev = node.prev;
    DLinkedList next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(DLinkedList node) {
    removeNode(node);
    node.prev = head;
    node.next = head.next;
    head.next = node;
    node.next.prev = node;
  }

  public int popTail() {
    int key = tail.prev.key;
    removeNode(tail.prev);
    return key;
  }

  public LRUCache(int capacity) {
    this.cache = new HashMap<>();
    this.capacity = capacity;

    head = new DLinkedList();
    tail = new DLinkedList();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DLinkedList node = cache.get(key);
    if (node == null) {
      return -1;
    } else {
      moveToHead(node);
      return node.val;
    }
  }


  public void put(int key, int value) {
    DLinkedList node = cache.get(key);
    if (node == null) {
      DLinkedList newNode = addNode(key, value);
      cache.put(key, newNode);
      System.out.println(cache.keySet().size());
      if (cache.keySet().size() > this.capacity) {
        cache.remove(popTail());
      }
    } else {
      node.val = value;
      moveToHead(node);
    }
  }
}

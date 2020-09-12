package implementation;

import java.util.*;

public class LRUCache {
  private Map<Integer, Integer> store = new HashMap<>();
  private List<Integer> queue = new ArrayList<>();
  private int size;

  public LRUCache(int capacity) {
    size = capacity;
  }

  public int get(int key) {
    if (store.containsKey(key)) {
      queue.remove(Integer.valueOf(key));
      queue.add(key);
      return store.get(key);
    }
    return -1;
  }

  public void put(int key, int value) {
    queue.remove(Integer.valueOf(key));
    if (queue.size() >= size) {
      store.remove(queue.get(0));
      queue.remove(0);
    }
    queue.add(key);
    store.put(key, value);
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache( 2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));
    cache.put(3, 3);
    System.out.println(cache.get(2));
  }
}

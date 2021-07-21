package amazonOA;

import java.util.Deque;
import java.util.LinkedList;

public class HardDiskScanning {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] res = new int[nums.length - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      deque.offer(i);
      if (i >= k - 1) {
        res[i - k + 1] = nums[deque.peekFirst()];
      }
    }
    return res;
  }
}

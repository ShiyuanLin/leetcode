package amazonQuestion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
    int res = 0;

    for (int[] interval : intervals) {
      if (minHeap.isEmpty()) {
        res = Math.max(res, 1);
        minHeap.add(interval[1]);
      } else {
        if (minHeap.peek() <= interval[0]) {
          minHeap.poll();
        } else {
          res++;
        }
        minHeap.add(interval[1]);
      }
    }
    return res;
  }
}

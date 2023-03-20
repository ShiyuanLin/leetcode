package amazonQuestion;

import java.util.PriorityQueue;

public class KClosest {
  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
            (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2)- Math.pow(b[0], 2) - Math.pow(b[1], 2)));

    for (int[] point: points) {
      minHeap.add(point);
      if (minHeap.size() > K) {
        minHeap.poll();
      }
    }
    return minHeap.toArray(new int[K][]);
  }
}

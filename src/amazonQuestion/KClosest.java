package amazonQuestion;

import java.util.PriorityQueue;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.min;

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

package amazonQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
  PriorityQueue<Integer> lowPart; // maxHeap
  PriorityQueue<Integer> highPart; // minHeap

  public MedianFinder() {
    lowPart = new PriorityQueue<>((a, b) -> b - a);
    highPart = new PriorityQueue<>((a, b) -> a - b);
  }

  public void addNum(int num) {
    if (lowPart.isEmpty()) {
      lowPart.add(num);
      return;
    }

    if (num > lowPart.peek()) {
      highPart.add(num);
      if (highPart.size() > lowPart.size()) {
        lowPart.add(highPart.poll());
      }
    } else {
      lowPart.add(num);
      if (lowPart.size() > highPart.size() + 1) {
        highPart.add(lowPart.poll());
      }
    }
  }

  public double findMedian() {
    if (lowPart.size() == 0) {
      return 0.0;
    }
    if (lowPart.size() == highPart.size()) {
      return (lowPart.peek() + highPart.peek()) / 2.0;
    } else {
      return lowPart.peek();
    }
  }
}

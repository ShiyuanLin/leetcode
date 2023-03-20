package amazonOA;

import java.util.ArrayList;
import java.util.List;

public class AmazonTurnstile {
  public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
    int[] times = new int[numCustomers];
    List<Integer> exIdxes = new ArrayList<>();
    List<Integer> enIdexes = new ArrayList<>();

    for (int i = 0; i < numCustomers; i++) {
      if (direction[i] == 1) {
        exIdxes.add(i);
      } else {
        enIdexes.add(i);
      }
    }

    int timeCounter = 0;
    int lastDirection = -1; // -1 can be any, 0 enter, 1 exit

    while (!exIdxes.isEmpty() || !enIdexes.isEmpty()) {
      if (!exIdxes.isEmpty() && arrTime[exIdxes.get(0)] <= timeCounter &&
              (lastDirection == -1 || lastDirection == 1 || enIdexes.isEmpty()
                      || arrTime[enIdexes.get(0)] > timeCounter)) {
        times[exIdxes.remove(0)] = timeCounter;
        lastDirection = 1;
      } else if (!enIdexes.isEmpty() && arrTime[enIdexes.get(0)] <= timeCounter) {
        times[enIdexes.remove(0)] = timeCounter;
        lastDirection = 0;
      } else {
        lastDirection = -1;
      }

      timeCounter++;
    }
    return times;
  }
}

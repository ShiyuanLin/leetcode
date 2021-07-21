package implementation;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
  public int findDuplicate(int[] nums) {
    Set<Integer> appeared = new HashSet<>();

    for (int num: nums) {
      if (appeared.contains(num)) {
        return num;
      }
      appeared.add(num);
    }
    return -1;
  }
}

package implementation;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
  public int solution(int[] nums) {
    int res = 0;
    for (int x: nums) {
      res = res & x;
    }
    return res;
  }

  public int brutalSolution(int[] nums) {
    Set<Integer> ones = new HashSet<>();
    for (int x: nums) {
      if (ones.contains(x)) {
        ones.remove(x);
      } else {
        ones.add(x);
      }
    }
    return ones.iterator().next();
  }
}

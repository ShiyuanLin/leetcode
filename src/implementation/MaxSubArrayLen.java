package implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayLen {
  public int maxSubArrayLen(int[] nums, int k) {
    int currLongest = 0;
    Map<Integer, Integer> sumIndexMap = new HashMap<>();
    int currSum = 0;

    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];

      if (currSum == k) {
        currLongest = i + 1;
      }

      if (sumIndexMap.containsKey(currSum - k)) {
        currLongest = Math.max(currLongest, i - sumIndexMap.get(currSum - k));
      }

      if (!sumIndexMap.containsKey(currSum)) {
        sumIndexMap.put(currSum, i);
      }
    }
    return currLongest;
  }
}

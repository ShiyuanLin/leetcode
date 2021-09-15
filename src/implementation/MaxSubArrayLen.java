package implementation;

import java.util.Arrays;

public class MaxSubArrayLen {
  int maxSubLen;
  public int maxSubArrayLen(int[] nums, int k) {
    maxSubLen = 0;
    Arrays.sort(nums);
    traverse(nums, k, 0, 0, 0);
    return maxSubLen;
  }

  public void traverse(int[] nums, int target, int i, int current, int len) {
    current += nums[i];
    if (current > target) return;

    len++;
    if (current == target) {
      maxSubLen = Math.max(maxSubLen, len);
      return;
    }

    for (int j = i + 1; j < nums.length; j++) {
      traverse(nums, target, j, current, len);
    }
  }
}

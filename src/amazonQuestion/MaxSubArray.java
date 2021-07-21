package amazonQuestion;

public class MaxSubArray {
  public int maxSubArray(int[] nums) {
    int max = nums[0];

    for (int num: nums) {
      max = Math.max(max, num);
    }
    if (max <= 0) {
      return max;
    }
    int curr = 0;
    for (int num: nums) {
      curr = Math.max(curr + num, 0);
      if (curr > max) {
        max = curr;
      }
    }
    return max;
  }
}

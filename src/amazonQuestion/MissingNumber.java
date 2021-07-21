package amazonQuestion;

public class MissingNumber {
  public static int missingNumber(int[] nums) {
    int max = nums.length;
    int sum = 0;
    int max_sum = max;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max_sum += i;
    }

    return max_sum - sum;
  }
}

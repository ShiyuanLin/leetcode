package implementation;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray {
  /**
   * The idea is simple:
   * Adding value from left to right
   * if the current value is greater than 0, keep adding
   * @param nums
   * @return
   */
  public static int solution(int[] nums) {
    int res = nums[0];
    int curr_value = nums[0];
    if (nums.length == 1) {
      return res;
    }

    int right_idx = 1;
    while (right_idx < nums.length) {
      if (curr_value < 0) {
        curr_value = nums[right_idx];
      } else {
        curr_value += nums[right_idx];
      }
      if (curr_value > res) {
        res = curr_value;
      }
      right_idx++;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(MaxSubArray.solution(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    System.out.println(MaxSubArray.solution(new int[] {1, 4, -1, -2, -1, -3}));
    System.out.println(MaxSubArray.solution(new int[] {1, 4, -1, -2, -1, -3, 2}));
    System.out.println(MaxSubArray.solution(new int[] {1, 4, -1, -2, -1, -3, 6}));
    System.out.println(MaxSubArray.solution(new int[] {-2, -1}));
    System.out.println(MaxSubArray.solution(new int[] {1, 4}));
    System.out.println(MaxSubArray.solution(new int[] {4, 1}));
  }
}

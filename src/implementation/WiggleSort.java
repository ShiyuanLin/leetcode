package implementation;

import java.util.Arrays;

public class WiggleSort {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);

    for (int i = 1; i < nums.length - 2; i+=2) {
      int temp = nums[i];
      nums[i] = nums[i + 2];
      nums[i + 2] = temp;
    }
  }
}

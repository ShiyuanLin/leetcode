package amazonQuestion;

import java.util.Arrays;

public class ThreeSumClosest {
  public static int threeSumClosest(int[] nums, int target) {
    int res = 10001;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int l_idx = i + 1;
      int r_idx = nums.length - 1;
      int cur_value;
      while (l_idx < r_idx) {
        cur_value = nums[i] + nums[l_idx] + nums[r_idx];
        if (Math.abs(cur_value - target) < Math.abs(res - target)) {
          res = cur_value;
        }
        if (cur_value > target) {
          r_idx--;
        } else {
          l_idx++;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(threeSumClosest(new int[] {1, 1, 1, 1}, 100));
  }
}

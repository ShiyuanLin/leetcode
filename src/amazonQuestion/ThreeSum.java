package amazonQuestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i-1]) {
        continue;
      }
      int l_idx = i+1;
      int r_idx = nums.length - 1;
      int sum;
      while (l_idx < r_idx) {
        sum = nums[i] + nums[l_idx] + nums[r_idx];
        if (sum == 0) {
          List<Integer> candidate = Arrays.asList(nums[i], nums[l_idx], nums[r_idx]);
          if (res.isEmpty()) {
            res.add(candidate);
          } else {
            if (!res.get(res.size()-1).equals(candidate)) {
              res.add(candidate);
            }
          }
        }
        if (sum > 0) {
          r_idx--;
        } else {
          l_idx++;
        }
      }
    }
    return res;
  }
}

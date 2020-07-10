package implementation;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
  /**
   * Solution idea:
   * Sort the list first and then use double point to do the inner loop
   *
   * @param nums
   * @return
   */
  public static List<List<Integer>> solution(int[] nums) {
    List<List<Integer>> res = new ArrayList<> ();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i-1]) {
        continue;
      }
      int left_index = i+1;
      int right_index = nums.length - 1;
      while (left_index < right_index) {
        int sum = nums[i] + nums[left_index] + nums[right_index];
        if (sum == 0) {
          List<Integer> candidate = Arrays.asList(nums[i], nums[left_index], nums[right_index]);
          if (res.isEmpty()) {
            res.add(candidate);
          } else {
            if (!res.get(res.size() - 1).equals(candidate)) {
              res.add(candidate);
            }
          }
          left_index++;
        } else if (sum > 0) {
          right_index--;
        } else {
          left_index++;
        }
      }
    }
    return res;
  }

  public static List<List<Integer>> brutal_solution(int[] nums) {
//    int len = nums.length;
    List<List<Integer>> res = new ArrayList<> ();
    Set<Integer> skips_out = new HashSet<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (skips_out.contains(nums[i])) {
        continue;
      }
      Set<Integer> skips_inner = new HashSet<>();
      for (int j = i + 1; j < nums.length - 1; j++) {
        if (skips_inner.contains(nums[j]) || skips_out.contains(nums[j])) {
          continue;
        }
        for (int k = j + 1; k < nums.length; k++) {
          if (skips_out.contains(nums[k])) {
            continue;
          }
          if (nums[i] + nums[j] + nums[k] == 0) {
            skips_inner.add(nums[j]);
            skips_inner.add(nums[k]);
            res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            break;
          }
        }
      }
      skips_out.add(nums[i]);
    }
    return res;
  }

  public static void main(String[] args) {
//      System.out.println(solution(new int[] {-1, 0, 1, 2, -1, -4, 3, -1, 0}));
      System.out.println("===========================");
      System.out.println(solution(new int[] {-2, 1, -2, -2, 1}));
//    List<List<Integer>> som = new ArrayList<>();
//    System.out.println(som.isEmpty());
//    int[] nums = new int[] {-1, 0, 1, 2, -1, -4, 3, -1, 0};
//    Arrays.sort(nums);
//    for (int num: nums) {
//      System.out.println(num);
    }
}

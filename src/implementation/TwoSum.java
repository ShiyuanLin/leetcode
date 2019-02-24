package implementation;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] solution(int[] nums, int target) {
        Map<Integer, Integer> nums_hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            nums_hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums_hash.containsKey(target - nums[i]) && nums_hash.get(target - nums[i]) != i)
            {
                return new int[] {i, nums_hash.get(target - nums[i])};
            }
        }
        return new int[] {};
    }
}

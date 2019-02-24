package test;

import implementation.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class tc_TwoSum {
    @Test
    public void tc_1()
    {
        tc_TwoSum tester = new tc_TwoSum();
        TwoSum twoSum = new TwoSum();
        int[]nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.solution(nums, target);
        int[] expectedResult = {0, 1};
        Assert.assertArrayEquals(result, expectedResult);
    }
}

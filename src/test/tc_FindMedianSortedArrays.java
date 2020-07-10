package test;

import implementation.FindMedianSortedArrays;
import org.junit.Assert;
import org.junit.Test;

public class tc_FindMedianSortedArrays {
    @Test
    public void tc_1(){
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {2};
        double res = FindMedianSortedArrays.solution(nums1, nums2);
        Assert.assertEquals(2, res, 0.001);
    }

    @Test
    public void tc_2(){
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};
        double res = FindMedianSortedArrays.solution(nums1, nums2);
        Assert.assertEquals(2.5, res, 0.001);
    }

    @Test
    public void tc_3(){
        int[] nums1 = new int[] {1, 2, 7, 8};
        int[] nums2 = new int[] {4, 12};
        double res = FindMedianSortedArrays.solution(nums1, nums2);
        Assert.assertEquals(5.5, res, 0.001);
    }

    @Test
    public void tc_4(){
        int[] nums1 = new int[] {1, 2, 7, 8, 10, 12, 15};
        int[] nums2 = new int[] {20, 30, 60, 80, 100, 101};
        double res = FindMedianSortedArrays.solution(nums1, nums2);
        Assert.assertEquals(15, res, 0.001);
    }
}
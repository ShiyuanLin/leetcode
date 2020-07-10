package implementation;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 */

// TODO: Failed
// Use while loop
public class FindMedianSortedArrays {
    public static double solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // Final case
        if (len1 == 1 && len2 ==1) {
            return (nums1[0] + nums2[0]) / 2.0;
        } else if (len1 == 1 && len2 == 2) {
            if (nums1[0] < nums2[0]) {
                return nums2[0];
            } else return Math.min(nums1[0], nums2[1]);
        } else if (len1 == 2 && len2 == 1) {
            if (nums2[0] < nums1[0]) {
                return nums2[0];
            } else return Math.min(nums2[0], nums1[1]);
        }

        // Intermediate case
        int medPos1Low = (int) Math.floor((len1-1) / 2.0);
        int medPos1High = (int) Math.ceil((len1-1) / 2.0);

        int medPos2Low = (int) Math.floor((len2-1) / 2.0);
        int medPos2High = (int) Math.ceil((len2-1) / 2.0);

        // odd length of nums1
        if (medPos1Low == medPos1High) {
            double med1 = nums1[medPos1Low];
            // odd length of nums2
            if (medPos2Low == medPos2High) {
                if (med1 > nums2[medPos2High]) {
                    return solution(subArray(nums1, 0, medPos1Low), subArray(nums2, medPos2Low, len2-1));
                } else if (nums1[medPos1High] < nums2[medPos2High]) {
                    return solution(subArray(nums1, medPos1Low, len1-1), subArray(nums2, 0, medPos2Low));
                } else {
                    return med1;
                }
            // even length of nums2
            } else {
                double med2 = (nums2[medPos2Low] + nums2[medPos2High]) / 2.0;
                if (med1 > med2) {
                    return solution(subArray(nums1, 0, medPos1Low), subArray(nums2, medPos2High, len2-1));
                } else if (med1 < med2) {
                    return solution(subArray(nums1, medPos1Low, len1-1), subArray(nums2, 0, medPos2Low));
                } else {
                    return med2;
                }
            }
        }

        // even length of nums1
        double med1 = (nums1[medPos1Low] + nums1[medPos1High]) / 2.0;
        // odd length of nums2
        if (medPos2Low == medPos2High) {
            if (med1 > nums2[medPos2High]) {
                return solution(subArray(nums1, 0, medPos1Low), subArray(nums2, medPos2High, len2-1));
            } else if (nums1[medPos1High] < nums2[medPos2High]) {
                return solution(subArray(nums1, medPos1High, len1-1), subArray(nums2, 0, medPos2Low));
            } else {
                return med1;
            }
            // even length of nums2
        } else {
            double med2 = (nums2[medPos2Low] + nums2[medPos2High]) / 2.0;
            if (med1 > med2) {
                return solution(subArray(nums1, 0, medPos1Low), subArray(nums2, medPos2High, len2-1));
            } else if (med1 < med2) {
                return solution(subArray(nums1, medPos1High, len1-1), subArray(nums2, 0, medPos2Low));
            } else {
                return med2;
            }
        }

//        return nums1.length;
    }

    public static int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }
}

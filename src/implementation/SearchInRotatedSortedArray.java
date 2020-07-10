package implementation;

/** p.s. Actually, I think the list is not rotated but switched place by finding a pivot in the middle
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
  /**
   * Pay attention when to move the start index and end index
   *
   * @param nums
   * @param target
   * @return
   */
  public static int search(int[] nums, int target) {
    int mid = nums.length / 2;
    int start = 0;
    int end = nums.length - 1;
    if (end == -1) {
      return -1;
    }
    while (nums[mid] != target) {
      if (nums[start] == target) {
        return start;
      }
      if (nums[end] == target) {
        return end;
      }
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        if (nums[end] >= target || nums[mid] > nums[end]) {
          start = mid + 1;
        } else {
          end = end - 1;
        }
      } else {
        // nums[mid] > target
        if (nums[start] < target || nums[start] > nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
      if (start >= end || end >= nums.length || start < 0) {
        return -1;
      }
      mid = (start + end) / 2;
    }
    return mid;
  }

  public static void main(String[] args) {
    System.out.println(SearchInRotatedSortedArray.search(new int[] {4,5,6,7,0,1,2}, 5));
    System.out.println(SearchInRotatedSortedArray.search(new int[] {4,5,6,7,0,1,2}, 3));
    System.out.println(SearchInRotatedSortedArray.search(new int[] {0,1,2,4,5,6,7}, 0));
    System.out.println(SearchInRotatedSortedArray.search(new int[] {1, 3}, 1));

//    System.out.println(7/2);
    int[] a = new int[] {7, 8, 1, 2, 3, 4, 5, 6};
//    System.out.println(a[0: 5]);
    System.out.println(SearchInRotatedSortedArray.search(a, 2));


  }
}

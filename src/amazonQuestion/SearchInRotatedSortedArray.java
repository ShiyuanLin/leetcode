package amazonQuestion;

public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    return findIndex(nums, target, 0, nums.length-1);
  }

  public int findIndex(int[] nums, int target, int leftIndex, int rightIndex) {
    if (leftIndex > rightIndex) {
      return -1;
    }
    int midIndex = (leftIndex + rightIndex) / 2;
    if (target == nums[leftIndex]) {
      return leftIndex;
    }
    if (target == nums[rightIndex]) {
      return rightIndex;
    }
    if (target == nums[midIndex]) {
      return midIndex;
    }

    if (nums[midIndex] >= nums[leftIndex]) {
      if (target > nums[leftIndex] && target < nums[midIndex]) {
        return findIndex(nums, target, leftIndex, midIndex-1);
      } else {
        return findIndex(nums, target, midIndex + 1, rightIndex);
      }
    } else { // nums[leftIndex] > nums[midIndex]
      if (target > nums[midIndex] && target < nums[rightIndex]) {
        return findIndex(nums, target, midIndex + 1, rightIndex);
      } else {
        return  findIndex(nums, target, leftIndex, midIndex);
      }
    }
  }
}

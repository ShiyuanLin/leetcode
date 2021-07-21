package implementation;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges {
//  static public List<String> findMissingRanges(int[] nums, int lower, int upper) {
//    int idx = 0;
//    Integer currentMin = null;
//    List<String> result = new ArrayList<>();
//    for (int i = lower; i <= upper; i++) {
//      if (idx >= nums.length) {
//        if (currentMin != null) {
//          result.add(createElement(currentMin, upper));
//        } else {
//          result.add(createElement(i, upper));
//        }
//        return result;
//      }
//      if (nums[idx] == i) {
//        if (currentMin != null) {
//          result.add(createElement(currentMin, i-1));
//          currentMin = null;
//        }
//        idx++;
//      } else if (nums[idx] > i) {
//        if (currentMin == null) {
//          currentMin = i;
//        }
//      } else { // nums[idx] < i
//        idx++;
//        i--;
//      }
//    }
//    if (currentMin != null) {
//      result.add(String.valueOf(currentMin));
//    }
//    return result;
//  }
public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
  Integer currentMin = null;
  List<String> result = new ArrayList<>();
  if (nums.length == 0) {
    result.add(createElement(lower, upper));
    return result;
  }
  for (int i = 0; i < nums.length; i++) {
    if (i == 0) {
      if (nums[i] > lower) {
        result.add(createElement(lower, nums[i] - 1));
      }
    } else {
      if (nums[i] > nums[i-1] + 1) {
        result.add(createElement(nums[i-1]+1, nums[i]-1));
      }
    }
  }
  if (nums[nums.length - 1] != upper) {
    result.add(createElement(nums[nums.length-1]+1, upper));
  }
  return result;
}

  static String createElement(int low, int high) {
    if (high == low) {
      return String.valueOf(low);
    } else {
      return low + "->" + high;
    }
  }

  public static void main(String[] args) {
    System.out.println(findMissingRanges(new int[] {-1000000000,1000000000},
    -1000000000,
    1000000000));
  }
}

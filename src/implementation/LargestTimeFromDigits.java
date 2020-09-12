package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Wrong answer. The only thing we can do is permutation.
 */
public class LargestTimeFromDigits {
  public static String solution(int[] arr) {
    String res = "";
    List<Integer> arr_list = new ArrayList<Integer>(arr.length);
    for (int i: arr) {
      arr_list.add(i);
    }
    int[] times;
    Integer h = largestNumBelowN(arr_list, 3);
    if (h == 2) {
      times = new int[]{3, 4, 6, 10};
    } else {
      times = new int[]{3, 10, 6, 10};
    }
    for (int time: times) {
      Integer x = largestNumBelowN(arr_list, time);
      if (x != -1) {
        res += x.toString();
        if (res.length() == 2) {
          res += ":";
        }
        arr_list.remove(x);
      } else {
        return "";
      }
    }
    return res;
  }

  public static Integer largestNumBelowN(List<Integer> arr, int n) {
    Integer num = -1;
    for (int i: arr) {
      if (i > num && i < n) {
        num = i;
      }
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{1,2,3,4}));
    System.out.println(solution(new int[]{5,5,5,5}));
    System.out.println(solution(new int[]{0,4,0,0}));
    System.out.println(solution(new int[]{0,6,2,6}));
  }
}

package amazonQuestion;

import java.util.Arrays;

public class ProductExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    int[] ls = new int[nums.length];
    int[] rs = new int[nums.length];
    int[] res = new int[nums.length];

    ls[0] = 1;
    rs[rs.length - 1] = 1;

    for (int i = 1; i < nums.length ; i++) {
      ls[i] = ls[i - 1] * nums[i - 1];
    }

    for (int i = nums.length - 2; i >= 0; i--) {
      rs[i] = rs[i + 1]  * nums[i + 1];
    }

    for (int i = 0; i < nums.length; i++) {
      res[i] = ls[i] * rs[i];
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
  }
}

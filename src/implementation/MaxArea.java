package implementation;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * source: https://leetcode.com/problems/container-with-most-water/
 */
public class MaxArea {
  /**
   * Idea: heuristic search
   * Start from the middle
   *
   * @param height
   * @return
   */
  public static int solution(int[] height) {
    int max_res = 0;
    int lf_idx = 0;
    int rt_idx = height.length - 1;
    int area = 0;

    while (lf_idx < rt_idx) {
      area = (rt_idx-lf_idx) * Math.min(height[lf_idx], height[rt_idx]);
      max_res = Math.max(area, max_res);
      if (height[lf_idx] < height[rt_idx]) {
        lf_idx++;
      } else {
        rt_idx--;
      }
    }

    return max_res;
  }

  public static void main(String[] args) {
    System.out.println(MaxArea.solution(new int[] {1, 2, 4, 3}));
    System.out.println(MaxArea.solution(new int[] {1,8,6,2,5,4,8,3,7}));

  }
}

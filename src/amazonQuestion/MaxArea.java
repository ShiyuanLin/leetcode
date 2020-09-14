package amazonQuestion;

public class MaxArea {
  public int solution(int[] height) {
    int l_idx = 0;
    int r_idx = height.length - 1;
    int area = 0;
    while (l_idx < r_idx) {
      area = Math.max(area, (r_idx - l_idx) * Math.min(height[l_idx], height[r_idx]));
      if (height[l_idx] > height[r_idx]) {
        r_idx--;
      } else {
        l_idx++;
      }
    }
    return area;
  }
}

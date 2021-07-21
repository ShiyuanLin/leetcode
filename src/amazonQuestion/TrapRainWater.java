package amazonQuestion;

import java.util.Arrays;

public class TrapRainWater {
  public int trap(int[] height) {
    int res = 0;
    int a = 0;
    int b = 1;
    int maxIdx = 0;

    for (int i = 0; i < height.length; i++) {
      if (height[i] > height[maxIdx]) {
        maxIdx = i;
      }
    }

    while (b < Math.min(maxIdx+1, height.length)) {
      if (height[b] < height[a]) {
        b++;
      } else {
        // b > a
        int area = (b - a - 1) * height[a];
        for (int i = a+1; i < b; i++) {
          area -= height[i];
        }
        res += Math.max(area, 0);
        a = b;
        b++;
      }
    }

    a = height.length - 1;
    b = height.length - 2;
    while (b > Math.max(maxIdx-1, -1)) {
      if (height[b] < height[a]) {
        b--;
      } else {
        // b > a
        int area = (a - b - 1) * height[a];
        for (int i = b+1; i < a; i++) {
          area -= height[i];
        }
        res += Math.max(area, 0);
        a = b;
        b--;
      }
    }

    return res;
//    if (a+2 < height.length) {
//      if (a == 0) {
//        int[] reverseHeight = new int[height.length - a];
//        int count = 0;
//        for (int i = height.length - 1; i >= a; i--) {
//          reverseHeight[count] = height[i];
//          count++;
//        }
//        return res + trap(reverseHeight);
//      } else {
//        return res + trap(Arrays.copyOfRange(height, a+1, height.length));
//      }
//    } else {
//      return res;
//    }
//    if (a+2 < height.length) {
//      int nextMaxIdx = a+1;
//      for (int i = a+2; i < height.length; i++) {
//        if (height[nextMaxIdx] <= height[i]) {
//          nextMaxIdx = i;
//        }
//      }
//
//      int area = (nextMaxIdx - a - 1) * height[nextMaxIdx];
//      for (int i = a + 1; i < nextMaxIdx; i++) {
//        area -= height[i];
//      }
//      res += Math.max(area, 0);
//    }

//    return res;
  }
}

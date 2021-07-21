package amazonOA;

import java.util.*;

public class CutOffRank {
  //https://aonecode.com/amazon-online-assessment-cutoff-ranks
  // Test passed: [82/87]
  public static int cutOffRank(int cutOffRank, int num, int[] scores) {
    if (cutOffRank == 0 || num == 0) {
      return 0;
    }
    if (cutOffRank >= num) {
      return num;
    }
    Arrays.sort(scores);
    int res = 0;
    int currRank = 1;
    int idx = num - 1;
    while (currRank <= cutOffRank && idx >= 0) {
      res++;
      if (idx-1 >= 0 && scores[idx] != scores[idx-1]) {
        currRank = res+1;
      }
      idx--;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(cutOffRank(3, 4, new int[] {100, 50, 50, 25}));
    System.out.println(cutOffRank(4, 5, new int[] {2,2,3,4,5}));
  }
}
// 241173475
// 79764889

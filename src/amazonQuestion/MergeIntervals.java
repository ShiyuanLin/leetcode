package amazonQuestion;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    return mergeOne(intervals);
  }

  public int[][] mergeOne(int[][] intervals) {
    for (int i = 0; i < intervals.length - 1; i++) {
      for (int j = i+1; j < intervals.length; j++) {
        if (intervals[j][0] <=  intervals[i][1] && intervals[j][1] >= intervals[i][1]) {
          int[] newInterval = new int[] {Math.min(intervals[i][0], intervals[j][0]),
                                         Math.max(intervals[i][1], intervals[j][1])};
          int[][] newIntervals = new int[intervals.length - 1][];
          newIntervals[0] = newInterval;
          int newIndex = 1;
          for (int k = 0; k < intervals.length; k++) {
            if (k != i && k !=j) {
              newIntervals[newIndex] = intervals[k];
              newIndex++;
            }
          }
          return mergeOne(newIntervals);
        }
      }
    }
    return intervals;
  }

  public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals) {
    if (intervals.size() <= 1) {
      return intervals;
    }
    intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
    List<List<Integer>> result = new ArrayList<>();

    List<Integer> current = intervals.get(0);
    int start = current.get(0);
    int end = current.get(1);
    for (int i = 1; i < intervals.size(); i++) {
      current = intervals.get(i);
      if (current.get(0) <= end) {
        end = Math.max(end, current.get(1));
      } else {
        result.add(new ArrayList<>(Arrays.asList(start, end)));
        start = current.get(0);
        end = current.get(1);
      }
    }
    result.add(new ArrayList<>(Arrays.asList(start, end)));
    return result;
  }
}

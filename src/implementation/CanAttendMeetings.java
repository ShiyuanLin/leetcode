package implementation;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
public class CanAttendMeetings {
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    for (int i = 0; i < intervals.length - 1; i++) {
      int[] first = intervals[i];
      int[] second = intervals[i+1];
      if (first[1] > second[0]) {
        return false;
      }
    }
    return true;
  }
}

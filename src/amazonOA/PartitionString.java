package amazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionString {
  public static List<String> partitionString(String input) {
    List<String> res = new ArrayList<>();
    Map<Character, Integer> maxIndexes = new HashMap<>();

    for (int i = 0; i < input.length(); i++) {
      maxIndexes.put(input.charAt(i), i);
    }
    int startIdx = 0;
    while (startIdx < input.length()) {
      int endIdx = maxIndexes.get(input.charAt(startIdx));
      int idx = startIdx;
      while (idx < endIdx) {
        idx++;
        endIdx = Math.max(endIdx, maxIndexes.get(input.charAt(idx)));
      }
      res.add(input.substring(startIdx, endIdx + 1));
      startIdx = endIdx + 1;
    }
    return res;
  }
}

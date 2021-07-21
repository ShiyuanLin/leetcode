package implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstringTwoDistinct {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int leftIdx = 0;
    int rightIdx = 0;
    int maxlength = 0;
    Map<Character, Integer> appeared = new HashMap<>();
    while (rightIdx < s.length()) {
      appeared.put(s.charAt(rightIdx), appeared.getOrDefault(s.charAt(rightIdx), 0) + 1);
      rightIdx++;
      while (appeared.keySet().size() > 2) {
        if (appeared.get(s.charAt(leftIdx)) > 1) {
          appeared.put(s.charAt(leftIdx), appeared.get(s.charAt(leftIdx))-1);
        } else {
          appeared.remove(s.charAt(leftIdx));
        }
        leftIdx++;
      }
      maxlength = Math.max(rightIdx - leftIdx, maxlength);
    }
    return maxlength;
  }
}

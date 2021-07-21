package implementation;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k == 0) {
      return 0;
    }
    Map<Character, Integer> appeared = new HashMap<>();

    int a = 0;
    int b = 0;
    int maxDiff = 0;

    appeared.put(s.charAt(b), 1);
    while (b < s.length() - 1) {
      b++;
      appeared.put(s.charAt(b), appeared.getOrDefault(s.charAt(b), 0) + 1);
      while (appeared.keySet().size() > k) {
        if (appeared.get(s.charAt(a)) == 1) {
          appeared.remove((s.charAt(a)));
        } else {
          appeared.put(s.charAt(a), appeared.get(s.charAt(a)) - 1);
        }
        a++;
      }
      maxDiff = Math.max(maxDiff, b + 1 - a);
    }
    return  Math.max(maxDiff, b + 1 - a);
  }
}

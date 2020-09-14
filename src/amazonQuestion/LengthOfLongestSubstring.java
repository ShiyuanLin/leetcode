package amazonQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
  public static int lengthOfLongestSubstring(String s) {
    // runtime: O(n^2)
    if (s.length() == 0) {
      return 0;
    }
    int i = 0;
    int maxLength = 0;
    int curlenth = 0;
    while (i < s.length()) {
      if (s.substring(i, i+curlenth).contains(String.valueOf(s.charAt(i+curlenth)))) {
        i = i + s.substring(i, i+curlenth).indexOf(s.charAt(i+curlenth)) + 1;
        curlenth = 0;
      } else {
        curlenth++;
      }
      maxLength = Math.max(maxLength, curlenth);
      if (i+curlenth >= s.length()) {
        return maxLength;
      }
    }
    return maxLength;
  }

  public static int slideWindow(String s) {
    int i = 0;
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int j = 0; j < s.length(); j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j-i+1);
      map.put(s.charAt(j), j+1);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "abda";
    System.out.println(s.indexOf("a"));
//    System.out.println(lengthOfLongestSubstring("pwekew"));
    System.out.println(slideWindow("dvdf"));
  }
}

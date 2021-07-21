package amazonQuestion;

import java.util.*;

public class FirstUniqChar {
  public int firstUniqChar(String s) {
    Map<Character, Integer> ones = new HashMap<>();
    Set<Character> mults = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      if (!mults.contains(s.charAt(i))) {
        if (ones.containsKey(s.charAt(i))) {
          ones.remove(s.charAt(i));
          mults.add(s.charAt(i));
        } else {
          ones.put(s.charAt(i), i);
        }
      }
    }
    if (ones.isEmpty()) {
      return -1;
    }
    return Collections.min(ones.values());
  }
}

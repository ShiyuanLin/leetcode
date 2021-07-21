package implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterReplacement {
  public static int characterReplacement(String s, int k) {
//    if (k == 0) {
//      return 0;
//    }
    Map<Character, Integer> appeared = new HashMap<>();
    int a = 0;
    int b = 0;
    int maxLength = 0;
    appeared.put(s.charAt(b), 1);
    while (b < s.length()-1) {
      b++;
      appeared.put(s.charAt(b), appeared.getOrDefault(s.charAt(b), 0) + 1);

      while (greaterThank(appeared, k)) {
        if (appeared.get(s.charAt(a)) == 1) {
          appeared.remove(s.charAt(a));
        } else {
          appeared.put(s.charAt(a), appeared.get(s.charAt(a))-1);
        }
        a++;
      }
      maxLength = Math.max(maxLength, b+1-a);
    }
    return Math.max(maxLength, b+1-a);
  }

  static boolean greaterThank(Map<Character, Integer> map, int k) {
//    if (map.keySet().size() == 1) {
//      return false;
//    }
    int maxValue = 0;
    int value = 0;
    for (Character key: map.keySet()) {
      if (map.get(key) > maxValue) {
        value += maxValue;
        maxValue = map.get(key);
      } else {
        value += map.get(key);
      }
    }
    return value > k;
  }

  public static void main(String[] args) {
    System.out.println(characterReplacement("AAAA", 0));
  }
}

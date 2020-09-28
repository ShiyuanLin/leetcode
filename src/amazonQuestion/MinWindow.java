package amazonQuestion;

import java.util.*;

public class MinWindow {
  public static String minWindow(String s, String t) {
    Map<Character, Integer> store_s = new HashMap<>();
    for (Character c: s.toCharArray()) {
      if (!store_s.containsKey(c)) {
        store_s.put(c, 1);
      } else {
        store_s.put(c, store_s.get(c) + 1);
      }
    }
    for (Character c: t.toCharArray()) {
      if (!(store_s.containsKey(c) && store_s.get(c) > 0)) {
        return "";
      } else {
        store_s.put(c, store_s.get(c)-1);
      }
    }
    String res = s;
    int i = 0;
    int l = s.length()-2;
//    store_s.put(s.charAt(1), store_s.get(s.charAt(i))+1);
    store_s.put(s.charAt(1+l), store_s.get(s.charAt(1+l))-1);
    if (Collections.min(store_s.values()) > 0) {
      res = s.substring(i, i+l);
    }
    boolean slide_right = true;
    while (l > t.length()) {
      if (slide_right) {
        if (i+1+l >= s.length()) {
          slide_right = false;
          store_s.put(s.charAt(i-1), store_s.get(s.charAt(i-1))-1);
          l--;
        } else {
          i++;
          // remove i-1, add i+l
          store_s.put(s.charAt(i-1), store_s.get(s.charAt(i-1))-1);
          store_s.put(s.charAt(i+l), store_s.get(s.charAt(i+l))+1);
        }
      } else {

        if (i-1 <= 0) {
          slide_right = true;
          store_s.put(s.charAt(i+l), store_s.get(s.charAt(i+l))-1);
          l--;
        } else {
          i--;
          store_s.put(s.charAt(i), store_s.get(s.charAt(i))+1);
          store_s.put(s.charAt(i+l+1), store_s.get(s.charAt(i+l+1))-1);
        }
      }
      if (Collections.min(store_s.values()) > 0) {
        res = s.substring(i, i+l);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
}

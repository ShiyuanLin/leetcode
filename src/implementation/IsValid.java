package implementation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class IsValid {
  public static boolean solution(String s) {
    List<Character> l = new ArrayList<Character>();
    Character last = '.';
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        l.add(s.charAt(i));
      } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
        if (l.size() < 1) {
          return false;
        }
        last = l.remove(l.size() - 1);
        if (last == '(') {
          last = ')';
        } else if (last == '{') {
          last = '}';
        } else if (last == '[') {
          last = ']';
        }
        if (!last.equals(s.charAt(i))) {
          return false;
        }
      }
    }
    return l.size() == 0;
//    int parenCounter = 0;
//    int curlCounter = 0;
//    int squareCounter = 0;
//
//    for (int i = 0; i < s.length(); i++) {
//      if (s.charAt(i) == '(') {
//        parenCounter++;
//      }
//      else if (s.charAt(i) == ')') {
//        parenCounter--;
//      }
//
//      if (s.charAt(i) == '{') {
//        curlCounter++;
//      }
//      else if (s.charAt(i) == '}') {
//        curlCounter--;
//      }
//
//      if (s.charAt(i) == '[') {
//        squareCounter++;
//      }
//      else if (s.charAt(i) == ']') {
//        squareCounter--;
//      }
//    }
//    return squareCounter==0 && curlCounter==0 && parenCounter ==0;
  }
}

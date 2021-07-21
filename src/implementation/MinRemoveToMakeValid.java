package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRemoveToMakeValid {
  public String minRemoveToMakeValid(String s) {
    int toBeClosed = 0;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        toBeClosed++;
        result.append(s.charAt(i));
      } else if (s.charAt(i) == ')' && toBeClosed != 0) {
        toBeClosed--;
        result.append(s.charAt(i));
      } else if (!(toBeClosed == 0 && s.charAt(i) == ')')) {
        result.append(s.charAt(i));
      }
    }
    if (toBeClosed == 0) {
      return result.toString();
    }

    String s1 = result.toString();
    result = new StringBuilder();
    for (int i = s1.length()-1; i >=0; i--) {
      if (s1.charAt(i) == ')') {
        toBeClosed++;
        result.insert(0, s1.charAt(i));
      } else if (s1.charAt(i) == '(' && toBeClosed != 0) {
        toBeClosed--;
        result.insert(0, s1.charAt(i));
      } else if (!(toBeClosed == 0 && s1.charAt(i) == '(')) {
        result.insert(0, s1.charAt(i));
      }
    }
    if (toBeClosed == 0) {
      return result.toString();
    } else {
      return "";
    }
  }
}

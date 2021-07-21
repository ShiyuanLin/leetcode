package amazonQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
  public List<String> letterCombinations(String digits) {
    HashMap<Character, List<String>> dict = new HashMap<>();
    dict.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
    dict.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
    dict.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
    dict.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
    dict.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
    dict.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
    dict.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
    dict.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

    List<String> res = new ArrayList<>();

    for (int i = 0; i < digits.length(); i++) {
      if (i == 0) {
        res.addAll(dict.get(digits.charAt(i)));
      } else {
        List<String> newList = new ArrayList<>();
        for (String currS: res) {
          for (String s: dict.get(digits.charAt(i))) {
            newList.add(currS+s);
          }
        }
        res.clear();
        res.addAll(newList);
      }
    }

    return res;
  }
}

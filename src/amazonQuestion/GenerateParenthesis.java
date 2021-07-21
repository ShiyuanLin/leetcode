package amazonQuestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    Set<String> res = new HashSet<>();

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        res.add("()");
      } else {
        List<String> currState = new ArrayList<>(res);
        List<String> nextState = new ArrayList<>();
        for (String parenth: currState) {
          for (int j=0; j < parenth.length(); j++) {
            nextState.add(parenth.substring(0,j) + "()" + parenth.substring(j));
          }
        }
        res.clear();
        res.addAll(nextState);
      }
    }

    return new ArrayList<>(res);
  }
}

package amazonQuestion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
  boolean found;
  Set<String> wordSet;
  public boolean wordBreak(String s, List<String> wordDict) {
    wordSet = new HashSet<>(wordDict);
    found = false;
    wordSeeker(s, 0, s.length());
    return found;
  }

  public void wordSeeker(String s, int startIndex, int endIndex) {
    if (startIndex >= endIndex || found) {
      found = true;
      return;
    }
    while (endIndex > startIndex) {
      if (wordSet.contains(s.substring(startIndex, endIndex))) {
        wordSeeker(s, endIndex, s.length());
      }
      if (found) {
        return;
      }
      endIndex--;
    }
  }
}

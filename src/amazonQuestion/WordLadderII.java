package amazonQuestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadderII {
  public boolean isNextWordValid(String w1, String w2) {
    int count = 0;

    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        count++;
      }
    }
    return count == 1;
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();

    List<List<String>> queue = new ArrayList<> ();
    queue.add(new ArrayList<>(Arrays.asList(beginWord)));

//    List<String> newWordList = new ArrayList<>(wordList);
    boolean keepAddToQueue = true;

    while (!queue.isEmpty()) {
      List<String> currList = queue.remove(0);
//      List<String> currNewWordList = new ArrayList<>(newWordList);
      for (String word: wordList) {
        if (isNextWordValid(currList.get(currList.size()-1), word) && !currList.contains(word)) {
          List<String> newList = new ArrayList<>(currList);
          newList.add(word);
          if (word.equals(endWord)) {
            keepAddToQueue = false;
            if (res.isEmpty()) {
              res.add(newList);
            } else {
              if (newList.size() <= res.get(0).size()) {
                if (newList.size() < res.get(0).size()) {
                  res.clear();
                }
                res.add(newList);
              }
            }
          } else {
            if (keepAddToQueue) {
//              newWordList.remove(word);
              queue.add(newList);
            }
          }
        }
      }
    }
    return res;
  }
}

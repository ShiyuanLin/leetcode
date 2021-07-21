package implementation;

import java.util.*;

// https://leetcode.com/problems/shortest-word-distance-ii/
public class WordDistance {
  Map<String, List<Integer>> wordPosMap;
  public WordDistance(String[] wordsDict) {
    wordPosMap = new HashMap<>();
    for (int i = 0; i < wordsDict.length; i++) {
      wordPosMap.computeIfAbsent(wordsDict[i], (a) -> new ArrayList<>()).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    int minDistance = Integer.MAX_VALUE;
    List<Integer> word1Poss = wordPosMap.get(word1);
    List<Integer> word2Poss = wordPosMap.get(word2);

    int i1 = word1Poss.size() / 2;
    int i2 = word2Poss.size() / 2;
    while (Math.abs(word1Poss.get(i1) - word2Poss.get(i2)) < minDistance) {
      minDistance = word1Poss.get(i1) - word2Poss.get(i2);
      // to-do
    }

    return minDistance;
  }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */

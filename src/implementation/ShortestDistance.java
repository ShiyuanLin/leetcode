package implementation;

public class ShortestDistance {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int idx1 = -1;
    int idx2 = -1;

    int currMin = wordsDict.length;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        idx1 = i;
      } else if (wordsDict[i].equals(word2)) {
        idx2 = i;
      }
      if (idx1 != -1 && idx2 != -1) {
        currMin = Math.min(currMin, Math.abs(idx1 - idx2) );
      }
    }
    return currMin;
  }
}

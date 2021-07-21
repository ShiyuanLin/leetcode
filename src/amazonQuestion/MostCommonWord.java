package amazonQuestion;

import java.util.*;

public class MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> bannedSet = new HashSet<>();

    bannedSet.addAll(Arrays.asList(banned));

    Map<String, Integer> counter = new HashMap<>();

//    String res = "";
//    int max = 0;
    String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
    for (String word: normalizedStr.split("\\s+")) {
      if (!bannedSet.contains(word)) {
        counter.put(word, counter.getOrDefault(word, 0) + 1);
      }
//      String word = uncleanWord.replaceAll("[!?',;. ]","").toLowerCase();
//      if (bannedSet.contains(word) || word.length() == 0) {
//        continue;
//      }
//      if (counter.containsKey(word)) {
//        counter.put(word, counter.get(word) + 1);
//      } else {
//        counter.put(word, 1);
//      }
//      if (counter.get(word) > max) {
//        max = counter.get(word);
//        res = word;
//      }
    }

//    return res;
    return Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
}

package implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
  public static List<List<String>> solution(String[] strs) {
    Map<Map<Character, Integer>, List<String>> strDicts = new HashMap<>();

    // Construct hashmap for the strs
    for (String str : strs) {
      Map<Character, Integer> strDict = new HashMap<>();
      // Construct hashmap for a string
      for (int j = 0; j < str.length(); j++) {
        if (strDict.containsKey(str.charAt(j))) {
          strDict.put(str.charAt(j), strDict.get(str.charAt(j)) + 1);
        } else {
          strDict.put(str.charAt(j), 1);
        }
      }
      // Compare hashmap with grouped str hashmaps
      if (strDicts.containsKey(strDict)) {
        List<String> curr = strDicts.get(strDict);
        curr.add(str);
        strDicts.put(strDict, curr);
      } else {
        strDicts.put(strDict, new ArrayList<>(List.of(str)));
      }
    }

    return new ArrayList<>(strDicts.values());
  }

  public static void main(String[] args) {
    System.out.println(GroupAnagrams.solution(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
  }
}

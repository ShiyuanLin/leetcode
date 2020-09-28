package amazonQuestion;

import java.util.*;

public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
//    Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();

//    for (String str: strs) {
//      Map<Character, Integer> letters = new HashMap<>();
//      for (int i = 0; i < str.length(); i++) {
//        if (letters.containsKey(str.charAt(i))) {
//          letters.put(str.charAt(i), letters.get(str.charAt(i))+1);
//        } else {
//          letters.put(str.charAt(i), 0);
//        }
//      }
//      if (groups.containsKey(letters)) {
//        groups.get(letters).add(str);
//      } else {
//        List<String> strings = new ArrayList<>();
//        strings.add(str);
//        groups.put(letters, strings);
//      }
//    }
    Map<String, List<String>> groups = new HashMap<>();
    for (String str: strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = String.valueOf(chars);
      if (!groups.containsKey(key)) {
        groups.put(key, new ArrayList<>());
      }
      groups.get(key).add(str);
    }

    return new ArrayList<>(groups.values());
  }

  public static void main(String[] args) {
    System.out.println("nifty" instanceof  String);
    ;
    List list = new ArrayList();
    list.add("hello");
    list.add(2);
    System.out.println(list.get(1) instanceof Integer);
  }
}

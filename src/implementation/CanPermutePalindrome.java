package implementation;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/palindrome-permutation
public class CanPermutePalindrome {
  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> characterOccurs = new HashMap<>();
    for (Character c: s.toCharArray()) {
      characterOccurs.put(c, characterOccurs.getOrDefault(c, 0) + 1 );
    }
    boolean singleChar = false;
    for (Integer i: characterOccurs.values()) {
      if (i % 2 == 1) {
        if (singleChar) {
          return false;
        } else {
          singleChar = true;
        }
      }
    }
    return true;
  }
}

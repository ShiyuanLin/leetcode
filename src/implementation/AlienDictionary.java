package implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/alien-dictionary/
public class AlienDictionary {
  //  Set<Character> appeared;
//  List<Character> lexiOrder;
//  public String alienOrder(String[] words) {
//
//  }

//  public String alienOrder(String[] words) {
//    appeared = new HashSet<>();
//    lexiOrder = new ArrayList<>();
//
//    for (int i = 1; i < words.length; i++) {
//      Character[] compare = orderDetector(words[i-1], words[i]);
//      if (compare.length == 0) {
//        continue;
//      }
//      if (appeared.contains(compare[0]) && appeared.contains(compare[1])) {
//        boolean secondAppeared = false;
//        for (Character c: lexiOrder) {
//          if (c.equals(compare[0]) && secondAppeared) {
//            return "";
//          } else if (c.equals(compare[1])) {
//            secondAppeared = true;
//          }
//        }
//      } else if (appeared.contains(compare[0]) || appeared.contains(compare[1])) {
//        for (int j = 0; j < lexiOrder.size(); j++) {
//          if (lexiOrder.get(j).equals(compare[0])) {
//            lexiOrder.add(j+1, compare[1]);
//            appeared.add(compare[1]);
//            break;
//          } else if (lexiOrder.get(j).equals(compare[1])) {
//            lexiOrder.add(j, compare[0]);
//            appeared.add(compare[0]);
//            break;
//          }
//        }
//      } else {
//        lexiOrder.add(compare[0]); lexiOrder.add(compare[1]);
//        appeared.add(compare[0]); appeared.add(compare[1]);
//      }
//    }
//    return lexiOrder.toString();
//  }
//
//  private Character[] orderDetector(String first, String second) {
//    for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
//      if (first.charAt(i) != second.charAt(i)) {
//        return new Character[] {first.charAt(i), second.charAt(i)};
//      }
//    }
//    return new Character[] {};
//  }
  public static void main(String[] args) {
    char a = 'a';
    char b = 'b';
    System.out.println(a < b);
  }
}

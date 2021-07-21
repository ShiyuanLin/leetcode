package implementation;

import java.util.*;

public class ReorganizeString {
  public static String reorganizeString(String s) {
    return "";
  }

  public static void main(String[] args) {
    System.out.println(reorganizeString("aaab"));
  }
}

//
//  Map<Character, Integer> characterIntegerMap = new HashMap<>();
//
//    for (Character c: s.toCharArray()) {
//            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
//            }
//
//            PriorityQueue<Integer> occurs = new PriorityQueue<>((a, b) -> b - a);
//        Map<Integer, List<Character>> integerCharacterMap = new HashMap<>();
//        for (Character c: characterIntegerMap.keySet()) {
//        if (!occurs.contains(characterIntegerMap.get(c))) {
//        occurs.add(characterIntegerMap.get(c));
//        }
//        integerCharacterMap.computeIfAbsent(characterIntegerMap.get(c), x -> new ArrayList<>());
//        integerCharacterMap.get(characterIntegerMap.get(c)).add(c);
//        }
//        StringBuilder result = new StringBuilder();
//        while (!occurs.isEmpty()) {
//        Integer occur = occurs.poll();
//        if (occur > 1) {
//        integerCharacterMap.computeIfAbsent(occur-1, x -> new ArrayList<>());
//        if (!occurs.contains(occur - 1)) {
//        occurs.add(occur - 1);
//        }
//        }
//        for (Character c: integerCharacterMap.get(occur)) {
//        if (result.length() > 0 && result.charAt(result.length() - 1) == c) {
//        if (occurs.isEmpty()) {
//        return "";
//        } else {
//        Integer suboccur = occurs.peek();
//        result.append(integerCharacterMap.get(suboccur).get(0));
//        if (integerCharacterMap.get(suboccur).size() == 1) {
//        occurs.poll();
//        integerCharacterMap.remove(suboccur);
//        } else {
//        integerCharacterMap.get(suboccur).remove(0);
//        integerCharacterMap.computeIfAbsent(suboccur-1, x->new ArrayList<>());
//        integerCharacterMap.get(suboccur-1).add(result.charAt(result.length()-1));
//        if (!occurs.contains(suboccur-1)) {
//        occurs.add(suboccur-1);
//        }
//        }
//        }
//        }
//        if (occur > 1 && !occurs.isEmpty() && occurs.peek() != occur - 1) {
//        integerCharacterMap.computeIfAbsent(occur-1, x -> new ArrayList<>());
//        if (occurs.peek() != occur - 1) {
//        occurs.add(occur - 1);
//        }
//        }
//        result.append(c);
//        if (occur > 1) {
//        integerCharacterMap.get(occur - 1).add(c);
//        }
//        }
//        integerCharacterMap.remove(occur);
//        }
//        return result.toString();
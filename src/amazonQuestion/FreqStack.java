package amazonQuestion;

import java.util.*;

class FreqStack {


  Map<Integer, Integer> valFreqDict;
  Map<Integer, Stack<Integer>> groups;
  int maxFreq;
  public FreqStack() {
    valFreqDict = new HashMap<>();
    groups = new HashMap<>();
    maxFreq = 0;
  }

  public void push(int x) {
    valFreqDict.put(x, valFreqDict.getOrDefault(x, 0) + 1);
    if (valFreqDict.get(x) > maxFreq) {
      maxFreq = valFreqDict.get(x);
    }
    groups.computeIfAbsent(valFreqDict.get(x), (z) -> new Stack<>()).push(x);
  }

  public int pop() {
    int element = groups.get(maxFreq).pop();
    valFreqDict.put(element, valFreqDict.get(element) - 1);
    if (groups.get(maxFreq).isEmpty()) {
      groups.remove(maxFreq);
      maxFreq--;
    }
    return element;
  }
}




//class FreqStack {
//
//  List<Integer> stack;
//  HashMap<Integer, Integer> valFreq;
//  HashMap<Integer, List<Integer>> freqVal;
//  public FreqStack() {
//    stack = new ArrayList<>();
//    valFreq = new HashMap<>();
//    freqVal = new HashMap<>();
//  }
//
//  public void push(int x) {
//    stack.add(0, x);
//    int freq = valFreq.getOrDefault(x, 0) + 1;
//    valFreq.put(x, freq);
//    if (freqVal.containsKey(freq)) {
//      freqVal.get(freq).add(x);
//      if (freq != 1) {
//        freqVal.get(freq-1).remove((Integer) x);
//      }
//    }
//  }
//
//  public int pop() {
//    int res;
//    int freq;
//    // tie
//    if (freqVal.get(Collections.max(freqVal.keySet())).size() > 1) {
//      res = stack.get(0);
//      freq = valFreq.get(res);
//      stack.remove(0);
//      if (freq == 1) {
//        valFreq.remove(res);
//      }
//      freqVal.get(freq).remove((Integer) res);
//      if (freq != 0) {
//        freqVal.get(freq-1).add(res);
//      }
//    } else {
//      res = fre
//    }
//  }
//}

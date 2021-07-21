package amazonQuestion;

import java.util.*;

class AutocompleteSystem {

  class Record implements Comparable<Record> {
    String sentence;
    int val; // how many times it appeared

    @Override
    public int compareTo(Record o) {
      int res = Integer.compare(this.val, o.val);
      if (res == 0) {
        return this.sentence.compareTo(o.sentence);
      }
      return res;
    }
  }

  Map<String, List<Record>> sentenceDict;
  Map<String, Record> recordDict;
  String currString;
  public AutocompleteSystem(String[] sentences, int[] times) {
    sentenceDict = new HashMap<>();
    recordDict = new HashMap<>();
    currString = "";
    for (int i = 0; i < sentences.length; i++) {
      addNewRecord(sentences[i], times[i]);
    }
  }

  public void addNewRecord(String sentence, int time) {
    Record newRecord = new Record();
    newRecord.sentence = sentence;
    newRecord.val = time;
    recordDict.put(sentence, newRecord);

    for (int j = 1; j <= sentence.length(); j++) {
      if (!sentenceDict.containsKey(sentence.substring(0,j))) {
        sentenceDict.put(sentence.substring(0,j), new ArrayList<>());
      }
      sentenceDict.get(sentence.substring(0,j)).add(newRecord);
    }
  }

  public List<String> input(char c) {
    List<String> res = new ArrayList<>();
    List<Record> candidates;
    if (c == '#') {
      if (recordDict.containsKey(currString)) {
        recordDict.get(currString).val++;
      } else {
        addNewRecord(currString, 1);
      }
      this.currString = "";
      return res;
    } else {
      this.currString += c;
      System.out.print(currString);
      candidates = sentenceDict.getOrDefault(currString, new ArrayList<>());
      Collections.sort(candidates);
      for (int i = 0; i < Math.min(3, candidates.size()); i++) {
        res.add(candidates.get(i).sentence);
      }
      return res;
    }
  }
}
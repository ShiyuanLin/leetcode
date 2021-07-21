package amazonQuestion;

import java.util.*;

public class TopKFrequent {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numFrequency = new HashMap<>();

    for (int num: nums) {
      numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
    }

    Map<Integer, List<Integer>> frequencyNum = new HashMap<>();
    for (Integer num: numFrequency.keySet()) {
      if (frequencyNum.containsKey(numFrequency.get(num))) {
        frequencyNum.get(numFrequency.get(num)).add(num);
      } else {
        frequencyNum.put(numFrequency.get(num), new ArrayList<>(Collections.singletonList(num)));
      }
    }

    Integer[] topFrequencies = new Integer[frequencyNum.keySet().size()];
    frequencyNum.keySet().toArray(topFrequencies);
    Arrays.sort(topFrequencies, (a, b) -> Integer.compare(b, a));
    int[] res = new int[k];

    int count = 0;
    for (Integer topFrequency : topFrequencies) {
      for (int j = 0; j < frequencyNum.get(topFrequency).size(); j++) {
        res[count] = frequencyNum.get(topFrequency).get(j);
        if (count == k - 1) {
          return res;
        }
        count++;
      }
    }
    return res;
  }
}

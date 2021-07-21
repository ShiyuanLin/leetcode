package implementation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  List<List<Integer>> results;

  void find(int index, int[] candidates, int target, List<Integer> combination) {
    if (target == 0) {
      results.add(new ArrayList<>(combination));
      return;
    }
    if (target < 0) {
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      combination.add(candidates[i]);
      find(i, candidates, target - candidates[i], combination);
      combination.remove(combination.size()-1);
    }
    return;
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    results = new ArrayList<>();
    find(0, candidates, target, new ArrayList<>());
    return results;
  }
}

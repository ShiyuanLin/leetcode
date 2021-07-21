package amazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimizeMemoryUsage {
  public List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K) {
    List<int[]> res = new ArrayList<>();
    Map<Integer, List<Integer>> foreValIdxDict = new HashMap<>();
    for (int i = 0; i < foregroundTasks.length; i++) {
      foreValIdxDict.computeIfAbsent(foregroundTasks[i], (a) -> new ArrayList<>()).add(i);
    }
    while (res.isEmpty() && K >=0) {
      if (foreValIdxDict.containsKey(K)) {
        for (int idx: foreValIdxDict.get(K)) {
          res.add(new int[] {idx, -1});
        }
      }
      for (int i = 0; i < backgroundTasks.length; i++) {
        if (backgroundTasks[i] == K) {
          res.add(new int[] {-1, i});
        }
        if (foreValIdxDict.containsKey(K - backgroundTasks[i])) {
          for (int idx: foreValIdxDict.get(K - backgroundTasks[i])) {
            res.add(new int[] {idx, i});
          }
        }
      }
      K--;
    }
    if (res.isEmpty()) {
      res.add(new int[] {-1, -1});
    }
    return res;
  }
}

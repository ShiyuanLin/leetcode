package amazonOA;

import java.util.*;

public class FillTheTruck {
  public static int loadTheCargo(int num, int[] containers, int itemSize, int[] itemsPerContainer, long cargoSize) {
    Map<Integer, List<Integer>> itemSizeIdxDict = new HashMap<>();
    PriorityQueue<Integer> itemsPerContainerRank = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < itemSize; i++) {
      itemSizeIdxDict.computeIfAbsent(itemsPerContainer[i], (a) -> new ArrayList<>()).add(i);
      itemsPerContainerRank.add(itemsPerContainer[i]);
    }

    int result = 0;

    while (cargoSize > 0 && !itemsPerContainerRank.isEmpty()) {
      int currMax = itemsPerContainerRank.poll();
      int containerIdx = itemSizeIdxDict.get(currMax).remove(0);
      while (cargoSize > 0 && containers[containerIdx] > 0) {
        result += currMax;
        containers[containerIdx]--;
        cargoSize--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(loadTheCargo(3, new int[] {3, 1, 2}, 3, new int[] {1, 2, 3}, 4));
  }
}

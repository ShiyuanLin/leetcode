package implementation;

import java.lang.reflect.Array;
import java.util.*;

// To be fixed
public class MinPathSum {
  public static int solution(int[][] grid) {
    Map<Integer, List<Integer>> steps = new HashMap<>();

    int i = 0;
    int j = 0;
    int max_i = grid[0].length - 1;
    int max_j = grid.length - 1;

    if (max_i == 0 && max_j ==0) {
      return grid[0][0];
    }
    steps.put(grid[j][i], new ArrayList<>(Arrays.asList(i, j)));
    Set<List<Integer>> explored = new HashSet<>();
    explored.add(new ArrayList<>(Arrays.asList(i, j)));

    while (!steps.isEmpty()) {
      // Find the coordinate with minimum value
      int min_value = Collections.min(steps.keySet());
      i = steps.get(min_value).get(0);
      j = steps.get(min_value).get(1);
      if (steps.get(min_value).size() > 2) {
        steps.get(min_value).remove(0);
        steps.get(min_value).remove(0);
      } else {
        steps.remove(min_value);
      }
      // Calculate the next value
      // i+1
      if (i < max_i && !explored.contains(new ArrayList<>(Arrays.asList(i+1, j)))) {
        grid[j][i+1] += grid[j][i];
        if (j == max_j && i+1 == max_i) {
          return grid[j][i+1];
        }
        explored.add(new ArrayList<>(Arrays.asList(i+1, j)));
        if (steps.containsKey(grid[j][i+1])) {
          steps.get(grid[j][i+1]).add(i+1);
          steps.get(grid[j][i+1]).add(j);
        } else {
          steps.put(grid[j][i+1], new ArrayList<>(Arrays.asList(i+1, j)));
        }
      }
      // j+1
      if (j < max_j && !explored.contains(new ArrayList<>(Arrays.asList(i, j+1)))) {
        grid[j+1][i] += grid[j][i];
        if (j+1 == max_j && i == max_i) {
          return grid[j+1][i];
        }
        explored.add(new ArrayList<>(Arrays.asList(i, j+1)));
        if (steps.containsKey(grid[j+1][i])) {
          steps.get(grid[j+1][i]).add(i);
          steps.get(grid[j+1][i]).add(j+1);
        } else {
          steps.put(grid[j+1][i], new ArrayList<>(Arrays.asList(i, j+1)));
        }
      }
    }
    return grid[max_j][max_i];
  }

  public static void main(String[] args) {
//    System.out.println(solution(new int[][]{{1}}));
    System.out.println(solution(new int[][]{{1, 2, 5}, {3, 2, 1}}));
//    int[] a = new int[] {1, 2};
//    int[] b = new int[] {1, 2};
//    System.out.println(a == b);
//    System.out.println(solution(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
  }
}

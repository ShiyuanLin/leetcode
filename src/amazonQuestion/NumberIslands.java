package amazonQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberIslands {
  public int numIslands(char[][] grid) {
    int res = 0;
    int index = 0;

    while (index < grid.length * grid[0].length) {
      int x = index % grid[0].length;
      int y = index / grid[0].length;
      if (grid[y][x] == '0') {
        index++;
      } else {
        res++;
        List<Integer> indexQueue = new ArrayList<>();
        indexQueue.add(x);
        indexQueue.add(y);
        grid[y][x] = '0';
        while (!indexQueue.isEmpty()) {
          x = indexQueue.remove(0);
          y = indexQueue.remove(0);
          if (x > 0) {
            if (grid[y][x-1] != '0') {
              indexQueue.add(x-1);
              indexQueue.add(y);
              grid[y][x-1] = '0';
            }
          }
          if (x < grid[0].length - 1) {
            if (grid[y][x+1] != '0') {
              indexQueue.add(x+1);
              indexQueue.add(y);
              grid[y][x+1] = '0';
            }
          }
          if (y > 0) {
            if (grid[y-1][x] != '0') {
              indexQueue.add(x);
              indexQueue.add(y-1);
              grid[y-1][x] = '0';
            }
          }
          if (y < grid.length - 1) {
            if (grid[y+1][x] != '0') {
              indexQueue.add(x);
              indexQueue.add(y+1);
              grid[y+1][x] = '0';
            }
          }
        }
      }
    }
    return res;
  }
}

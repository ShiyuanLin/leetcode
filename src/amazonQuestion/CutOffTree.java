package amazonQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutOffTree {
  public int cutOffTree(List<List<Integer>> forest) {
    int numTrees = 0;
    if (forest.get(0).get(0) > 1) {
      numTrees = -1;
    }
    for (int x = 0; x < forest.get(0).size(); x++) {
      for (List<Integer> integers : forest) {
        if (integers.get(x) > 1) {
          numTrees++;
        }
      }
    }
    int steps = cutoffTreeTour(forest, 0, 0, 0);
    if (steps == numTrees) {
      return steps;
    } else {
      return -1;
    }
  }

  public int cutoffTreeTour(List<List<Integer>> forest, int x, int y, int currStep) {
    List<Integer> nextXY = nextCoor(forest, x, y);
    int nextX = nextXY.get(0);
    int nextY = nextXY.get(0);


    if (nextX == x && nextY == y) {
      forest.get(y).set(x, 1);
    }
    return cutoffTreeTour(forest, nextX, nextY, currStep + 1) + 1;
  }

  public List<Integer> nextCoor(List<List<Integer>> forest, int x, int y) {
    int nextX = x;
    int nextY = y;

    int max = Integer.MAX_VALUE;
    if (x > 0) {
      if (forest.get(y).get(x-1) > forest.get(y).get(x) && forest.get(y).get(x-1) < max) {
        nextX = x-1;
        nextY = y;
      }
    }
    if (x < forest.get(0).size()-1) {
      if (forest.get(y).get(x+1) > forest.get(y).get(x) && forest.get(y).get(x+1) < max) {
        nextX = x+1;
        nextY = y;
      }
    }
    if (y > 0) {
      if (forest.get(y-1).get(x) > forest.get(y).get(x) && forest.get(y-1).get(x) < max) {
        nextX = x;
        nextY = y-1;
      }
    }
    if (y < forest.size()-1) {
      if (forest.get(y+1).get(x) > forest.get(y).get(x) && forest.get(y+1).get(x) < max) {
        nextX = x;
        nextY = y+1;
      }
    }
    return new ArrayList<>(Arrays.asList(nextX, nextY));
  }
}

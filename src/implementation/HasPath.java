package implementation;

import javafx.util.Pair;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//https://leetcode.com/problems/the-maze/
public class HasPath {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if (start[0] == destination[0] && start[1] == destination[1]) {
      return true;
    }
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Deque<Pair<Integer, Integer>> queue = new LinkedList<>();

    Pair<Integer, Integer> current = new Pair<Integer, Integer>(start[0], start[1]);
    visited.add(current);
    queue.add(current);

    int[] xDirections = new int[] {0, 0, -1, 1};
    int[] yDirections = new int[] {-1, 1, 0, 0};
    while (!queue.isEmpty()) {
      current = queue.pollFirst();

      for (int i = 0; i < xDirections.length; i++) {
        int nextX = current.getKey();
        int nextY = current.getValue();
        while (nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length &&
                maze[nextX][nextY] != 1) {
          nextX += xDirections[i];
          nextY += yDirections[i];
        }
        nextX -= xDirections[i];
        nextY -= yDirections[i];
        if (nextX == destination[0] && nextY == destination[1]) {
          return true;
        }
        Pair<Integer, Integer> next = new Pair<Integer, Integer> (nextX, nextY);
        if (!visited.contains(next)) {
          visited.add(next);
          queue.add(next);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Pair<Integer, Integer> a = new Pair<Integer, Integer>(2, 3);
  }
}

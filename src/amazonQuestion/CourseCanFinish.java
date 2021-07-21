package amazonQuestion;

import java.util.*;

public class CourseCanFinish {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> edges = new HashMap<>();

    Set<Integer> unexplorered = new HashSet<>();


    for (int[] prerequisite : prerequisites) {
      if (edges.containsKey(prerequisite[0])) {
        edges.get(prerequisite[0]).add(prerequisite[1]);
      } else {
        unexplorered.add(prerequisite[0]);
        edges.put(prerequisite[0], new ArrayList<>(Collections.singletonList(prerequisite[1])));
      }
    }

    while (!unexplorered.isEmpty()) {
      int firstCourse = (Integer) unexplorered.toArray()[0];
      Set<Integer> visited = new HashSet<>();
//      Set<Integer> visiting = new HashSet<>();
      visited.add(firstCourse);
      List<Integer> queue = new ArrayList<>(edges.get(firstCourse));
      while (!queue.isEmpty()) {
        int currCourse = queue.get(queue.size() - 1);
        queue.remove(0);
        if (edges.containsKey(currCourse)) {
          for (int course: edges.get(currCourse)) {
            if (visited.contains(course)) {
              return false;
            }
          }
          visited.add(currCourse);
          queue.addAll(edges.get(currCourse));
        } else {
          visited.remove(currCourse);
          unexplorered.remove(currCourse);
        }
      }
      for (int visitedCourse: visited) {
        unexplorered.remove(visitedCourse);
      }
    }
    return true;
  }
}

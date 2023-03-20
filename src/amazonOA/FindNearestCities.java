package amazonOA;

import java.util.*;

public class FindNearestCities {
  public static String[] findNearestCities(int numOfPoints,
                                    String[] points,
                                    int[] xCoordinates,
                                    int[] yCoordinates,
                                    int numOfQueriedPoints,
                                    String[] queriedPoints) {
    String[] result = new String[numOfQueriedPoints];
    Map<Integer, List<Integer>> xIdxDict = new HashMap<> (); // yCoord: pointIdx
    Map<Integer, List<Integer>> yIdxDict = new HashMap<>();  // xCood: pointIdx
    Map<String, Integer> pointIdxDict = new HashMap<>(); // String: pointIdx

    for (int i = 0; i < numOfPoints; i++) {
      xIdxDict.computeIfAbsent(xCoordinates[i], (a) -> new ArrayList<>()).add(i);
      yIdxDict.computeIfAbsent(yCoordinates[i], (a) -> new ArrayList<>()).add(i);
      pointIdxDict.put(points[i], i);
    }
    for (int i = 0; i < numOfQueriedPoints; i++) {
      String point = queriedPoints[i];
      Integer pointIdx = pointIdxDict.get(point);
      int x = xCoordinates[pointIdx];
      int y = yCoordinates[pointIdx];
      Set<Integer> candidates = new HashSet<>();
      candidates.addAll(xIdxDict.get(x));
      candidates.addAll(yIdxDict.get(y));
      candidates.remove(pointIdx);
      if (candidates.isEmpty()) {
        result[i] = null;
      } else {
        int minIdx = 0;
        int minDistance = Integer.MAX_VALUE;
        for (Integer candidate: candidates) {
          int distance = Math.abs(xCoordinates[candidate] - x)
                  + Math.abs(yCoordinates[candidate] - y);
          minIdx = (distance < minDistance) ? candidate:minIdx;
        }
        result[i] = points[minIdx];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(findNearestCities(3, new String[]{"c1", "c2", "c3"}, new int[]{3, 2, 1},
            new int[]{3, 2, 3}, 3, new String[]{"c1", "c2", "c3"})));
  }
}

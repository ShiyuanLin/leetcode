package implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountComponents {
  int[] visited;
  public int countComponents(int n, int[][] edges) {
    visited = new int[n];
    Map<Integer, List<Integer>> nodeEdgeMap = new HashMap<>();

    for (int[] edge: edges) {
      if (!nodeEdgeMap.containsKey(edge[0])) {
        nodeEdgeMap.put(edge[0], new ArrayList<>());
      }
      if (!nodeEdgeMap.containsKey(edge[1])) {
        nodeEdgeMap.put(edge[1], new ArrayList<>());
      }
      nodeEdgeMap.get(edge[0]).add(edge[1]);
      nodeEdgeMap.get(edge[1]).add(edge[0]);
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        count++;
        traverse(i, nodeEdgeMap);
      }
    }
    return count;
  }

  public void traverse(int n, Map<Integer, List<Integer>> nodeEdgeMap) {
    if (visited[n] == 1) return;
    visited[n] = 1;
    if (!nodeEdgeMap.containsKey(n)) return;
    for (int node: nodeEdgeMap.get(n)) {
      traverse(node, nodeEdgeMap);
    }
  }
}

package implementation;

import java.util.ArrayList;

//https://leetcode.com/problems/graph-valid-tree/
public class ValidTree {
  int[] explored;
  public boolean validTree(int n, int[][] edges) {
    explored = new int[n];
    ArrayList<Integer>[] tree = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      tree[i] = new ArrayList<>();
    }
    for (int[] edge: edges) {
      tree[edge[0]].add(edge[1]);
      tree[edge[1]].add(edge[0]);
    }
    if (!dfs(0, tree, -1)) {
      return false;
    }
    for (int i: explored) {
      if (i == 0) {
        return false;
      }
    }
    return true;
  }

  public boolean dfs(int node, ArrayList<Integer>[] tree, int prev) {
    if (explored[node] == 1) {
      return false;
    }
    explored[node] = 1;
    for (int i: tree[node]) {
      if (i == prev) {
        continue;
      }
      if (!dfs(i, tree, node)) {
        return false;
      }
    }
    return true;
  }
}

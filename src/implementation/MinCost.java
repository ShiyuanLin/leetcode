package implementation;

//https://leetcode.com/problems/paint-house/
public class MinCost {
  public int minCost(int[][] costs) {
    int len = costs.length;
    int[][] totalCosts = new int[len][];
    totalCosts[0] = costs[0];
    for (int i = 1; i < len; i++) {
      int[] currentCosts = new int[3];
      for (int j = 0; j < 3; j++) {
        currentCosts[j] = Math.min(totalCosts[i-1][(j+1) % 3], totalCosts[i-1][(j+2) % 3]) + costs[i][j];
      }
      totalCosts[i] = currentCosts;
    }
    return Math.min(totalCosts[len - 1][0], Math.min(totalCosts[len - 1][1], totalCosts[len - 1][2]));
  }
}

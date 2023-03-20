package amazonQuestion;

import java.util.Arrays;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    Arrays.sort(coins);
    int[] dp = new int[amount+1];

    for (int i = 0; i < amount + 1; i++) {
      dp[i] = 0;
    }
    for (int i = 0; i < amount + 1; i++) {
      int currMin = Integer.MAX_VALUE;
      for (int j = coins.length - 1; j >=0; j--) {
        int previousIndex = i - coins[j];
        if (previousIndex >= 0) {
          if (!(dp[previousIndex] == 0 && previousIndex != 0)) {
            currMin = Math.min(dp[previousIndex] + 1, currMin);
          }
        }
      }
      if (currMin != Integer.MAX_VALUE) {
        dp[i] = currMin;
      }
    }
    if (dp[amount] == 0) {
      return -1;
    }
    return dp[amount];
  }
}

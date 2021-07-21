package amazonQuestion;

public class MaxStockProfit {
  public int maxProfit(int[] prices) {
    int minIndex = 0;
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      profit = Math.max(profit, prices[i] - prices[minIndex]);
      if (prices[i] < prices[minIndex]) {
        minIndex = i;
      }
    }
    return profit;
  }
}

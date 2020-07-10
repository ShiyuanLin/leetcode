package implementation;

public class MaxProfit {
  public static int solution(int[] prices) {
    int profit = 0;
    int i = 0;
    boolean bought = false;
    int price = 0;
    while (i < prices.length) {
      if (bought) {
        if (i+1 == prices.length) {
          if (prices[i] > price) {
            profit += prices[i] - price;
            bought = false;
          }
        } else if (prices[i+1] < prices[i] && prices[i] >= price) {
          profit += prices[i] - price;
          bought = false;
        }
      } else {
        // Not bought
        if (i+1 < prices.length) {
          if (prices[i + 1] > prices[i]) {
            price = prices[i];
            bought = true;
          }
        }
      }
      i++;
    }

    return profit;
  }

  public static void main(String[] args) {
//    System.out.println(solution(new int[] {7,1,5,3,6,4}));
//    System.out.println(solution(new int[] {1,2,3,4,5}));
//    System.out.println(solution(new int[] {7,6,4,3,1}));
    System.out.println(solution(new int[] {2, 4, 1}));
  }
}

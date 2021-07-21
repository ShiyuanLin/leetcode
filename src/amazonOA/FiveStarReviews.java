package amazonOA;

import java.util.Collections;

public class FiveStarReviews {
  public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
    int count = 0;
    Double[] gains = new Double[productRatings.length];
    for (int i = 0; i < productRatings.length; i++) {
      gains[i] = ((productRatings[i][0]+1.0) / (productRatings[i][1]+1))
              - (productRatings[i][0] * 1.0 / productRatings[i][1]);
    }
    while (calculateOverallRating(productRatings) < ratingsThreshold) {
      int gainIdx = 0;
      for (int i = 1; i < productRatings.length; i++) {
        if (gains[gainIdx] < gains[i]) {
          gainIdx = i;
        }
      }
      productRatings[gainIdx][0]++;
      productRatings[gainIdx][1]++;
      gains[gainIdx] = ((productRatings[gainIdx][0]+1.0) / (productRatings[gainIdx][1]+1))
              - (productRatings[gainIdx][0] * 1.0 / productRatings[gainIdx][1]);
      count++;
    }
    return count;
  }

  public static double calculateOverallRating(int[][] productRatings) {
    double totalPercent = 0;
    for (int[] productRating: productRatings) {
      totalPercent += (productRating[0] * 1.0) / productRating[1];
    }
    return totalPercent * 100 / productRatings.length;
  }
}

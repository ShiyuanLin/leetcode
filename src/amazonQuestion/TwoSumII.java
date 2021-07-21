package amazonQuestion;

public class TwoSumII {
  public int[] twoSum(int[] numbers, int target) {
    int leftIndex = 0;
    int rightIndex = numbers.length -1 ;

    int predict = numbers[leftIndex] + numbers[rightIndex];
    while (predict != target) {
      if (predict > target) {
        rightIndex--;
      } else {
        leftIndex++;
      }
      predict = numbers[leftIndex] + numbers[rightIndex];
    }
    return new int[] {leftIndex+1, rightIndex+1};
  }
}

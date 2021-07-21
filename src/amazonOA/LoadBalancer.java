package amazonOA;

public class LoadBalancer {
  public boolean loadBalance(int[] arr) {
    if (arr.length < 5) {
      return false;
    }
    int leftIdx = 1;
    int rightIdx = 3;

    int leftSum = arr[0], midSum = arr[2], rightSum = 0;
    for (int i = rightIdx + 1; i < arr.length; i++) {
      rightSum += arr[i];
    }
    while (!(leftSum == midSum && leftSum == rightSum)) {
      if (leftSum > rightSum && midSum > rightSum) {
        return false;
      }
      midSum += arr[rightIdx];
      rightIdx++;
      rightSum -= arr[rightIdx];
      if (leftSum < midSum) {
        leftSum += arr[leftIdx];
        leftIdx++;
        midSum -= arr[leftIdx];
      }
    }
    return true;
  }
}
// 1 2 3 4 5
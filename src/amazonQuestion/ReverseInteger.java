package amazonQuestion;

public class ReverseInteger {
  public int reverse(int x) {
    boolean positive = false;
    int diff = -1;
    if (x > 0) {
      x = -x;
      positive = true;
      diff = 0;
    }
    String xString = String.valueOf(x);
    StringBuilder reverseString = new StringBuilder();
    for (char c: xString.toCharArray()) {
      if (c != '-') {
        reverseString.insert(0, c);
      }
    }
    reverseString.insert(0, '-');
    if (Integer.parseInt(reverseString.toString()) < - 2147483647 + diff) {
      return 0;
    }
    int res = Integer.parseInt(reverseString.toString());
    return positive?-res:res;
//    boolean positive = false;
//    int addOne = 1;
//    if (x > 0) {
//      positive = true;
//      x = -x;
//      addOne = 0;
//    }
//    if (x == 0) {
//      return x;
//    }
//    int currIndex = -1;
//    int reverseIndex = -1;
//    int res = 0;
//    while (currIndex > x && currIndex * 10 > x) {
//      currIndex *= 10;
//    }
////    currIndex /= 10;
//    while (currIndex <= -1) {
//      if (res - (x / currIndex) * reverseIndex < -2147483647 - addOne) {
//        return 0;
//      }
//      res -= (x / currIndex) * reverseIndex;
//      currIndex /= 10;
//      reverseIndex *= 10;
//    }
//    return positive?-res:res;
  }
}



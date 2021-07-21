package amazonQuestion;

public class LongestPalindromixSubstring {
  String res = "";
  public String longestPalindrome(String s) {
    for (int i = 0; i < s.length(); i++) {
      longestSub(s, i, i);
      longestSub(s, i, i+1);
    }
    return res;
  }

  public void longestSub(String s, int leftIndex, int rightIndex) {
    if (leftIndex < 0 ||rightIndex >= s.length()) {
      return;
    }
    if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
      if (rightIndex - leftIndex >= res.length()) {
        res = s.substring(leftIndex, rightIndex + 1);
      }
      longestSub(s, leftIndex - 1, rightIndex + 1);
    }
  }
}

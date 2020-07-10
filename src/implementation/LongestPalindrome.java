package implementation;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindrome {
  public static String solution(String s) {
    int winLen = s.length();
    if (winLen < 1) {
      return s;
    }
    while (winLen > 1) {
      for (int i = 0; i <= s.length()-winLen; i++) {
        boolean sameFlag = true;
        for (int j = 0; j < winLen / 2; j++) {
          if (s.charAt(i + j) != s.charAt(i + winLen - j - 1)) {
            sameFlag = false;
            break;
          }
        }
        if (sameFlag) {
          return s.substring(i, i+winLen);
        }
      }
      winLen--;
    }
    return s.substring(0,1);
  }
}

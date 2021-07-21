package implementation;

public class ValidPalindrome {
  public static boolean validPalindrome(String s) {
    int leftIdx = 0;
    int rightIdx = s.length() - 1;

    while (leftIdx < rightIdx) {
      if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
        leftIdx++;
        rightIdx--;
      } else {
        return validPalindromeHelper(s.substring(leftIdx+1, rightIdx+1)) ||
                validPalindromeHelper(s.substring(leftIdx, rightIdx));
      }
    }
      return true;
  }

  public static boolean validPalindromeHelper(String s) {
    int leftIdx = 0;
    int rightIdx = s.length() - 1;
    while (leftIdx < rightIdx) {
      if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
        leftIdx++;
        rightIdx--;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String a = "TheoTheo";
    System.out.println(a.substring(0, 4));
//    validPalindrome("\"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
  }
}

// abcbcbca

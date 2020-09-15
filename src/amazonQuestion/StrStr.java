package amazonQuestion;

public class StrStr {
  public static int strStr(String haystack, String needle) {
    // String built-in function
//    return haystack.indexOf(needle);

    // Self solution
    if (needle.isEmpty()) {
      return 0;
    }

    int i = 0;
    while (i < haystack.length()) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        int j = 0;
        boolean same = true;
        while (j < needle.length() && same) {
          if (i+j >= haystack.length()) {
            same = false;
            break;
          }
          if (haystack.charAt(i+j) != needle.charAt(j)) {
            same = false;
          }
          j++;
        }
        if (same) {
          return i;
        } else {
          i++;
        }
      } else {
        i++;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(strStr("mississippi", "ll"));
  }
}

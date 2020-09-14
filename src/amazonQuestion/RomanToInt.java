package amazonQuestion;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */
public class RomanToInt {
  public static int romanToInt(String s) {
    int res = 0;
    int i = 0;
    while (i < s.length()) {
      if (s.charAt(i) == 'M') {
        res += 1000;
        i++;
      } else if (s.charAt(i) == 'D') {
        res += 500;
        i++;
      } else if (s.charAt(i) == 'C') {
        if (i+1 < s.length()) {
          if (s.charAt(i+1) == 'D') {
            res += 400;
            i += 2;
          } else if (s.charAt(i+1) == 'M') {
            res += 900;
            i += 2;
          } else {
            res += 100;
            i++;
          }
        } else {
          res += 100;
          i++;
        }
      } else if (s.charAt(i) == 'L') {
        res += 50;
        i++;
      } else if (s.charAt(i) == 'X') {
        if (i+1 < s.length()) {
          if (s.charAt(i+1) == 'L') {
            res += 40;
            i += 2;
          } else if (s.charAt(i+1) == 'C') {
            res += 90;
            i += 2;
          } else {
            res += 10;
            i++;
          }
        } else {
          res += 10;
          i++;
        }
      } else if (s.charAt(i) == 'V') {
        res += 5;
        i++;
      } else if (s.charAt(i) == 'I') {
        if (i+1 < s.length()) {
          if (s.charAt(i+1) == 'V') {
            res += 4;
            i += 2;
          } else if (s.charAt(i+1) == 'X') {
            res += 9;
            i += 2;
          } else {
            res += 1;
            i++;
          }
        } else {
          res += 1;
          i++;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("MMCDXXV"));
  }
}

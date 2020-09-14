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
 */
public class IntToRoman {
  public static String intToRoman(int num) {
    StringBuilder res = new StringBuilder();
    res.append("M".repeat(Math.max(0, num / 1000)));
    num %= 1000;

    if (num >= 900) {
      res.append("CM");
      num -= 900;
    } else if (num >= 500) {
      res.append("D");
      num -= 500;
    }
    if (num >= 400) {
      res.append("CD");
      num -= 400;
    }
    res.append("C".repeat(Math.max(0, num / 100)));
    num %= 100;

    if (num >= 90) {
      res.append("XC");
      num -= 90;
    } else if (num >= 50) {
      res.append("L");
      num -= 50;
    }
    if (num >= 40) {
      res.append("XL");
      num -= 40;
    }
    res.append("X".repeat(Math.max(0, num/10)));
    num %= 10;

    if (num >= 9) {
      res.append("IX");
      num -= 9;
    } else if (num >= 5) {
      res.append("V");
      num -= 5;
    }

    if (num == 4) {
      res.append("IV");
      num -= 4;
    }
    res.append("I".repeat(num));


    return res.toString();
  }

  public static void main(String[] args) {
//    System.out.println(2001/1000);
    System.out.println(intToRoman(1994));
  }
}

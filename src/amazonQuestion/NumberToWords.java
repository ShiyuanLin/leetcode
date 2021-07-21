package amazonQuestion;

public class NumberToWords {
  public String one(int num) {
    return switch (num) {
      case 1 -> "One";
      case 2 -> "Two";
      case 3 -> "Three";
      case 4 -> "Four";
      case 5 -> "Five";
      case 6 -> "Six";
      case 7 -> "Seven";
      case 8 -> "Eight";
      case 9 -> "Nine";
      default -> "";
    };
  }

  public String ten(int num) {
    return switch (num) {
      case 10 -> "Ten";
      case 11 -> "Eleven";
      case 12 -> "Twelve";
      case 13 -> "Thirteen";
      case 14 -> "Fourteen";
      case 15 -> "Fifteen";
      case 16 -> "Sixteen";
      case 17 -> "Seventeen";
      case 18 -> "Eighteen";
      case 19 -> "Nineteen";
      default -> "";
    };
  }

  public String tens(int num) {
    return switch (num) {
      case 2 -> "Twenty";
      case 3 -> "Thirty";
      case 4 -> "Forty";
      case 5 -> "Fifty";
      case 6 -> "Sixty";
      case 7 -> "Seventy";
      case 8 -> "Eighty";
      case 9 -> "Ninety";
      default -> "";
    };
  }

  public String three(int num) {
    String res = "";
    if (num / 100 >= 1) {
      res += one(num/100) + " Hundred ";
    }
    num %= 100;
    if (num / 10 > 1) {
      res += tens(num/10) ;
      num %= 10;
    }
    if (num / 10 == 1) {
      res += ten(num);
    } else {
      res += one(num);
    }
    return res;
  }



  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    String res = "";
    String temp = "";
    int oneThousand = 1000;
    int oneMillion = oneThousand * 1000;
    int oneBillion = oneMillion * 1000;

    if (num >= oneBillion) {
      res += three(num/oneBillion);
      res += " Billion ";
    }
    num %= oneBillion;
    if (num >= oneMillion) {
      temp = three(num/oneMillion);
      if (!temp.equals("")) {
        res += temp.strip() + " Million ";
      }
    }
    num %= oneMillion;
    if (num >= oneThousand) {
      temp = three(num/oneThousand);
      if (!temp.equals("")) {
        res += temp.strip() + " Thousand ";
      }
    }
    num %= oneThousand;
    res += three(num);
    return res.strip();
  }
}

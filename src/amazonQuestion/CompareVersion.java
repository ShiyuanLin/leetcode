package amazonQuestion;

public class CompareVersion {
  public static int compareVersion(String version1, String version2) {
    int idx1 = version1.indexOf(".");
    int idx2 = version2.indexOf(".");

    if (idx1 == -1) {
      idx1 = version1.length();
    }
    if (idx2 == -1) {
      idx2 = version2.length();
    }

    if (compareVersionHelper(version1.substring(0, idx1), version2.substring(0, idx2)) != 0) {
      return compareVersionHelper(version1.substring(0, idx1), version2.substring(0, idx2));
    } else {
      if (idx1 == version1.length() && idx2 == version2.length()) {
        return 0;
      }
      idx1++;
      idx2++;
      if (idx1 >= version1.length()) {
        return compareVersion("0", version2.substring(idx2, version2.length()));
      }
      if (idx2 >= version2.length()) {
        return compareVersion(version1.substring(idx1, version1.length()), "0");
      }
      return compareVersion(version1.substring(idx1, version1.length()),
              version2.substring(idx2, version2.length()));

    }

//    if (compareVersionHelper(version1.substring(0, idx1), version2.substring(0, idx2)) != 0) {
//      return compareVersionHelper(version1.substring(0, idx1), version2.substring(0, idx2));
//    } else {
//      idx1++;
//      idx2++;
//      int idx12 = version1.indexOf(".", idx1);
//      int idx22 = version2.indexOf(".", idx2);
//      while (idx12 != -1 && idx22 != -1) {
//        if (compareVersionHelper(version1.substring(idx1, idx12), version2.substring(idx2, idx22)) != 0) {
//          return compareVersionHelper(version1.substring(idx1, idx12), version2.substring(idx2, idx22));
//        }
//        idx1 = idx12 + 1;
//        idx2 = idx22 + 1;
//        idx12 = version1.indexOf(".", idx1);
//        idx22 = version2.indexOf(".", idx2);
//      }
//      if (idx12 == -1 && idx22 == -1) {
//        if (compareVersionHelper(version1.substring(idx1, version1.length()), version2.substring(idx2, version2.length())) != 0) {
//          return compareVersionHelper(version1.substring(idx1, idx12), version2.substring(idx2, idx22));
//        }
//        return 0;
//      }
//      if (idx12 == -1) {
//        while (idx22 != -1) {
//          if (Integer.parseInt(version2.substring(idx2, idx22)) > 0) {
//            return -1;
//          }
//          idx2 = idx22 + 1;
//          idx22 = version2.indexOf(".", idx2);
//        }
//      }
//      while (idx12 != -1) {
//        if (Integer.parseInt(version1.substring(idx1, idx12)) > 0) {
//          return 1;
//        }
//        idx1 = idx12 + 1;
//        idx12 = version1.indexOf(".", idx1);
//      }
//    }
//    return 0;
  }

  public static int compareVersionHelper(String version1, String version2) {
    if (Integer.parseInt(version1) > Integer.parseInt(version2)) {
      return 1;
    } else if (Integer.parseInt(version1) < Integer.parseInt(version2)) {
      return -1;
    }
    return 0;
  }

  public static void main(String[] args) {
//    String ver1 = "1.0.1";
    System.out.println(compareVersion("1.0.1", "1")); // 1
    System.out.println(compareVersion("1.01", "1.001")); // 0
    System.out.println(compareVersion("1.0", "1.0.0")); // 0
    System.out.println(compareVersion("0.1", "1.1")); // -1
    System.out.println(compareVersion("7.5.2.4", "7.5.3")); // -1
    System.out.println(compareVersion("5", "4")); //1
  }
}

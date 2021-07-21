package amazonQuestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {
  class LetterComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      int res = o1.substring(o1.indexOf(" "), o1.length()).compareTo(o2.substring(o2.indexOf(" "), o2.length()));
      if (res == 0) {
        return o1.compareTo(o2);
      } else {
        return res;
      }
    }
  }

  public String[] reorderLogFiles(String[] logs) {
    List<String> letLogs = new ArrayList<>();
    List<String> digLogs = new ArrayList<>();

    for (String log : logs) {
      if (Character.isDigit(log.charAt(log.indexOf(" ")+1))) {
        digLogs.add(log);
      } else {
        letLogs.add(log);
      }
    }

    letLogs.sort(new LetterComparator());

    letLogs.addAll(digLogs);
    return letLogs.toArray(new String[] {});
  }
}

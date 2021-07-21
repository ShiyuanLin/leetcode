package amazonOA;

import java.util.*;

public class ProcessLogFile {
  public static String[] processLogFile(String[] logs, int threshold) {
    Map<String, Integer> dict = new HashMap<>();
    for (String log: logs) {
      String[] element = log.split("\\s+");
      for (int i = 0; i < 2; i++) {
        if (i == 0 || !element[i].equals(element[i - 1])) {
          dict.put(element[i], dict.getOrDefault(element[i], 0) + 1);
        }
      }
    }
    List<String> res = new ArrayList<>();
    for (String id: dict.keySet()) {
      if (dict.get(id) >= threshold) {
        res.add(String.valueOf(id));
      }
    }
    res.sort((a, b) -> (Integer.compare(Integer.parseInt(a), Integer.parseInt(b))));
    String[] resArray = new String[res.size()];
    res.toArray(resArray);
    return resArray;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(processLogFile(new String[]{"88 99 200", "88 99 300", "99 32 100", "12 12 15"}, 2)));
  }
}

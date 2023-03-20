package amazonOA;

import java.util.ArrayList;
import java.util.List;

public class ZombieMatrix {
  public int humanDays(int[][] matrix) {
//    Set<Integer> idexes = new HashSet<>();
    // O(day * XY)
    List<Integer> xCoord = new ArrayList<>();
    List<Integer> yCoord = new ArrayList<>();

    int Y = matrix.length;
    int X = matrix[0].length;

    int day = 0;

    while (xCoord.size() < Y * X) {
      xCoord.clear();
      yCoord.clear();
      for (int y = 0; y < Y; y++) {
        for (int x = 0; x <X; x++) {
          if (matrix[y][x] == 1) {
            xCoord.add(x);
            yCoord.add(y);
          }
        }
      }
      if (xCoord.size() == 0) {
        return -1;
      } else if (xCoord.size() == Y * X) {
        return day;
      }
      for (int i = 0; i < xCoord.size(); i++) {
        matrix[Math.max(0, yCoord.get(i)-1)][xCoord.get(i)] = 1;
        matrix[Math.min(Y-1, yCoord.get(i)+1)][xCoord.get(i)] = 1;
        matrix[yCoord.get(i)][Math.max(0, xCoord.get(i)-1)] = 1;
        matrix[yCoord.get(i)][Math.min(X-1, xCoord.get(i)+1)] = 1;
      }
      day++;
    }
    return day;
  }
}

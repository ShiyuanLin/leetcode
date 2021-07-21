package amazonQuestion;

import java.util.HashMap;
import java.util.Map;

public class TicTacToe {

  int size;
  Map<Integer, Integer> rows;
  Map<Integer, Integer> cols;
  Map<Integer, Integer> rowCount;
  Map<Integer, Integer> colCount;

  int topLeft_bottomRight;
  int bottomLeft_topRight;
  int topLeft_bottomRightCount;
  int bottomLeft_topRightCount;

  public TicTacToe(int n) {
    this.size = n;
    this.rows = new HashMap<>();
    this.cols = new HashMap<>();
    this.rowCount = new HashMap<>();
    this.colCount = new HashMap<>();

    for (int i = 0; i < n; i++) {
      rows.put(i, 0);
      cols.put(i, 0);
      rowCount.put(i, 0);
      colCount.put(i, 0);
    }

    this.topLeft_bottomRight = 0;
    this.bottomLeft_topRight = 0;
    // Count diagonal elements
    this.topLeft_bottomRightCount = 0;
    this.bottomLeft_topRightCount = 0;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {
    if (row == col) {
      if (topLeft_bottomRight == player || topLeft_bottomRight == 0) {
        topLeft_bottomRight = player;
        topLeft_bottomRightCount++;
        if (topLeft_bottomRightCount == this.size) {
          return player;
        }
      }
    }
    if (row == size - 1 - col)  {
      if (bottomLeft_topRight == player || bottomLeft_topRight == 0) {
        bottomLeft_topRight = player;
        bottomLeft_topRightCount++;
        if (bottomLeft_topRightCount == this.size) {
          return player;
        }
      }
    }
    if (updateData(row, player, rows, rowCount)) return player;
    if (updateData(col, player, cols, colCount)) return player;
    return 0;
  }

  private boolean updateData(int idx, int player, Map<Integer, Integer> elements, Map<Integer, Integer> elementCount) {
    if (elements.get(idx) == player || elements.get(idx) == 0) {
      elements.put(idx, player);
      elementCount.put(idx, elementCount.get(idx) + 1);
      return elementCount.get(idx) == this.size;
    }
    return false;
  }
}

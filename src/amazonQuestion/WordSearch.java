package amazonQuestion;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    if (word.length() == 0) {
      return true;
    }

    int startIndex =0;

    while (startIndex < board.length * board[0].length) {
      int startX = startIndex % board[0].length;
      int startY = startIndex / board[0].length;
      if (board[startY][startX] == word.charAt(0)) {
        if (nextStep(board, word.substring(1), new HashSet<>(Collections.singletonList(startIndex)), startIndex)) {
          return true;
        }
      }
      startIndex++;
    }
    return false;
  }

  public boolean nextStep(char[][] board, String word, Set<Integer> went, Integer curr) {
    if (word.length() == 0) {
      return true;
    }

    int currX = curr % board[0].length;
    int currY = curr / board[0].length;
    boolean isSuccess = false;
    Integer nextIndex;
    Set<Integer> newWent;

    if (currX > 0) {
      nextIndex = (currX-1) + currY * board[0].length;
      if (word.charAt(0) == board[currY][currX-1] && !went.contains(nextIndex)) {
        newWent = new HashSet<>(went);
        newWent.add(nextIndex);
        isSuccess = nextStep(board, word.substring(1), newWent, nextIndex);
      }
    }
    if (currX < board[0].length - 1) {
      nextIndex = (currX+1) + currY * board[0].length;
      if (word.charAt(0) == board[currY][currX+1] && !went.contains(nextIndex)) {
        newWent = new HashSet<>(went);
        newWent.add(nextIndex);
        isSuccess = isSuccess || nextStep(board, word.substring(1), newWent, nextIndex);
      }
    }
    if (currY > 0) {
      nextIndex = currX + (currY-1) * board[0].length;
      if (word.charAt(0) == board[currY-1][currX] && !went.contains(nextIndex)) {
        newWent = new HashSet<>(went);
        newWent.add(nextIndex);
        isSuccess = isSuccess || nextStep(board, word.substring(1), newWent, nextIndex);
      }
    }
    if (currY < board.length - 1) {
      nextIndex = currX + (currY + 1) * board[0].length;
      if (word.charAt(0) == board[currY+1][currX] && !went.contains(nextIndex)) {
        newWent = new HashSet<>(went);
        newWent.add(nextIndex);
        isSuccess = isSuccess || nextStep(board, word.substring(1), newWent, nextIndex);
      }
    }
    return isSuccess;
  }
}

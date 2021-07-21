package amazonQuestion;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
  char[][] board;
  String[] words;
  Integer boardX;
  Integer boardY;
  List<String> res;

  public List<String> findWords(char[][] board, String[] words) {
    this.board = board;
    this.words = words;
    this.boardX = board[0].length;
    this.boardY = board.length;

    res = new ArrayList<>();
    if (words.length == 0) {
      return res;
    }

    List<Integer> status = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      status.add(0);
    }
    for (int x = 0; x < this.boardX; x++) {
      for (int y = 0; y < this.boardY; y++) {
        dfsWords(x, y, new ArrayList<>(status));
      }
    }

    return this.res;
  }

  public void dfsWords(int x, int y, List<Integer> status) {
    // Check if Status statisfy all the words length
    List<String> currRes = new ArrayList<>();
    for (int i = 0; i < status.size(); i++) {
      if (status.get(i) >= this.words[i].length()) {
        currRes.add(this.words[i]);
      }
    }
    if (currRes.size() > this.res.size()) {
      this.res = currRes;
    }
    if (this.res.size() == this.words.length) {
      return;
    }

    if (x < 0 || x >= this.boardX || y < 0 || y >= this.boardY || this.board[y][x] == '#') {
      return;
    }

    List<Integer> newStatus = new ArrayList<>(status);

    char currChar = this.board[y][x];
    for (int i = 0; i < words.length; i++) {
      if (status.get(i) < words[i].length()) {
        if (currChar == words[i].charAt(status.get(i))) {
          newStatus.set(i, newStatus.get(i) + 1);
          this.board[y][x] = '#';
        }
      }
    }
    if (this.board[y][x] == '#') {
      int[] xDirection = {0, 1, 0, -1};
      int[] yDirection = {1, 0, -1, 0};
      for (int d = 0; d < xDirection.length; d++) {
        dfsWords(x+xDirection[d], y+yDirection[d], new ArrayList<>(newStatus));
      }
    }
    this.board[y][x] = currChar;
  }
}

//    for (int i = 0; i < words.length; i++) {
//      if (status.get(i) < words[i].length()) {
//        if (this.board[y][x] == words[i].charAt(status.get(i))) {
//          int[] xDirection = {0, 1, 0, -1};
//          int[] yDirection = {1, 0, -1, 0};
//          newStatus = new ArrayList<>(status);
//          newStatus.set(i, newStatus.get(i)+1);
//          this.board[y][x] = '#';
//          for (int d = 0; d < xDirection.length; d++) {
//            dfsWords(x+xDirection[d], y+yDirection[d], new ArrayList<>(newStatus));
//          }
//          this.board[y][x] = words[i].charAt(status.get(i));
//        }
//      }
//    }
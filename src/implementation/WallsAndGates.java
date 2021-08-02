package implementation;

//https://leetcode.com/problems/walls-and-gates/
public class WallsAndGates {
  int[][] rooms;
  public void wallsAndGates(int[][] rooms) {
    this.rooms = rooms;
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (rooms[i][j] == 0) {
          dfs(i, j);
        }
      }
    }
  }

  void dfs(int i, int j) {
    int[] xs = new int[] {-1, 0, 1, 0};
    int[] ys = new int[] {0, -1, 0, 1};

    for (int k = 0; k < xs.length; k++) {
      int x = i + xs[k];
      int y = j + ys[k];
      if (x >= 0 && y >= 0 && x < this.rooms.length && y < this.rooms[x].length &&
              this.rooms[x][y] > this.rooms[i][j] + 1) {
        this.rooms[x][y] = this.rooms[i][j] + 1;
        dfs(x, y);
      }
    }
  }
}

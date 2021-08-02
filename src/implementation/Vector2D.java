package implementation;

public class Vector2D {
  int x;
  int y;
  boolean hasNext;
  int[][] vec;
  public Vector2D(int[][] vec) {
    this.vec = vec;
    this.hasNext = true;
    this.y = 0;
    if (vec.length == 0) {
      this.hasNext = false;
    } else {
      this.x = 0;
      nextX();
    }
  }

  public int next() {
    int val = this.vec[this.x][this.y];
    if (this.y == this.vec[x].length - 1) {
      this.x++;
      nextX();
      this.y = 0;
    } else {
      this.y++;
    }
    return val;
  }

  public boolean hasNext() {
    return hasNext;
  }

  private void nextX() {
    while (x < this.vec.length && this.vec[x].length == 0) {
      x++;
    }
    if (x == this.vec.length) {
      this.hasNext = false;
    }
  }
}

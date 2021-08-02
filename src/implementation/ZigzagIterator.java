package implementation;

import java.util.List;

//https://leetcode.com/problems/zigzag-iterator/
public class ZigzagIterator {
  List<Integer> v1;
  List<Integer> v2;
  boolean isFirst;
  int i1;
  int i2;
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    this.v1 = v1;
    this.v2 = v2;
    i1 = 0;
    i2 = 0;
    isFirst = true;
    if (v1.size() == 0) {
      isFirst = false;
      i1 = -1;
    }
    if (v2.size() == 0) {
      i2 = -1;
    }

  }

  public int next() {
    int res = 0;
    if (this.isFirst) {
      res = this.v1.get(this.i1);
      this.isFirst = this.i2 == -1;
      this.i1++;
      if (this.i1 == this.v1.size()) this.i1 = -1;
    } else {
      res = this.v2.get(this.i2);
      this.isFirst = this.i1 != -1;
      this.i2++;
      if (this.i2 == this.v2.size()) this.i2 = -1;
    }
    return res;
  }

  public boolean hasNext() {
    return this.i1 != -1 || this.i2 != -1;
  }
}


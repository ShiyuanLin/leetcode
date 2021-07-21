package implementation;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

  List<Integer> record;

  public ProductOfNumbers() {
    record = new ArrayList<>();
    record.add(1);
  }

  public void add(int num) {
    if (num == 0) {
      record.clear();
      record.add(1);
    } else {
      record.add(record.get(record.size()-1) * num);
    }
  }

  public int getProduct(int k) {
    if (k > record.size()-1) {
      return 0;
    }
    int start = record.size() - k;
    return record.get(record.size() - 1) / record.get(start-1);
  }
}

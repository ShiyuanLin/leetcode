package implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HighFive {
  public int[][] highFive(int[][] items) {

    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

    for(int[] i: items){
      // Max heap
      PriorityQueue<Integer> p = map.getOrDefault(i[0],
              new PriorityQueue<Integer>((x, y)->y-x));
      p.add(i[1]);
      map.put(i[0], p);
    }

    // System.out.println(map);
    int[][] res = new int[map.size()][2]; int index = 0;
    for(HashMap.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()){
      res[index][0] = e.getKey();
      res[index++][1] = avg(map.get(e.getKey()));
    }

    Arrays.sort(res, (x, y)->x[0] - y[0]);
    return res;
  }

  int avg(PriorityQueue<Integer> pq){
    int sum = 0, k = 5;
    while(k-->0) sum+=pq.remove();
    return sum/5;
  }
}

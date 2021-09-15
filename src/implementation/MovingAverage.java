package implementation;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    /** Initialize your data structure here. */
    int count;
    Queue<Integer> window;
    int size;
    int currTotal;
    public MovingAverage(int size) {
        this.window = new LinkedList<>();
        this.count = 0;
        this.size = size;
        this.currTotal = 0;
    }

    public double next(int val) {
        if (this.count < this.size) {
            this.count++;
        } else {
            this.currTotal -= this.window.poll();
        }
        this.currTotal += val;
        this.window.add(val);

        return (double) this.currTotal / this.count;
    }
}

package implementation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int width;
    int height;
    int currPos;
    int[][] food;
    int foodIdx;
    Set<Integer> posSet;
    Queue<Integer> posSeq;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIdx = 0;
        this.currPos = 0;
        this.posSet = new HashSet<> ();
        this.posSeq = new LinkedList<> ();
        this.posSet.add(this.currPos);
        this.posSeq.add(this.currPos);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int currHeight = currPos / this.width;
        int currWidth = currPos % this.width;

        switch (direction) {
            case "U" -> currHeight--;
            case "L" -> currWidth--;
            case "R" -> currWidth++;
            case "D" -> currHeight++;
        }

        if (currHeight >= this.height || currHeight < 0 ||
            currWidth >= this.width || currWidth < 0) {
            return -1;
        }

        int newPos = currHeight * this.width + currWidth;

        if (this.foodIdx < this.food.length && currHeight == this.food[this.foodIdx][0] &&
            currWidth == this.food[this.foodIdx][1]) {
            this.foodIdx++;
        } else {
            int tail = this.posSeq.poll();
            this.posSet.remove(tail);
        }
        if (posSet.contains(newPos)) {
            return -1;
        }
        this.posSet.add(newPos);
        this.posSeq.add(newPos);
        this.currPos = newPos;
        return foodIdx;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

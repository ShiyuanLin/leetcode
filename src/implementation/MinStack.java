package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

  /**
   * My original solution was keeping two array list
   * The second array was supposed to keep track of the minimum element
   * I wanted this array to be sorted and every time I need to find an element and then delete it
   * Clearly, this solution doesn't have O(1) running time
   * It was O(c) where c is the current element in the list.
   *
   * Then I updated the solution inspired by the Youtube video.
   * The idea is that
   *
   */
  Stack<Integer> stack;
  Stack<Integer> sorted;
  public MinStack() {
    stack = new Stack<>();
    sorted = new Stack<> ();
  }

  public void push(int x) {
    stack.push(x);
    if (sorted.isEmpty() || x <= sorted.peek()) {
      sorted.add(x);
    }
  }

  public void pop() {
    if (stack.peek().equals(sorted.peek())) {
      sorted.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return sorted.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
  }
}

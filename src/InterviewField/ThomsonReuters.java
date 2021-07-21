package InterviewField;

import javafx.util.Pair;

import java.util.*;

public class ThomsonReuters {

  // https://leetcode.com/problems/word-search-ii/
  class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode () {}
  }

  List<String> found;
  public List<String> findWords(char[][] board, String[] words) {
    found = new ArrayList<>();
    TrieNode root = new TrieNode();
//    found.sort((a, b)-> Integer.compare(a.length(), b.length()));
//    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    for (String word: words) {
      TrieNode node = root;

      for (Character c: word.toCharArray()) {
        if (node.children.containsKey(c)) {
          node = node.children.get(c);
        } else {
          node.children.put(c, new TrieNode());
          node = node.children.get(c);
        }
      }
      node.word = word;
    }

    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[0].length; y++) {
        if (root.children.containsKey(board[x][y])) {
          backtracking(root.children.get(board[x][y]), x, y, board);
        }
      }
    }
    return found;
  }

  public void backtracking(TrieNode root, int x, int y, char[][] board) {
    if (root.word != null && !found.contains(root.word)) {
      found.add(root.word);
    }

    if (root.children.isEmpty()) {
      return;
    }

    Character originChar = board[x][y];
    board[x][y] = '#';
    int[] xDirections = {-1, 0, 1, 0};
    int[] yDirections = {0, -1, 0, 1};

    for (int i = 0; i < 4; i++) {
      int newX = x + xDirections[i];
      int newY = y + yDirections[i];

      if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length) {
        continue;
      }

      if (root.children.containsKey(board[newX][newY])) {
        backtracking(root.children.get(board[newX][newY]), newX, newY, board);
      }
    }
    board[x][y] = originChar;
  }
  // ============== word-search-ii END ==========================

  // https://leetcode.com/problems/word-search/
  boolean isExist;
  public boolean exist(char[][] board, String word) {
    if (word.length() == 0) {
      return true;
    }
    isExist = false;

    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[0].length; y++) {
        if (board[x][y] == word.charAt(0)) {
          backtrackingExist(board, x, y, word.substring(1));
        }
        if (isExist) {
          return isExist;
        }
      }
    }
    return isExist;
  }

  void backtrackingExist(char[][] board, int x, int y, String word) {
    if (word.length() == 0 || isExist) {
      isExist = true;
      return;
    }

    Character originChar = board[x][y];
    board[x][y] = '#';

    int[] xDirections = {-1, 0, 1, 0};
    int[] yDirections = {0, -1, 0, 1};

    for (int i = 0; i < 4; i++) {
      int newX = x + xDirections[i];
      int newY = y + yDirections[i];

      if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length) {
        continue;
      }

      if (board[newX][newY] == word.charAt(0)) {
        backtrackingExist(board, newX, newY, word.substring(1));
      }
    }
    board[x][y] = originChar;
  }

  // ============= word search END =============================================

  // balance bracket
  public static String isBalanced(String s) {
    // Write your code here
    Pair<Integer,Integer> test = new Pair<>(1, 2);
    String yes = "YES";
    String no = "NO";
    Stack<Character> stack = new Stack<>();
    for (Character c: s.toCharArray()) {
      if (c == '{' || c == '(' || c == '[') {
        stack.push(c);
      }

      if (c == '}' || c == ')' || c == ']') {
        if (stack.size() == 0) {
          return no;
        }
        Character prev = stack.peek();
        char match;
        switch (c) {
          case '}':
            match = '{';
            break;
          case ')':
            match = '(';
            break;
          case ']':
            match = '[';
            break;
          default : match = ' ';
        }
        if (prev == match ) {
          stack.pop();
        } else {
          return no;
        }
      }
    }
    if (stack.size() == 0) {
      return yes;
    } else {
      return no;
    }
  }
  // ============== balance bracket END =============================

  //
  public static long getTime(String s) {
    long result = 0;
    for (int i = 1; i < s.length(); i++) {
      int dist1 = Math.abs( (int) s.charAt(i) - (int) s.charAt(i-1));
      int dist2 = Math.abs( (int) 'z' - (int) s.charAt(i)) + Math.abs( (int) 'z' - (int) s.charAt(i-1));
      result += Math.min(dist1, dist2);
    }
    return result;
  }

  public static char toLowerCase(char c) {
    int num = (int) c;
//    System.out.println(num);
    num = num & 0b11011111;
//    System.out.println(0b00100000);
//    System.out.println(num);
    return (char) num;
  }

  public static void main(String[] args) {
  //  System.out.println((int)'Z'-(int)'A');
//    isBalanced("{[()]}");
//    String s = "hello";
//    s.startsWith("e");
    System.out.println(toLowerCase('a'));
    System.out.println(toLowerCase('.'));
    System.out.println(toLowerCase('#'));
    System.out.println(toLowerCase('}'));
  }
}

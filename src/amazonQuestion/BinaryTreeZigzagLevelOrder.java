package amazonQuestion;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrder {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    boolean reverse = false;

    List<TreeNode> currLevel = new ArrayList<>();
    currLevel.add(root);

    while (!currLevel.isEmpty()) {
      List<TreeNode> nextLevel = new ArrayList<>();
      List<Integer> currLevelInteger = new ArrayList<>();
      for (TreeNode element: currLevel) {
        currLevelInteger.add(element.val);
        if (element.left != null) {
          nextLevel.add(element.left);
        }
        if (element.right != null) {
          nextLevel.add(element.right);
        }
      }
      currLevel = nextLevel;
      if (reverse) {
        for (int i = 1; i < currLevelInteger.size(); i++) {
          currLevelInteger.add(0, currLevelInteger.get(i));
          currLevelInteger.remove(i+1);
        }
      }
      reverse = !reverse;
      res.add(currLevelInteger);
    }
    return res;
  }
}

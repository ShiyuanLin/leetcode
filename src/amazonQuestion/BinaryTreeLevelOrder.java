package amazonQuestion;

import model.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

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
      res.add(currLevelInteger);
    }
    return res;
  }
}

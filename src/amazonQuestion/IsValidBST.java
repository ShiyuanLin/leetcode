package amazonQuestion;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    List<Integer> elements = new ArrayList<>();

    if (root.left != null) {
      elements.addAll(treeNodeToArray(root.left));
    }
    elements.add(root.val);
    if (root.right != null) {
      elements.addAll(treeNodeToArray(root.right));
    }

    for (int i = 1; i < elements.size(); i++) {
      if (elements.get(i) <= elements.get(i-1)) {
        return false;
      }
    }
    return true;
  }

  public List<Integer> treeNodeToArray(TreeNode root) {
    List<Integer> elements = new ArrayList<>();

    if (root.left != null) {
      elements.addAll(treeNodeToArray(root.left));
    }

    elements.add(root.val);

    if (root.right != null) {
      elements.addAll(treeNodeToArray(root.right));
    }
    return elements;
  }

// ============ Second way and its helper function ==============
//  public boolean isValidBST(TreeNode root) {
//    return isValidBSTSub(root, null, null);
//  }

  public boolean isValidBSTSub(TreeNode root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }

    if ((min != null && root.val <= min) ||
            (max != null && root.val >= max)) {
      return false;
    }
    return isValidBSTSub(root.left, min, root.val) && isValidBSTSub(root.right, root.val, max);
  }
}

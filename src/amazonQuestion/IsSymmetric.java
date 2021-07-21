package amazonQuestion;

import model.TreeNode;

public class IsSymmetric {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetricSub(root.left, root.right);
  }

  public boolean isSymmetricSub(TreeNode leftNode, TreeNode rightNode) {
    if (leftNode != null && rightNode != null) {
      if (leftNode.val != rightNode.val) {
        return false;
      } else {
        return isSymmetricSub(leftNode.left, rightNode.right) && isSymmetricSub(leftNode.right, rightNode.left);
      }
    } else {
      return leftNode == null && rightNode == null;
    }
  }
}

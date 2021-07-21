package amazonQuestion;

import model.TreeNode;

public class DiameterOfBinaryTree {
  int max_length = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int res = sumlength(root);
    return max_length;
  }

  public int sumlength(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftdepth = sumlength(root.left);
    int rightdepth = sumlength(root.right);

    max_length = Math.max(leftdepth+rightdepth, max_length);

    return Math.max(leftdepth, rightdepth) + 1;
  }
}

package amazonQuestion;

import model.TreeNode;

public class MaxPathSum {
  int maxValue;
  public int maxPathSum(TreeNode root) {
    maxValue = Integer.MIN_VALUE;
    maxPathSumSub(root);
    return maxValue;
  }

  public int maxPathSumSub(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftMax = Math.max(maxPathSumSub(root.left), 0); // 0
    int rightMax = Math.max(maxPathSumSub(root.right), 0); // 0

    maxValue = Math.max(leftMax + rightMax + root.val, maxValue);

    return Math.max(leftMax, rightMax) + root.val;
  }
}

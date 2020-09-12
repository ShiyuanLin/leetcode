package implementation;

import model.TreeNode;

public class MaxPathSum {
  int max_path_sum;
  public int solution(TreeNode root) {
    max_path_sum = Integer.MIN_VALUE;
    pathSum(root);
    return max_path_sum;
  }

  public int pathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left_sum = Math.max(pathSum(root.left), 0);
    int right_sum = Math.max(pathSum(root.right), 0);

    max_path_sum = Math.max(max_path_sum, left_sum + right_sum + root.val);
    return Math.max(left_sum, right_sum) + root.val;
  }
}

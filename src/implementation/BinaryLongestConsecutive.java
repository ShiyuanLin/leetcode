package implementation;

import model.TreeNode;

public class BinaryLongestConsecutive {
  int maxDepth;
  public int longestConsecutive(TreeNode root) {
    maxDepth = 0;
    traverse(root, root.val - 1, 0);
    return maxDepth;
  }

  public void traverse(TreeNode root, int previous, int count) {
    if (root == null) {
      return;
    }

    if (root.val == previous + 1) {
      maxDepth = Math.max(maxDepth, count + 1);
    }

    if (root.left != null) {
      if (root.left.val == root.val + 1) {
        traverse(root.left, root.val, count + 1);
      } else {
        traverse(root.left, root.left.val - 1, 0);
      }
    }

    if (root.right != null) {
      if (root.right.val == root.val + 1) {
        traverse(root.right, root.val, count + 1);
      } else {
        traverse(root.right, root.right.val - 1, 0);
      }
    }
  }
}

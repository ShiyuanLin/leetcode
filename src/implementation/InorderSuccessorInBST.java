package implementation;

import model.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/inorder-successor-in-bst/
public class InorderSuccessorInBST {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode currentMin = null;
    TreeNode current = root;
    while (current != null) {
      if (current.val > p.val) {
        if (currentMin == null || currentMin.val > current.val) {
          currentMin = current;
        }
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return currentMin;
  }
}

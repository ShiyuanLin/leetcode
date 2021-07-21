package amazonOA;

public class MaximumAverageSubtree {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  double curMax;
  public double maximumAverageSubtree(TreeNode root) {
    curMax = Double.MIN_VALUE;
    maxAvgSubRecur(root);
    return curMax;
  }

  public int[] maxAvgSubRecur(TreeNode root) {
    int[] leftSub, rightSub;
    if (root == null) {
      return new int[] {0,0};
    }
    leftSub = maxAvgSubRecur(root.left);
    rightSub = maxAvgSubRecur(root.right);
    int[] currLevel = new int[2];
    currLevel[1] = leftSub[1] + rightSub[1] + 1;
    currLevel[0] = leftSub[0] + rightSub[0] + root.val;
    curMax = Math.max(currLevel[0]*1.0/currLevel[1], curMax);
    return currLevel;
  }
}

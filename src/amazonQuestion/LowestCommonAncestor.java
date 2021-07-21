package amazonQuestion;

import com.sun.source.tree.Tree;
import model.TreeNode;

import java.util.*;

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> stack = new ArrayList<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    parent.put(root, null);
    stack.add(root);
    while (!parent.containsKey(p) || !parent.containsKey(q)) {
      TreeNode curr = stack.get(0);
      stack.remove(0);
      if (curr.right != null) {
        stack.add(0, curr.right);
        parent.put(curr.right, curr);
      }
      if (curr.left != null) {
        stack.add(0, curr.left);
        parent.put(curr.left, curr);
      }
    }

    // find common ancestors
    Set<TreeNode> pAncestors = new HashSet<>();
    TreeNode pAncestor = p;
    while (pAncestor != null) {
      pAncestors.add(pAncestor);
      pAncestor = parent.get(pAncestor);
    }

    TreeNode qAncestor = q;
    while (!pAncestors.contains(qAncestor)) {
      qAncestor = parent.get(qAncestor);
    }
    return qAncestor;
  }

}

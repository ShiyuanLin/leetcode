package implementation;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetAllElements {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> res1 = treeToList(root1);
    List<Integer> res2 = treeToList(root2);

    int i = 0;
    while (i < res1.size() && !res2.isEmpty()) {
      if (res2.get(0) < res1.get(i)) {
        res1.add(i, res2.get(0));
        res2.remove(0);
      } else {
        i++;
      }
    }
    res1.addAll(res2);

    // Lazy coding and slow run time
//    res1.addAll(res2);
//    Collections.sort(res1);
    return res1;
  }

  public static List<Integer> treeToList(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    if (root.left != null) {
      res.addAll(treeToList(root.left));
    }
    res.add(root.val);
    if (root.right != null) {
      res.addAll(treeToList(root.right));
    }
    return res;
  }
}

package implementation;

import javafx.util.Pair;
import model.TreeNode;

import java.util.*;

public class VerticalOrder {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    Map<Integer, List<Integer>> dict = new HashMap<>();
//    traverse(root, 0);
    Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
    queue.add(new Pair<>(0, root));
    while (!queue.isEmpty()) {
      Pair<Integer, TreeNode> currentPair = queue.poll();
      Integer verticalIdx = currentPair.getKey();
      TreeNode currentNode = currentPair.getValue();
      if (currentNode.left != null) {
        queue.add(new Pair<> (verticalIdx - 1, currentNode.left));
      }
      if (!dict.containsKey(verticalIdx)) dict.put(verticalIdx, new ArrayList<>());
      dict.get(verticalIdx).add(currentNode.val);
      if (currentNode.right != null) {
        queue.add(new Pair<>(verticalIdx + 1, currentNode.right));
      }
    }
    List<Integer> keys = new ArrayList<>(dict.keySet());
    keys.sort(Integer::compare);
    for (Integer key: keys) {
      result.add(dict.get(key));
    }
    return result;
  }

//  public void traverse(TreeNode root, int verticalIdx) {
//    if (root == null) {
//      return;
//    }
//    if (root.left != null) {
//      traverse(root.left, verticalIdx - 1);
//    }
//
//    if (!dict.containsKey(verticalIdx)) dict.put(verticalIdx, new ArrayList<>());
//    dict.get(verticalIdx).add(root.val);
//
//    if (root.right != null) {
//      traverse(root.right, verticalIdx + 1);
//    }
//  }
}

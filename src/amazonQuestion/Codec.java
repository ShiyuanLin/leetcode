package amazonQuestion;

import model.TreeNode;

public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    String res = "";
    if (root == null) {
      return res;
    } else {
      res += root.val + ",";
    }
    if (root.left == null) {
      res += "n,";
    } else {
      res += serialize(root.left);
    }

    if (root.right == null) {
      res += "n,";
    } else {
      res += serialize(root.right);
    }
    return res;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    TreeNode res;
    if (data.equals("")) {
      return null;
    } else {
      int index = data.indexOf(",");
      res = new TreeNode(Integer.parseInt(data.substring(0, index)));
      deserializeSub(res, data.substring(index+1));
    }
    return res;
  }

  public String deserializeSub(TreeNode prev, String data) {
    if (data.length() <= 1) {
      return "";
    }

    if (data.charAt(0) != 'n') {
      int index = data.indexOf(",");
      TreeNode newLeft = new TreeNode(Integer.parseInt(data.substring(0, index)));
      prev.left = newLeft;
      data = deserializeSub(newLeft, data.substring(index+1));
    } else {
      data = data.substring(2);
    }
    if (data.charAt(0) != 'n') {
      int index = data.indexOf(",");
      TreeNode newRight = new TreeNode(Integer.parseInt(data.substring(0, index)));
      prev.right = newRight;
      data = deserializeSub(newRight, data.substring(index+1));
    } else {
      data = data.substring(2);
    }
    return data;
  }
}

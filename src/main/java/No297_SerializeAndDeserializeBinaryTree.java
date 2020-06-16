import java.util.LinkedList;

public class No297_SerializeAndDeserializeBinaryTree {
//  Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//  Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//  Example: 
//
//  You may serialize the following tree:
//
//      1
//     / \
//    2   3
//       / \
//      4   5
//
//  as "[1,2,3,null,null,4,5]"
//
//  Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
//  Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No297_SerializeAndDeserializeBinaryTree test = new No297_SerializeAndDeserializeBinaryTree();

  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    LinkedList<TreeNode> li = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    if (root != null) {
      sb.append(root.val + ",");
      li.add(root);
    } else {
      return "";
    }

    TreeNode node;
    while (!li.isEmpty()) {
      node = li.pop();
      if (node.left != null) {
        sb.append(node.left.val + ",");
        li.add(node.left);
      } else {
        sb.append("null,");
      }
      if (node.right != null) {
        sb.append(node.right.val + ",");
        li.add(node.right);
      } else {
        sb.append("null,");
      }
    }
    return sb.substring(0, sb.length() - 1);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) {
      return null;
    }
    String[] a = data.split(",");
    TreeNode root = new TreeNode(Integer.valueOf(a[0]));
    if (a.length == 1) {
      return root;
    }
    LinkedList<TreeNode> li = new LinkedList<>();
    li.add(root);
    TreeNode node = root;
    for (int i = 1, j = 2; j < a.length; i = i + 2, j = j + 2) {
      node = li.pop();
      if ("null".equals(a[i])) {
        node.left = null;
      } else {
        node.left = new TreeNode(Integer.valueOf(a[i]));
        li.add(node.left);
      }
      if ("null".equals(a[j])) {
        node.right = null;
      } else {
        node.right = new TreeNode(Integer.valueOf(a[j]));
        li.add(node.right);
      }
    }
    return root;
  }

  // Your Codec object will be instantiated and called as such:
  // Codec codec = new Codec();
  // codec.deserialize(codec.serialize(root));
}
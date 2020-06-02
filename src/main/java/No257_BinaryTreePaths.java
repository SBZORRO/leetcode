import java.util.LinkedList;
import java.util.List;

public class No257_BinaryTreePaths {
//  Given a binary tree, return all root-to-leaf paths.
//
//      Note: A leaf is a node with no children.
//
//      Example:
//
//      Input:
//
//         1
//       /   \
//      2     3
//       \
//        5
//
//      Output: ["1->2->5", "1->3"]
//
//      Explanation: All root-to-leaf paths are: 1->2->5, 1->3
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/binary-tree-paths
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No257_BinaryTreePaths test = new No257_BinaryTreePaths();
  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  List<String> li = new LinkedList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }
    path(root, "");
    return li;
  }

  public void path(TreeNode root, String path) {
    path = path + root.val + "->";
    if (root.right == null && root.left == null) {
      li.add(path.substring(0, path.length() - 2));
      return;
    }
    if (root.right != null) {
      path(root.right, path);
    }
    if (root.left != null) {
      path(root.left, path);
    }
  }
}

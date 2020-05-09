class No111_MinimumDepthOfBinaryTree {
//  Given a binary tree, find its minimum depth.
//
//  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//  Note: A leaf is a node with no children.
//
//  Example:
//
//  Given binary tree [3,9,20,null,null,15,7],
//
//      3
//     / \
//    9  20
//      /  \
//     15   7
//
//  return its minimum depth = 2.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No111_MinimumDepthOfBinaryTree test = new No111_MinimumDepthOfBinaryTree();
  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int m = minDepth(root.left);
    int n = minDepth(root.right);
    if (m == 0 && n == 0) {
      return 1;
    } else if (m == 0) {
      return n + 1;
    } else if (n == 0) {
      return m + 1;
    } else {
      return 1 + Math.min(m, n);
    }
  }

}

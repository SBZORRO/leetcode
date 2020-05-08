public class No104_MaximumDepthOfBinaryTree {
//  Given a binary tree, find its maximum depth.
//
//  The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
//  return its depth = 3.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No104_MaximumDepthOfBinaryTree test = new No104_MaximumDepthOfBinaryTree();
  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}

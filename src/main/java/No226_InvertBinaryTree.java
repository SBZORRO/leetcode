public class No226_InvertBinaryTree {
//  Invert a binary tree.
//
//  Example:
//
//  Input:
//
//       4
//     /   \
//    2     7
//   / \   / \
//  1   3 6   9
//
//  Output:
//
//       4
//     /   \
//    7     2
//   / \   / \
//  9   6 3   1
//
//  Trivia:
//  This problem was inspired by this original tweet by Max Howell:
//
//      Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/invert-binary-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No226_InvertBinaryTree test = new No226_InvertBinaryTree();

  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = root.right;
    TreeNode right = root.left;
    root.left = left;
    root.right = right;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }
}

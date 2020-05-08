public class No110_BalancedBinaryTree {
//  Given a binary tree, determine if it is height-balanced.
//
//  For this problem, a height-balanced binary tree is defined as:
//
//      a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//   
//
//  Example 1:
//
//  Given the following tree [3,9,20,null,null,15,7]:
//
//      3
//     / \
//    9  20
//      /  \
//     15   7
//
//  Return true.
//
//  Example 2:
//
//  Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//         1
//        / \
//       2   2
//      / \
//     3   3
//    / \
//   4   4
//
//  Return false.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/balanced-binary-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No110_BalancedBinaryTree test = new No110_BalancedBinaryTree();

  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean ans = false;
    ans = isBalanced(root.left) && isBalanced(root.right);

    int m = height(root.left);
    int n = height(root.right);
    if (Math.max(m, n) - Math.min(m, n) > 1) {
      return false;
    }

    return ans;
  }

  public int height(TreeNode t) {
    if (t == null) {
      return 0;
    }
    return 1 + Math.max(height(t.left), height(t.right));
  }
}
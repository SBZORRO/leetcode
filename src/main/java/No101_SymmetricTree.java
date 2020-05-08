public class No101_SymmetricTree {
//  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//  For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//      1
//     / \
//    2   2
//   / \ / \
//  3  4 4  3
//
//   
//
//  But the following [1,2,2,null,3,null,3] is not:
//
//      1
//     / \
//    2   2
//     \   \
//     3    3
//
//   
//
//  Follow up: Solve it both recursively and iteratively.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/symmetric-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No101_SymmetricTree test = new No101_SymmetricTree();
  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return mirror(root.left, root.right);
  }

  public boolean mirror(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    } else if (l == null || r == null) {
      return false;
    } else if (l.val != r.val) {
      return false;
    } else {
      return mirror(l.left, r.right) && mirror(l.right, r.left);
    }
  }
}

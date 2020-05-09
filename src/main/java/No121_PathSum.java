public class No121_PathSum {
//  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//  Note: A leaf is a node with no children.
//
//  Example:
//
//  Given the below binary tree and sum = 22,
//
//        5
//       / \
//      4   8
//     /   / \
//    11  13  4
//   /  \      \
//  7    2      1
//
//  return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/path-sum
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No121_PathSum test = new No121_PathSum();
  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    sum = sum - root.val;
    if (sum == 0 && root.left == null && root.right == null) {
      return true;
    }
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}

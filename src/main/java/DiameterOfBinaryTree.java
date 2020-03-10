public class DiameterOfBinaryTree {
//  Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//  Example:
//  Given a binary tree
//
//            1
//           / \
//          2   3
//         / \     
//        4   5    
//
//  Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//  Note: The length of path between two nodes is represented by the number of edges between them. 
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    DiameterOfBinaryTree test = new DiameterOfBinaryTree();
    System.out.println(test.diameterOfBinaryTree(null));
  }

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode(int x) { val = x; }
   * }
   */
  static int depth = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return depth;
  }

  public int depth(TreeNode root) {
    int l = 0;
    int r = 0;
    if (root == null) {
      return 0;

    } else {
      l = depth(root.left);
      r = depth(root.right);
    }
    
    depth = Math.max(depth, l + r + 1);
    return Math.max(l, r) + 1;
  }

  static class TreeNode {
    public int      val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}

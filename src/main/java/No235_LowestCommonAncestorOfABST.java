public class No235_LowestCommonAncestorOfABST {
//  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//  According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//  Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//   
//
//  Example 1:
//
//  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//  Output: 6
//  Explanation: The LCA of nodes 2 and 8 is 6.
//
//  Example 2:
//
//  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//  Output: 2
//  Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//
//   
//
//  Note:
//
//      All of the nodes' values will be unique.
//      p and q are different and both values will exist in the BST.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No235_LowestCommonAncestorOfABST test = new No235_LowestCommonAncestorOfABST();

  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val == q.val) {
      return q;
    }
    TreeNode small = p.val > q.val ? q : p;
    TreeNode big = p.val > q.val ? p : q;
    if (small.val <= root.val && big.val >= root.val) {
      return root;
    }
    if (small.val <= root.val && big.val <= root.val) {
      return lowestCommonAncestor(root.left, small, big);
    }
    if (small.val >= root.val && big.val >= root.val) {
      return lowestCommonAncestor(root.right, small, big);
    }
    return null;
  }

}

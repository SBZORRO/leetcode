import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class No105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
//  Given preorder and inorder traversal of a tree, construct the binary tree.
//
//  Note:
//  You may assume that duplicates do not exist in the tree.
//
//  For example, given
//
//  preorder = [3,9,20,15,7]
//  inorder = [9,3,15,20,7]
//
//  Return the following binary tree:
//
//      3
//     / \
//    9  20
//      /  \
//     15   7
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No105_ConstructBinaryTreeFromPreorderAndInorderTraversal test = new No105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
    test.buildTree(new int[] { 1, 2 }, new int[] { 2, 1 });
  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    if (preorder.length == 1 || inorder.length == 1) {
      return root;
    }
    Map<Integer, Integer> prem = new HashMap<>();
    Map<Integer, Integer> inm = new HashMap<>();

    for (int i = 0; i < preorder.length; i++) {
      prem.put(preorder[i], i);
      inm.put(inorder[i], i);
    }

    int[] inorderLeftSubtree = Arrays.copyOfRange(inorder, 0, inm.get(preorder[0]));
    int[] inorderRightSubtree = Arrays
        .copyOfRange(inorder, inm.get(preorder[0]) + 1, inorder.length);
    int[] preorderLeftSubtree = Arrays.copyOfRange(preorder, 1, 1 + inorderLeftSubtree.length);
    int[] preorderRightSubtree = Arrays
        .copyOfRange(preorder, 1 + inorderLeftSubtree.length, preorder.length);
    if (inorderLeftSubtree.length == 1) {
      root.left = new TreeNode(inorderLeftSubtree[0]);
    } else if (inorderLeftSubtree.length == 0) {
      root.left = null;
    } else {
      root.left = buildTree(preorderLeftSubtree, inorderLeftSubtree);
    }
    if (inorderRightSubtree.length == 1) {
      root.right = new TreeNode(inorderRightSubtree[0]);
    } else if (inorderRightSubtree.length == 0) {
      root.right = null;
    } else {
      root.right = buildTree(preorderRightSubtree, inorderRightSubtree);
    }
    return root;
  }
}

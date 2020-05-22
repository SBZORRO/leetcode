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
    Map<Integer, Integer> prem = new HashMap<>();
    Map<Integer, Integer> inm = new HashMap<>();
    TreeNode root = new TreeNode(preorder[0]);
    TreeNode h = root;

    for (int i = 0; i < preorder.length; i++) {
      prem.put(preorder[i], i);
      inm.put(inorder[i], i);
    }
    int i = 0;
    int j = 0;

    TreeNode subroot = new TreeNode(preorder[i]);
    prem.get(inorder[j]);

//    int leftestIndi = prem.get(inorder[0]);
//    int secondLeftestIndi = leftestIndi - 1;
//    int[] rightSubOfLeftestIn = Arrays
//        .copyOfRange(inorder, 1, inm.get(preorder[secondLeftestIndi]));
//    int[] rightSubOfLeftestPre = Arrays
//        .copyOfRange(preorder, leftestIndi + 1, leftestIndi + 1 + rightSubOfLeftestIn.length);
    int[] inorderLeftSubtree = Arrays.copyOfRange(inorder, 0, inm.get(preorder[0]));
    int[] inorderRightSubtree = Arrays
        .copyOfRange(inorder, inm.get(preorder[0]) + 1, inorder.length);
    int[] preorderLeftSubtree = Arrays.copyOfRange(preorder, 1, 1 + inorderLeftSubtree.length);
    int[] preorderRightSubtree = Arrays
        .copyOfRange(preorder, 1 + inorderLeftSubtree.length, preorder.length);
    subroot.left = buildTree(preorderLeftSubtree, inorderLeftSubtree);
    subroot.right = buildTree(preorderRightSubtree, inorderRightSubtree);
//    subroot.right = buildTree(rightSubOfLeftestPre, rightSubOfLeftestIn);

    return root;
  }
}

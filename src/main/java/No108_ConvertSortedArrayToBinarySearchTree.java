import java.util.Arrays;

public class No108_ConvertSortedArrayToBinarySearchTree {
//  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//  Example:
//
//  Given the sorted array: [-10,-3,0,5,9],
//
//  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//        0
//       / \
//     -3   9
//     /   /
//   -10  5
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No108_ConvertSortedArrayToBinarySearchTree test = new No108_ConvertSortedArrayToBinarySearchTree();
    test.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5 });
    test.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });

  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    int len = nums.length;
    TreeNode head = new TreeNode(nums[len / 2]);

    addChild(
        head,
        Arrays.copyOfRange(nums, 0, nums.length / 2),
        Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
    return head;
  }

  public void addChild(TreeNode head, int[] l, int[] r) {
    if (l != null && l.length != 0) {
      head.left = new TreeNode(l[l.length / 2]);
      addChild(
          head.left,
          Arrays.copyOfRange(l, 0, l.length / 2),
          Arrays.copyOfRange(l, l.length / 2 + 1, l.length));
    }
    if (r != null && r.length != 0) {
      head.right = new TreeNode(r[r.length / 2]);
      addChild(
          head.right,
          Arrays.copyOfRange(r, 0, r.length / 2),
          Arrays.copyOfRange(r, r.length / 2 + 1, r.length));
    }
  }
}
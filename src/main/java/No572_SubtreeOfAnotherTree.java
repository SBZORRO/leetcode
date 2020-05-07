public class No572_SubtreeOfAnotherTree {
//  Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
//
//  Example 1:
//  Given tree s:
//
//       3
//      / \
//     4   5
//    / \
//   1   2
//
//  Given tree t:
//
//     4 
//    / \
//   1   2
//
//  Return true, because t has the same structure and node values with a subtree of s.
//
//  Example 2:
//  Given tree s:
//
//       3
//      / \
//     4   5
//    / \
//   1   2
//      /
//     0
//
//  Given tree t:
//
//     4
//    / \
//   1   2
//
//  Return false.
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/subtree-of-another-tree
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No572_SubtreeOfAnotherTree test = new No572_SubtreeOfAnotherTree();
//    TreeNode head = new TreeNode(3);
//    TreeNode s = head;
//    s.left = new TreeNode(4);
//    s.right = new TreeNode(5);
//    s = s.left;
//    s.left = new TreeNode(1);
//    head.right.left = new TreeNode(2);
//
//    TreeNode head2 = new TreeNode(3);
//    TreeNode t = head2;
//    t.left = new TreeNode(1);
//    t.right = new TreeNode(2);
//
//    System.out.println(test.isSubtree(head, head2));
    TreeNode head = new TreeNode(0);
    TreeNode s = head;
    s.left = new TreeNode(4);
    s.right = new TreeNode(5);
    s = s.left;
    s.left = new TreeNode(1);
    s.right = new TreeNode(2);

    TreeNode t = head.left;

    System.out.println(test.isSubtree(head, t));
  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null || t == null) {
      return false;
    }
    boolean ans = false;
    if (s.val == t.val) {
      ans = isSubtree(s, t, true);
    }
    if (ans == false) {
      ans = isSubtree(s.left, t);
    }
    if (ans == false) {
      ans = isSubtree(s.right, t);
    }
    return ans;
  }

  public boolean isSubtree(TreeNode s, TreeNode t, boolean con) {
    if (con == false) {
      return false;
    }
    if (s == null && t == null) {
      return true;
    } else if (s == null || t == null) {
      return false;
    }
    boolean isRight = false;
    boolean isLeft = false;
    if (s.val == t.val) {
      isLeft = isSubtree(s.left, t.left, true);
      if (isLeft == false) {
        return false;
      }
      isRight = isSubtree(s.right, t.right, true);
      return isLeft && isRight;
    } else {
      return false;
    }
  }
}

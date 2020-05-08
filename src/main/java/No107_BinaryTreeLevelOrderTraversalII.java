import java.util.LinkedList;
import java.util.List;

public class No107_BinaryTreeLevelOrderTraversalII {
//  Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//      For example:
//      Given binary tree [3,9,20,null,null,15,7],
//
//          3
//         / \
//        9  20
//          /  \
//         15   7
//
//      return its bottom-up level order traversal as:
//
//      [
//        [15,7],
//        [9,20],
//        [3]
//      ]
//
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No107_BinaryTreeLevelOrderTraversalII test = new No107_BinaryTreeLevelOrderTraversalII();

    TreeNode head = new TreeNode(3);
    TreeNode t = head;
    t.left = new TreeNode(9);
    t.right = new TreeNode(20);
    test.levelOrderBottom(head);
  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> lis = new LinkedList<>();
    if (root == null) {
      return lis;
    }

    LinkedList<TreeNode> q = new LinkedList<>();
    q.addLast(root);
    q.addLast(null);
    List<Integer> li = new LinkedList<>();
    while (!q.isEmpty()) {
      TreeNode tmp = q.pop();
      if (tmp == null) {
        lis.addFirst(li);
        li = new LinkedList<>();
        if (!q.isEmpty()) {
          q.addLast(null);
        }
      } else if (tmp != null) {
        li.add(tmp.val);
        if (tmp.left != null) {
          q.addLast(tmp.left);
        }
        if (tmp.right != null) {
          q.addLast(tmp.right);
        }
      }
    }
    return (List<List<Integer>>) lis;
  }
}
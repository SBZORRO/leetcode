import java.util.LinkedList;
import java.util.List;

public class No102_BinaryTreeLevelOrderTraversal {
//  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
//      return its level order traversal as:
//
//      [
//        [3],
//        [9,20],
//        [15,7]
//      ]
//
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No102_BinaryTreeLevelOrderTraversal test = new No102_BinaryTreeLevelOrderTraversal();
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lis = new LinkedList<>();
    List<Integer> li = new LinkedList<>();
    if (root != null) {
      li.add(root.val);
      lis.add(li);
    } else {
      return lis;
    }
    LinkedList<TreeNode> l = new LinkedList<>();
    l.add(root);
    l.add(null);
    li = new LinkedList<>();
    while (l.size() != 0) {
      TreeNode cur = l.pop();
      if (cur == null) {
        if (l.size() != 0) {
          lis.add(li);
          li = new LinkedList<>();
          l.add(null);
        }
      } else {
        if (cur.left != null) {
          l.add(cur.left);
          li.add(cur.left.val);
        }
        if (cur.right != null) {
          l.add(cur.right);
          li.add(cur.right.val);
        }
      }
    }
    return lis;
  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}

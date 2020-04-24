import java.util.LinkedList;
import java.util.List;

public class No199_BinaryTreeRightSideView {
//  Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//      Example:
//
//      Input: [1,2,3,null,5,null,4]
//      Output: [1, 3, 4]
//      Explanation:
//
//         1            <---
//       /   \
//      2     3         <---
//       \     \
//        5     4       <---
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No199_BinaryTreeRightSideView test = new No199_BinaryTreeRightSideView();
    System.out.println();

  }

  public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  List<Integer> list = new LinkedList<>();

  public List<Integer> rightSideView(TreeNode root) {
    travse(root, 0);
    return list;
  }

  public void travse(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (depth >= list.size()) {
      list.add(root.val);
    }
    depth++;
    travse(root.right, depth);
    travse(root.left, depth);
  }

}

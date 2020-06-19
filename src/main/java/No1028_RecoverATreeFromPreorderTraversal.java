public class No1028_RecoverATreeFromPreorderTraversal {
//  We run a preorder depth first search on the root of a binary tree.
//
//  At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
//
//  If a node has only one child, that child is guaranteed to be the left child.
//
//  Given the output S of this traversal, recover the tree and return its root.
//
//   
//
//  Example 1:
//
//  Input: "1-2--3--4-5--6--7"
//  Output: [1,2,5,3,4,6,7]
//
//  Example 2:
//
//  Input: "1-2--3---4-5--6---7"
//  Output: [1,2,5,3,null,6,null,4,null,7]
//
//   
//
//  Example 3:
//
//  Input: "1-401--349---90--88"
//  Output: [1,401,null,349,88,90]
//
//   
//
//  Note:
//
//      The number of nodes in the original tree is between 1 and 1000.
//      Each node will have a value between 1 and 10^9.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1028_RecoverATreeFromPreorderTraversal test = new No1028_RecoverATreeFromPreorderTraversal();

  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode recoverFromPreorder(String S) {
    char[] s = S.toCharArray();
    TreeNode root = new TreeNode(s[0] - '0');
    root.left = recoverFromPreorder(s, 1, 0);
    return root;
  }

  public TreeNode recoverFromPreorder(char[] s, int beg, int depth) {

    int i = beg;

    for (; i < s.length && s[i] == '-'; i++) {
    }
    int d = i - beg;
    if (d > depth) {

    }
    TreeNode node = new TreeNode(s[i] - '0');

    return node;
  }

  public TreeNode rec(TreeNode node) {
    TreeNode 
  }
}
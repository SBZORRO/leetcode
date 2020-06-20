public class AVLTree {

  static class TreeNode {
    TreeNode left;
    TreeNode right;
    int      val;
    int      height;

    public TreeNode() {
      // TODO Auto-generated constructor stub
    }
  }

  public static TreeNode NULL = new TreeNode();
  public static TreeNode ROOT = new TreeNode();

  public static void main(String[] args) {
    AVLTree test = new AVLTree();
  }

  public TreeNode insert(TreeNode root, int v) {
    TreeNode node = root;
    if (node == null) {
      TreeNode n = new TreeNode();
      n.val = v;
      n.height = 0;
    } else if (v < node.val) {
      node.left = insert(node, v);
      if (node.left.height - node.right.height == 2) {
        if (v < node.left.height) {
          singleRotateWithLeft(node);
        } else {
          doubleRotateWithLeft(node);
        }
      }
    } else if (v > node.val) {
      node.right = insert(node, v);
      if (node.right.height - node.left.height == 2) {
        if (v > node.right.height) {
          singleRotateWithRight(node);
        } else {
          doubleRotateWithRight(node);
        }
      }
    }
    node.height = Math.max(node.left.height, node.right.height) + 1;
    return root;
  }

  public TreeNode singleRotateWithLeft(TreeNode node) {
    TreeNode tmp = node.left;
    node.left = tmp.right;
    tmp.right = node;

    tmp.height = Math.max(tmp.left.height, tmp.right.height) + 1;
    node.height = Math.max(node.left.height, node.right.height) + 1;

    return tmp;
  }

  public TreeNode singleRotateWithRight(TreeNode node) {
    TreeNode tmp = node.right;
    node.right = tmp.left;
    tmp.left = node;
    tmp.height = Math.max(tmp.left.height, tmp.right.height) + 1;
    node.height = Math.max(node.left.height, node.right.height) + 1;
    return tmp;
  }

  public TreeNode doubleRotateWithLeft(TreeNode node) {
    node.left = singleRotateWithLeft(node.left);
    return singleRotateWithRight(node);
  }

  public TreeNode doubleRotateWithRight(TreeNode node) {
    node.right = singleRotateWithRight(node.right);
    return singleRotateWithLeft(node);
  }
}

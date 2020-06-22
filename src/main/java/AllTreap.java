public class AllTreap {

  enum COLOR {
    Red, Black
  };

  static class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode par;
    int      priority;
    int      val;

    public TreeNode() {
      // TODO Auto-generated constructor stub
    }
  }

  public static TreeNode NULL = new TreeNode();
  public static TreeNode ROOT = new TreeNode();

  public static void main(String[] args) {
    AllTreap test = new AllTreap();
  }

  public TreeNode insert(TreeNode root, int v) {
    TreeNode node = root;
    if (node == NULL) {
      node.val = v;
      node.left = NULL;
      node.right = NULL;
    } else if (v < node.val) {
      node.left = insert(node, v);
      if (node.left.priority < node.priority) {
        singleRotateWithLeft(node);
      }
    } else {
      node.right = insert(node, v);
      if (node.right.priority < node.priority) {
        singleRotateWithRight(node);
      }
    }
    return node;
  }

  public TreeNode delete(TreeNode node, int v) {
    if (node != NULL) {
      if (v == node.val) {
        node.priority = Integer.MAX_VALUE;
        if (node.left.priority < node.right.priority) {
          node = singleRotateWithLeft(node);
        } else {
          node = singleRotateWithRight(node);
        }
        if (node != NULL) {
          node = delete(node, v);
        } else {
          node.left = NULL;
        }
      } else if (v < node.val) {
        node.left = delete(node.left, v);
      } else {
        node.right = delete(node.right, v);
      }
    }
    return node;
  }

  public TreeNode singleRotateWithLeft(TreeNode node) {
    TreeNode tmp = node.left;
    node.left = tmp.right;
    tmp.right = node;
    return tmp;
  }

  public TreeNode singleRotateWithRight(TreeNode node) {
    TreeNode tmp = node.right;
    node.right = tmp.left;
    tmp.left = node;
    return tmp;
  }

}

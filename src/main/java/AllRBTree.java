public class AllRBTree {

  enum COLOR {
    Red, Black
  };

  static class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode par;
    COLOR    color;
    int      val;

    public TreeNode() {
      // TODO Auto-generated constructor stub
    }
  }

  public static TreeNode NULL = new TreeNode();

  public static void main(String[] args) {
    AllRBTree test = new AllRBTree();
  }

  public void insert(TreeNode root, int v) {

  }

  public void handleReorient(TreeNode root, int v) {

  }

  public void rotate(TreeNode p, int v) {

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

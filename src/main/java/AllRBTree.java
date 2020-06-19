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
  public static TreeNode ROOT = new TreeNode();

  public static void main(String[] args) {
    AllRBTree test = new AllRBTree();
  }

  public void insert(TreeNode root, int v) {
    NULL.val = v;

    TreeNode node = root;
    TreeNode p = node;
    while (v != node.val) {
      if (v < node.left.val) {
        node = node.left;
      } else {
        node = node.right;
      }
      p = node.par;
      if (node.left.color == COLOR.Red && node.right.color == COLOR.Black) {
        handleReorient(node, v);
      }
    }
    TreeNode add = new TreeNode();
    add.val = v;
    add.left = NULL;
    add.right = NULL;
    if (v < p.val) {
      p.left = add;
    } else {
      p.right = add;
    }
    handleReorient(add, v);
  }

  public void delete(TreeNode node, int v) {
    if (node == null || node.val == v) {
      return;
    }
    TreeNode f = null;
    TreeNode p = node;
    TreeNode s = node;
    TreeNode gp = node;
    while (node != NULL) {
      if (node.val > v) {
        node = node.left;
        s = node.right;
      } else {
        node = node.right;
        s = node.left;
        if (p.val == v) {
          f = p;
        }
      }
      if (p.color == COLOR.Black && node.color == COLOR.Red) {
        continue;
      } else if (p.color == COLOR.Black && node.color == COLOR.Black) {
        if (node == p.left) {
          singleRotateWithLeft(p);
        } else {
          singleRotateWithRight(p);
        }
      } else if (p.color == COLOR.Red) {
        if (node.right.color == COLOR.Black && node.left.color == COLOR.Black) {
          if (s.right.color == COLOR.Black && s.left.color == COLOR.Black) {
            p.color = COLOR.Black;
            node.color = COLOR.Red;
            s.color = COLOR.Red;
          } else {
            if (node == p.left && s.left.color == COLOR.Red) {
              gp = doubleRotateWithRight(p);
            } else if (node == p.right && s.right.color == COLOR.Red) {
              gp = doubleRotateWithLeft(p);
            } else if (node == p.left && s.right.color == COLOR.Red) {
              p = singleRotateWithRight(p);
            } else if (node == p.right && s.left.color == COLOR.Red) {
              p = singleRotateWithLeft(p);
            }
            node.color = COLOR.Red;
            gp.color = COLOR.Red;
            gp.left.color = COLOR.Black;
            gp.right.color = COLOR.Black;
          }
        }
      }
    }
    f.val = p.val;
    gp.left = p.right;
    gp.left.par = gp;
  }

  public void handleReorient(TreeNode node, int v) {
    node.color = COLOR.Red;
    node.left.color = COLOR.Black;
    node.right.color = COLOR.Black;

    TreeNode p = node.par;
    TreeNode gp = p.par;
    TreeNode ggp = gp.par;
    if (p.color == COLOR.Red) {
      gp.color = COLOR.Red;
      if (node.val < p.val && p.val < gp.val) {
        ggp.left = singleRotateWithLeft(gp);
        ggp.left.color = COLOR.Black;
      } else if (node.val >= p.val && p.val >= gp.val) {
        ggp.right = singleRotateWithRight(gp);
        ggp.right.color = COLOR.Black;
      } else if (p.val < gp.val && node.val >= p.val) {
        ggp.left = doubleRotateWithLeft(gp);
        ggp.left.color = COLOR.Black;
      } else {
        ggp.right = doubleRotateWithRight(gp);
        ggp.right.color = COLOR.Black;
      }
    }
    ROOT.color = COLOR.Black;
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

  public TreeNode doubleRotateWithLeft(TreeNode node) {
    node.left = singleRotateWithLeft(node.left);
    return singleRotateWithRight(node);
  }

  public TreeNode doubleRotateWithRight(TreeNode node) {
    node.right = singleRotateWithRight(node.right);
    return singleRotateWithLeft(node);
  }

}

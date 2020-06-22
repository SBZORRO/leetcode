public class AllDeterministicSkipList {

  static class SkipNode {
    int      val;
    SkipNode right;
    SkipNode down;

    public SkipNode() {
      // TODO Auto-generated constructor stub
    }
  }

  SkipNode BOTTOM = null;
  SkipNode TAIL   = null;
  SkipNode HEAD   = null;

  public AllDeterministicSkipList() {
    BOTTOM.right = BOTTOM;
    BOTTOM.down = BOTTOM;
    TAIL.val = Integer.MAX_VALUE;
    TAIL.right = TAIL;
    HEAD.val = Integer.MAX_VALUE;
    HEAD.right = TAIL;
    HEAD.down = BOTTOM;
  }

  public SkipNode find(SkipNode root, int v) {
    SkipNode node = root;
    while (node.val != v) {
      if (v < node.val) {
        node = node.down;
      } else {
        node = node.right;
      }
    }
    return node;
  }

  public SkipNode insert(SkipNode root, int v) {
    SkipNode node = root;
    BOTTOM.val = v;
    while (node != BOTTOM) {
      while (v > node.val) {
        node = node.right;
      }
      if (node.val > node.down.right.right.val) {
        SkipNode n = new SkipNode();
        n.val = node.val;
        n.right = node.right;
        n.down = node.down.right.right;
        node.val = node.down.right.val;
        node.right = n;
      } else {
        node = node.down;
      }
    }
    if (root.right != TAIL) {
      SkipNode n = new SkipNode();
      n.down = root;
      n.right = TAIL;
      n.val = Integer.MAX_VALUE;
      root = n;
    }
    return root;
  }
}

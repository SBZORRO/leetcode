public class No21_MergeTwoSortedLists {
//  Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
//      Example:
//
//      Input: 1->2->4, 1->3->4
//      Output: 1->1->2->3->4->4
//
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No21_MergeTwoSortedLists test = new No21_MergeTwoSortedLists();
    ListNode res = new ListNode(1);
    ListNode l1 = res;
    res.next = new ListNode(2);
    res = res.next;
    res.next = new ListNode(4);
    res = res.next;
    res = new ListNode(1);
    ListNode l2 = res;
    res.next = new ListNode(3);
    res = res.next;
    res.next = new ListNode(4);
    res = res.next;
    System.out.println(test.mergeTwoLists(l1, l2));
  }

  static class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode head = res;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        res.next = new ListNode(l1.val);
        l1 = l1.next;
        res = res.next;
      } else {
        res.next = new ListNode(l2.val);
        l2 = l2.next;
        res = res.next;
      }
    }

    while (l1 != null) {
      res.next = new ListNode(l1.val);
      l1 = l1.next;
      res = res.next;
    }
    while (l2 != null) {
      res.next = new ListNode(l2.val);
      l2 = l2.next;
      res = res.next;
    }
    return head.next;
  }
}

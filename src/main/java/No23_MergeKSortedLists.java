import java.util.Arrays;

public class No23_MergeKSortedLists {
//  Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
//      Example:
//
//      Input:
//      [
//        1->4->5,
//        1->3->4,
//        2->6
//      ]
//      Output: 1->1->2->3->4->4->5->6
//
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No23_MergeKSortedLists test = new No23_MergeKSortedLists();

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

    res = new ListNode(2);
    ListNode l3 = res;
    res.next = new ListNode(2);
    res = res.next;
    res.next = new ListNode(4);
    res = res.next;

    res = new ListNode(1);
    ListNode l4 = res;
    res.next = new ListNode(3);
    res = res.next;
    res.next = new ListNode(4);
    res = res.next;
    ListNode[] ls = new ListNode[4];
    ls[0] = l1;
    ls[1] = l2;
    ls[2] = l3;
    ls[3] = l4;
    System.out.println(test.mergeKLists(ls));

  }

  static class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    } else if (lists.length == 1) {
      return lists[0];
    }
    return div(lists);
  }

  public ListNode div(ListNode[] lists) {
    return merge(
        Arrays.copyOfRange(lists, 0, lists.length / 2),
        Arrays.copyOfRange(lists, lists.length / 2, lists.length));
  }

  public ListNode merge(ListNode[] l1, ListNode[] l2) {
    ListNode res1 = null;
    ListNode res2 = null;
    if (l1.length > 1) {
      res1 = div(l1);
    } else {
      res1 = l1[0];
    }
    if (l2.length > 1) {
      res2 = div(l2);
    } else {
      res2 = l2[0];
    }
    return mergeTwo(res1, res2);
  }

  public ListNode mergeTwo(ListNode l1, ListNode l2) {
    ListNode list = new ListNode(0);
    ListNode head = list;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        list.next = l1;
        l1 = l1.next;
      } else {
        list.next = l2;
        l2 = l2.next;
      }
      list = list.next;
    }
    while (l1 != null) {
      list.next = l1;
      l1 = l1.next;
      list = list.next;
    }
    while (l2 != null) {
      list.next = l2;
      l2 = l2.next;
      list = list.next;
    }
    return head.next;
  }
}
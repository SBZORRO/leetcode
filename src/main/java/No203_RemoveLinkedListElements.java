public class No203_RemoveLinkedListElements {
//  Remove all elements from a linked list of integers that have value val.
//
//  Example:
//
//  Input:  1->2->6->3->4->5->6, val = 6
//  Output: 1->2->3->4->5
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/remove-linked-list-elements
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No203_RemoveLinkedListElements test = new No203_RemoveLinkedListElements();
    ListNode head = new ListNode(1);
    ListNode h = head;
    head.next = new ListNode(2);
    head = head.next;
    head.next = new ListNode(3);
    head = head.next;
    head.next = new ListNode(4);
    head = head.next;
    head.next = new ListNode(5);
    head = head.next;
    head.next = new ListNode(6);
    head = head.next;
    test.removeElements(h, 6);
  }

  static class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val) {
      head = head.next;
    }
    ListNode h = head;
    ListNode prev = new ListNode(0);
    prev.next = head;
    while (h != null) {
      if (h.val == val) {
        prev.next = h.next;
        h = prev.next;
      } else {
        prev = h;
        h = h.next;
      }
    }
    return head;
  }
}
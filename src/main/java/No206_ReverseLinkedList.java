public class No206_ReverseLinkedList {
//  Reverse a singly linked list.
//
//  Example:
//
//  Input: 1->2->3->4->5->NULL
//  Output: 5->4->3->2->1->NULL
//
//  Follow up:
//
//  A linked list can be reversed either iteratively or recursively. Could you implement both?
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/reverse-linked-list
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No206_ReverseLinkedList test = new No206_ReverseLinkedList();
    ListNode h = new ListNode(1);
    ListNode head = h;
    h.next = new ListNode(2);
    h = h.next;
    h.next = new ListNode(3);
    h = h.next;
    h.next = new ListNode(4);
    h = h.next;
    h.next = new ListNode(5);
    h = h.next;
    test.reverseList(head);
  }

  static class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode re(ListNode head) {

    if (head.next == null) {
      res = head;
      return head;
    }
    return re(head.next).next = head;
  }

  ListNode res = null;

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode h = head;
    re(head);
    h.next = null;
    return res;
  }
}
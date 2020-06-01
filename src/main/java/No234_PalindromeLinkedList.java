public class No234_PalindromeLinkedList {
//  Given a singly linked list, determine if it is a palindrome.
//
//  Example 1:
//
//  Input: 1->2
//  Output: false
//
//  Example 2:
//
//  Input: 1->2->2->1
//  Output: true
//
//  Follow up:
//  Could you do it in O(n) time and O(1) space?

  public static void main(String[] args) {
    No234_PalindromeLinkedList test = new No234_PalindromeLinkedList();
    ListNode h = new ListNode(1);
    ListNode head = h;
    h.next = new ListNode(1);
    h = h.next;
    h.next = new ListNode(2);
    h = h.next;
    h.next = new ListNode(1);
    h = h.next;
    h.next = new ListNode(1);
    test.isPalindrome(head);
  }

  static class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    int total = 0;
    ListNode h = head;
    while (h != null) {
      total++;
      h = h.next;
    }
    h = head;
    for (int i = 0; i < (total + 1) / 2; i++) {
      h = h.next;
    }
    ListNode h2 = reverse(h);
    for (int i = 0; i < total / 2; i++) {
      if (head.val != h2.val) {
        return false;
      }
      head = head.next;
      h2 = h2.next;
    }
    return true;
  }

  public ListNode reverse(ListNode head) {
    ListNode cur = head.next;
    ListNode next = null;
    ListNode prev = head;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}

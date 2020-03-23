public class No876_MiddleOfTheLinkedList {
//  Given a non-empty, singly linked list with head node head, return a middle node of linked list.
//
//      If there are two middle nodes, return the second middle node.
//
//       
//
//      Example 1:
//
//      Input: [1,2,3,4,5]
//      Output: Node 3 from this list (Serialization: [3,4,5])
//      The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
//      Note that we returned a ListNode object ans, such that:
//      ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
//
//      Example 2:
//
//      Input: [1,2,3,4,5,6]
//      Output: Node 4 from this list (Serialization: [4,5,6])
//      Since the list has two middle nodes with values 3 and 4, we return the second one.
//
//       
//
//      Note:
//
//          The number of nodes in the given list will be between 1 and 100.
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No876_MiddleOfTheLinkedList test = new No876_MiddleOfTheLinkedList();
    ListNode head = new ListNode(1);
    ListNode temp = head;
    for (int i = 2; i <= 5; i++) {
      head.next = new ListNode(i);
      head = head.next;
    }

    System.out.println(test.middleNode(temp).val);
    System.out.println(test.middleNode1(temp).val);
  }

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode(int x) { val = x; }
   * }
   */

  static class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode middleNode1(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (true) {
      if (fast == null || fast.next == null) {
        return slow;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
  }
}
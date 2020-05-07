public class No83_RemoveDuplicatesFromSortedList {
//  Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//  Example 1:
//
//  Input: 1->1->2
//  Output: 1->2
//
//  Example 2:
//
//  Input: 1->1->2->3->3
//  Output: 1->2->3
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No83_RemoveDuplicatesFromSortedList cc = new No83_RemoveDuplicatesFromSortedList();

  }

  public class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode ori = head;
    ListNode next = head.next;

    while (next != null) {
      if (head.val == next.val) {
        next = next.next;
        head.next = next;
      } else {
        head = next;
        next = next.next;
      }
    }
    return ori;
  }
}
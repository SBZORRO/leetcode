public class No445_AddTowNumbers2 {
//  You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//      Follow up:
//      What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//
//      Example:
//
//      Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//      Output: 7 -> 8 -> 0 -> 7

  public static void main(String[] args) {
    No445_AddTowNumbers2 test = new No445_AddTowNumbers2();
    ListNode l1 = new ListNode(7);
    ListNode h1 = l1;
    l1.next = new ListNode(2);
    l1 = l1.next;
    l1.next = new ListNode(4);
    l1 = l1.next;
    l1.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    ListNode h2 = l2;
    l2.next = new ListNode(6);
    l2 = l2.next;
    l2.next = new ListNode(4);

//    ListNode l1 = new ListNode(2);
//    ListNode h1 = l1;
//    l1.next = new ListNode(4);
//    l1 = l1.next;
//    l1.next = new ListNode(3);
//    ListNode l2 = new ListNode(5);
//    ListNode h2 = l2;
//    l2.next = new ListNode(6);
//    l2 = l2.next;
//    l2.next = new ListNode(4);

//    ListNode l1 = new ListNode(1);
//    ListNode h1 = l1;
//    ListNode l2 = new ListNode(9);
//    ListNode h2 = l2;
//    l2.next = new ListNode(9);

//    ListNode l1 = new ListNode(8);
//    ListNode h1 = l1;
//    l1.next = new ListNode(9);
//    l1 = l1.next;
//    l1.next = new ListNode(9);
//    ListNode l2 = new ListNode(2);
//    ListNode h2 = l2;

    test.addTwoNumbers(h1, h2);
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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int len1 = 0;
    int len2 = 0;
    ListNode head1 = l1;
    ListNode head2 = l2;
    while (l1 != null) {
      len1++;
      l1 = l1.next;
    }
    while (l2 != null) {
      len2++;
      l2 = l2.next;
    }

    if (len1 == 1 && head1.val == 0) {
      return head2;
    }
    if (len2 == 1 && head2.val == 0) {
      return head1;
    }
    int min = 0;
    int max = 0;
    ListNode headMin = null;
    ListNode headMax = null;
    if (len1 < len2) {
      headMin = head1;
      headMax = head2;
      min = len1;
      max = len2;
    } else {
      headMax = head1;
      headMin = head2;
      max = len1;
      min = len2;
    }

    ListNode curPtr = headMax;
    ListNode nextPtr = headMax;
    ListNode result = headMax;

    if (max == min) {
      curPtr.val = headMax.val + headMin.val;
      nextPtr = nextPtr.next;
      headMin = headMin.next;
    } else {
      for (int i = max; i > min; i--) {
        curPtr = nextPtr;
        nextPtr = nextPtr.next;
      }
    }
    while (nextPtr != null) {
      nextPtr.val = nextPtr.val + headMin.val;
//      if (nextPtr.val > 9) {
//        curPtr.val++;
//        nextPtr.val = nextPtr.val % 10;
//      }
      curPtr = nextPtr;
      nextPtr = nextPtr.next;
      headMin = headMin.next;
    }

    curPtr = headMax;
    nextPtr = headMax.next;
    while (nextPtr != null) {
      if (nextPtr.val > 9) {
        nextPtr.val = nextPtr.val % 10;
        curPtr.val++;
        while (curPtr.next != nextPtr) {
          curPtr = curPtr.next;
          curPtr.val = 0;
        }
      } else if (nextPtr.val == 9) {
        nextPtr = nextPtr.next;
      } else {
        curPtr = nextPtr;
        nextPtr = nextPtr.next;
      }
    }
    if (headMax.val > 9) {
      result = new ListNode(1);
      headMax.val = headMax.val % 10;
      result.next = headMax;
    }
    return result;
  }
}

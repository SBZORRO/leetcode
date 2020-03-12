public class AddTwoNumbers {
//  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//      Example:
//
//      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//      Output: 7 -> 0 -> 8
//      Explanation: 342 + 465 = 807.
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/add-two-numbers
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    AddTwoNumbers test = new AddTwoNumbers();
    System.out.println(test.addTwoNumbers(new ListNode(8), new ListNode(9)).val);
//    System.out.println(test.isValid("()[]{}"));
//    System.out.println(test.isValid("([)]"));
//    System.out.println(test.isValid("{[()]}"));
  }

//  Definition for singly-linked list.
  static class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    int nextOne = 0;
    ListNode result = new ListNode(0);
    ListNode head = result;
    int n1 = 0;
    int n2 = 0;
    while (true) {

      if (l1 == null) {
        n1 = 0;
      } else {
        n1 = l1.val;
        l1 = l1.next;
      }
      if (l2 == null) {
        n2 = 0;
      } else {
        n2 = l2.val;
        l2 = l2.next;
      }
      int temp = n1 + n2 + nextOne;
      if (temp / 10 >= 1) {
        nextOne = 1;
      } else {
        nextOne = 0;
      }
      result.val = temp % 10;
      if (l1 != null || l2 != null || nextOne == 1) {
        result.next = new ListNode(0);
        result = result.next;
      } else {
        return head;
      }
    }

  }

}

public class No1114_PrintInOrder {
//  Suppose we have a class:
//
//    public class Foo {
//      public void first() { print("first"); }
//      public void second() { print("second"); }
//      public void third() { print("third"); }
//    }
//
//    The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
//
//     
//
//    Example 1:
//
//    Input: [1,2,3]
//    Output: "firstsecondthird"
//    Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
//
//    Example 2:
//
//    Input: [1,3,2]
//    Output: "firstsecondthird"
//    Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
//
//     
//
//    Note:
//
//    We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/print-in-order
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1114_PrintInOrder test = new No1114_PrintInOrder();
    System.out.println();

  }

  class Foo {

    int i = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
      i = 1;
      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      i = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
      while (i != 2) {

      }
      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      i = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
      while (i != 3) {

      }
      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
    }
  }
}

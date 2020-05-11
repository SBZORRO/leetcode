import java.util.function.IntConsumer;

public class No1116_PrintZeroEvenOdd {
//  Suppose you are given the following code:
//
//    class ZeroEvenOdd {
//      public ZeroEvenOdd(int n) { ... }      // constructor
//      public void zero(printNumber) { ... }  // only output 0's
//      public void even(printNumber) { ... }  // only output even numbers
//      public void odd(printNumber) { ... }   // only output odd numbers
//    }
//
//    The same instance of ZeroEvenOdd will be passed to three different threads:
//
//        Thread A will call zero() which should only output 0's.
//        Thread B will call even() which should only ouput even numbers.
//        Thread C will call odd() which should only output odd numbers.
//
//    Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
//
//     
//
//    Example 1:
//
//    Input: n = 2
//    Output: "0102"
//    Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
//
//    Example 2:
//
//    Input: n = 5
//    Output: "0102030405"
//
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/print-zero-even-odd
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {

  }
}

class ZeroEvenOdd {
  private int n;
  private int m = 0;

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      synchronized (this) {
        while (m != 0) {
          this.wait();
        }
        printNumber.accept(0);
        m = (i + 1) % 2 + 1;
        this.notifyAll();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i < n; i = i + 2) {
      synchronized (this) {
        while (m != 2) {
          this.wait();
        }
        printNumber.accept(i);
        m = 0;
        this.notifyAll();
      }
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i < n; i = i + 2) {
      synchronized (this) {
        while (m != 1) {
          this.wait();
        }
        printNumber.accept(i);
        m = 0;
        this.notifyAll();
      }
    }
  }
}
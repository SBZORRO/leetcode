public class No1115_PrintFooBarAlternately {
//  Suppose you are given the following code:
//
//    class FooBar {
//      public void foo() {
//        for (int i = 0; i < n; i++) {
//          print("foo");
//        }
//      }
//
//      public void bar() {
//        for (int i = 0; i < n; i++) {
//          print("bar");
//        }
//      }
//    }
//
//    The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
//
//     
//
//    Example 1:
//
//    Input: n = 1
//    Output: "foobar"
//    Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
//
//    Example 2:
//
//    Input: n = 2
//    Output: "foobarfoobar"
//    Explanation: "foobar" is being output 2 times.
//
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/print-foobar-alternately
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {

  }
}

class FooBar {
  private int n;
  private int m = 0;

  public FooBar(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      synchronized (this) {
        while (m == 1) {
          this.wait();
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        m = 1;
        this.notify();
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {

      synchronized (this) {
        while (m == 1) {
          this.wait();
        }
        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();
        m = 0;
      }
      this.notify();
    }
  }
}

class FooBar1 {
  private int          n;
  private volatile int m = 0;

  public FooBar1(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      while (m == 1) {
        // 不加超时
        Thread.yield();

      }
      // printFoo.run() outputs "foo". Do not change or remove this line.
      printFoo.run();
      m = 1;
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      while (m == 0) {
        // 不加超时
        Thread.yield();
      }
      // printBar.run() outputs "bar". Do not change or remove this line.
      printBar.run();
      m = 0;
    }
  }
}

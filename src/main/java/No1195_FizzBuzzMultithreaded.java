import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class No1195_FizzBuzzMultithreaded {
//  Write a program that outputs the string representation of numbers from 1 to n, however:
//
//    If the number is divisible by 3, output "fizz".
//    If the number is divisible by 5, output "buzz".
//    If the number is divisible by both 3 and 5, output "fizzbuzz".
//
//For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
//
//Suppose you are given the following code:
//
//class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//}
//
//Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:
//
//    Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
//    Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
//    Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
//    Thread D will call number() which should only output the numbers.
//
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

  public static void main(String[] args) {
    FizzBuzz fb = new FizzBuzz(15);
    EXECUTOR.execute(() -> {
      try {
        fb.fizz(() -> {
          System.out.println("fizz");
        });
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
    EXECUTOR.execute(() -> {
      try {
        fb.buzz(() -> {
          System.out.println("buzz");
        });
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
    EXECUTOR.execute(() -> {
      try {
        fb.fizzbuzz(() -> {
          System.out.println("fizzbuzz");
        });
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
    EXECUTOR.execute(() -> {
      try {
        fb.number((i) -> {
          System.out.println(i);
        });
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }
}

class FizzBuzz {
  private int            n;
  private int            i;
  public volatile Object fizz = new Object();
  public volatile Object buzz = new Object();
  public volatile Object fb   = new Object();

  public FizzBuzz(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    synchronized (fizz) {
      while (true) {
        fizz.wait();
        if (i > n) {
          break;
        }
        printFizz.run();
//        fizz++;
        fizz.notify();
      }
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    synchronized (buzz) {
      while (true) {
        buzz.wait();
        if (i > n) {
          break;
        }
        printBuzz.run();
//        buzz++;
        buzz.notify();
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    synchronized (fb) {
      while (true) {
        fb.wait();
        if (i > n) {
          break;
        }
        printFizzBuzz.run();
//        fb++;
        fb.notify();
      }
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    for (i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        synchronized (fb) {
//          int m = fb;
//          while (fb == m) {
          fb.notify();
          fb.wait();
//          }
        }
      } else if (i % 3 == 0) {
        synchronized (fizz) {
//          int m = fizz;
//          while (fizz == m) {
          fizz.notify();
          fizz.wait();
//          }
        }
      } else if (i % 5 == 0) {
        synchronized (buzz) {
//          int m = buzz;
//          while (buzz == m) {
          buzz.notify();
          buzz.wait();
//          }
        }
      } else {
        printNumber.accept(i);
      }
    }
    synchronized (fizz) {
      synchronized (buzz) {
        synchronized (fb) {
          fizz.notify();
          buzz.notify();
          fb.notify();
        }
      }
    }
  }
}
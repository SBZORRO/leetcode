public class No1117_BuildingH2O {
//  There are two kinds of threads, oxygen and hydrogen. Your goal is to group these threads to form water molecules. There is a barrier where each thread has to wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given releaseHydrogen and releaseOxygen methods respectively, which will allow them to pass the barrier. These threads should pass the barrier in groups of three, and they must be able to immediately bond with each other to form a water molecule. You must guarantee that all the threads from one molecule bond before any other threads from the next molecule do.
//
//  In other words:
//
//      If an oxygen thread arrives at the barrier when no hydrogen threads are present, it has to wait for two hydrogen threads.
//      If a hydrogen thread arrives at the barrier when no other threads are present, it has to wait for an oxygen thread and another hydrogen thread.
//
//  We don’t have to worry about matching the threads up explicitly; that is, the threads do not necessarily know which other threads they are paired up with. The key is just that threads pass the barrier in complete sets; thus, if we examine the sequence of threads that bond and divide them into groups of three, each group should contain one oxygen and two hydrogen threads.
//
//  Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.
//
//   
//
//  Example 1:
//
//  Input: "HOH"
//  Output: "HHO"
//  Explanation: "HOH" and "OHH" are also valid answers.
//
//  Example 2:
//
//  Input: "OOHHHH"
//  Output: "HHOHHO"
//  Explanation: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.
//
//   
//
//  Constraints:
//
//      Total length of input string will be 3n, where 1 ≤ n ≤ 20.
//      Total number of H will be 2n in the input string.
//      Total number of O will be n in the input string.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/building-h2o
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {

  }
}

class H2O {
  private volatile int h = 0;
  private volatile int o = 0;

  public H2O() {}

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    synchronized (this) {
      while (h == 2 && o != 1) {
        this.notify();
        this.wait();
      }
      if (o == 1 && h == 2) {
        o = 0;
        h = 0;
      }
      releaseHydrogen.run();
      h++;
      this.notify();
    }
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    synchronized (this) {
      while (o == 1 && h != 2) {
        this.notify();
        this.wait();
      }
      if (o == 1 && h == 2) {
        o = 0;
        h = 0;
      }
      releaseOxygen.run();
      o++;
      this.notify();
    }
  }
}

class H2O1 {
  private volatile int h = 0;
  private volatile int o = 0;

  public H2O1() {

  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    while (true) {
      synchronized (this) {
        if (h < 2) {
          releaseHydrogen.run();
          h++;
        } else if (o == 0 && h == 2) {
          this.wait();
        } else if (o == 1 && h == 2) {
          o = 0;
          h = 0;
          releaseHydrogen.run();
          h++;
          this.notify();
        }
      }
    }
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    while (true) {
      synchronized (this) {
        if (o == 0) {
          releaseOxygen.run();
          o++;
        } else if (o == 1 && h < 2) {
          this.wait();
        } else if (o == 1 && h == 2) {
          o = 0;
          h = 0;
          releaseOxygen.run();
          o++;
          this.notify();
        }
      }
    }
  }
}
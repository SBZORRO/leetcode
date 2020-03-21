public class No365_WaterAndJugProblem {
//  You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
//
//  If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
//
//  Operations allowed:
//
//      Fill any of the jugs completely with water.
//      Empty any of the jugs.
//      Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
//
//  Example 1: (From the famous "Die Hard" example)
//
//  Input: x = 3, y = 5, z = 4
//  Output: True
//
//  Example 2:
//
//  Input: x = 2, y = 6, z = 5
//  Output: False

  public static void main(String[] args) {
    No365_WaterAndJugProblem test = new No365_WaterAndJugProblem();
    System.out.println(test.gcd(12, 16));
    System.out.println(test.gcd(3, 5));
  }

//  方法二：数学
//
//  思路及算法
//
//  预备知识：贝祖定理
//
//  我们认为，每次操作只会让桶里的水总量增加 x，增加 y，减少 x，或者减少 y。
//
//  你可能认为这有问题：如果往一个不满的桶里放水，或者把它排空呢？那变化量不就不是 x 或者 y 了吗？接下来我们来解释这一点：
//
//      首先要清楚，在题目所给的操作下，两个桶不可能同时有水且不满。因为观察所有题目中的操作，操作的结果都至少有一个桶是空的或者满的；
//
//      其次，对一个不满的桶加水是没有意义的。因为如果另一个桶是空的，那么这个操作的结果等价于直接从初始状态给这个桶加满水；而如果另一个桶是满的，那么这个操作的结果等价于从初始状态分别给两个桶加满；
//
//      再次，把一个不满的桶里面的水倒掉是没有意义的。因为如果另一个桶是空的，那么这个操作的结果等价于回到初始状态；而如果另一个桶是满的，那么这个操作的结果等价于从初始状态直接给另一个桶倒满。
//
//  因此，我们可以认为每次操作只会给水的总量带来 x 或者 y 的变化量。因此我们的目标可以改写成：找到一对整数 a,ba, ba,b，使得
//
//  ax+by=zax+by=z ax+by=z
//
//  而只要满足 z≤x+yz\leq x+yz≤x+y，且这样的 a,ba, ba,b 存在，那么我们的目标就是可以达成的。这是因为：
//
//      若 a≥0,b≥0a\geq 0, b\geq 0a≥0,b≥0，那么显然可以达成目标。
//
//      若 a<0a\lt 0a<0，那么可以进行以下操作：
//
//          往 y 壶倒水；
//
//          把 y 壶的水倒入 x 壶；
//
//          如果 y 壶不为空，那么 x 壶肯定是满的，把 x 壶倒空，然后再把 y 壶的水倒入 x 壶。
//
//      重复以上操作直至某一步时 x 壶进行了 aaa 次倒空操作，y 壶进行了 bbb 次倒水操作。
//
//      若 b<0b\lt 0b<0，方法同上，x 与 y 互换。
//
//  而贝祖定理告诉我们，ax+by=z 有解当且仅当 z 是 x,y 的最大公约数的倍数。因此我们只需要找到 x,y 的最大公约数并判断 z 是否是它的倍数即可。
  public boolean canMeasureWater(int x, int y, int z) {
    if (x + y < z) {
      return false;
    }
    if (x == 0 || y == 0) {
      return z == 0 || x + y == z;
    }
    return z % gcd(x, y) == 0;

  }

  public int gcd(int x, int y) {
    if (y == 0) {
      return x;
    }
    return gcd(y, x % y);
  }
}

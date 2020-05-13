public class No204_CountPrimes {
//  Count the number of prime numbers less than a non-negative number, n.
//
//  Example:
//
//  Input: 10
//  Output: 4
//  Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/count-primes
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No204_CountPrimes test = new No204_CountPrimes();
  }

  public int countPrimes(int n) {
    if (n <= 2) {
      return 0;
    }
    int[] table = new int[n + 1];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (table[i] == -1) {
        continue;
      } else {
        count++;
      }
      for (int j = i; j <= n / i; j++) {
        table[i * j] = -1;
      }

    }

    return count;
  }

  public int countPrimes1(int n) {

    if (n < 2) {
      return 0;
    } else if (n == 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    }

    int count = 2;
    for (int i = 4; i < n; i++) {
      count = count + isPrime(i);
    }
    return count;
  }

  public int isPrime(int n) {
    int sqrt = (int) Math.sqrt(n);
    for (int j = 2; j <= sqrt; j++) {
      if (n % j == 0) {
        return 0;
      }
    }
    return 1;
  }
}
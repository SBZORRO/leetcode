import java.util.HashMap;
import java.util.Map;

public class No974_SubarraySumsDivisibleByK {
//  Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
//
//      
//
//      Example 1:
//
//      Input: A = [4,5,0,-2,-3,1], K = 5
//      Output: 7
//      Explanation: There are 7 subarrays with a sum divisible by K = 5:
//      [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//
//       
//
//      Note:
//
//          1 <= A.length <= 30000
//          -10000 <= A[i] <= 10000
//          2 <= K <= 10000

  public static void main(String[] args) {
    No974_SubarraySumsDivisibleByK test = new No974_SubarraySumsDivisibleByK();
    test.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5);
    test.subarraysDivByK(new int[] { -1, 2, 9 }, 2);
    test.subarraysDivByK(new int[] { -1, 2, 9 }, 5);
  }

  public int subarraysDivByK2(int[] A, int K) {
    Map<Integer, Integer> record = new HashMap<>();
    record.put(0, 1);
    int sum = 0, ans = 0;
    for (int elem : A) {
      sum += elem;
      // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
      int modulus = (sum % K + K) % K;
      int same = record.getOrDefault(modulus, 0);
      ans += same;
      record.put(modulus, same + 1);
    }
    return ans;
  }
//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/solution/he-ke-bei-k-zheng-chu-de-zi-shu-zu-by-leetcode-sol/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  public int subarraysDivByK(int[] A, int K) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum = sum + A[i];
      int rem = (sum % K + K) % K;
      if (map.containsKey(rem)) {
        int n = map.get(rem);
        res += n;
        map.put(rem, n + 1);
      } else {
        map.put(rem, 1);
      }
    }

    return res;
  }

  public int subarraysDivByK1(int[] A, int K) {
    int res = 0;
    int[] p = new int[A.length];
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum = sum + A[i];
      p[i] = sum;
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = i; j < A.length; j++) {
        int first = i - 1 >= 0 ? p[i - 1] : 0;
        int gap = p[j] - first;
        if (gap % K == 0) {
          res++;
        }
      }
    }
    return res;
  }
}

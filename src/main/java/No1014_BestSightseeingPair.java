public class No1014_BestSightseeingPair {
//  Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.
//
//  The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.
//
//  Return the maximum score of a pair of sightseeing spots.
//
//   
//
//  Example 1:
//
//  Input: [8,1,5,2,6]
//  Output: 11
//  Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
//
//   
//
//  Note:
//
//      2 <= A.length <= 50000
//      1 <= A[i] <= 1000

  public static void main(String[] args) {
    No1014_BestSightseeingPair test = new No1014_BestSightseeingPair();
  }

  public int maxScoreSightseeingPair(int[] A) {
    if (A == null || A.length == 0 || A.length == 1) {
      return 0;
    }
    int[] a = new int[A.length];
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      a[i] = A[i] - i;
    }
    int max = a[0];
    for (int i = 1; i < a.length; i++) {
      res = Math.max(res, max + a[i]);
      max = Math.max(max, a[i] + 2 * i);
    }
    return res;
  }
}

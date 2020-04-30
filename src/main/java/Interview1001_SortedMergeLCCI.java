import java.util.Arrays;

public class Interview1001_SortedMergeLCCI {
//  You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
//
//  Initially the number of elements in A and B are m and n respectively.
//
//  Example:
//
//  Input:
//  A = [1,2,3,0,0,0], m = 3
//  B = [2,5,6],       n = 3
//
//  Output: [1,2,2,3,5,6]
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/sorted-merge-lcci
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Interview1001_SortedMergeLCCI test = new Interview1001_SortedMergeLCCI();
  }

  public void merge(int[] A, int m, int[] B, int n) {
    for (int i = A.length - 1, j = 0; j < B.length; i--, j++) {
      A[i] = B[j];
    }
    Arrays.sort(A);

  }
}

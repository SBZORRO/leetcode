

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution_DivTargetNumToSequenceNum {
//  面试题57 - II. 和为s的连续正数序列
//
//  输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//  序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//   
//
//  示例 1：
//
//  输入：target = 9
//  输出：[[2,3,4],[4,5]]
//
//  示例 2：
//
//  输入：target = 15
//  输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//
//   
//
//  限制：
//
//      1 <= target <= 10^5

  public static void main(String[] args) {
    Solution_DivTargetNumToSequenceNum solution_DivTargetNumToSequenceNum = new Solution_DivTargetNumToSequenceNum();
    int arr[][] = solution_DivTargetNumToSequenceNum.findContinuousSequence(75);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println("\n");
    }
  }

  public int[][] findContinuousSequence(int target) {
    ArrayList<int[]> result = new ArrayList<int[]>();
    HashMap<Integer, Integer> divisors = findDivisors(target);
    for (Map.Entry<Integer, Integer> entry : divisors.entrySet()) {
      boolean isKeyOdd = isOdd(entry.getKey());
      boolean isValOdd = isOdd(entry.getValue());

      if (target % 2 != 0) {
        int[] seq0 = divOddMid(1, target);
        checkAndAdd(result, seq0);
      }
      if (isKeyOdd == false && isValOdd == false) {
        continue;
      } else if (isKeyOdd == true && isValOdd == true) {
        if (entry.getKey() == entry.getValue()) {
          int[] seq1 = oddLen(entry.getKey(), entry.getValue());
          int[] seq6 = divOddMid(entry.getValue(), entry.getKey());
          checkAndAdd(result, seq1);
          checkAndAdd(result, seq6);
        } else if (entry.getKey() != entry.getValue()) {
          int[] seq1 = oddLen(entry.getKey(), entry.getValue());
          int[] seq2 = oddLen(entry.getValue(), entry.getKey());
          int[] seq5 = divOddMid(entry.getKey(), entry.getValue());
          int[] seq6 = divOddMid(entry.getValue(), entry.getKey());
          checkAndAdd(result, seq1);
          checkAndAdd(result, seq2);
          checkAndAdd(result, seq5);
          checkAndAdd(result, seq6);
        }
      } else if (isKeyOdd == true || isValOdd == true) {
        int odd = 0;
        int even = 0;
        if (isKeyOdd) {
          odd = entry.getKey();
          even = entry.getValue();
        } else {
          odd = entry.getValue();
          even = entry.getKey();
        }
        int[] seq3 = oddLen(odd, even);
        int[] seq4 = divOddMid(even, odd);
        checkAndAdd(result, seq3);
        checkAndAdd(result, seq4);
      }
    }
    result.sort((int[] i, int[] j) -> {
      return i[0] < j[0] ? -1 : 1;
    });
    int[][] resultarr = new int[result.size()][];
    int indi = 0;
    for (int[] i : result) {
      resultarr[indi] = i;
      indi++;
    }
    return resultarr;
  }

  public void checkAndAdd(ArrayList<int[]> list, int[] arr) {
    if (arr[0] > 0) {
      list.add(arr);
    }
  }

  public int[] oddLen(int l, int mid) {
    int[] seq = new int[l];
    seq[l / 2] = mid;
    for (int i = l / 2, j = 0; i >= 1; i--, j++) {
      seq[j] = mid - i;
      seq[l - j - 1] = mid + i;
    }
    return seq;
  }

  public int[] oddLenDivMid(int l, int mid) {
    int[] midTwo = minConSeqOfAnOdd(mid);
    int[] seq = new int[l * 2];
    for (int i = 0; i < l; i++) {
      seq[l - i - 1] = midTwo[0] - i;
      seq[l + i] = midTwo[1] + i;
    }
    return seq;

  }

  public int[] divOddMid(int l, int mid) {
    int[] midTwo = minConSeqOfAnOdd(mid);
    int[] seq = new int[l * 2];
    for (int i = 0; i < l; i++) {
      seq[l - i - 1] = midTwo[0] - i;
      seq[l + i] = midTwo[1] + i;
    }
    return seq;
  }

  public HashMap<Integer, Integer> findDivisors(int target) {
    HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
    for (int i = 2; i <= ((int) Math.sqrt(target)); i++) {
      int remd = target % i;
      int r = target / i;
      if (remd == 0) {
        list.put(i, r);
      }
    }
    return list;
  }

  public int[] minConSeqOfAnOdd(int i) {
    int[] arr = new int[2];
    arr[0] = i / 2;
    arr[1] = arr[0] + 1;
    return arr;
  }

  public boolean isOdd(int i) {
    return i % 2 == 0 ? false : true;
  }
}

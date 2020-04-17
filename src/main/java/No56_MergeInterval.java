import java.util.LinkedList;
import java.util.List;

public class No56_MergeInterval {
//  Given a collection of intervals, merge all overlapping intervals.
//
//  Example 1:
//
//  Input: [[1,3],[2,6],[8,10],[15,18]]
//  Output: [[1,6],[8,10],[15,18]]
//  Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//  Example 2:
//
//  Input: [[1,4],[4,5]]
//  Output: [[1,5]]
//  Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//  NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/merge-intervals
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No56_MergeInterval test = new No56_MergeInterval();
    System.out.println(test.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
    System.out.println(test.merge(new int[][] { { 1, 4 }, { 4, 5 } }));
    System.out.println(test.merge(new int[][] { { 1, 3 }, { 4, 5 } }));
    System.out.println(test.merge(new int[][] { { 1, 3 }, { 0, 0 } }));
    System.out.println(test.merge(new int[][] { { 1, 3 }, { 3, 3 }, { 4, 7 } }));
    System.out
        .println(test.merge(new int[][] { { 2, 3 }, { 5, 5 }, { 2, 2 }, { 3, 4 }, { 3, 4 } }));

  }

  public int[][] merge(int[][] intervals) {
    int len = 0;
    for (int i = 0; i < intervals.length; i++) {
      len = Math.max(len, intervals[i][1]);
    }
    int[] res = new int[len + 1];

    for (int i = 0; i < intervals.length; i++) {
      int[] item = intervals[i];
      if (item[0] == item[1] && res[item[0]] == 0) {
        res[item[0]] = 2;
        continue;
      }
      for (int j = item[0]; j < item[1]; j++) {
        res[j] = 1;
      }
    }
    List<int[]> list = new LinkedList<>();
    int i = 0;

    while (i <= len) {
      if (res[i] == 0) {
        i++;
        continue;
      }
      int[] item = new int[2];
      item[0] = i;
      if (res[i] == 2) {
        item[1] = i;
        i++;
      } else {
        while (i <= len && res[i] == 1) {
          i++;
        }
        item[1] = i;
        if (res[i] == 2) {
          i++;
        }
      }
      list.add(item);

    }
    int[][] ans = new int[list.size()][2];
    for (int j = 0; j < list.size(); j++) {
      ans[j] = list.get(j);
    }
    return ans;
  }
}
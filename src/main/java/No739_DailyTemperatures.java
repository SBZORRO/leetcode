import java.util.LinkedList;

public class No739_DailyTemperatures {
//  Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
//
//      For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//
//      Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/daily-temperatures
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No739_DailyTemperatures test = new No739_DailyTemperatures();
    test.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
  }

  public int[] dailyTemperatures(int[] T) {
    int[] res = new int[T.length];

    for (int i = T.length - 2; i >= 0; i--) {
      int j = i + 1;
      while (true) {
        if (T[i] < T[j]) {
          res[i] = j - i;
          break;
        } else if (res[j] == 0) {
          res[i] = 0;
          break;
        }
        j = j + res[j];
      }
    }
    return res;
  }

  public int[] dailyTemperatures3(int[] T) {
    int[] res = new int[T.length];
    LinkedList<Integer> li = new LinkedList<>();
    for (int i = 0; i < T.length; i++) {
      while (li.size() > 0 && T[li.getFirst()] < T[i]) {
        int top = li.pop();
        res[top] = i - top;
      }
      li.addFirst(i);
    }
    return res;
  }

  public int[] dailyTemperatures2(int[] T) {
    int[] res = new int[T.length];
    int[] range = new int[71];
    for (int i = T.length - 1; i >= 0; i--) {
      res[i] = range[T[i] - 30] == 0 ? 0 : range[T[i] - 30] - i;
      for (int j = 0; j < T[i] - 30; j++) {
        range[j] = range[j] == 0 ? i : Math.min(range[j], i);
      }
    }
    return res;
  }

  // how many warmer days in the future >_<
  public int[] dailyTemperatures1(int[] T) {
    int[] res = new int[T.length];
    int[] range = new int[71];
    for (int i = T.length - 1; i >= 0; i--) {
      res[i] = range[T[i] - 30];
      for (int j = 0; j < T[i] - 30; j++) {
        range[j]++;
      }
    }
    return res;
  }
}

import java.util.LinkedList;
import java.util.List;

public class No119_PascalsTriangle2 {
//  Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//
//      Note that the row index starts from 0.
//
//
//      In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//      Example:
//
//      Input: 3
//      Output: [1,3,3,1]
//
//      Follow up:
//
//      Could you optimize your algorithm to use only O(k) extra space?
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/pascals-triangle-ii
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No119_PascalsTriangle2 test = new No119_PascalsTriangle2();
    test.generate(6);

  }

  public List<Integer> generate(int numRows) {
    numRows++;
    LinkedList<Integer> li = new LinkedList<>();
    if (numRows == 0) {
      return li;
    }

    li.add(1);
    if (numRows == 1) {
      return li;
    }
    li.add(1);
    if (numRows == 2) {
      return li;
    }
    int p = 1;
    int c = 1;
    for (int j = 2; j < numRows; j++) {
      for (int i = 1; i < j; i++) {
        p = c;
        c = i >= li.size() ? 0 : li.get(i);
        li.set(i, p + c);
      }
      li.add(1);
    }
    return li;
  }
}

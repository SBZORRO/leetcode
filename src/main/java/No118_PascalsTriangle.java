import java.util.LinkedList;
import java.util.List;

public class No118_PascalsTriangle {
//  Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
//  In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//  Example:
//
//  Input: 5
//  Output:
//  [
//       [1],
//      [1,1],
//     [1,2,1],
//    [1,3,3,1],
//   [1,4,6,4,1]
//  ]
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/pascals-triangle
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No118_PascalsTriangle test = new No118_PascalsTriangle();
    test.generate(5);

  }

  public List<List<Integer>> generate(int numRows) {
    LinkedList<List<Integer>> lis = new LinkedList<>();
    if (numRows == 0) {
      return lis;
    }
    List<Integer> li = new LinkedList<>();
    li.add(1);
    lis.add(li);
    if (numRows == 1) {
      return lis;
    }
    li = new LinkedList<>();
    li.add(1);
    li.add(1);
    lis.add(li);
    if (numRows == 2) {
      return lis;
    }
    for (int i = 2; i < numRows; i++) {
      lis.addLast(new LinkedList<Integer>());
    }
    LinkedList<Integer> prev = (LinkedList<Integer>) lis.get(1);
    LinkedList<Integer> cur = null;
    int p = 0;
    int c = 0;
    for (int j = 2; j < numRows; j++) {
      cur = (LinkedList<Integer>) lis.get(j);
      for (int i = 0; i <= j; i++) {
        p = i - 1 >= 0 ? prev.get(i - 1) : 0;
        c = i >= prev.size() ? 0 : prev.get(i);
        cur.add(p + c);
      }
      prev = cur;

    }
    return lis;
  }
}

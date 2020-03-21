public class No836_RectangleOverlap {
//  Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//  Example 1:
//
//  Input: "babad"
//  Output: "bab"
//  Note: "aba" is also a valid answer.
//
//  Example 2:
//
//  Input: "cbbd"
//  Output: "bb"
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No836_RectangleOverlap test = new No836_RectangleOverlap();
    System.out.println(test.isRectangleOverlap(new int[] { 0, 0, 2, 2 }, new int[] { 1, 1, 3, 3 }));
    System.out.println(test.isRectangleOverlap(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 }));
    System.out
        .println(test.isRectangleOverlap(new int[] { 7, 8, 13, 15 }, new int[] { 10, 8, 12, 20 }));

  }

//  思路
//
//  如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形与 xxx 轴平行的边（水平边）投影到 xxx 轴上时会有交集，与 yyy 轴平行的边（竖直边）投影到 yyy 轴上时也会有交集。因此，我们可以将问题看作一维线段是否有交集的问题。
//
//  算法
//
//  矩形 rec1 和 rec2 的水平边投影到 xxx 轴上的线段分别为 (rec1[0], rec1[2]) 和 (rec2[0], rec2[2])。根据数学知识我们可以知道，当 min(rec1[2], rec2[2]) > max(rec1[0], rec2[0]) 时，这两条线段有交集。对于矩形 rec1 和 rec2 的竖直边投影到 yyy 轴上的线段，同理可以得到，当 min(rec1[3], rec2[3]) > max(rec1[1], rec2[1]) 时，这两条线段有交集。
//
//  作者：LeetCode-Solution
//  链接：https://leetcode-cn.com/problems/rectangle-overlap/solution/ju-xing-zhong-die-by-leetcode-solution/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
        && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
  }

  public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
    // left bottom right top
    return !(rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3]);
  }

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/rectangle-overlap/solution/ju-xing-zhong-die-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
    int[] temp;
    if ((rec1[0] > rec2[0]) || (rec1[0] == rec2[0] && rec1[2] > rec2[2])) {
      temp = rec1;
      rec1 = rec2;
      rec2 = temp;
    }
    boolean ol1 = false;
    boolean ol2 = false;
    if ((rec1[2] > rec2[0])) {
      ol1 = true;
    }
    if (rec1[1] > rec2[1] || (rec1[1] == rec2[1] && rec1[3] > rec2[3])) {
      temp = rec1;
      rec1 = rec2;
      rec2 = temp;
    }
    if (rec1[3] > rec2[1]) {
      ol2 = true;
    }
    return ol1 && ol2;
  }
}
public class No84_LargestRectangleInHistogram {
//  Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//  
//
//
//  Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//   
//
//
//  The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//   
//
//  Example:
//
//  Input: [2,1,5,6,2,3]
//  Output: 10
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No84_LargestRectangleInHistogram test = new No84_LargestRectangleInHistogram();
    test.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 });

  }

  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    int res = Integer.MIN_VALUE;

    for (int i = 0; i < heights.length; i++) {
      min = Integer.MAX_VALUE;
      for (int j = i; j < heights.length; j++) {
        min = Math.min(min, heights[j]);
        res = Math.max(res, min * (j - i + 1));
      }
    }
    return res;
  }
}

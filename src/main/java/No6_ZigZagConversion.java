public class No6_ZigZagConversion {
//  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//  P   A   H   N
//  A P L S I I G
//  Y   I   R
//
//  And then read line by line: "PAHNAPLSIIGYIR"
//
//  Write the code that will take a string and make this conversion given a number of rows:
//
//  string convert(string s, int numRows);
//
//  Example 1:
//
//  Input: s = "PAYPALISHIRING", numRows = 3
//  Output: "PAHNAPLSIIGYIR"
//
//  Example 2:
//
//  Input: s = "PAYPALISHIRING", numRows = 4
//  Output: "PINALSIGYAHRPI"
//  Explanation:
//
//  P     I    N
//  A   L S  I G
//  Y A   H R
//  P     I
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/zigzag-conversion
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No6_ZigZagConversion test = new No6_ZigZagConversion();
    System.out.println(test.convert("PAYPALISHIRING", 3));
    System.out.println(test.convert("PAYPALISHIRING", 4));
  }

  public String convert(String s, int numRows) {
    if (s == null || s.length() == 0 || numRows == 0) {
      return "";
    }
    if (numRows == 1) {
      return s;
    }
    int gap = numRows + (numRows - 2);
    int[] gaps = new int[2];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      int indi = 0;
      gaps = i == 0 || i == numRows - 1 ? new int[] { gap, gap } : new int[] { gap - i * 2, i * 2 };
      for (int j = i; j < s.length();) {
        sb.append(s.charAt(j));
        j += gaps[indi];
        indi = indi == 0 ? 1 : 0;
      }
    }
    return sb.toString();
  }
}

public class No171_ExcelSheetColumnNumber {
//  Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//      For example:
//
//          A -> 1
//          B -> 2
//          C -> 3
//          ...
//          Z -> 26
//          AA -> 27
//          AB -> 28 
//          ...
//
//      Example 1:
//
//      Input: "A"
//      Output: 1
//
//      Example 2:
//
//      Input: "AB"
//      Output: 28
//
//      Example 3:
//
//      Input: "ZY"
//      Output:
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/excel-sheet-column-number
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No171_ExcelSheetColumnNumber test = new No171_ExcelSheetColumnNumber();
  }

  public int titleToNumber(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    char c = 0;
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      res = res + (int) ((c - 'A' + 1) * Math.pow(26, s.length() - 1 - i));
    }
    return res;
  }
}
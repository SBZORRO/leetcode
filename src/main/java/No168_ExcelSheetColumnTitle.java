public class No168_ExcelSheetColumnTitle {
//  Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//      For example:
//
//          1 -> A
//          2 -> B
//          3 -> C
//          ...
//          26 -> Z
//          27 -> AA
//          28 -> AB 
//          ...
//
//      Example 1:
//
//      Input: 1
//      Output: "A"
//
//      Example 2:
//
//      Input: 28
//      Output: "AB"
//
//      Example 3:
//
//      Input: 701
//      Output: "ZY"
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/excel-sheet-column-title
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No168_ExcelSheetColumnTitle test = new No168_ExcelSheetColumnTitle();
    System.out.println(test.convertToTitle(12));
    System.out.println(test.convertToTitle(26));
    System.out.println(test.convertToTitle(27));
    System.out.println(test.convertToTitle(28));
    System.out.println(test.convertToTitle(52));
    System.out.println(test.convertToTitle(701));
  }

  public String convertToTitle(int n) {
    if (n == 0) {
      return "";
    }

    char[] c = new char[] { 0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    int div = n / 26;
    int rem = n % 26;
    StringBuilder sb = new StringBuilder();

    while (div != 0) {
      if (rem == 0) {
        sb.append('Z');
        div--;
      } else {
        sb.append(c[rem]);
      }
      rem = div % 26;
      div = div / 26;
    }
    if (div == 0 && rem != 0) {
      sb.append(c[rem]);
    }
    return sb.reverse().toString();
  }
}
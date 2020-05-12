class No193_ValidPhoneNumbers {
//  Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.
//
//  You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)
//
//  You may also assume each line in the text file must not contain leading or trailing white spaces.
//
//  Example:
//
//  Assume that file.txt has the following content:
//
//  987-123-4567
//  123 456 7890
//  (123) 456-7890
//
//  Your script should output the following valid phone numbers:
//
//  987-123-4567
//  (123) 456-7890
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/valid-phone-numbers
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No193_ValidPhoneNumbers test = new No193_ValidPhoneNumbers();
    test.hammingWeight(11);
  }

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int op = 1;
    int count = 0;
    for (int i = 0; i < 32; op = op << 1, i++) {
      if ((op & n) == op) {
        count++;
      }
    }
    return count;
  }
}

import java.util.Arrays;

public class AllSorting {

  public static void main(String[] args) {
    AllSorting test = new AllSorting();
//    System.out.println(test.insertion(new int[] { 2, 1, 8, 6, 3, 7, 9 }));
//    System.out.println(test.selection(new int[] { 2, 1, 8, 6, 3, 7, 9 }));
    System.out.println(test.merge(new int[] { 2, 1, 8, 6, 3, 7, 9 }));
  }

  public int[] insertion(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int temp = a[i];
      for (int j = i - 1; j >= 0; j--) {
        if (temp < a[j]) {
          a[j + 1] = a[j];
        } else {
          break;
        }
        a[j] = temp;
      }
    }
    return a;
  }

  public int[] selection(int[] a) {
    int max = 0;
    int temp = 0;
    for (int i = a.length - 1; i > 0; i--) {
      max = 0;
      temp = 0;
      for (int j = 0; j <= i; j++) {
        if (a[j] > a[max]) {
          max = j;
        }
      }
      temp = a[i];
      a[i] = a[max];
      a[max] = temp;
    }
    return a;
  }

  public int[] merge(int[] a) {
    int[] aa = merge(
        Arrays.copyOfRange(a, 0, a.length / 2),
        Arrays.copyOfRange(a, a.length / 2, a.length));
    return aa;
  }

  public int[] merge(int[] a, int[] b) {
    if (a.length > 1 || b.length > 1) {
      a = merge(a);
      b = merge(b);
      System.currentTimeMillis();
    }
    int[] res = new int[a.length + b.length];
    if (a.length == 0) {
      return b;
    }
    if (b.length == 0) {
      return a;
    }
    for (int i = 0, j = 0; i < a.length || j < b.length;) {
      if (i == a.length) {
        res[i + j] = b[j];
        j++;
      } else if (j == b.length) {
        res[i + j] = a[i];
        i++;
      } else if (a[i] < b[j]) {
        res[i + j] = a[i];
        i++;
      } else {
        res[i + j] = b[j];
        j++;
      }
    }
    return res;
  }
}

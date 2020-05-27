import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class No460_LFUCache {
//  Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
//
//  get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//  put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
//
//  Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
//
//   
//
//  Follow up:
//  Could you do both operations in O(1) time complexity?
//
//   
//
//  Example:
//
//  LFUCache cache = new LFUCache( 2 /* capacity */ );
//
//  cache.put(1, 1);
//  cache.put(2, 2);
//  cache.get(1);       // returns 1
//  cache.put(3, 3);    // evicts key 2
//  cache.get(2);       // returns -1 (not found)
//  cache.get(3);       // returns 3.
//  cache.put(4, 4);    // evicts key 1.
//  cache.get(1);       // returns -1 (not found)
//  cache.get(3);       // returns 3
//  cache.get(4);       // returns 4
//
//   
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/lfu-cache
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    LFUCache test = new LFUCache(10);

    test.put(10, 13);
    test.put(3, 17);
    test.put(6, 11);
    test.put(10, 5);
    test.put(9, 10);
    test.get(13);
    test.put(2, 19);
    test.get(2);
    test.get(3);
    test.put(5, 25);
    test.get(8);
    test.put(9, 22);
    test.put(5, 5);
    test.put(1, 30);
    test.get(11);
    test.put(9, 12);
    test.get(7);
    test.get(5);
    test.get(8);
    test.get(9);
    test.put(4, 30);
    test.put(9, 3);
    test.get(9);
    test.get(10);
    test.get(10);
    test.put(6, 14);
    test.put(3, 1);
    test.get(3);
    test.put(10, 11);
    test.get(8);
    test.put(2, 14);
    test.get(1);
    test.get(5);
    test.get(4);
    test.put(11, 4);
    test.put(12, 24);
    test.put(5, 18);
    test.get(13);
    test.put(7, 23);
    test.get(8);
    test.get(12);
    test.put(3, 27);
    test.put(2, 12);
    test.get(5);
    test.put(2, 9);
    test.put(13, 4);
    test.put(8, 18);
    test.put(1, 7);
    test.get(6);
    test.put(9, 29);
    test.put(8, 21);
    test.get(5);
    test.put(6, 30);
    test.put(1, 12);
    test.get(10);
    test.put(4, 15);
    test.put(7, 22);
    test.put(11, 26);
    test.put(8, 17);
    test.put(9, 29);
    test.get(5);
    test.put(3, 4);
    test.put(11, 30);
    test.get(12);
    test.put(4, 29);
    test.get(3);
    test.get(9);
    test.get(6);
    test.put(3, 4);
    test.get(1);
    test.get(10);
    test.put(3, 29);
    test.put(10, 28);
    test.put(1, 20);
    test.put(11, 13);
    test.get(3);
    test.put(3, 12);
    test.put(3, 8);
    test.put(10, 9);
    test.put(3, 26);
    test.get(8);
    test.get(7);
    test.get(5);
    test.put(13, 17);
    test.put(2, 27);
    test.put(11, 15);
    test.get(12);
    test.put(9, 19);
    test.put(2, 15);
    test.put(3, 16);
    test.get(1);
    test.put(12, 17);
    test.put(9, 1);
    test.put(6, 19);
    test.get(4);
    test.get(5);
    test.get(5);
    test.put(8, 1);
    test.put(11, 7);
    test.put(5, 2);
    test.put(9, 28);
    test.get(1);
    test.put(2, 2);
    test.put(7, 4);
    test.put(4, 22);
    test.put(7, 24);
    test.put(9, 26);
    test.put(13, 28);
    test.put(11, 26);

    String[] s = new String[] { "LFUCache", "put", "put", "put", "put", "put", "get", "put", "get",
        "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put",
        "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get",
        "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put",
        "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put",
        "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put",
        "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put",
        "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put",
        "put", "put", "get", "put", "put", "put", "put", "put", "put", "put" };
    int[][] data = new int[][] { { 10 }, { 10, 13 }, { 3, 17 }, { 6, 11 }, { 10, 5 }, { 9, 10 },
        { 13 }, { 2, 19 }, { 2 }, { 3 }, { 5, 25 }, { 8 }, { 9, 22 }, { 5, 5 }, { 1, 30 }, { 11 },
        { 9, 12 }, { 7 }, { 5 }, { 8 }, { 9 }, { 4, 30 }, { 9, 3 }, { 9 }, { 10 }, { 10 },
        { 6, 14 }, { 3, 1 }, { 3 }, { 10, 11 }, { 8 }, { 2, 14 }, { 1 }, { 5 }, { 4 }, { 11, 4 },
        { 12, 24 }, { 5, 18 }, { 13 }, { 7, 23 }, { 8 }, { 12 }, { 3, 27 }, { 2, 12 }, { 5 },
        { 2, 9 }, { 13, 4 }, { 8, 18 }, { 1, 7 }, { 6 }, { 9, 29 }, { 8, 21 }, { 5 }, { 6, 30 },
        { 1, 12 }, { 10 }, { 4, 15 }, { 7, 22 }, { 11, 26 }, { 8, 17 }, { 9, 29 }, { 5 }, { 3, 4 },
        { 11, 30 }, { 12 }, { 4, 29 }, { 3 }, { 9 }, { 6 }, { 3, 4 }, { 1 }, { 10 }, { 3, 29 },
        { 10, 28 }, { 1, 20 }, { 11, 13 }, { 3 }, { 3, 12 }, { 3, 8 }, { 10, 9 }, { 3, 26 }, { 8 },
        { 7 }, { 5 }, { 13, 17 }, { 2, 27 }, { 11, 15 }, { 12 }, { 9, 19 }, { 2, 15 }, { 3, 16 },
        { 1 }, { 12, 17 }, { 9, 1 }, { 6, 19 }, { 4 }, { 5 }, { 5 }, { 8, 1 }, { 11, 7 }, { 5, 2 },
        { 9, 28 }, { 1 }, { 2, 2 }, { 7, 4 }, { 4, 22 }, { 7, 24 }, { 9, 26 }, { 13, 28 },
        { 11, 26 } };

    for (int i = 1; i < s.length; i++) {
      if ("put".equals(s[i])) {
        System.out.println("test.put(" + data[i][0] + "," + data[i][1] + ");");
      } else if ("get".equals(s[i])) {
        System.out.println("test.get(" + data[i][0] + ");");
      }
    }

//    LFUCache test = new LFUCache(1);
//    test.put(3, 1);
//    test.put(2, 1);
//    test.put(2, 2);
//    test.put(4, 4);
//    test.get(2);

    test.put(1, 1);
    test.put(2, 2);
    test.get(1);
    test.put(3, 3);
    test.get(2);
    test.get(3);
    test.put(4, 4);
    test.get(1);
    test.get(3);
    test.get(2);
    test.get(4);

//    test.put(2, 1);
//    test.get(2);
//    test.put(3, 2);
//    test.get(2);
//    test.get(3);
//    String[] s = new String[] { "LFUCache", "put", "get", "put", "get", "get", "get", "put", "get",
//        "put", "put", "put", "put", "put", "put",
//        "get", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put", "get", "put",
//        "put", "put", "put",
//        "put", "put", "get", "put", "put", "get", "put", "get", "put", "get", "put", "put", "get",
//        "put", "put", "put",
//        "get", "get", "put", "put", "get", "put", "get", "get", "get", "get", "put", "get", "put",
//        "put", "put", "get",
//        "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "get", "get", "get",
//        "put", "get", "put",
//        "get", "put", "put", "get", "get", "get", "get", "get", "get", "put", "put", "get", "get",
//        "put", "get", "put",
//        "put", "get", "get", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put",
//        "get", "put", "put",
//        "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "get", "put", "put",
//        "get", "get", "put",
//        "put", "put", "put", "put", "put", "put", "get", "put", "put", "get", "get", "put", "put",
//        "put", "put", "put",
//        "put", "put", "put", "put", "put", "put", "get", "put", "get", "get", "get", "put", "put",
//        "put", "put", "put",
//        "get", "put", "put", "get", "put", "put", "get", "put", "get", "put", "get", "put", "get",
//        "get", "get", "get",
//        "put", "get", "get", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put",
//        "put", "get", "get",
//        "get", "put", "get", "get", "get", "get", "put", "get", "put", "put", "get", "get", "put",
//        "put", "get", "get",
//        "put", "put", "put", "get", "put", "get", "get", "put", "put", "put", "get", "put", "get",
//        "put", "get", "put",
//        "get", "put", "get", "put", "put", "get", "put", "put", "get", "put", "get", "get", "put",
//        "get", "get", "get",
//        "put", "get", "put", "put", "put", "put", "get", "get", "put", "get", "put", "get", "put",
//        "get", "put", "get",
//        "get", "get", "get", "get", "put", "put", "get", "put", "get", "put", "put", "get", "get",
//        "put", "get", "get",
//        "put", "get", "put", "put", "get", "put", "put", "get", "get", "put", "put", "get", "get",
//        "put", "get", "put",
//        "put", "get", "put", "put", "put", "get", "put", "put", "get", "get", "get", "get", "put",
//        "put", "get", "get",
//        "put", "put", "get", "put", "put", "put", "put", "get", "put", "get", "put", "get", "get",
//        "put", "get", "put",
//        "put", "get", "get", "put", "get", "put", "put", "get", "put", "get", "put", "put", "put",
//        "put", "get", "get",
//        "get", "put", "put", "put", "put", "get", "get", "put", "put", "get", "put", "put", "get",
//        "put", "put", "get",
//        "put", "put", "put", "put", "put", "get", "get", "put", "put", "put", "get", "put", "get",
//        "get", "put", "put",
//        "get", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put",
//        "put", "get", "get",
//        "put", "put", "put", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put",
//        "get", "put", "put",
//        "get", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put",
//        "put", "put", "put",
//        "put", "get", "put", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get",
//        "put", "get", "get",
//        "put", "get", "put", "put", "get", "get", "get", "get", "get", "put", "put", "put", "get",
//        "put", "get", "put",
//        "get", "get", "get", "put", "get", "put", "put", "put", "get", "get", "get", "get", "put",
//        "put", "put", "put",
//        "put", "put", "get", "get", "put", "put", "get", "put", "put", "get", "put", "get", "get",
//        "get", "get", "put",
//        "get", "get", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put",
//        "get", "put", "put",
//        "get", "put", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put",
//        "put", "get", "put",
//        "put", "put", "put", "put", "put", "get", "get", "put", "get", "get", "get", "get", "get",
//        "put", "put", "put",
//        "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "put", "put", "get",
//        "put", "put", "get",
//        "put", "put", "get", "get", "get", "get", "put", "put", "put", "get", "get", "put", "get",
//        "put", "put", "put",
//        "put", "get", "put", "put", "get", "get", "put", "put", "put", "put", "put", "put", "put",
//        "put", "put", "get",
//        "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "get", "get", "put",
//        "get", "put", "get",
//        "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put",
//        "get", "get", "put",
//        "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "get", "put",
//        "get", "put", "put",
//        "put", "put", "get", "put", "put", "put", "put", "get", "get", "put", "put", "get", "get",
//        "put", "put", "put",
//        "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get",
//        "put", "get", "get",
//        "put", "put", "put", "put", "put", "get", "get", "put", "put", "put", "get", "put", "put",
//        "put", "put", "get",
//        "put", "put", "get", "get", "put", "put", "get", "get", "put", "put", "get", "put", "put",
//        "put", "put", "get",
//        "get", "get", "get", "put", "get", "get", "put", "put", "put", "get", "get", "put", "put",
//        "get", "get", "get",
//        "put", "get", "get", "get", "put", "get", "get", "get", "put", "put", "put", "put", "get",
//        "put", "put", "put",
//        "get", "get", "put", "get", "put", "put", "get", "get", "put", "get", "get", "get", "get",
//        "put", "put", "put",
//        "put", "put", "put", "put", "put", "get", "get", "put", "put", "put", "get", "put", "get",
//        "get", "get", "put",
//        "put", "get", "put", "put", "put", "put", "put", "put", "get", "put", "put", "put", "put",
//        "get", "put", "put",
//        "get", "put", "get", "put", "get", "put", "get", "put", "get", "put", "put", "put", "get",
//        "put", "get", "get",
//        "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "put",
//        "put", "put", "put",
//        "get", "put", "put", "put", "put", "put", "put", "get", "get", "put", "put", "put", "put",
//        "put", "put", "get",
//        "put", "put", "put", "get", "get", "put", "put", "put", "put", "put", "put", "put", "put",
//        "put", "get", "put",
//        "put", "get", "get", "get", "get", "put", "put", "get", "put", "get", "get", "get", "put",
//        "put", "put", "put",
//        "put", "put", "put", "get", "get", "put", "put", "put", "put", "put", "get", "get", "put",
//        "put", "get", "put",
//        "get", "put", "put", "put", "get", "put", "get", "put", "get", "get", "put", "get", "get",
//        "get", "put", "put",
//        "put", "put", "get", "put", "get", "put", "put", "put", "put", "put", "put", "get", "put",
//        "put", "get", "put",
//        "put", "get", "put", "put", "put",
//        "put", "get", "put", "put", "get", "get", "put", "put", "put", "put", "get", "put", "get",
//        "put", "put", "put",
//        "put", "put", "put",
//        "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "get",
//        "get", "put", "put",
//        "put", "put", "get", "put", "get",
//        "get", "get", "put", "get", "get", "put", "get", "put", "get", "put", "put", "get", "put",
//        "get", "get", "get",
//        "get", "put", "put", "get", "put",
//        "get", "get", "get", "get", "put", "put", "put", "get", "put", "get", "put", "get",
//        "put", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "get", "put",
//        "put", "put", "get",
//        "put", "get", "put", "put", "get", "put", "get", "put", "get", "put", "get", "get", "put",
//        "get", "get", "put",
//        "put", "put", "get", "put", "put", "get", "get", "put", "get", "put", "get", "put", "put",
//        "get", "get" };
//    int[][] data = new int[][] { { 105 }, { 33, 219 }, { 39 }, { 96, 56 }, { 129 }, { 115 },
//        { 112 }, { 3, 280 }, { 40 }, { 85, 193 }, { 10, 10 }, { 100, 136 }, { 12, 66 }, { 81, 261 },
//        { 33, 58 }, { 3 }, { 121, 308 }, { 129, 263 }, { 105 }, { 104, 38 }, { 65, 85 }, { 3, 141 },
//        { 29, 30 }, { 80, 191 }, { 52, 191 }, { 8, 300 }, { 136 }, { 48, 261 }, { 3, 193 },
//        { 133, 193 }, { 60, 183 }, { 128, 148 }, { 52, 176 }, { 48 }, { 48, 119 }, { 10, 241 },
//        { 124 }, { 130, 127 }, { 61 }, { 124, 27 }, { 94 }, { 29, 304 }, { 102, 314 }, { 110 },
//        { 23, 49 }, { 134, 12 }, { 55, 90 }, { 14 }, { 104 }, { 77, 165 }, { 60, 160 }, { 117 },
//        { 58, 30 }, { 54 }, { 136 }, { 128 }, { 131 }, { 48, 114 }, { 136 }, { 46, 51 },
//        { 129, 291 }, { 96, 207 }, { 131 }, { 89, 153 }, { 120, 154 }, { 111 }, { 47 }, { 5 },
//        { 114, 157 }, { 57, 82 }, { 113, 106 }, { 74, 208 }, { 56 }, { 59 }, { 100 }, { 132 },
//        { 127, 202 }, { 75 }, { 102, 147 }, { 37 }, { 53, 79 }, { 119, 220 }, { 47 }, { 101 },
//        { 89 }, { 20 }, { 93 }, { 7 }, { 48, 109 }, { 71, 146 }, { 43 }, { 122 }, { 3, 160 },
//        { 17 }, { 80, 22 }, { 80, 272 }, { 75 }, { 117 }, { 76, 204 }, { 74, 141 }, { 107, 93 },
//        { 34, 280 }, { 31, 94 }, { 132 }, { 71, 258 }, { 61 }, { 60 }, { 69, 272 }, { 46 },
//        { 42, 264 }, { 87, 126 }, { 107, 236 }, { 131, 218 }, { 79 }, { 41, 71 }, { 94, 111 },
//        { 19, 124 }, { 52, 70 }, { 131 }, { 103 }, { 81 }, { 126 }, { 61, 279 }, { 37, 100 },
//        { 95 }, { 54 }, { 59, 136 }, { 101, 219 }, { 15, 248 }, { 37, 91 }, { 11, 174 }, { 99, 65 },
//        { 105, 249 }, { 85 }, { 108, 287 }, { 96, 4 }, { 70 }, { 24 }, { 52, 206 }, { 59, 306 },
//        { 18, 296 }, { 79, 95 }, { 50, 131 }, { 3, 161 }, { 2, 229 }, { 39, 183 }, { 90, 225 },
//        { 75, 23 }, { 136, 280 }, { 119 }, { 81, 272 }, { 106 }, { 106 }, { 70 }, { 73, 60 },
//        { 19, 250 }, { 82, 291 }, { 117, 53 }, { 16, 176 }, { 40 }, { 7, 70 }, { 135, 212 }, { 59 },
//        { 81, 201 }, { 75, 305 }, { 101 }, { 8, 250 }, { 38 }, { 28, 220 }, { 21 }, { 105, 266 },
//        { 105 }, { 85 }, { 55 }, { 6 }, { 78, 83 }, { 126 }, { 102 }, { 66 }, { 61, 42 },
//        { 127, 35 }, { 117, 105 }, { 128 }, { 102 }, { 50 }, { 24, 133 }, { 40, 178 }, { 78, 157 },
//        { 71, 22 }, { 25 }, { 82 }, { 129 }, { 126, 12 }, { 45 }, { 40 }, { 86 }, { 100 },
//        { 30, 110 }, { 49 }, { 47, 185 }, { 123, 101 }, { 102 }, { 5 }, { 40, 267 }, { 48, 155 },
//        { 108 }, { 45 }, { 14, 182 }, { 20, 117 }, { 43, 124 }, { 38 }, { 77, 158 }, { 111 },
//        { 39 }, { 69, 126 }, { 113, 199 }, { 21, 216 }, { 11 }, { 117, 207 }, { 30 }, { 97, 84 },
//        { 109 }, { 99, 218 }, { 109 }, { 113, 1 }, { 62 }, { 49, 89 }, { 53, 311 }, { 126 },
//        { 32, 153 }, { 14, 296 }, { 22 }, { 14, 225 }, { 49 }, { 75 }, { 61, 241 }, { 7 }, { 6 },
//        { 31 }, { 75, 15 }, { 115 }, { 84, 181 }, { 125, 111 }, { 105, 94 }, { 48, 294 }, { 106 },
//        { 61 }, { 53, 190 }, { 16 }, { 12, 252 }, { 28 }, { 111, 122 }, { 122 }, { 10, 21 }, { 59 },
//        { 72 }, { 39 }, { 6 }, { 126 }, { 131, 177 }, { 105, 253 }, { 26 }, { 43, 311 }, { 79 },
//        { 91, 32 }, { 7, 141 }, { 38 }, { 13 }, { 79, 135 }, { 43 }, { 94 }, { 80, 182 }, { 53 },
//        { 120, 309 }, { 3, 109 }, { 97 }, { 9, 128 }, { 114, 121 }, { 56 }, { 56 }, { 124, 86 },
//        { 34, 145 }, { 131 }, { 78 }, { 86, 21 }, { 98 }, { 115, 164 }, { 47, 225 }, { 95 },
//        { 89, 55 }, { 26, 134 }, { 8, 15 }, { 11 }, { 84, 276 }, { 81, 67 }, { 46 }, { 39 }, { 92 },
//        { 96 }, { 89, 51 }, { 136, 240 }, { 45 }, { 27 }, { 24, 209 }, { 82, 145 }, { 10 },
//        { 104, 225 }, { 120, 203 }, { 121, 108 }, { 11, 47 }, { 89 }, { 80, 66 }, { 16 },
//        { 95, 101 }, { 49 }, { 1 }, { 77, 184 }, { 27 }, { 74, 313 }, { 14, 118 }, { 16 }, { 74 },
//        { 88, 251 }, { 124 }, { 58, 101 }, { 42, 81 }, { 2 }, { 133, 101 }, { 16 }, { 1, 254 },
//        { 25, 167 }, { 53, 56 }, { 73, 198 }, { 48 }, { 30 }, { 95 }, { 90, 102 }, { 92, 56 },
//        { 2, 130 }, { 52, 11 }, { 9 }, { 23 }, { 53, 275 }, { 23, 258 }, { 57 }, { 136, 183 },
//        { 75, 265 }, { 85 }, { 68, 274 }, { 15, 255 }, { 85 }, { 33, 314 }, { 101, 223 },
//        { 39, 248 }, { 18, 261 }, { 37, 160 }, { 112 }, { 65 }, { 31, 240 }, { 40, 295 },
//        { 99, 231 }, { 123 }, { 34, 43 }, { 87 }, { 80 }, { 47, 279 }, { 89, 299 }, { 72 },
//        { 26, 277 }, { 92, 13 }, { 46, 92 }, { 67, 163 }, { 85, 184 }, { 38 }, { 35, 65 }, { 70 },
//        { 81 }, { 40, 65 }, { 80 }, { 80, 23 }, { 76, 258 }, { 69 }, { 133 }, { 123, 196 },
//        { 119, 212 }, { 13, 150 }, { 22, 52 }, { 20, 105 }, { 61, 233 }, { 97 }, { 128, 307 },
//        { 85 }, { 80 }, { 73 }, { 30 }, { 46, 44 }, { 95 }, { 121, 211 }, { 48, 307 }, { 2 },
//        { 27, 166 }, { 50 }, { 75, 41 }, { 101, 105 }, { 2 }, { 110, 121 }, { 32, 88 }, { 75, 84 },
//        { 30, 165 }, { 41, 142 }, { 128, 102 }, { 105, 90 }, { 86, 68 }, { 13, 292 }, { 83, 63 },
//        { 5, 239 }, { 5 }, { 68, 204 }, { 127 }, { 42, 137 }, { 93 }, { 90, 258 }, { 40, 275 },
//        { 7, 96 }, { 108 }, { 104, 91 }, { 63 }, { 31 }, { 31, 89 }, { 74 }, { 81 }, { 126, 148 },
//        { 107 }, { 13, 28 }, { 21, 139 }, { 114 }, { 5 }, { 89 }, { 133 }, { 20 }, { 96, 135 },
//        { 86, 100 }, { 83, 75 }, { 14 }, { 26, 195 }, { 37 }, { 1, 287 }, { 79 }, { 15 }, { 6 },
//        { 68, 11 }, { 52 }, { 124, 80 }, { 123, 277 }, { 99, 281 }, { 133 }, { 90 }, { 45 },
//        { 127 }, { 9, 68 }, { 123, 6 }, { 124, 251 }, { 130, 191 }, { 23, 174 }, { 69, 295 },
//        { 32 }, { 37 }, { 1, 64 }, { 48, 116 }, { 68 }, { 117, 173 }, { 16, 89 }, { 84 },
//        { 28, 234 }, { 129 }, { 89 }, { 55 }, { 83 }, { 99, 264 }, { 129 }, { 84 }, { 14 },
//        { 26, 274 }, { 109 }, { 110 }, { 96, 120 }, { 128, 207 }, { 12 }, { 99, 233 }, { 20, 305 },
//        { 26, 24 }, { 102, 32 }, { 82 }, { 16, 30 }, { 5, 244 }, { 130 }, { 109, 36 }, { 134, 162 },
//        { 13, 165 }, { 45, 235 }, { 112, 80 }, { 6 }, { 34, 98 }, { 64, 250 }, { 18, 237 },
//        { 72, 21 }, { 42, 105 }, { 57, 108 }, { 28, 229 }, { 83 }, { 1, 34 }, { 93, 151 },
//        { 132, 94 }, { 18, 24 }, { 57, 68 }, { 42, 137 }, { 35 }, { 80 }, { 10, 288 }, { 21 },
//        { 115 }, { 131 }, { 30 }, { 43 }, { 97, 262 }, { 55, 146 }, { 81, 112 }, { 2, 212 },
//        { 5, 312 }, { 82, 107 }, { 14, 151 }, { 77 }, { 60, 42 }, { 90, 309 }, { 90 }, { 131, 220 },
//        { 86 }, { 106, 85 }, { 85, 254 }, { 14 }, { 66, 262 }, { 88, 243 }, { 3 }, { 50, 301 },
//        { 118, 91 }, { 25 }, { 105 }, { 100 }, { 89 }, { 111, 152 }, { 65, 24 }, { 41, 264 },
//        { 117 }, { 117 }, { 80, 45 }, { 38 }, { 11, 151 }, { 126, 203 }, { 128, 59 }, { 6, 129 },
//        { 91 }, { 118, 2 }, { 50, 164 }, { 74 }, { 80 }, { 48, 308 }, { 109, 82 }, { 3, 48 },
//        { 123, 10 }, { 59, 249 }, { 128, 64 }, { 41, 287 }, { 52, 278 }, { 98, 151 }, { 12 },
//        { 25 }, { 18, 254 }, { 24, 40 }, { 119 }, { 66, 44 }, { 61, 19 }, { 80, 132 }, { 62, 111 },
//        { 80 }, { 57, 188 }, { 132 }, { 42 }, { 18, 314 }, { 48 }, { 86, 138 }, { 8 }, { 27, 88 },
//        { 96, 178 }, { 17, 104 }, { 112, 86 }, { 25 }, { 129, 119 }, { 93, 44 }, { 115 },
//        { 33, 36 }, { 85, 190 }, { 10 }, { 52, 182 }, { 76, 182 }, { 109 }, { 118 }, { 82, 301 },
//        { 26, 158 }, { 71 }, { 108, 309 }, { 58, 132 }, { 13, 299 }, { 117, 183 }, { 115 }, { 89 },
//        { 42 }, { 11, 285 }, { 30, 144 }, { 69 }, { 31, 53 }, { 21 }, { 96, 162 }, { 4, 227 },
//        { 77, 120 }, { 128, 136 }, { 92 }, { 119, 208 }, { 87, 61 }, { 9, 40 }, { 48, 273 }, { 95 },
//        { 35 }, { 62, 267 }, { 88, 161 }, { 59 }, { 85 }, { 131, 53 }, { 114, 98 }, { 90, 257 },
//        { 108, 46 }, { 54 }, { 128, 223 }, { 114, 168 }, { 89, 203 }, { 100 }, { 116 }, { 14 },
//        { 61, 104 }, { 44, 161 }, { 60, 132 }, { 21, 310 }, { 89 }, { 109, 237 }, { 105 }, { 32 },
//        { 78, 101 }, { 14, 71 }, { 100, 47 }, { 102, 33 }, { 44, 29 }, { 85 }, { 37 }, { 68, 175 },
//        { 116, 182 }, { 42, 47 }, { 9 }, { 64, 37 }, { 23, 32 }, { 11, 124 }, { 130, 189 }, { 65 },
//        { 33, 219 }, { 79, 253 }, { 80 }, { 16 }, { 38, 18 }, { 35, 67 }, { 107 }, { 88 },
//        { 37, 13 }, { 71, 188 }, { 35 }, { 58, 268 }, { 18, 260 }, { 73, 23 }, { 28, 102 }, { 129 },
//        { 88 }, { 65 }, { 80 }, { 119, 146 }, { 113 }, { 62 }, { 123, 138 }, { 18, 1 }, { 26, 208 },
//        { 107 }, { 107 }, { 76, 132 }, { 121, 191 }, { 4 }, { 8 }, { 117 }, { 11, 118 }, { 43 },
//        { 69 }, { 136 }, { 66, 298 }, { 25 }, { 71 }, { 100 }, { 26, 141 }, { 53, 256 },
//        { 111, 205 }, { 126, 106 }, { 43 }, { 14, 39 }, { 44, 41 }, { 23, 230 }, { 131 }, { 53 },
//        { 104, 268 }, { 30 }, { 108, 48 }, { 72, 45 }, { 58 }, { 46 }, { 128, 301 }, { 71 }, { 99 },
//        { 113 }, { 121 }, { 130, 122 }, { 102, 5 }, { 111, 51 }, { 85, 229 }, { 86, 157 },
//        { 82, 283 }, { 88, 52 }, { 136, 105 }, { 40 }, { 63 }, { 114, 244 }, { 29, 82 },
//        { 83, 278 }, { 131 }, { 56, 33 }, { 123 }, { 11 }, { 119 }, { 119, 1 }, { 48, 52 }, { 47 },
//        { 127, 136 }, { 78, 38 }, { 117, 64 }, { 130, 134 }, { 93, 69 }, { 70, 98 }, { 68 },
//        { 4, 3 }, { 92, 173 }, { 114, 65 }, { 7, 309 }, { 31 }, { 107, 271 }, { 110, 69 }, { 45 },
//        { 35, 288 }, { 20 }, { 38, 79 }, { 46 }, { 6, 123 }, { 19 }, { 84, 95 }, { 76 }, { 71, 31 },
//        { 72, 171 }, { 35, 123 }, { 32 }, { 73, 85 }, { 94 }, { 128 }, { 28 }, { 38 }, { 109 },
//        { 85, 197 }, { 10, 41 }, { 71, 50 }, { 128 }, { 3, 55 }, { 15, 9 }, { 127, 215 }, { 17 },
//        { 37 }, { 111, 272 }, { 79, 169 }, { 86, 206 }, { 40, 264 }, { 134 }, { 16, 207 },
//        { 27, 127 }, { 29, 48 }, { 32, 122 }, { 15, 35 }, { 117, 36 }, { 127 }, { 36 }, { 72, 70 },
//        { 49, 201 }, { 89, 215 }, { 134, 290 }, { 77, 64 }, { 26, 101 }, { 99 }, { 36, 96 },
//        { 84, 129 }, { 125, 264 }, { 43 }, { 38 }, { 24, 76 }, { 45, 2 }, { 32, 24 }, { 84, 235 },
//        { 16, 240 }, { 17, 289 }, { 49, 94 }, { 90, 54 }, { 88, 199 }, { 23 }, { 87, 19 },
//        { 11, 19 }, { 24 }, { 57 }, { 4 }, { 40 }, { 133, 286 }, { 127, 231 }, { 51 }, { 52, 196 },
//        { 27 }, { 10 }, { 93 }, { 115, 143 }, { 62, 64 }, { 59, 200 }, { 75, 85 }, { 7, 93 },
//        { 117, 270 }, { 116, 6 }, { 32 }, { 135 }, { 2, 140 }, { 23, 1 }, { 11, 69 }, { 89, 30 },
//        { 27, 14 }, { 100 }, { 61 }, { 99, 41 }, { 88, 12 }, { 41 }, { 52, 203 }, { 65 },
//        { 62, 78 }, { 104, 276 }, { 105, 307 }, { 7 }, { 23, 123 }, { 22 }, { 35, 299 }, { 69 },
//        { 11 }, { 14, 112 }, { 115 }, { 112 }, { 108 }, { 110, 165 }, { 83, 165 }, { 36, 260 },
//        { 54, 73 }, { 36 }, { 93, 69 }, { 134 }, { 125, 96 }, { 74, 127 }, { 110, 305 },
//        { 92, 309 }, { 87, 45 }, { 31, 266 }, { 10 }, { 114, 206 }, { 49, 141 }, { 82 }, { 92, 3 },
//        { 91, 160 }, { 41 }, { 60, 147 }, { 36, 239 }, { 23, 296 }, { 134, 120 }, { 6 }, { 5, 283 },
//        { 117, 68 }, { 35 }, { 120 }, { 44, 191 }, { 121, 14 }, { 118, 113 }, { 84, 106 }, { 23 },
//        { 15, 240 }, { 37 }, { 52, 256 }, { 119, 116 }, { 101, 7 }, { 14, 157 }, { 29, 225 },
//        { 4, 247 }, { 8, 112 }, { 8, 189 }, { 96, 220 }, { 104 }, { 72, 106 }, { 23, 170 },
//        { 67, 209 }, { 70, 39 }, { 18 }, { 6 }, { 34 }, { 121, 157 }, { 16 }, { 19 }, { 83, 283 },
//        { 13, 22 }, { 33, 143 }, { 88, 133 }, { 88 }, { 5, 49 }, { 38 }, { 110 }, { 67 },
//        { 23, 227 }, { 68 }, { 3 }, { 27, 265 }, { 31 }, { 13, 103 }, { 116 }, { 111, 282 },
//        { 43, 71 }, { 134 }, { 70, 141 }, { 14 }, { 119 }, { 43 }, { 122 }, { 38, 187 }, { 8, 9 },
//        { 63 }, { 42, 140 }, { 83 }, { 92 }, { 106 }, { 28 }, { 57, 139 }, { 36, 257 }, { 30, 204 },
//        { 72 }, { 105, 243 }, { 16 }, { 74, 25 }, { 22 }, { 118, 144 }, { 133 }, { 71 }, { 99, 21 },
//        { 26 }, { 35 }, { 89, 209 }, { 106, 158 }, { 76, 63 }, { 112, 216 }, { 128 }, { 54 },
//        { 16, 165 }, { 76, 206 }, { 69, 253 }, { 23 }, { 54, 111 }, { 80 }, { 111, 72 },
//        { 95, 217 }, { 118 }, { 4, 146 }, { 47 }, { 108, 290 }, { 43 }, { 70, 8 }, { 117 }, { 121 },
//        { 42, 220 }, { 48 }, { 32 }, { 68, 213 }, { 30, 157 }, { 62, 68 }, { 58 }, { 125, 283 },
//        { 132, 45 }, { 85 }, { 92 }, { 23, 257 }, { 74 }, { 18, 256 }, { 90 }, { 10, 158 },
//        { 57, 34 }, { 27 }, { 107 } };

//    for (int i = 1; i < s.length; i++) {
//      if ("put".equals(s[i])) {
//        System.out.println("test.put(" + data[i][0] + "," + data[i][1] + ");");
//      } else if ("get".equals(s[i])) {
//        System.out.println("test.get(" + data[i][0] + ");");
//      }
//    }

    test.put(33, 219);
    test.get(39);
    test.put(96, 56);
    test.get(129);
    test.get(115);
    test.get(112);
    test.put(3, 280);
    test.get(40);
    test.put(85, 193);
    test.put(10, 10);
    test.put(100, 136);
    test.put(12, 66);
    test.put(81, 261);
    test.put(33, 58);
    test.get(3);
    test.put(121, 308);
    test.put(129, 263);
    test.get(105);
    test.put(104, 38);
    test.put(65, 85);
    test.put(3, 141);
    test.put(29, 30);
    test.put(80, 191);
    test.put(52, 191);
    test.put(8, 300);
    test.get(136);
    test.put(48, 261);
    test.put(3, 193);
    test.put(133, 193);
    test.put(60, 183);
    test.put(128, 148);
    test.put(52, 176);
    test.get(48);
    test.put(48, 119);
    test.put(10, 241);
    test.get(124);
    test.put(130, 127);
    test.get(61);
    test.put(124, 27);
    test.get(94);
    test.put(29, 304);
    test.put(102, 314);
    test.get(110);
    test.put(23, 49);
    test.put(134, 12);
    test.put(55, 90);
    test.get(14);
    test.get(104);
    test.put(77, 165);
    test.put(60, 160);
    test.get(117);
    test.put(58, 30);
    test.get(54);
    test.get(136);
    test.get(128);
    test.get(131);
    test.put(48, 114);
    test.get(136);
    test.put(46, 51);
    test.put(129, 291);
    test.put(96, 207);
    test.get(131);
    test.put(89, 153);
    test.put(120, 154);
    test.get(111);
    test.get(47);
    test.get(5);
    test.put(114, 157);
    test.put(57, 82);
    test.put(113, 106);
    test.put(74, 208);
    test.get(56);
    test.get(59);
    test.get(100);
    test.get(132);
    test.put(127, 202);
    test.get(75);
    test.put(102, 147);
    test.get(37);
    test.put(53, 79);
    test.put(119, 220);
    test.get(47);
    test.get(101);
    test.get(89);
    test.get(20);
    test.get(93);
    test.get(7);
    test.put(48, 109);
    test.put(71, 146);
    test.get(43);
    test.get(122);
    test.put(3, 160);
    test.get(17);
    test.put(80, 22);
    test.put(80, 272);
    test.get(75);
    test.get(117);
    test.put(76, 204);
    test.put(74, 141);
    test.put(107, 93);
    test.put(34, 280);
    test.put(31, 94);
    test.get(132);
    test.put(71, 258);
    test.get(61);
    test.get(60);
    test.put(69, 272);
    test.get(46);
    test.put(42, 264);
    test.put(87, 126);
    test.put(107, 236);
    test.put(131, 218);
    test.get(79);
    test.put(41, 71);
    test.put(94, 111);
    test.put(19, 124);
    test.put(52, 70);
    test.get(131);
    test.get(103);
    test.get(81);
    test.get(126);
    test.put(61, 279);
    test.put(37, 100);
    test.get(95);
    test.get(54);
    test.put(59, 136);
    test.put(101, 219);
    test.put(15, 248);
    test.put(37, 91);
    test.put(11, 174);
    test.put(99, 65);
    test.put(105, 249);
    test.get(85);
    test.put(108, 287);
    test.put(96, 4);
    test.get(70);
    test.get(24);
    test.put(52, 206);
    test.put(59, 306);
    test.put(18, 296);
    test.put(79, 95);
    test.put(50, 131);
    test.put(3, 161);
    test.put(2, 229);
    test.put(39, 183);
    test.put(90, 225);
    test.put(75, 23);
    test.put(136, 280);
    test.get(119);
    test.put(81, 272);
    test.get(106);
    test.get(106);
    test.get(70);
    test.put(73, 60);
    test.put(19, 250);
    test.put(82, 291);
    test.put(117, 53);
    test.put(16, 176);
    test.get(40);
    test.put(7, 70);
    test.put(135, 212);
    test.get(59);
    test.put(81, 201);
    test.put(75, 305);
    test.get(101);
    test.put(8, 250);
    test.get(38);
    test.put(28, 220);
    test.get(21);
    test.put(105, 266);
    test.get(105);
    test.get(85);
    test.get(55);
    test.get(6);
    test.put(78, 83);
    test.get(126);
    test.get(102);
    test.get(66);
    test.put(61, 42);
    test.put(127, 35);
    test.put(117, 105);
    test.get(128);
    test.get(102);
    test.get(50);
    test.put(24, 133);
    test.put(40, 178);
    test.put(78, 157);
    test.put(71, 22);
    test.get(25);
    test.get(82);
    test.get(129);
    test.put(126, 12);
    test.get(45);
    test.get(40);
    test.get(86);
    test.get(100);
    test.put(30, 110);
    test.get(49);
    test.put(47, 185);
    test.put(123, 101);
    test.get(102);
    test.get(5);
    test.put(40, 267);
    test.put(48, 155);
    test.get(108);
    test.get(45);
    test.put(14, 182);
    test.put(20, 117);
    test.put(43, 124);
    test.get(38);
    test.put(77, 158);
    test.get(111);
    test.get(39);
    test.put(69, 126);
    test.put(113, 199);
    test.put(21, 216);
    test.get(11);
    test.put(117, 207);
    test.get(30);
    test.put(97, 84);
    test.get(109);
    test.put(99, 218);
    test.get(109);
    test.put(113, 1);
    test.get(62);
    test.put(49, 89);
    test.put(53, 311);
    test.get(126);
    test.put(32, 153);
    test.put(14, 296);
    test.get(22);
    test.put(14, 225);
    test.get(49);
    test.get(75);
    test.put(61, 241);
    test.get(7);
    test.get(6);
    test.get(31);
    test.put(75, 15);
    test.get(115);
    test.put(84, 181);
    test.put(125, 111);
    test.put(105, 94);
    test.put(48, 294);
    test.get(106);
    test.get(61);
    test.put(53, 190);
    test.get(16);
    test.put(12, 252);
    test.get(28);
    test.put(111, 122);
    test.get(122);
    test.put(10, 21);
    test.get(59);
    test.get(72);
    test.get(39);
    test.get(6);
    test.get(126);
    test.put(131, 177);
    test.put(105, 253);
    test.get(26);
    test.put(43, 311);
    test.get(79);
    test.put(91, 32);
    test.put(7, 141);
    test.get(38);
    test.get(13);
    test.put(79, 135);
    test.get(43);
    test.get(94);
    test.put(80, 182);
    test.get(53);
    test.put(120, 309);
    test.put(3, 109);
    test.get(97);
    test.put(9, 128);
    test.put(114, 121);
    test.get(56);
    test.get(56);
    test.put(124, 86);
    test.put(34, 145);
    test.get(131);
    test.get(78);
    test.put(86, 21);
    test.get(98);
    test.put(115, 164);
    test.put(47, 225);
    test.get(95);
    test.put(89, 55);
    test.put(26, 134);
    test.put(8, 15);
    test.get(11);
    test.put(84, 276);
    test.put(81, 67);
    test.get(46);
    test.get(39);
    test.get(92);
    test.get(96);
    test.put(89, 51);
    test.put(136, 240);
    test.get(45);
    test.get(27);
    test.put(24, 209);
    test.put(82, 145);
    test.get(10);
    test.put(104, 225);
    test.put(120, 203);
    test.put(121, 108);
    test.put(11, 47);
    test.get(89);
    test.put(80, 66);
    test.get(16);
    test.put(95, 101);
    test.get(49);
    test.get(1);
    test.put(77, 184);
    test.get(27);
    test.put(74, 313);
    test.put(14, 118);
    test.get(16);
    test.get(74);
    test.put(88, 251);
    test.get(124);
    test.put(58, 101);
    test.put(42, 81);
    test.get(2);
    test.put(133, 101);
    test.get(16);
    test.put(1, 254);
    test.put(25, 167);
    test.put(53, 56);
    test.put(73, 198);
    test.get(48);
    test.get(30);
    test.get(95);
    test.put(90, 102);
    test.put(92, 56);
    test.put(2, 130);
    test.put(52, 11);
    test.get(9);
    test.get(23);
    test.put(53, 275);
    test.put(23, 258);
    test.get(57);
    test.put(136, 183);
    test.put(75, 265);
    test.get(85);
    test.put(68, 274);
    test.put(15, 255);
    test.get(85);
    test.put(33, 314);
    test.put(101, 223);
    test.put(39, 248);
    test.put(18, 261);
    test.put(37, 160);
    test.get(112);
    test.get(65);
    test.put(31, 240);
    test.put(40, 295);
    test.put(99, 231);
    test.get(123);
    test.put(34, 43);
    test.get(87);
    test.get(80);
    test.put(47, 279);
    test.put(89, 299);
    test.get(72);
    test.put(26, 277);
    test.put(92, 13);
    test.put(46, 92);
    test.put(67, 163);
    test.put(85, 184);
    test.get(38);
    test.put(35, 65);
    test.get(70);
    test.get(81);
    test.put(40, 65);
    test.get(80);
    test.put(80, 23);
    test.put(76, 258);
    test.get(69);
    test.get(133);
    test.put(123, 196);
    test.put(119, 212);
    test.put(13, 150);
    test.put(22, 52);
    test.put(20, 105);
    test.put(61, 233);
    test.get(97);
    test.put(128, 307);
    test.get(85);
    test.get(80);
    test.get(73);
    test.get(30);
    test.put(46, 44);
    test.get(95);
    test.put(121, 211);
    test.put(48, 307);
    test.get(2);
    test.put(27, 166);
    test.get(50);
    test.put(75, 41);
    test.put(101, 105);
    test.get(2);
    test.put(110, 121);
    test.put(32, 88);
    test.put(75, 84);
    test.put(30, 165);
    test.put(41, 142);
    test.put(128, 102);
    test.put(105, 90);
    test.put(86, 68);
    test.put(13, 292);
    test.put(83, 63);
    test.put(5, 239);
    test.get(5);
    test.put(68, 204);
    test.get(127);
    test.put(42, 137);
    test.get(93);
    test.put(90, 258);
    test.put(40, 275);
    test.put(7, 96);
    test.get(108);
    test.put(104, 91);
    test.get(63);
    test.get(31);
    test.put(31, 89);
    test.get(74);
    test.get(81);
    test.put(126, 148);
    test.get(107);
    test.put(13, 28);
    test.put(21, 139);
    test.get(114);
    test.get(5);
    test.get(89);
    test.get(133);
    test.get(20);
    test.put(96, 135);
    test.put(86, 100);
    test.put(83, 75);
    test.get(14);
    test.put(26, 195);
    test.get(37);
    test.put(1, 287);
    test.get(79);
    test.get(15);
    test.get(6);
    test.put(68, 11);
    test.get(52);
    test.put(124, 80);
    test.put(123, 277);
    test.put(99, 281);
    test.get(133);
    test.get(90);
    test.get(45);
    test.get(127);
    test.put(9, 68);
    test.put(123, 6);
    test.put(124, 251);
    test.put(130, 191);
    test.put(23, 174);
    test.put(69, 295);
    test.get(32);
    test.get(37);
    test.put(1, 64);
    test.put(48, 116);
    test.get(68);
    test.put(117, 173);
    test.put(16, 89);
    test.get(84);
    test.put(28, 234);
    test.get(129);
    test.get(89);
    test.get(55);
    test.get(83);
    test.put(99, 264);
    test.get(129);
    test.get(84);
    test.get(14);
    test.put(26, 274);
    test.get(109);
    test.get(110);
    test.put(96, 120);
    test.put(128, 207);
    test.get(12);
    test.put(99, 233);
    test.put(20, 305);
    test.put(26, 24);
    test.put(102, 32);
    test.get(82);
    test.put(16, 30);
    test.put(5, 244);
    test.get(130);
    test.put(109, 36);
    test.put(134, 162);
    test.put(13, 165);
    test.put(45, 235);
    test.put(112, 80);
    test.get(6);
    test.put(34, 98);
    test.put(64, 250);
    test.put(18, 237);
    test.put(72, 21);
    test.put(42, 105);
    test.put(57, 108);
    test.put(28, 229);
    test.get(83);
    test.put(1, 34);
    test.put(93, 151);
    test.put(132, 94);
    test.put(18, 24);
    test.put(57, 68);
    test.put(42, 137);
    test.get(35);
    test.get(80);
    test.put(10, 288);
    test.get(21);
    test.get(115);
    test.get(131);
    test.get(30);
    test.get(43);
    test.put(97, 262);
    test.put(55, 146);
    test.put(81, 112);
    test.put(2, 212);
    test.put(5, 312);
    test.put(82, 107);
    test.put(14, 151);
    test.get(77);
    test.put(60, 42);
    test.put(90, 309);
    test.get(90);
    test.put(131, 220);
    test.get(86);
    test.put(106, 85);
    test.put(85, 254);
    test.get(14);
    test.put(66, 262);
    test.put(88, 243);
    test.get(3);
    test.put(50, 301);
    test.put(118, 91);
    test.get(25);
    test.get(105);
    test.get(100);
    test.get(89);
    test.put(111, 152);
    test.put(65, 24);
    test.put(41, 264);
    test.get(117);
    test.get(117);
    test.put(80, 45);
    test.get(38);
    test.put(11, 151);
    test.put(126, 203);
    test.put(128, 59);
    test.put(6, 129);
    test.get(91);
    test.put(118, 2);
    test.put(50, 164);
    test.get(74);
    test.get(80);
    test.put(48, 308);
    test.put(109, 82);
    test.put(3, 48);
    test.put(123, 10);
    test.put(59, 249);
    test.put(128, 64);
    test.put(41, 287);
    test.put(52, 278);
    test.put(98, 151);
    test.get(12);
    test.get(25);
    test.put(18, 254);
    test.put(24, 40);
    test.get(119);
    test.put(66, 44);
    test.put(61, 19);
    test.put(80, 132);
    test.put(62, 111);
    test.get(80);
    test.put(57, 188);
    test.get(132);
    test.get(42);
    test.put(18, 314);
    test.get(48);
    test.put(86, 138);
    test.get(8);
    test.put(27, 88);
    test.put(96, 178);
    test.put(17, 104);
    test.put(112, 86);
    test.get(25);
    test.put(129, 119);
    test.put(93, 44);
    test.get(115);
    test.put(33, 36);
    test.put(85, 190);
    test.get(10);
    test.put(52, 182);
    test.put(76, 182);
    test.get(109);
    test.get(118);
    test.put(82, 301);
    test.put(26, 158);
    test.get(71);
    test.put(108, 309);
    test.put(58, 132);
    test.put(13, 299);
    test.put(117, 183);
    test.get(115);
    test.get(89);
    test.get(42);
    test.put(11, 285);
    test.put(30, 144);
    test.get(69);
    test.put(31, 53);
    test.get(21);
    test.put(96, 162);
    test.put(4, 227);
    test.put(77, 120);
    test.put(128, 136);
    test.get(92);
    test.put(119, 208);
    test.put(87, 61);
    test.put(9, 40);
    test.put(48, 273);
    test.get(95);
    test.get(35);
    test.put(62, 267);
    test.put(88, 161);
    test.get(59);
    test.get(85);
    test.put(131, 53);
    test.put(114, 98);
    test.put(90, 257);
    test.put(108, 46);
    test.get(54);
    test.put(128, 223);
    test.put(114, 168);
    test.put(89, 203);
    test.get(100);
    test.get(116);
    test.get(14);
    test.put(61, 104);
    test.put(44, 161);
    test.put(60, 132);
    test.put(21, 310);
    test.get(89);
    test.put(109, 237);
    test.get(105);
    test.get(32);
    test.put(78, 101);
    test.put(14, 71);
    test.put(100, 47);
    test.put(102, 33);
    test.put(44, 29);
    test.get(85);
    test.get(37);
    test.put(68, 175);
    test.put(116, 182);
    test.put(42, 47);
    test.get(9);
    test.put(64, 37);
    test.put(23, 32);
    test.put(11, 124);
    test.put(130, 189);
    test.get(65);
    test.put(33, 219);
    test.put(79, 253);
    test.get(80);
    test.get(16);
    test.put(38, 18);
    test.put(35, 67);
    test.get(107);
    test.get(88);
    test.put(37, 13);
    test.put(71, 188);
    test.get(35);
    test.put(58, 268);
    test.put(18, 260);
    test.put(73, 23);
    test.put(28, 102);
    test.get(129);
    test.get(88);
    test.get(65);
    test.get(80);
    test.put(119, 146);
    test.get(113);
    test.get(62);
    test.put(123, 138);
    test.put(18, 1);
    test.put(26, 208);
    test.get(107);
    test.get(107);
    test.put(76, 132);
    test.put(121, 191);
    test.get(4);
    test.get(8);
    test.get(117);
    test.put(11, 118);
    test.get(43);
    test.get(69);
    test.get(136);
    test.put(66, 298);
    test.get(25);
    test.get(71);
    test.get(100);
    test.put(26, 141);
    test.put(53, 256);
    test.put(111, 205);
    test.put(126, 106);
    test.get(43);
    test.put(14, 39);
    test.put(44, 41);
    test.put(23, 230);
    test.get(131);
    test.get(53);
    test.put(104, 268);
    test.get(30);
    test.put(108, 48);
    test.put(72, 45);
    test.get(58);
    test.get(46);
    test.put(128, 301);
    test.get(71);
    test.get(99);
    test.get(113);
    test.get(121);
    test.put(130, 122);
    test.put(102, 5);
    test.put(111, 51);
    test.put(85, 229);
    test.put(86, 157);
    test.put(82, 283);
    test.put(88, 52);
    test.put(136, 105);
    test.get(40);
    test.get(63);
    test.put(114, 244);
    test.put(29, 82);
    test.put(83, 278);
    test.get(131);
    test.put(56, 33);
    test.get(123);
    test.get(11);
    test.get(119);
    test.put(119, 1);
    test.put(48, 52);
    test.get(47);
    test.put(127, 136);
    test.put(78, 38);
    test.put(117, 64);
    test.put(130, 134);
    test.put(93, 69);
    test.put(70, 98);
    test.get(68);
    test.put(4, 3);
    test.put(92, 173);
    test.put(114, 65);
    test.put(7, 309);
    test.get(31);
    test.put(107, 271);
    test.put(110, 69);
    test.get(45);
    test.put(35, 288);
    test.get(20);
    test.put(38, 79);
    test.get(46);
    test.put(6, 123);
    test.get(19);
    test.put(84, 95);
    test.get(76);
    test.put(71, 31);
    test.put(72, 171);
    test.put(35, 123);
    test.get(32);
    test.put(73, 85);
    test.get(94);
    test.get(128);
    test.get(28);
    test.get(38);
    test.get(109);
    test.put(85, 197);
    test.put(10, 41);
    test.put(71, 50);
    test.get(128);
    test.put(3, 55);
    test.put(15, 9);
    test.put(127, 215);
    test.get(17);
    test.get(37);
    test.put(111, 272);
    test.put(79, 169);
    test.put(86, 206);
    test.put(40, 264);
    test.get(134);
    test.put(16, 207);
    test.put(27, 127);
    test.put(29, 48);
    test.put(32, 122);
    test.put(15, 35);
    test.put(117, 36);
    test.get(127);
    test.get(36);
    test.put(72, 70);
    test.put(49, 201);
    test.put(89, 215);
    test.put(134, 290);
    test.put(77, 64);
    test.put(26, 101);
    test.get(99);
    test.put(36, 96);
    test.put(84, 129);
    test.put(125, 264);
    test.get(43);
    test.get(38);
    test.put(24, 76);
    test.put(45, 2);
    test.put(32, 24);
    test.put(84, 235);
    test.put(16, 240);
    test.put(17, 289);
    test.put(49, 94);
    test.put(90, 54);
    test.put(88, 199);
    test.get(23);
    test.put(87, 19);
    test.put(11, 19);
    test.get(24);
    test.get(57);
    test.get(4);
    test.get(40);
    test.put(133, 286);
    test.put(127, 231);
    test.get(51);
    test.put(52, 196);
    test.get(27);
    test.get(10);
    test.get(93);
    test.put(115, 143);
    test.put(62, 64);
    test.put(59, 200);
    test.put(75, 85);
    test.put(7, 93);
    test.put(117, 270);
    test.put(116, 6);
    test.get(32);
    test.get(135);
    test.put(2, 140);
    test.put(23, 1);
    test.put(11, 69);
    test.put(89, 30);
    test.put(27, 14);
    test.get(100);
    test.get(61);
    test.put(99, 41);
    test.put(88, 12);
    test.get(41);
    test.put(52, 203);
    test.get(65);
    test.put(62, 78);
    test.put(104, 276);
    test.put(105, 307);
    test.get(7);
    test.put(23, 123);
    test.get(22);
    test.put(35, 299);
    test.get(69);
    test.get(11);
    test.put(14, 112);
    test.get(115);
    test.get(112);
    test.get(108);
    test.put(110, 165);
    test.put(83, 165);
    test.put(36, 260);
    test.put(54, 73);
    test.get(36);
    test.put(93, 69);
    test.get(134);
    test.put(125, 96);
    test.put(74, 127);
    test.put(110, 305);
    test.put(92, 309);
    test.put(87, 45);
    test.put(31, 266);
    test.get(10);
    test.put(114, 206);
    test.put(49, 141);
    test.get(82);
    test.put(92, 3);
    test.put(91, 160);
    test.get(41);
    test.put(60, 147);
    test.put(36, 239);
    test.put(23, 296);
    test.put(134, 120);
    test.get(6);
    test.put(5, 283);
    test.put(117, 68);
    test.get(35);
    test.get(120);
    test.put(44, 191);
    test.put(121, 14);
    test.put(118, 113);
    test.put(84, 106);
    test.get(23);
    test.put(15, 240);
    test.get(37);
    test.put(52, 256);
    test.put(119, 116);
    test.put(101, 7);
    test.put(14, 157);
    test.put(29, 225);
    test.put(4, 247);
    test.put(8, 112);
    test.put(8, 189);
    test.put(96, 220);
    test.get(104);
    test.put(72, 106);
    test.put(23, 170);
    test.put(67, 209);
    test.put(70, 39);
    test.get(18);
    test.get(6);
    test.get(34);
    test.put(121, 157);
    test.get(16);
    test.get(19);
    test.put(83, 283);
    test.put(13, 22);
    test.put(33, 143);
    test.put(88, 133);
    test.get(88);
    test.put(5, 49);
    test.get(38);
    test.get(110);
    test.get(67);
    test.put(23, 227);
    test.get(68);
    test.get(3);
    test.put(27, 265);
    test.get(31);
    test.put(13, 103);
    test.get(116);
    test.put(111, 282);
    test.put(43, 71);
    test.get(134);
    test.put(70, 141);
    test.get(14);
    test.get(119);
    test.get(43);
    test.get(122);
    test.put(38, 187);
    test.put(8, 9);
    test.get(63);
    test.put(42, 140);
    test.get(83);
    test.get(92);
    test.get(106);
    test.get(28);
    test.put(57, 139);
    test.put(36, 257);
    test.put(30, 204);
    test.get(72);
    test.put(105, 243);
    test.get(16);
    test.put(74, 25);
    test.get(22);
    test.put(118, 144);
    test.get(133);
    test.get(71);
    test.put(99, 21);
    test.get(26);
    test.get(35);
    test.put(89, 209);
    test.put(106, 158);
    test.put(76, 63);
    test.put(112, 216);
    test.get(128);
    test.get(54);
    test.put(16, 165);
    test.put(76, 206);
    test.put(69, 253);
    test.get(23);
    test.put(54, 111);
    test.get(80);
    test.put(111, 72);
    test.put(95, 217);
    test.get(118);
    test.put(4, 146);
    test.get(47);
    test.put(108, 290);
    test.get(43);
    test.put(70, 8);
    test.get(117);
    test.get(121);
    test.put(42, 220);
    test.get(48);
    test.get(32);
    test.put(68, 213);
    test.put(30, 157);
    test.put(62, 68);
    test.get(58);
    test.put(125, 283);
    test.put(132, 45);
    test.get(85);
    test.get(92);
    test.put(23, 257);
    test.get(74);
    test.put(18, 256);
    test.get(90);
    test.put(10, 158);
    test.put(57, 34);
    test.get(27);
    test.get(107);

  }

}

class LFUCache {

  Map<Integer, Node>   map;
  Map<Integer, Node[]> ht;

  Node head = null;

  int cap      = 0;
  int capacity = 0;

  public LFUCache(int capacity) {
    map = new HashMap<>(capacity);
    ht = new HashMap<>();
    this.capacity = capacity;
  }

  public void addToTail(int i, Node target) {
    if (i == 1 && !ht.containsKey(1)) {
      ht.put(1, new Node[] { target, target });
      target.next = head;
      head.prev = target;
      head = target;
      return;
    }
    Node t = ht.get(i)[1];
    Node tnext = t.next;
    t.next = target;
    target.prev = t;
    if (tnext != null) {
      tnext.prev = target;
      target.next = tnext;
    }
    ht.get(i)[1] = target;
  }

  public void unlinkNode(Node node) {
    Node pre = node.prev;
    Node nxt = node.next;
    if (pre == null && nxt == null) {
      return;
    } else {
      if (pre != null) {
        pre.next = node.next;
      }
      if (nxt != null) {
        nxt.prev = node.prev;
      }
      node.prev = null;
      node.next = null;
    }
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node target = map.get(key);
      if (target == head && target.next != null) {
        head = target.next;
      }
      target.use();
      Node[] cur = ht.get(target.lfu());
      Node[] pre = ht.get(target.lfu() - 1);

      Node catchUp = null;

      if (pre[0] == pre[1]) {
        catchUp = pre[0].prev;
        ht.remove(target.lfu() - 1);
      } else {
        if (pre[0] == target) {
          ht.get(target.lfu() - 1)[0] = target.next;
        } else if (pre[1] == target) {
          ht.get(target.lfu() - 1)[1] = target.prev;
        }
        catchUp = ht.get(target.lfu() - 1)[1];
      }
      unlinkNode(target);

      if (cur == null) {
        ht.put(target.lfu(), new Node[] { target, target });
        if (catchUp != null) {
          catchUp.next = target;
          target.prev = catchUp;
        }
      } else if (cur != null) {
        addToTail(target.lfu(), target);
      }

      return target.getValue();
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (map.containsKey(key)) {
      map.get(key).setValue(value);
      get(key);
      return;
    }
    Node node = new Node(key, value);
    if (cap == 0) {
      head = node;
      ht.put(1, new Node[] { node, node });
    } else {
      addToTail(1, node);
      if (cap == capacity) {
        Node h = ht.get(1)[0];
        if (node != h) {
          Node n = h.next;
          head = n;
          h.next = null;
          n.prev = null;
          ht.get(1)[0] = n;
          map.remove(h.getKey());
          cap--;
        } else {
          Node toDel = h.next;
          unlinkNode(toDel);
          map.remove(toDel.getKey());
          cap--;
        }
      }
    }
    map.put(key, node);
    cap++;
  }

  static class Node implements Map.Entry<Integer, Integer> {
    final int key;
    int       value;
    Node      next;
    Node      prev;
    int       lfu = 1;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    Node(int hash, int key, int value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public int lfu() {
      return lfu;
    }

    public int use() {
      return ++lfu;
    }

    public final Integer getKey() {
      return key;
    }

    public final Integer getValue() {
      return value;
    }

    public final Integer setValue(Integer newValue) {
      int oldValue = value;
      value = newValue;
      return oldValue;
    }

    public final boolean equals(Object o) {
      if (o == this)
        return true;
      if (o instanceof Map.Entry) {
        Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
        if (Objects.equals(key, e.getKey())
            &&
            Objects.equals(value, e.getValue()))
          return true;
      }
      return false;
    }

  }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
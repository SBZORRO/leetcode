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
//    LFUCache test = new LFUCache(10);

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

//    for (int i = 1; i < s.length; i++) {
//      if ("put".equals(s[i])) {
//        System.out.println("test.put(" + data[i][0] + "," + data[i][1] + ");");
//      } else if ("get".equals(s[i])) {
//        System.out.println("test.get(" + data[i][0] + ");");
//      }
//    }

    LFUCache test = new LFUCache(2);
    test.put(3, 1);
    test.put(2, 1);
    test.get(2);
    test.get(3);
    test.put(4, 4);

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

//    for (int i = 1; i < s.length; i++) {
//      if ("put".equals(s[i])) {
//        System.out.println("test.put(" + data[i][0] + "," + data[i][1] + ");");
//      } else if ("get".equals(s[i])) {
//        System.out.println("test.get(" + data[i][0] + ");");
//      }
//    }

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

          Node hh = ht.get(toDel.lfu())[0];
          Node tt = ht.get(toDel.lfu())[1];
          if (hh == tt) {
            ht.remove(toDel.lfu());
          } else {
            ht.get(toDel.lfu())[0] = hh.next;
          }

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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class No146_LRUCache {
//  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//  get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//  put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//  The cache is initialized with a positive capacity.
//
//  Follow up:
//  Could you do both operations in O(1) time complexity?
//
//  Example:
//
//  LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//  cache.put(1, 1);
//  cache.put(2, 2);
//  cache.get(1);       // returns 1
//  cache.put(3, 3);    // evicts key 2
//  cache.get(2);       // returns -1 (not found)
//  cache.put(4, 4);    // evicts key 1
//  cache.get(1);       // returns -1 (not found)
//  cache.get(3);       // returns 3
//  cache.get(4);       // returns 4
//
//   
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/lru-cache
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(2, 6);
    cache.put(1, 5);
    cache.put(1, 2);
    cache.get(1);
    cache.get(2);
  }
}

class LRUCache {

  Map<Integer, Node<Integer, Integer>> map;

  int cap      = 0;
  int capacity = 0;

  Node<Integer, Integer> head = null;
  Node<Integer, Integer> tail = null;

  public LRUCache(int capacity) {
    map = new HashMap<>(capacity);
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node<Integer, Integer> target = map.get(key);
      if (tail == target) {
        return target.getValue();
      } else if (head == target) {
        target.next.prev = null;
        head = target.next;
        target.next = null;
        tail.next = target;
        target.prev = tail;
        tail = target;
        return target.getValue();
      } else {
        target.prev.next = target.next;
        target.next.prev = target.prev;
        target.prev = tail;
        tail.next = target;
        tail = target;
        return target.getValue();
      }
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      map.get(key).setValue(value);
      get(key);
      return;
    }
    Node<Integer, Integer> node = new Node<>(key, value);
    if (head == null || tail == null) {
      head = node;
      tail = node;
      cap++;
    } else if (cap == capacity) {
      tail.next = node;
      node.prev = tail;
      tail = node;

      Node<Integer, Integer> tmp;
      tmp = head;
      head = head.next;
      head.prev = null;
      tmp.next = null;
      map.remove(tmp.getKey());
    } else {
      tail.next = node;
      node.prev = tail;
      tail = node;
      cap++;
    }
    map.put(key, node);
  }

  static class Node<K, V> implements Map.Entry<K, V> {
    final K    key;
    V          value;
    Node<K, V> next;
    Node<K, V> prev;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }

    Node(int hash, K key, V value, Node<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public final K getKey() {
      return key;
    }

    public final V getValue() {
      return value;
    }

    public final V setValue(V newValue) {
      V oldValue = value;
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
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

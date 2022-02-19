# 实现原理

> ^ [极客学院wiki](https://wiki.jikexueyuan.com/project/java-collection/hashmap.html)
>
> ^ [有or无符号右移](https://juejin.cn/post/6844903969915944973)

- HashMap 是基于哈希表的 Map 接口的**非同步**实现
  Hashmap 不是同步的，如果多个线程同时访问一个 HashMap，而其中至少一个线程从结构上（指添加或者删除一个或多个映射关系的任何操作）修改了，则必须保持外部同步，以防止对映射进行意外的非同步访问。
  - 同步：A执行一个操作，A等待操作返回执行结果，获得操作返回的结果，继续下一个操作
  - 非同步：A执行一个操作，A不等待操作返回结果，A直接执行下一个操作，操作使用回调函数返回结果。
- 不保证有序，不是不保证无序
- 它是顺序存储结构+链式存储结构

## 1：ADT

## 2：存储

### put(K, V)

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
```

```java
/**
     * Implements Map.put and related methods
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
*/
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

- i = (n - 1) & hash 来得到该对象在数组中的下标，

  | (15-1)&hash(0)=0 	 1110&0=0 <br/>(15-1)&hash(1)=0 	 1110&1=0 <br/>(15-1)&hash(2)=2 	 1110&10=10 <br/>(15-1)&hash(3)=2 	 1110&11=10 <br/>(15-1)&hash(4)=4 	 1110&100=100 <br/>(15-1)&hash(5)=4 	 1110&101=100 | (16-1)&hash(0)=0 	 1111&0=0 <br/>(16-1)&hash(1)=1 	 1111&1=1 <br/>(16-1)&hash(2)=2 	 1111&10=10 <br/>(16-1)&hash(3)=3 	 1111&11=11 <br/>(16-1)&hash(4)=4 	 1111&100=100 <br/>(16-1)&hash(5)=5 	 1111&101=101 |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |

  - 2的倍数的特性就出现了


### hash算法

```java
/**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
*/
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```



## 3：构造函数

- HashMap(初始化容量，负载因子)

  ```java
  public HashMap(int initialCapacity, float loadFactor) {
      if (initialCapacity < 0)
          throw new IllegalArgumentException("Illegal initial capacity: " +
                  initialCapacity);
      if (initialCapacity > MAXIMUM_CAPACITY)
          initialCapacity = MAXIMUM_CAPACITY;
      if (loadFactor <= 0 || Float.isNaN(loadFactor))
          throw new IllegalArgumentException("Illegal load factor: " +
                  loadFactor);
      this.loadFactor = loadFactor;
      this.threshold = tableSizeFor(initialCapacity);
  }
  ```

  ```java
  /**
  * The maximum capacity, used if a higher value is implicitly specified
  * by either of the constructors with arguments.
  * MUST be a power of two <= 1<<30.
  */
  static final int MAXIMUM_CAPACITY = 1 << 30;
  ```

- HashMap(初始化容量)，默认负载因子=0.75

  ```java
  public HashMap(int initialCapacity) {
      this(initialCapacity, DEFAULT_LOAD_FACTOR);
  }
  ```

  ```java
  static final float DEFAULT_LOAD_FACTOR = 0.75f;
  ```

- HashMap()，默认负载因子=0.75，默认初始化容量=16

  ```java
  public HashMap() {
      this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
  }
  ```

  ```java
  /**
  * The default initial capacity - MUST be a power of two.
  */
  static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
  ```

  

------



## 4：读取



## 5：扩容

### 为啥要扩容？

### threshold，扩容阈值

```java
/**
* The next size value at which to resize (capacity * load factor).
*/
int threshold;
```

### resize()，为啥数组长度是2的n次幂？

> 数组长度：太小了resize频繁，太大了浪费空间，

```java
final HashMap.Node<K,V>[] resize() {
    HashMap.Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
    HashMap.Node<K,V>[] newTab = (HashMap.Node<K,V>[])new HashMap.Node[newCap];
    table = newTab;
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            HashMap.Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof HashMap.TreeNode)
                    ((HashMap.TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    HashMap.Node<K,V> loHead = null, loTail = null;
                    HashMap.Node<K,V> hiHead = null, hiTail = null;
                    HashMap.Node<K,V> next;
                    do {
                        next = e.next;
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```



------

## 6：Fail-Fast(快速失败) 机制

- Fail-Fast 机制：当多个线程对同一个集合的内容进行操作时，就可能会产生 fail-fast 事件。当使用迭代器遍历的同时，使用集合本身的remove方法，此时集合发生了结构性改变，也会产生fail-fast事件。使用迭代器的过程中，除非使用迭代器的remove方法，其他任何方式的结构性修改都会抛出ConcurrentModificationException，

- ？？？？？？？因此并发修改中，迭代器很快会fail，

- 集合通过modCount记录集合自己的方法修改集合的次数，很多对集合造成结构性修改的方法会导致modCount++，在迭代器初始化的时候会在expectedModCount中记录当前modCount的值，带迭代过程中modCount != expectedModCount则说明出现了不正常的结构性修改。

  ```java
  if (modCount != expectedModCount)
      throw new ConcurrentModificationException();
  ```

  

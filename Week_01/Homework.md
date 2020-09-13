# 本周作业

## 数据结构与算法脑图

日后会不断更新完善数据结构与算法的知识点。点击查看 -> [点击](https://mubu.com/doc/3MewKNWN19d#m)

## 简单

### 用 add first 或 add last 这套新的 API 改写 Deque 的代码

```java
    Deque<String> deque = new LinkedList<>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    System.out.println(deque);

    String str = deque.getFirst();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
        System.out.println(deque.removeFirst());
    }
    System.out.println(deque);
```

### 分析 Queue 和 Priority Queue 的源码

Queue 在 Java 中是一个接口并且继承于 Collection，具体有以下几种方法：

```java
public interface Queue<E> extends Collection<E> {
    /**
     * 将元素插入队列，插入成功返回 true，如果插入时队列空间不足则抛出异常。
     */
    boolean add(E e);

    /**
     * 将元素插入到有容量限制的队列，插入成功返回 true，如果容量已满则返回 false。
     */
    boolean offer(E e);

    /**
     * 返回队列的头部元素并删除，如果队列为空则抛出异常。
     */
    E remove();

    /**
     * 返回队列的头部元素并删除，如果队列为空则返回 null。
     */
    E poll();

    /**
     * 返回队列的头部元素，如果队列为空则抛出异常。
     */
    E element();

    /**
     * 返回队列的头部元素，如果队列为空则返回 null。
     */
    E peek();
}

```

Priority Queue 是一个优先队列，它继承了 AbstractQueue 类。和普通队列的区别是，它每次出队的元素都是优先级最高的元素。
以下分析它的关键代码部分（基于 Java 8）：

```java

    /**
     * add操作就是调用 offer 方法
     */
    public boolean add(E e) {
        return offer(e);
    }

    public boolean offer(E e) {
        // 说明插入元素不能为null
        if (e == null)
            throw new NullPointerException();
        // 修复次数++
        modCount++;
        // size 为列队中元素个数
        int i = size;
        // queue 是列队内部存放元素的数组
        // 如果当前元素个数大于容量，需要扩容了，扩大为 i + 1
        if (i >= queue.length)
            grow(i + 1);
        // 元素个数+1
        size = i + 1;
        // 如果队列中还没有元素，直接添加到根部
        if (i == 0)
            queue[0] = e;
        else
        //如果已经有元素了，添加到尾部
            siftUp(i, e);
        return true;
    }

    private void grow(int minCapacity) {
        // 记录当前队列的容量
        int oldCapacity = queue.length;
        // 如果当前队列容量小于64则容量+2，否则扩容1.5倍
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // 如果扩容后的容量大于最大值
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // 数组copy，进行扩容
        queue = Arrays.copyOf(queue, newCapacity);
    }

    // 这里最大数组长度是根据 VM (Java虚拟机) int最大值来设定，-8是因为数组中会保留一些头部信息，避免内存溢出。
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private static int hugeCapacity(int minCapacity) {
        // 扩容不能小于0
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        // 如果扩容大于MAX_ARRAY_SIZE，则返回int最大值，否则返回MAX_ARRAY_SIZE
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }

    private void siftUp(int k, E x) {
        // 如果比较器comparator不为空，则调用siftUpUsingComparator方法进行上移操作
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
        // 如果比较器comparator为空，则调用siftUpComparable方法进行上移操作
            siftUpComparable(k, x);
    }

```

### 删除排序数组中的重复项（Facebook、字节跳动、微软在半年内面试中考过）

点击查看 -> [点击](./26.删除排序数组中的重复项.java)

### 旋转数组（微软、亚马逊、PayPal 在半年内面试中考过）

点击查看 -> [点击](./189.旋转数组.java)

### 合并两个有序链表（亚马逊、字节跳动在半年内面试常考）

点击查看 -> [点击](./21.合并两个有序链表.java)

### 合并两个有序数组（Facebook 在半年内面试常考）

点击查看 -> [点击](./88.合并两个有序数组.java)

### 两数之和（亚马逊、字节跳动、谷歌、Facebook、苹果、微软在半年内面试中高频常考）

点击查看 -> [点击](./1.两数之和.java)

### 移动零（Facebook、亚马逊、苹果在半年内面试中考过）

点击查看 -> [点击](./283.移动零.java)

### 加一（谷歌、字节跳动、Facebook 在半年内面试中考过）

点击查看 -> [点击](./66.加一.java)

## 中等

### 设计循环双端队列（Facebook 在 1 年内面试中考过）

点击查看 -> [点击](./641.设计循环双端队列.java)

## 困难

### 接雨水（亚马逊、字节跳动、高盛集团、Facebook 在半年内面试常考）

点击查看 -> [点击](./42.接雨水.java)

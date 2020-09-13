/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {

    /**
     * 大致思路，用 2 个 Stack 保存，fontStack 用于头添加，rearStack 用于尾部添加
     * deleteFront 操作的时候需要注意，如果 fontStack 已经 empty，那么该Deque的第一个元素就是rearStack的最后一个元素，即 fontStack.remove(0)，同理 deleteLast
     * getFront 和 getRear 也是同一个思路。
     **/ 

    Stack<Integer> fontStack = new Stack<>();
    Stack<Integer> rearStack = new Stack<>();

    final int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        fontStack.push(value);
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        rearStack.push(value);
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        if (!fontStack.empty()) {
            fontStack.pop();
        } else {
            rearStack.remove(0);
        }
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        if (!rearStack.empty()) {
            rearStack.pop();
        } else {
            fontStack.remove(0);
        }
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty())
            return -1;
        if (!fontStack.empty()) {
            return fontStack.peek();
        } else {
            return rearStack.elementAt(rearStack.size() - 1);
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty())
            return -1;
        if (!rearStack.empty()) {
            return rearStack.peek();
        } else {
            return fontStack.elementAt(fontStack.size() - 1);
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return fontStack.empty() && rearStack.empty();
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return fontStack.size() + rearStack.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end


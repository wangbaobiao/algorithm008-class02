package structure.leetCode.weekWork;

public class MyCircularDeque {

    private int[] ring;

    private int capacity;

    private int head;

    private int tail;

    /**
     * 641. 设计循环双端队列
     * 设计实现双端队列。
     * @param nums
     */
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        //构造函数,双端队列的大小为k。
        // 画的队满的情况，tail=3，head=4，n=8，所以总结一下规律就是：(3+1)%8=4。多画几张队满的图，你就会发现，当队满时，(tail+1)%n=head。
        // 因为环形队列需要一个空位判断队列为空
        //当(tail+1)%n=head时，说明是一个环境队列
        capacity = k + 1;
        //环形数组的大小 k+1
        ring = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        //将一个元素添加到双端队列头部。 如果操作成功返回 true。
        if ((tail + 1) % capacity == head){
            return false;
        }
        ring[head] = value;
        head ++;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        //将一个元素添加到双端队列尾部。如果操作成功返回 true。
        if ((tail + 1) % capacity == head){
            return false;
        }
        ring[tail] = value;
        tail ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        //从双端队列头部删除一个元素。 如果操作成功返回 true。
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        //从双端队列尾部删除一个元素。如果操作成功返回 true。
        if (isEmpty()){
            return false;
        }
        tail = (tail + capacity - 1) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        //从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
        if (isEmpty()) {
            return -1;
        }

        return ring[head];

    }

    /** Get the last item from the deque. */
    public int getRear() {
        //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
        return 1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        //检查双端队列是否为空。
        return head == tail;

    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        //检查双端队列是否满了。
        System.out.println((tail + 1) % capacity);
        return (tail + 1) % capacity == head;
    }


    public static void main(String[] args) {
        MyCircularDeque solution = new MyCircularDeque(1);
        boolean flag = solution.isFull();
        System.out.println(flag);
        System.out.println(solution.isEmpty());
    }


}

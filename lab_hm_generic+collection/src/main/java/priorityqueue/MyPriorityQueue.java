package priorityqueue;

import shipwithdroid.Droid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyPriorityQueue<T extends Droid & Comparable<Droid>> implements MyQueue<T> {
    private Object[] queue;
    private static final int CAPACITY = 11;
    private int size = 0;
    private Comparator<? super T> comparator;

    public MyPriorityQueue() {
        queue = new Object[CAPACITY];
    }

    public MyPriorityQueue(int initCapacity, Comparator<? super T> comparator) {
        this.queue = new Object[initCapacity];
        this.comparator = comparator;
    }

    public MyPriorityQueue(Comparator<? super T> comparator) {
        this.queue = new Object[CAPACITY];
        this.comparator = comparator;
    }

    public T peek() {
        return size == 0 ? null : (T) queue[0];
    }

    public boolean add(T e) {
        return offer(e);
    }

    public boolean offer(T e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (queue.length <= size) {
            growArray();
        }
        if (size == 0) {
            queue[size] = e;
            size++;
            return true;
        }
        sort(e);
        size++;
        return true;
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T res = (T) queue[0];
        if (size == 1) {
            queue[0] = null;
        } else {
            copyDeleteArray(0);
            queue[size - 1] = null;
        }
        size--;
        return res;
    }

    public void remove() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            queue[0] = null;
        } else {
            copyDeleteArray(0);
            queue[size - 1] = null;
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void growArray() {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity << 2;
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private void copyAddArray(int index) {
        System.arraycopy(queue, index, queue, index + 1, size - index);
    }

    private void sort(T e) {
        if (comparator == null) {
            sortWithComparable(e);
        } else {
            sortWithComparator(e);
        }
    }

    private void copyDeleteArray(int index) {
        System.arraycopy(queue, index + 1, queue, index, size);
    }

    private void sortWithComparable(T e) {
        Comparable<? super T> key = e;
        int i = 0;
        while (i < size) {
            if (key.compareTo((T) queue[i]) >= 0) {
                ++i;
            } else {
                break;
            }
        }
        copyAddArray(i);
        queue[i] = key;
    }

    private void sortWithComparator(T e) {
        int i = 0;
        while (i < size) {
            if (comparator.compare(e, (T) queue[i]) >= 0) {
                ++i;
            } else {
                break;
            }
        }
        copyAddArray(i);
        queue[i] = e;
    }

    public void clear() {
        for (int i = 0; i < size; ++i) {
            queue[i] = null;
        }
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public MyIterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator<T> implements Iterator<T> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size || queue[currentIndex] != null;
        }

        public T next() {
            return (T) queue[currentIndex++];
        }
    }
}

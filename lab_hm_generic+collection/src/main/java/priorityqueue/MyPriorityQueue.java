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
        this.queue = new Object[11];
    }

    public MyPriorityQueue(int initCapacity, Comparator<? super T> comparator) {
        this.queue = new Object[initCapacity];
        this.comparator = comparator;
    }

    public MyPriorityQueue(Comparator<? super T> comparator) {
        this.queue = new Object[11];
        this.comparator = comparator;
    }

    public T peek() {
        return this.size == 0 ? null : (T)this.queue[0];
    }

    public boolean add(T e) {
        return this.offer(e);
    }

    public boolean offer(T e) {
        if (e == null) {
            throw new NullPointerException();
        } else {
            if (this.queue.length <= this.size) {
                this.growArray();
            }

            if (this.size == 0) {
                this.queue[this.size] = e;
                ++this.size;
                return true;
            } else {
                this.sort(e);
                ++this.size;
                return true;
            }
        }
    }

    public T poll() {
        if (this.size == 0) {
            return null;
        } else {
            T res = (T)this.queue[0];
            if (this.size == 1) {
                this.queue[0] = null;
            } else {
                this.copyDeleteArray(0);
                this.queue[this.size - 1] = null;
            }

            --this.size;
            return res;
        }
    }

    public void remove() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (this.size == 1) {
                this.queue[0] = null;
            } else {
                this.copyDeleteArray(0);
                this.queue[this.size - 1] = null;
            }

            --this.size;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void growArray() {
        int oldCapacity = this.queue.length;
        int newCapacity = oldCapacity << 2;
        this.queue = Arrays.copyOf(this.queue, newCapacity);
    }

    private void copyAddArray(int index) {
        System.arraycopy(this.queue, index, this.queue, index + 1, this.size - index);
    }

    private void sort(T e) {
        if (this.comparator == null) {
            this.sortWithComparable(e);
        } else {
            this.sortWithComparator(e);
        }

    }

    private void copyDeleteArray(int index) {
        System.arraycopy(this.queue, index + 1, this.queue, index, this.size);
    }

    private void sortWithComparable(T e) {
        Comparable<? super T> key = e;
        int i = 0;

        while(i < this.size) {
            if (key.compareTo((T)this.queue[i]) >= 0) {
                if (this.size - 1 != i) {
                    ++i;
                    continue;
                }

                ++i;
            }

            this.copyAddArray(i);
            this.queue[i] = key;
            break;
        }

    }

    private void sortWithComparator(T e) {
        int i = 0;

        while(i < this.size) {
            if (this.comparator.compare(e, (T)this.queue[i]) >= 0) {
                if (this.size - 1 != i) {
                    ++i;
                    continue;
                }

                ++i;
            }

            this.copyAddArray(i);
            this.queue[i] = e;
            break;
        }

    }

    public void clear() {
        for(int i = 0; i < this.size; ++i) {
            this.queue[i] = null;
        }

        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public MyIterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator<T> implements Iterator<T> {
        private int currentIndex;

        private MyIterator() {
            this.currentIndex = 0;
        }

        public boolean hasNext() {
            return this.currentIndex < MyPriorityQueue.this.size || MyPriorityQueue.this.queue[this.currentIndex] != null;
        }

        public T next() {
            return (T) queue[this.currentIndex++];
        }

        public void remove() {
            if (MyPriorityQueue.this.size == 0) {
                throw new IndexOutOfBoundsException();
            } else {
                if (MyPriorityQueue.this.size == 1) {
                    MyPriorityQueue.this.queue[0] = null;
                } else {
                    MyPriorityQueue.this.copyDeleteArray(this.currentIndex);
                    MyPriorityQueue.this.queue[MyPriorityQueue.this.size - 1] = null;
                }

                MyPriorityQueue.this.size--;
            }
        }
    }
}

package mydeque;

import java.util.Deque;

public interface DequeCollection<T> {
    void addFirst(T t);
    void addLast(T t);
    T getFirst();
    T getLast();
    T peekFirst();
    T peekLast();
    T pollFirst();
    T pollLast();
    int size();
}

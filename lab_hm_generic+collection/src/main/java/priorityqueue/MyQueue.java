package priorityqueue;


import shipwithdroid.Droid;

public interface MyQueue<T extends Droid> extends Iterable <T>{
    T peek();
    boolean add(T var1);
    boolean offer(T var1);
    T poll();
    void remove();
    boolean isEmpty();
    void clear();
    int size();
}

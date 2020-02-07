package mydeque;

import java.util.NoSuchElementException;

public class MyDeque<T> implements DequeCollection<T> {
    private Node<T> fstNode;
    private Node<T> lstNode;
    private int size = 0;

    public void addFirst(T t) {
        Node<T> fresh = new Node<T>(t);
        if (size == 0) {
            fstNode = fresh;
            lstNode = fresh;
        } else {
            fstNode.prevElement = fresh;
            fresh.nextElement = fstNode;
            fstNode = fresh;
        }
        size++;
    }

    public void addLast(T t) {
        Node<T> fresh = new Node<T>(t);
        if (size == 0) {
            fstNode = fresh;
            lstNode = fresh;
        } else {
            lstNode.nextElement = fresh;
            fresh.prevElement = lstNode;
            lstNode = fresh;
        }
        size++;
    }


    public T getFirst() {
        if (fstNode == null) {
            throw new NoSuchElementException();
        }
        return fstNode.currentElement;
    }


    public T getLast() {
        if (lstNode == null) {
            throw new NoSuchElementException();
        }
        return lstNode.currentElement;
    }

    public T peekFirst() {
        return (fstNode == null) ? null : fstNode.currentElement;
    }

    public T peekLast() {
        return (lstNode == null) ? null : lstNode.currentElement;
    }

    public T pollFirst() {
        if (fstNode == null) {
            return null;
        }
        T element  = fstNode.currentElement;
        fstNode = fstNode.nextElement;
        if (fstNode == null) {
            lstNode = null;
        }else fstNode.prevElement = null;
        size--;
        return element;
    }

    public T pollLast() {
        if (lstNode == null) {
            return null;
        }
        T element  = lstNode.currentElement;
        lstNode = lstNode.prevElement;
        if (lstNode == null) {
            fstNode = null;
        }else lstNode.nextElement = null;
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node<T> {
        private T currentElement;
        private Node<T> prevElement;
        private Node<T> nextElement;

        public Node(T currentElement) {
            this.currentElement = currentElement;
        }

    }
}

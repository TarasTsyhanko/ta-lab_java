package mytreemap;

import java.util.Comparator;
import java.util.TreeMap;

public class MyTreeMap<K, V> {
    private Entry<K, V> root;
    private Comparator<? super K> comparator;
    private int size = 0;
    public MyTreeMap(Comparator<? super K> comparator){
        this.comparator = comparator;
    }
    public MyTreeMap(){

    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return (entry == null ? null : entry.value);
    }
    public int size(){
        return this.size;
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            root = new Entry<K, V>(key, value, null);
            size = 1;
            return null;
        }
        Entry<K, V> t = root;
        Entry<K, V> parent;
        int compare;
        if (comparator != null) {
            do {
                parent = t;
                compare = comparator.compare(key, t.key);
                if (compare < 0)
                    t = t.left;
                else if (compare > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        } else {
            Comparable<? super K> comparable = (Comparable<? super K>) key;
            do {
                parent = t;
                compare = comparable.compareTo(t.key);
                if (compare < 0)
                    t = t.left;
                else if (compare > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        Entry<K, V> entry = new Entry<K, V>(key, value, parent);
        if (compare < 0) {
            parent.left = entry;
        } else {
            parent.right = entry;
        }
        size++;
        return null;
    }

    private Entry<K, V> getEntry(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (comparator != null) {
            return useComparator(key);
        }
        Entry<K, V> t = root;
        Comparable<? super K> comparable = (Comparable<? super K>) key;
        while (t != null) {
            int compare = comparable.compareTo(t.key);
            if (compare < 0)
                t = t.left;
            else if (compare > 0)
                t = t.right;
            else {
                return t;
            }
        }
        return null;
    }

    private Entry<K, V> useComparator(K key) {
        Entry<K, V> t = root;
        while (t != null) {
            int compare = comparator.compare(key, t.key);
            if (compare < 0)
                t = t.left;
            else if (compare > 0)
                t = t.right;
            else
                return t;
        }
        return null;
    }

    class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> right;
        private Entry<K, V> left;
        private Entry<K, V> parent;

        public Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public Entry<K, V> getParent() {
            return parent;
        }

        public void setParent(Entry<K, V> parent) {
            this.parent = parent;
        }
    }
}

package mytreemap;

import java.util.*;

public class MyTreeMap<K, V> implements MyMap<K, V> {
    private Entry<K, V> root;
    private Comparator<? super K> comparator;
    private int size = 0;

    public MyTreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public MyTreeMap() {
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return (entry == null ? null : entry.value);
    }

    public int size() {
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
                if (compare < 0) {
                    t = t.left;
                } else if (compare > 0) {
                    t = t.right;
                } else {
                    return t.setValue(value);
                }
            } while (t != null);
        } else {
            Comparable<? super K> comparable = (Comparable<? super K>) key;
            do {
                parent = t;
                compare = comparable.compareTo(t.key);
                if (compare < 0) {
                    t = t.left;
                } else if (compare > 0) {
                    t = t.right;
                } else {
                    return t.setValue(value);
                }
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

    public V remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        deleteEntry(entry);
        size--;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public Entry<K, V> firstEntry() {
        return getFirstEntry();
    }

    public Entry<K, V> lastEntry() {
        return getLastEntry();
    }

    private void deleteEntry(Entry<K, V> p) {
        if (p == root) {
            deleteRoot();
        } else {
            if (p.parent.right == p) {
                deleteRight(p);
            } else if (p.parent.left == p) {
                deleteLeft(p);
            }
        }
    }

    private void deleteRoot() {
        if (size == 1) {
            root = null;
        } else {
            if (root.left == null && root.right != null) {
                root = root.right;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else root = root.right;
        }
    }

    public void addAll(Map<? extends K, ? extends V> map) {
        Set<? extends K> keys = map.keySet();
        keys.forEach(key -> put(key, map.get(key)));
    }

    private Entry<K, V> getFirstEntry() {
        Entry<K, V> entry = root;
        if (entry != null) {
            while (entry.left != null) {
                entry = entry.left;
            }
        }
        return entry;
    }

    private Entry<K, V> getLastEntry() {
        Entry<K, V> entry = root;
        if (entry != null) {
            while (entry.right != null) {
                entry = entry.right;
            }
        }
        return entry;
    }

    private void deleteRight(Entry<K, V> p) {
        if (p.right != null) {
            p.parent.right = p.right;
            p.right.parent = p.parent;
            if (p.left != null) {
                Entry<K, V> entry = getLastLeft(p.right);
                p.left.parent = entry;
                entry.left = p.left;
            }
        } else if (p.left != null) {
            p.parent.right = p.left;
            p.left.parent = p.parent;
        } else {
            p.parent.right = null;
        }
    }

    private void deleteLeft(Entry<K, V> p) {
        if (p.right != null) {
            p.right.parent = p.parent;
            p.parent.left = p.right;
            if (p.left != null) {
                Entry<K, V> entry = getLastLeft(p.right);
                p.left.parent = entry;
                entry.left = p.left;
            }
        } else if (p.left != null) {
            p.parent.left = p.left;
            p.left.parent = p.parent;
        } else {
            p.parent.left = null;
        }
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

    private Entry<K, V> getLastLeft(Entry<K, V> entry) {
        Entry<K, V> p = entry;
        while (true) {
            if (p.left == null) {
                return p;
            }
            p = p.left;
        }
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

    public Iterator<K> keyIterator() {
        return new KeyIterator(getFirstEntry());
    }

    public Iterator<V> valueIterator() {
        return new ValueIterator(getFirstEntry());
    }

    public Iterator<Entry<K, V>> iterator() {
        return new EntryIterator(getFirstEntry());
    }

    private abstract class MyEntryIterator<T> implements Iterator<T> {
        Entry<K, V> next;

        public MyEntryIterator(Entry<K, V> firstEntry) {
            this.next = firstEntry;
        }

        public final boolean hasNext() {
            return next != null;
        }

        public final Entry<K, V> nextEntry() {
            Entry<K, V> e = next;
            if (e == getLastEntry()){
                next = null;
            }else if (next.right != null) {
                next = next.right;
                if (next.left != null) {
                    while (next.left != null) {
                        next = next.left;
                    }
                }
            } else if (next.parent != null) {
                if (next.parent.left == next) {
                    next = next.parent;
                } else {
                    if (next.parent.parent != null) {
                        while (next.parent != null){
                            next = next.parent;
                        if (next.parent.left == next) {
                            next = next.parent;
                            break;
                        }
                    }}
                }
            }
            if (next == e) {
                next = null;
            }
            return e;
        }
    }

    private final class EntryIterator extends MyEntryIterator<Entry<K, V>> {
        EntryIterator(Entry<K, V> firstEntry) {
            super(firstEntry);
        }

        public Entry<K, V> next() {
            return nextEntry();
        }
    }

    private final class ValueIterator extends MyEntryIterator<V> {
        ValueIterator(Entry<K, V> firstEntry) {
            super(firstEntry);
        }

        public V next() {
            return nextEntry().value;
        }
    }

    private final class KeyIterator extends MyEntryIterator<K> {
        KeyIterator(Entry<K, V> firstEntry) {
            super(firstEntry);
        }

        public K next() {
            return nextEntry().key;
        }
    }

    static final class Entry<K, V> {
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

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key.equals(entry.key) &&
                    value.equals(entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public V getValue() {
            return value;
        }
    }
}

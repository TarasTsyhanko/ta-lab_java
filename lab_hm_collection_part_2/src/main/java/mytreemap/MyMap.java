package mytreemap;

import java.util.Iterator;
import java.util.Map;

public interface MyMap<K,V> extends Iterable<MyTreeMap.Entry<K, V>> {
    int size();
    void clear();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    public V remove(K key);
    MyTreeMap.Entry<K, V> firstEntry();
    MyTreeMap.Entry<K, V> lastEntry();
    public void addAll(Map<? extends K, ? extends V> map);
    Iterator<MyTreeMap.Entry<K, V>> iterator();
}

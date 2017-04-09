package hashmap;

/**
 * Created by sudhirkumar on 4/9/17.
 * Let’s create an Entry class. We need a key, which can’t change,
 * a value, which can change,
 * and a pointer to next so we can make our array that has 0..N entries in each spot.
 */
public class Entry<K,V> {
    private Entry<K, V> next;
    private final K key;
    private V val;

    public Entry(K key, V val) {
        this.key = key;

        setValue(val);
    }

    public void setValue(V val) {
        this.val = val;
    }

    public K getKey()
    {
        return this.key;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public V getVal() {
        return val;
    }

    public Entry<K, V> setNext(Entry<K, V> next)
    {
        this.next = next;
        return next;
    }
}

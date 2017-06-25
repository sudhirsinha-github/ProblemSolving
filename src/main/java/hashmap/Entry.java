package hashmap;

/**
 * Created by sudhirkumar on 4/9/17.
 * Let’s create an Entry class. We need a FINAL key, which can’t be changed,
 * a value, which can change,
 * and a pointer to next so we can make our array that has 0..N entries in each spot.LEAKY_BUCKET (list)
 */
public class Entry<K,V> {
    private Entry<K, V> next;
    private final K key; // reason bieng need to set in CTOR 1c
    private V val;

    public Entry(K key, V val) {
        this.key = key;

        setValue(val);
    }

    public K getKey()
    {
        return this.key;
    }
    public V getVal() {
        return val;
    }

    public void setValue(V val) {
        this.val = val;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public Entry<K, V> setNext(Entry<K, V> next) {
        this.next = next;
        return next;
    }
}

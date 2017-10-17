package hashmap;

public class CustomHashMap<K, V> {
    private int DEFAULT_BUCKET_SIZE = 10;
    private Entry<K, V>[] bucket;

    public CustomHashMap() {
        this.bucket = new Entry[DEFAULT_BUCKET_SIZE];
    }

    /**
     * give custom size
     *
     * @param size
     */
    public CustomHashMap(int size) {
        this.bucket = new Entry[size];
    }

    public V getVal(K key) {
        CheckKeyNull(key);

        Entry<K, V> entry = bucket[bucketIndexOfKey(key)];
        while (entry != null && !key.equals(entry.getKey()))
            entry = entry.getNext(); // goto next node like linked list..

        return entry.getVal();
    }

    public void putValue(K key, V val)
    {
        CheckKeyNull(key);

        Entry<K, V> newEntry = bucket[bucketIndexOfKey(key)]; //get the index of bucket array.. if it contains item?

        if(null != newEntry) {

            boolean check = false;
            while (!check) {
                if (key.equals(newEntry.getKey())) { // Update the old value
                    newEntry.setValue(val);
                    check = true;
                } else if (newEntry.getNext() == null) { // set NExt with new Entry obj
                    newEntry.setNext(new Entry<K, V>(key, val));
                    check = true;
                }

                // Continue looping till above match happens or Next is null
                // to insert newEntry
                newEntry = newEntry.getNext();
            }
        }
        else {

            //Then make a new entry in bucket >> Inserted
            bucket[bucketIndexOfKey(key)] = new Entry<K, V>(key, val);
        }

    }

    private void CheckKeyNull(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key value can't be null");
    }

    private int bucketIndexOfKey(K key) {
        return key.hashCode() % bucket.length;
    }

//    private int hashFunction(int keyhashCode) {
//        return keyhashCode % bucket.length;
//    }

}

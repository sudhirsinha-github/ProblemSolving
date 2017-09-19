package lru;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by sudhirkumar on 4/5/17.
 */
/*class LRUCache<K, V> extends LinkedHashMap<K, V>{
    private int capacity;

    public LRUCache(int initialCapacity, int capacity) {
        super(initialCapacity,1.0f, true);
        this.capacity = capacity;
    }
http://www.codewalk.com/2012/04/least-recently-used-lru-cache-implementation-java.html
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}*/
public class MyLRU {

    private static final int max = 3;


    Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(max){

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {

            return map.size() > max;
        }
    };

    int getCachedValue(int x)
    {
        return map.get(x);
    }

    int getFreshValue(int x)
    {
        //x = x + 2;
        // do some computation ...
        return x;
    }

    int getValue(int x)
    {
        int result = 0;
        if(map.containsKey(x)){
         result = getCachedValue(x);
        }
        else {
        result = getFreshValue(x);
        }

        /*if(hashMap.containsKey(x)){
            hashMap.remove(x);
        }*/

        map.put(x, result);

        return result;
    }

    public static void main(String[] args) {
        MyLRU lru = new MyLRU();
        // int a[] = {2,1,3,0,1,2,3};
        int a[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};

        for (int i = 0; i < a.length; i++) {
            /*if(i > 0){
                lru.getValue( 1);
            }*/

            /*lru.getValue(i);
            lru.getValue(i*10);*/
            lru.getValue(a[i]);
            System.out.println(lru.map);
        }

        System.out.println(lru.map);

    }

}

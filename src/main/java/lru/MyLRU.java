package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sudhirkumar on 4/5/17.
 */
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

        /*if(map.containsKey(x)){
            map.remove(x);
        }*/

        map.put(x, result);

        return result;
    }

    public static void main(String[] args) {
        MyLRU lru = new MyLRU();
        int a[] = {2,1,3,0,1,2,3};

        for (int i = 0; i < a.length; i++) {
            if(i > 0){
                lru.getValue( 1);
            }

            /*lru.getValue(i);
            lru.getValue(i*10);*/
            lru.getValue(a[i]);
            System.out.println(lru.map);
        }
    }

}

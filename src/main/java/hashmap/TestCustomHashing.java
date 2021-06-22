package hashmap;


import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

/**
 * Created by sudhirkumar on 4/9/17.
 */
public class TestCustomHashing {

    @Test
    public void readWriteSimpleValue() {
        CustomHashMap<String, Duck> map = new CustomHashMap<String, Duck>();http://gadgets.ndtv.com/internet/news/apple-secret-job-posting-looks-for-talented-engineer-1739976
        map.putValue("duck", new Duck("duck",2));
        map.putValue("goose", new Duck("goose",4));
        assertEquals(2, map.getVal("duck").getWeight());
        assertEquals(4, map.getVal("goose").getWeight());
    }

    @Test(expected = NullPointerException.class)
    public void getSomethingThatIsntThere(){
        CustomHashMap<Integer, String> map = new CustomHashMap<Integer, String>();
        assertEquals(null, map.getVal(412));
    }

    @Test
    public void overWriteValue() {
        CustomHashMap<Integer, String> map = new CustomHashMap<Integer, String>();
        map.putValue(1, "OLD D1");
        map.putValue(11, "Moon");
        System.out.println(map.getVal(1));
        System.out.println(map.getVal(11));

        map.putValue(42, "OLD D1");
        assertEquals("OLD D1", map.getVal(42));

        map.putValue(42, "NEW D1");
        assertEquals("NEW D1", map.getVal(42));
    }

    @Test
    public void doNOtOverWriteValueInsertNew() {
        CustomHashMap<Integer, String> map = new CustomHashMap<Integer, String>();
        map.putValue(42, "OLD D1");
        assertEquals("OLD D1", map.getVal(42));

        map.putValue(2, "NEW D1");
        assertEquals("NEW D1", map.getVal(2));
    }

    /**
     * A simple Util class
     **/
    class Duck {
        private String name;
        private int weight;

        public Duck(String name, int weight){
            this.name = name;
            this.weight = weight;
        }

        public String getName(){return name;}
        public int getWeight(){return weight;}

        @Override
        public String toString(){
            return format("name:\t%s\tweight:\t%d");
        }
    }//class
}
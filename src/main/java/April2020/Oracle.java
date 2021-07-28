package April2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Oracle {
// realtime deadlock condition in app?


    // ConcurrentHashMap internal

    ArrayList<Node> nodeArrayList = new ArrayList<>();
    // add(){}

    // get
    Node get(int key){
        return nodeArrayList.get(key).data;
    }

}
class Node {
    // it will have key value
    int key;
    Node data;
}

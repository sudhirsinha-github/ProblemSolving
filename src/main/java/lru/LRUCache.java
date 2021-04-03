package lru;

import java.util.HashMap;

class Node{
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> hashMap = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(hashMap.containsKey(key)){
            Node node = hashMap.get(key);
            // remove the node and set this node as head
            remove(node);
            setHead(node);

            return node.value;
        }
 
        return -1;
    }
 
    public void remove(Node node){
        if(node.previous !=null){
            node.previous.next = node.next;
        }else{
            head = node.next;
        }
 
        if(node.next!=null){
            node.next.previous = node.previous;
        }else{
            end = node.previous;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.previous = null;
 
        if(head!=null)
            head.previous = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(hashMap.containsKey(key)){
            Node old = hashMap.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(hashMap.size()>=capacity){
                hashMap.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            hashMap.put(key, created);
        }
    }

    public static void main(String[] args) {
        int capac = 3;
        LRUCache lru = new LRUCache(capac);
        // int a[] = {2,1,3,0,1,2,3};
        int a[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};

        for (int i = 0; i < a.length; i++) {
            /*if(i > 0){
                lru.getValue( 1);
            }*/

            /*lru.getValue(i);
            lru.getValue(i*10);*/
            lru.set(capac, a[i]);
            if(capac> 0)
            {
                capac--;
            }
            else {
                capac =3;
            }
        }

        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
    }
}
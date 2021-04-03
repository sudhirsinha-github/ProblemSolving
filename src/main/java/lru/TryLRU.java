package lru;

import java.util.HashMap;

/**
 * Created by sudhirkumar on 8/10/17.
 */

/*
Double linked List for both way traversal
 */
class DNode {
    int data;
    DNode leftlink;
    DNode rightlink;

    public DNode(int data) {
        this.data = data;
    }
}

public class TryLRU {
    private int MAX_SIZE = 3;
    HashMap<Integer, DNode> nodeHashMap;
    DNode head;

    public TryLRU(int capacity) {
        if(capacity == 0 || capacity >= MAX_SIZE) {
            nodeHashMap = new HashMap<>(MAX_SIZE);
        }
        else {
            this.MAX_SIZE = capacity;
            nodeHashMap = new HashMap<>(capacity);
        }
    }

    private void insertInFront(DNode first) {
        // first.leftlink = null;
        if (head != null) {
            first.rightlink = head;
            head.leftlink = first;
            head = first;
        } else {
            head = first;
        }
    }

    /*
    Deleting specific node ,either end or at any place
     */
    private void remove(DNode node)
    {
        if(node.rightlink == null)
        {
            node.leftlink.rightlink = null;
        }
        else {
            node.leftlink.rightlink = node.rightlink;
            node.rightlink.leftlink = node.leftlink;
        }
    }


    int getValue(int key) {
        if (nodeHashMap.containsKey(key)) {
            DNode getNode = nodeHashMap.get(key);
            remove(getNode);
            insertInFront(nodeHashMap.get(key));

            return nodeHashMap.get(key).data;
        } else
            return -1;
    }

    void setValue(int key, DNode node)
    {
        if(nodeHashMap.containsKey(key))
        {
            DNode getNode = nodeHashMap.get(key);

            remove(getNode);
            insertInFront(getNode);
        }
        else {
            if(nodeHashMap.size() >= MAX_SIZE){
                nodeHashMap.remove(MAX_SIZE);
                remove(nodeHashMap.get(MAX_SIZE));
                insertInFront(node);
            }
            else {
                insertInFront(node);
            }
        }

        nodeHashMap.put(key, node);
    }

    public static void main(String[] args) {
        TryLRU lru = new TryLRU(3);
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(0);
        DNode node3 = new DNode(2);
        DNode node4 = new DNode(0);
        DNode node5 = new DNode(1);
        node1.leftlink = node2;
        node2.rightlink = node1;
        node2.leftlink = node3;
        node3.rightlink = node2;
        node3.leftlink = node4;
        node4.rightlink = node3;
        node4.leftlink = node5;

        lru.setValue(1, node1);
        lru.setValue(2, node2);
        lru.setValue(3, node3);

        lru.getValue(2);

        lru.setValue(1, node4);
        lru.setValue(2, node5);

        System.out.println(lru.getValue(1));
        System.out.println(lru.getValue(3));

    }
}

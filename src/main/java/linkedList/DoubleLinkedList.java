package linkedList;

import java.util.LinkedList;

/**
 * Created by sudhirkumar on 8/10/17.
 */
class Node {
    int data;
    Node leftlink;
    Node rightlink;

    public Node(int data) {
        this.data = data;
        this.leftlink = null;
        this.rightlink = null;
    }
}


public class DoubleLinkedList {
    Node init(){
        Node first = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        first.leftlink = null;
        first.rightlink = sec;
        sec.leftlink= first;
        sec.rightlink = third;
        third.leftlink = sec;
        third.rightlink = null;

        return first;
    }

    void displayData(Node first) {
        Node curr = first;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.rightlink;
        }
    }

    Node insert(Node first,boolean isFront) {
        Node temp;

        if (isFront) {
            temp = new Node(4);
            temp.rightlink = first;
            first.leftlink = temp;
            first = temp;
        } else {
            temp = new Node(12);
            Node curr = first;
            while (curr.rightlink != null) {
                curr = curr.rightlink;
            }

            curr.rightlink = temp;
            temp.leftlink = curr;
        }

        return first;
    }

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        Node first = linkedList.init();
        linkedList.displayData(first);

        first = linkedList.insert(first, true);
        first = linkedList.insert(first, false);
        linkedList.displayData(first);

    }
}

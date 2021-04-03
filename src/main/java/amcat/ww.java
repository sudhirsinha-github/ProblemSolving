/*
package amcat;

public class ww {
    
    static char maxChar(Node head) {
        Node p = head;
        int[] haser={0};

        // Storing element's frequencies 
        // in a haser table. 
        while (p != null) {
            haser[p.data]++;
            p = p.next;
        }

        p = head;

        int max = -1;
        char res=' ';

        // calculating the first maximum element 
        while (p != null) {
            if (max < haser[p.data]) {
                res = p.data;
                max = haser[p.data];
            }
            p = p.next;
        }
        return res;
    }

    */
/* Push a node to linked list. Note that
       this function changes the head *//*

    static void push(Node head_ref, char new_data) {
        Node new_Node = new Node();
        new_Node.data = new_data;
        new_Node.next = (head_ref);
        (head_ref) = new_Node;
    }

    */
/* Drier program to test above function*//*

    public static void main(String[] args) {
        Node head = null;
        char[] str = "skeegforskeeg".toCharArray();
        for (int i = 0; str[i] != '\0'; i++)
            push(head, str[i]);
        System.out.println(maxChar(head));

    }
}


class Node {
        char data;
        Node next;
};
*/

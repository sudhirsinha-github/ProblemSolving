package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintRightSiblings {

    public static void main(String[] args) {
        Node root = new Node(1, null);
        Node left = new Node(2, root);
        Node leftLChild = new Node(4, left);
        Node leftRightChild = new Node(5, left);
        left.left = leftLChild;
        left.right = leftRightChild;

        Node right = new Node(3, root);
        Node rightlChild = new Node(6, root);
        Node rightrChild = new Node(7, root);
        right.left = rightlChild;
        right.right = rightrChild;
        root.left = left;
        root.right = right;

        bfs(root, 4);
    }

    static Queue<Node> nodeQueue = new LinkedList<Node>();

    private static void bfs(Node root, int data) {
        nodeQueue.add(root);
        int level = 1;
        while (!nodeQueue.isEmpty()) {

            Node tempNode = nodeQueue.poll();

            System.out.println(tempNode.data);

            if (null != tempNode.left)
                nodeQueue.add(tempNode.left);

            if (null != tempNode.right)
                nodeQueue.add(tempNode.right);
        }
    }
}

 class Node {
     int data;
     Node left;
     Node right;
     Node parent;
     Node(int data,Node parent){
         this.data = data;
         this.parent = parent;
     }
 }

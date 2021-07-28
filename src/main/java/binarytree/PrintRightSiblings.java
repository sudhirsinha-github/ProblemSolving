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
        while (!nodeQueue.isEmpty()) {

            Node tempNode = nodeQueue.poll();

            System.out.println(tempNode.data);

            if (null != tempNode.left)
                nodeQueue.add(tempNode.left);

            if (null != tempNode.right)
                nodeQueue.add(tempNode.right);
        }
    }

    private static Node getSiblings(Node root, int key) {
        if (root.data == key || root == null) {
            return null;
        }

        if (root.left != null && root.left.data == key) {
            return root.right;
        }

        if (root.right != null && root.right.data == key) {
            return root.left;
        }

        if (getSiblings(root.right, key) == null)
            return getSiblings(root.right, key);
        else
            return getSiblings(root.left, key);
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

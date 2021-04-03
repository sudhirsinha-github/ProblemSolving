package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sudhirkumar on 6/30/17.
 */
public class BinaryTree {
    public static Node createTree()
    {
        Node root = new Node(8);
        Node rootLeft = new Node(4);
        Node rootRight = new Node(10);
        Node rootRight_left = new Node(9);
        Node rootRight_right = new Node(12);
        Node rootLeft_left = new Node(1);
        Node rootLeft_right = new Node(5);
        rootLeft.left = rootLeft_left;
        rootLeft.right = rootLeft_right;
        rootRight.left = rootRight_left;
        rootRight.right = rootRight_right;
        root.left = rootLeft;
        root.right = rootRight;

        return root;
    }

    public static void preOrderTraversal(Node node){
        if(node == null)
            return;

        System.out.print(" --> " + node.data); //Root -> LEFT -> RIGHT
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }


    public static void inOrderTraversal(Node node){
        if(node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(" --> " + node.data); //LEFT ->Root -> RIGHT
        inOrderTraversal(node.right);
    }

    // Find the element
    public int findElement(Node node)
    {

        return 1;
    }

    //depth of tree
    public static int depthOfTree(Node root)
    {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        if(root.left == null)
            return depthOfTree(root.right)+1;

        if(root.right == null)
            return depthOfTree(root.left)+1;


        return Math.min(depthOfTree(root.left), depthOfTree(root.right))+1;
    }

    public static void postOrderTraversal(Node node){
        if(node == null)
            return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(" --> " + node.data); //LEFT -> RIGHT--Root ->
    }

    public static void main(String[] args) {
        Node node = createTree();

        /*System.out.println(" ------ ********preOrderTraversal*******----------------");
        preOrderTraversal(node);
        System.out.println(" ------ ********inOrderTraversal*******----------------");
        inOrderTraversal(node);
        System.out.println(" ------ ***********postOrderTraversal****----------------");
        postOrderTraversal(node);*/

        //System.out.println(depthOfTree(node));

        // printGivenLevel(node, 1);

        // printLevelWithQueue(node);

        printInOrderWithStack(node);
    }

    static void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }


    static void printLevelWithQueue(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + "----");

            if (tempNode.left != null)
                queue.add(tempNode.left);

            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    static void printInOrderWithStack(Node root)
    {
     Stack<Node> nodeStack = new Stack<>();

     while (root != null)
     {
         nodeStack.push(root);
         root = root.left;
     }

     while(nodeStack.size() > 0)
     {
         Node tempNode = nodeStack.pop();
         System.out.println(tempNode.data);

         if (tempNode.right != null) {
             tempNode = tempNode.right;
             while (tempNode != null){
                 nodeStack.push(tempNode);
                 tempNode = tempNode.left;
             }

         }
     }

    }
}

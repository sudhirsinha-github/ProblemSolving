package bst;

import java.util.HashMap;

import static bst.BinaryTree.preOrderTraversal;

public class BSTVerticalOrder {

    static HashMap<Integer, String> integerIntegerHashMap = new HashMap<>();
    public static void main(String[] args) {
        Node root = BinaryTree.createTree();

        // preOrderTraversal(root);

        traversePreOrder(root, 0);

        integerIntegerHashMap.entrySet().forEach(
                e -> System.out.println(e.getKey() + " --- " + e.getValue())
        );
    }

    private static void traversePreOrder(Node node, int d) {
        if (node == null)
            return;

        if (integerIntegerHashMap.containsKey(d)) {
             String sum = integerIntegerHashMap.get(d) +" __ " + node.data;
            // int sum = integerIntegerHashMap.get(d) + node.data;
            integerIntegerHashMap.put(d, sum);
        } else {
            integerIntegerHashMap.put(d, " >> " + node.data);
        }

        if (null != node.left) {
            traversePreOrder(node.left, d - 1);
        }

        if (null != node.right) {
            traversePreOrder(node.right, d + 1);
        }

        return;
    }

}

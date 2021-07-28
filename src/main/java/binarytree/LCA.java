package binarytree;

public class LCA {

    static class Node {

        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    //      1
    //  2       3
    //4   5   6   7

    static Node findLCA(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node lca = findLCA(root.left, n1, n2);
        Node rca = findLCA(root.right, n1, n2);

        if (lca != null && rca != null)
            return root;

        if (lca == null)
            return rca;
        else
            return lca;
    }

    public static void main(String[] args) {
        Node root = constructBST();
//        Node res = findLCA(root, 4, 7);
//
//        if (res != null) {
//            System.out.println(res.data);
//        }
        int xx= 3 +'a';
        char c = (char)xx;
        System.out.println(c);
        System.out.println(countNodes(root));

    }

    public static int countNodes(Node root) {
        if (root == null)
            return 0;

        int res = 0;
        res = countNodes(root.left) + countNodes(root.right);
        return 1 + res;
    }


    private static Node constructBST() {
        Node root = new Node(1);

        Node left = new Node(2);
        Node leftL = new Node(4);
        Node leftR = new Node(5);
        left.left = leftL;
        left.right = leftR;

        Node right = new Node(3);
        Node rightL = new Node(6);
        Node rightR = new Node(7);
        right.left = rightL;
        right.right = rightR;

        root.left = left;
        root.right = right;

        return root;
    }


}

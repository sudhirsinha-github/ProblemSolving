package binarytree;

public class LongestConsecutiveLength {
    public static void main(String[] args) {

        Node root = new Node(6);
        Node right = new Node(9);
        right.left = new Node(7);
        Node right1 = new Node(10);
        right.right = right1;
        right1.right = new Node(11);
        root.right = right;
        System.out.println(findLength(root));
    }

    private static int findLength(Node root){
        if(root == null)
            return 0;

        int res = 0;
        int currLength = 0;
        res = findLongestLenth(root, 0, root.data, res);

        return res;

    }

    private static int findLongestLenth(Node root, int currLength, int data, int res) {
        if(root == null)
            return 0;

        if(root.data == data)
        {
            currLength++;
        }
        else {
            currLength =1;
        }

        res = Math.max(res, currLength);

        findLongestLenth(root.left, currLength, data+1, res);
        findLongestLenth(root.right, currLength, data+1, res);

        return res;
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int i) {
            this.data = i;
        }

        public Node() {

        }
    }
}

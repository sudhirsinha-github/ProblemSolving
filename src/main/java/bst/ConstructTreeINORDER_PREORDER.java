package bst;

public class ConstructTreeINORDER_PREORDER {

    public static void main(String[] args) {
        int inorder[]={20,10,40,30,50}; //this is mandatory to pick
        int preorder[]={10,20,30,40,50}; //or post

        Node tree = constructTree(inorder, preorder, 0, inorder.length-1);

        BinaryTree.inOrderTraversal(tree);
    }

    static int preorderIndex;

    private static Node constructTree(int[] inorder,int[] preorder, int start, int end) {
        if (start > end) return null;

        Node node = new Node(preorder[preorderIndex++]);

        int inorder_index = start;
        for (int i = start; i < end; i++) {
            if (inorder[i] == node.data) {
                inorder_index = i; //root or parent node
                break;
            }
        }

        node.left = constructTree(inorder, preorder, start, (inorder_index - 1));
        node.right = constructTree(inorder, preorder, inorder_index +1 , end);
        return node;
    }
}

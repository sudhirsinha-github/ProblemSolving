package amcat;

import java.util.Scanner;

class GfG
{
    // private static int globalMax = Integer.MIN_VALUE;
    int maxDiff(Node root)
    {

        return Math.max(recursive(root.data, root.left, Integer.MIN_VALUE),
        recursive(root.data, root.right, Integer.MIN_VALUE));
        //your code here
    }
    private static int recursive(int max, Node child, int globalMax) {
        if (child == null) {
            return globalMax;
        }
        
        globalMax = Math.max(max - child.data, globalMax);
        max = Math.max(child.data, max);

        return Math.max(recursive(max, child.left, globalMax),
        recursive(max, child.right, globalMax));
    }
}
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                            break;
                        case 'R':root.right=new Node(a1);
                            break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }

            GfG g=new GfG();
            System.out.println(g.maxDiff(root));

        }
    }
    public static void insert(Node root, int a, int a1, char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                    break;
                case 'R':root.right=new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }


}

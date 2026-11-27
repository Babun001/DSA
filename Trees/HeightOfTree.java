import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}
class HeightOfTree{

    static int i = -1;
    public static Node buildTree(int []a){
        i++;
        if(a[i] == -1){
            return null;
        }
        Node root = new Node(a[i]);
        root.left=buildTree(a);
        root.right=buildTree(a);

        return root;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return countOfNodes(root.left)+countOfNodes(root.right)+1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int sum = root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
        return sum;
    }

    public static void main(String[] args)throws IOException{

        int[] a = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root = buildTree(a);
        System.out.println(root.data);
        System.out.println("The Height of the tree is: "+height(root));
        System.out.println("Total Nodes of this tree has: "+countOfNodes(root));
        System.out.println("Sum of nodes: "+sumOfNodes(root));
        // System.out.println("Working...");
    }
}
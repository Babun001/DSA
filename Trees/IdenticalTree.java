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

class IdenticalTree{

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


    public static boolean isIdentical(Node n1, Node n2){
        if(n1==null && n2==null)return true;
        if(n1 == null || n2 == null) return false;
        return isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right) && n1.data == n2.data;
    }

    public static void main(String[] args){
        int[] arr = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        Node root = buildTree(arr);
        i=-1;
        int[] arr1 = {1,2,-1,-1,3,4,-1,-1,5,6,-1,-1};
        Node root1 = buildTree(arr1);
        System.out.println(root.data +" <--> "+ root1.data);
        System.out.println(isIdentical(root,root1)?"The trees are identical ":"The Trees are not identical");

        // System.out.println("Working...");
    }
}
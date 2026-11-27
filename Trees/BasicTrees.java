import java.io.*;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}



class BasicTrees{

    static int indx = -1;
    static Node buildTree(int[] arr){
        indx ++;
        if(arr[indx] == -1){
            return null;
        }
        Node root = new Node(arr[indx]);
        root.left = buildTree(arr);
        root.right = buildTree(arr);

        return root;
    }

    static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+", ");
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+", ");
    }

    static void bfs(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new ArrayDeque<>();

        q.add(root);

        while(!q.isEmpty()){

            Node curr = q.remove();
            System.out.print(curr.data+", ");

            if(curr.left != null){
                q.add(curr.left);
            }

            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }

    public static void main(String [] ags)throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        for(int e: arr){
            System.out.print(e+", ");
        }
        System.out.println();

        Node root = buildTree(arr);
        System.out.println("The Root of the tree is: "+ root.data);
        // System.out.println(root.data);
        System.out.println("The preorder representation of that tree: ");
        preOrder(root);
        System.out.println();
        System.out.println("The Inorder representation of that tree: ");
        inOrder(root);
        System.out.println();
        System.out.println("The PostOrder representation of that tree: ");
        postOrder(root);
        System.out.println();
        System.out.println("The Breaadth First Search representation of that tree: ");
        bfs(root);
        // System.out.println("The tree is: "+ for(int e:arr)System.out.println(e));
        // String name = br.readLine();
        // System.out.println();
        
    }
}
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

class SubTree{

    // build the trees first
    static int i = -1;
    static Node buildTree(int []a){
        i++;
        if(i >= a.length || a[i] == -1) {
            return null;
        }
        Node newNode = new Node(a[i]);
        newNode.left = buildTree(a);
        newNode.right = buildTree(a);

        return newNode;
    }

    //let's the trees are identical or not first
    public static boolean isIdentical(Node mainRoot, Node subTree){
        if(mainRoot == null || subTree == null) return mainRoot==subTree;
        return isIdentical(mainRoot.left, subTree.left) && isIdentical(mainRoot.right, subTree.right) && mainRoot.data == subTree.data;
    }

    //let's check if the subtree is a subtree of the main tree it will return tree and false;
    public static boolean isASubtree(Node mainRoot, Node subTree){
        if(mainRoot == null)return false;
        if(subTree == null)return true;

        if (isIdentical(mainRoot, subTree)) {
            return true;
        }

        return isASubtree(mainRoot.left, subTree) || isASubtree(mainRoot.right, subTree);
    }
    public static void main(String[] arr){
        int[] rootArr = {3,4,1,-1,-1,2,-1,-1,5,-1,-1};
        int[] subArr  = {4,1,-1,-1,5,-1,-1};
        Node mainTreeRoot = buildTree(rootArr);
        i=-1;
        Node subTreeRoot = buildTree(subArr);

        System.out.println("mainTreeRoot : "+ mainTreeRoot.data+", "+"and the sub tree root: "+ subTreeRoot.data);

        System.out.println("is the sub tree is actuall subtree of the main treee? "+isASubtree(mainTreeRoot,subTreeRoot));
        // System.out.println("Working...");
    }
}
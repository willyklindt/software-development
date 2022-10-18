package MyBinarySearchTree;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
    }

    public void insert(Node in) {
        if (root == null) {
            root = in;
            return;
        } else {
            insert(in, root);
        }
    }

    public void insert(Node in, Node parent) {
        if (in.data.compareTo(parent.data) >= 0) {
            if (parent.rightChild == null) {
                parent.rightChild = in;
            } else {
                insert(in, parent.rightChild);
            }
        }
        if (in.data.compareTo(parent.data) < 0) {
            if (parent.leftChild == null) {
                parent.leftChild = in;
            } else {
                insert(in, parent.leftChild);
            }
        }
    }

    public void TheFirstSearch() {
        System.out.println("In order");
        System.out.println(root);
    }

    public void TheFirstSearch(Node n) {
        if (n == null){
            return;
        }
            TheFirstSearch(n.leftChild);
            System.out.println(n.data);
            TheFirstSearch(n.rightChild);
    }

    
}

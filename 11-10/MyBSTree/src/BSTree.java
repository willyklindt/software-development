public class BSTree {

    Node root;
    public void insert(Node in){
        if (root == null)
        {
            root = in;
            return;
        }
        else
        {
            insert(in, root);
        }
    }

    public void insert(Node in, Node parent){
        if (in.data.compareTo(parent.data) >=0 ) //Tjekker om node er større end parent
        {
            if (parent.rightChild == null) {
                parent.rightChild = in;
            } else {
                insert(in, parent.rightChild);
            }
        }
            if (in.data.compareTo(parent.data) <0)
            {
                if (parent.leftChild == null)
                {
                    parent.leftChild = in;
                }
                else
                {
                    insert(in, parent.leftChild);
                }
            }
        }


    public void DFSInOrder(){
        System.out.println(" in order DFS: ");
        DFSInOrder(root);
    }

    public void DFSInOrder(Node n){
        if (n == null)
        {
            return;
        }
        DFSInOrder(n.leftChild);
        System.out.println( n.data);
        DFSInOrder(n.rightChild);

    }

    public void DFSPreOrder(){
        System.out.println(" Pre order DFS: ");
        DFSPreOrder(root);
    }
    public void DFSPreOrder(Node n){
        if (n == null)
        {
            return;
        }
        System.out.println(n.data );
        DFSPreOrder(n.leftChild);
        DFSPreOrder(n.rightChild);
    }

}

class Node<T extends Comparable<T>>{ //Node bruges til at sortere med
    T data; //Den data, vi bruger til at sortere med
    Node leftChild=null;
    Node rightChild = null;
    Node(T d){data = d;} //Constructor

}

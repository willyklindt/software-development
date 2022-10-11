package MyBinarySearchTree;


    class Node<T extends Comparable<T>> {

        T data;

        Node leftChild = null;
        Node rightChild = null;

        Node(T d) { // Constructor
            this.data = d;
        }
    }


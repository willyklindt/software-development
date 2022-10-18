package MyBinarySearchTree;

public class Main {
    
    public static void main(String[] args) {
        BinarySearchTree MyBST = new BinarySearchTree();
        MyBST.insert(new Node("love"));
        MyBST.insert(new Node("data"));
        MyBST.insert(new Node("trees"));
        MyBST.insert(new Node("binary"));
        MyBST.insert(new Node("we"));
        
        MyBST.TheFirstSearch();
    }
}

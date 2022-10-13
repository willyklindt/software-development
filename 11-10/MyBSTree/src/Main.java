public class Main {

    public static void main(String[] args) {
	BSTree MyBST = new BSTree();
    MyBST.insert(new Node("love"));
    MyBST.insert(new Node("datastructures"));
    MyBST.insert(new Node("trees"));
    MyBST.insert(new Node("binary"));
    MyBST.insert(new Node("we"));
    MyBST.insert(new Node("and"));
    MyBST.DFSInOrder();
    MyBST.DFSPreOrder();
    }
}

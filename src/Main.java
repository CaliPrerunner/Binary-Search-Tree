public class Main {
    public static void main(String[] args) {

        //creating bst and inserting data
        binaryTree test = new binaryTree();
        test.insert(10);
        test.insert(5);
        test.insert(15);
       test.insert(4);
      test.insert(7);
        test.insert(25);
        test.insert(8);


        //*******test cases of methods working***********


        System.out.println("Aearching for 10");
        test.search(10 );
        System.out.println("Searching for 11");
        test.search(11 );


        System.out.println("\nPrinting tree using the in-order traversal method");
        test.inOrderTraverse();

        System.out.println("\nPrinting tree using the in pre-order traversal method");
        test.preOrderTraverse();

        System.out.println("\nPrinting tree using the in post-order traversal method");
        test.postOrderTraverse();

        //here to show that this method checks for items that are not in the BST
        System.out.println("\n\nDeleting 22, which is not in BST");
        test.delete( 22);
        //showing how the BST can delete nodes
        System.out.println("Deleting 8,is in BST");
        test.delete( 8);
        System.out.println("Printing tree without 8");
        test.inOrderTraverse();
        test.delete( 15);
        System.out.println("Printing tree without 15");
        test.inOrderTraverse();
    }
}
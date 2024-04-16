public class Main {
    public static void main(String[] args) {

        binaryTree test = new binaryTree();
        binaryTree test2 = new binaryTree();

        test.insert(10);
        test.insert(5);
        test.insert(15);
       test.insert(4);
      test.insert(7);
        test.insert(25);
        test.insert(8);

        test2.insert(4);
        test2.insert(3);
        test2.insert(2);
        test2.insert(1);

      System.out.println("Printing tree using the in-order traversal method");


      //test.delete( 8);

        System.out.println("Printing tree using the in-order traversal method");
        test.inOrderTraverse();

        System.out.println("\nPrinting tree using the in pre-order traversal method");
        test.preOrderTraverse();

        System.out.println("\nPrinting tree using the in post-order traversal method");
        test.postOrderTraverse();

int x =0;
    }
}
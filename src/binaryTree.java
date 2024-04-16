public class binaryTree<T extends Comparable<T>>{
    //variable
    Node root;
    //constructor
    public binaryTree(Node root){
        this.root = root;
    }
    public binaryTree(){
    }

    public  class Node<T extends Comparable<T>>{
        T Data;
        Node left, right;

        public Node(T d,Node l, Node r){
            this.Data = d;
            this.left = l;
            this.right = r;
        }
        public Node(T d){
            this.Data = d;
            this.left = null;
            this.right = null;
        }
        public Node(){}

        public void setData(T data){
            this.Data = data;
        }

        public int compareTo(Node<T> o) {
            return this.Data.compareTo(o.Data);
        }
    }


    //Methods
    public void insert(T data){

        //creates a node with the data passed in to be added to the BST
       Node<T> p = new Node<>(data);
       //checks to see if the data is in the BST tree already
       if(searchH(this.root, p) == false ){
           this.root = searchN(this.root, p);
       }else{
           System.out.println(data+" is already in there!");
       }
    }

    //main method that will delete the conents of the BST
    public void delete(T data){
        Node<T> dataToDelete = new Node<>(data);

        if(searchH(this.root, dataToDelete)) {
            deleteH(this.root, data);
            System.out.println("deleted " + data);
            System.out.println("Data " +data +" not in the BST!");
        }else{
            System.out.println("Data " +data +" not in the BST!");
        }
    }

    //delete helper method that has the recursive logic to delete
    public  Node deleteH(Node current,T dataD){
        Node<T> dataToDelete = new Node<>(dataD);
            if (current == null) {
                return current;
            }else if (dataToDelete.compareTo(current) < 0) {
                // go left
                current.left =  deleteH(current.left, dataD);
            } else if (dataToDelete.compareTo(current) > 0) {
                //go right
                current.right = deleteH(current.right, dataD);
            }else{
                //node found
                //checking to see if node is independent leaf
                if(current.left == null && current.right == null){
                    current = null;
                }else if (current.right != null){
                    //some data in the right node of the node you want to delete
                     current = sucessor(current);
                    current.right = deleteH(current.right, dataD);

                }else {
                    //find the predecesor to replace this node
                  current = pre(current);
                  current.left = deleteH(current.left, dataD);
                }
            }
        return current;
    }

    public Node sucessor(Node current){
        //find the least value below the right child of the root node
        current = current.right;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
    public Node pre(Node current){
        //find the greatest value below the left child of the root node
        current = current.left;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }

    //main search method will print out to the console
public void search(T data){
        Node d = new Node<>(data);
        if(searchH(this.root,d)){
            System.out.println("Data "+data+" found in BST!");
        }else{
            System.out.println("Data "+data+" not found in BST");
        }
}

//search helper will return false if data not in BST and true if in BST
    public boolean searchH(Node root, Node data){
        //returns false if there is no data in the binary tree
        if(root == null){
            return false;
            //data == root.Data
        }else if(data.compareTo(root) == 0){
            return true;
            //data < root.Data
        }else if(data.compareTo(root) < 0){
            // go left
            return searchH(root.left,data);
        }else{
            //go right
            return searchH(root.right, data);
        }

    }

    //searches and returns the node
    public Node searchN(Node current, Node data){
        if(current == null){
            current = data;
            return current;
        }else if(data.compareTo(current) < 0){
            // go left
            current.left = searchN(current.left, data);
        }else{
            //go right
            current.right = searchN(current.right, data);
        }
        return current;
    }


    //Traverses through the array from smallest (left most) to largest (right most)
    public void inOrderTraverseH(Node current){
        if (current != null) {
            inOrderTraverseH(current.left);
            System.out.print(current.Data+ " ");
            inOrderTraverseH(current.right);
        }
    }
    public void inOrderTraverse(){
        inOrderTraverseH(this.root);
    }
    public void preOrderTraverseH(Node current){
        if (current != null) {
            System.out.print(current.Data+ " ");
            preOrderTraverseH(current.left);
            preOrderTraverseH(current.right);

        }
    }
    public void preOrderTraverse(){
        preOrderTraverseH(this.root);
    }
    public void postOrderTraverseH(Node current){
        if (current != null) {
            postOrderTraverseH(current.left);
            postOrderTraverseH(current.right);
            System.out.print(current.Data+ " ");

        }
    }
    public void postOrderTraverse(){
        postOrderTraverseH(this.root);
    }

}

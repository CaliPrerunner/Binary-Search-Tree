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
       if(search(this.root, p) == false ){
           this.root = searchN(this.root, p);
       }else{
           System.out.println("Already in there!");
       }
    }

    public  Node delete(Node current,T dataD){
        Node<T> dataToDelete = new Node<>(dataD);

        if(search(current, dataToDelete) == false ) {


        }else {
            if (current == null) {
                return current;

            }else if (dataToDelete.compareTo(current) < 0) {
                // go left
                current.left =  delete(current.left, dataD);
            } else if (dataToDelete.compareTo(current) > 0) {
                //go right
                current.right = delete(current.right, dataD);
            }else{
                //node not found

                //checking to see if node is independent leaf
                if(current.left == null|| current.right == null){
                    current = null;
                }else if (current.right != null){
                    current = sucessor(current);
                    current.right = delete(current.right, dataD);
                }else { //find the predecesor to replace this node
                    current = pre(current);
                    current.left = delete(current.left, dataD);
                }
            }
        }
        return null;
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


    public boolean search(Node root, Node data){
        //returns false if there is no data in the binary tree
        if(root == null){
            return false;
            //data == root.Data
        }else if(data.compareTo(root) == 0){
            return true;
            //data < root.Data
        }else if(data.compareTo(root) < 0){
            // go left
            return search(root.left,data);
        }else{
            //go right
            return search(root.right, data);
        }

    }

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
    public void inOrderTraverse(){



    }
    public void preOrderTraverse(){
        // root, left then right
        /*
       go all the way to the left and then go to the right, when you get to the root, the RLR resets to go back to the last left
       value of that
         */

    }
    public void postOrderTraverse(){

    }

}

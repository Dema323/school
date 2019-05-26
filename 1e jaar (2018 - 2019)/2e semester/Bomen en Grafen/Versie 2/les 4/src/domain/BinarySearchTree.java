package domain;

public class BinarySearchTree<E extends Comparable<E>> {
    private BinaryTree<E> root;

    public void printInOrder() {
        if (this.isEmpty()) System.out.println("Geen data in BST");
        else root.printInOrder();
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean lookup(E data){
        if (this.isEmpty()) return false;
        return root.lookup(data);
    }

    public boolean addNode(E data){
        if (root == null) {
            this.root = new BinaryTree<>(data);
            return true;
        } else return this.root.addNode(data);
    }

    public boolean removeNode(E data){
        if (this.isEmpty()) return false;
        else {
            boolean ok = root.removeNode(data);
            if (ok && root.isEmpty()) root = null;
            return ok;
        }
    }

    public E searchSmallest(){
        if(this.isEmpty()) throw new IllegalStateException();
        return this.root.searchSmallest();
    }

    public E searchGreatest(){
        if (this.isEmpty()) throw new IllegalStateException();
        return this.root.searchGreatest();
    }

    private class BinaryTree<E extends Comparable<E>>{
        private E data;
        private BinaryTree<E> leftTree, rightTree;

        public BinaryTree(E data){
            if (data == null) throw new IllegalArgumentException();
            this.data = data;
        }

        public void printInOrder(){
            if (leftTree != null) leftTree.printInOrder();
            System.out.print(" " + data);
            if (rightTree != null) rightTree.printInOrder();
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean lookup(E data) {
            if (data == null) {
                return false;// er is geen data
            } else {
                if (data.compareTo(this.data) == 0) {
                    return true;// gevonde
                } else {
                    if (data.compareTo(this.data) < 0) {
                        if (leftTree == null) {
                            return false;
                        } else {
                            return leftTree.lookup(data);
                        }
                    }else {
                        if (leftTree == null) {
                            return false;
                        }else {
                            return rightTree.lookup(data);
                        }
                    }
                }
            }
        }
        public boolean addNode(E data){
            if (data == null){
                throw new IllegalArgumentException("data mag niet leeg zijn");

            } else {
                if (data.compareTo(this.data) == 0){
                    return false; //data is al voorgekomen
                } else if (data.compareTo(this.data) < 0){
                    if (leftTree == null){
                        leftTree = new BinaryTree<>(data);
                        return true;
                    } else return this.leftTree.addNode(data);
                } else {
                    if (rightTree == null){
                        rightTree = new BinaryTree<>(data);
                        return true;
                    } else return this.rightTree.addNode(data);
                }
            }
        }


        public boolean removeNode(E data){
            return false;
        }

        private void cleanUp(){

        }

        public E searchGreatest() {
            return null;
        }


        public E searchSmallest() {
            return null;
        }

    }
}



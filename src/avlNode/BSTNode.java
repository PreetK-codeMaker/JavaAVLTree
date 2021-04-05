package avlNode;
/**
 * A node in the Balanced binary search tree also known as AVLTree
 * @param <E> Place holder for any kind of data type
 *
 * @author Parnpreet Kanwar
 * */

public class BSTNode<E> {
    private int balanceFactor = 0;
    private int height = 0 ;
    private E element;
    public BSTNode<E> leftChild;
    public BSTNode<E> rightChild;

    public BSTNode (E element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Gets the element for the node.
     * @return the element in the node
     * */
    public E getElement() {
        return element;
    }

    /**
     * Set the given element to the node
     * @param element to set the element
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Gives the left node of the parent node.
     * @return give the left child node.
     */
    public BSTNode<E> getLeftChild() {
        return leftChild;
    }

    /**
     * Makes a connection with parent node on the left side.
     * @param leftChild accept the left child to set
     */
    public void setLeftChild(BSTNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Gives right node connected to the parent node
     * @return get's the right child node.
     */
    public BSTNode<E> getRightChild() {
        return rightChild;
    }

    /**
     * Makes a connection to the parent node on the right side.
     * @param rightChild accept a right child to set
     */
    public void setRightChild(BSTNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * this hold balance factor of node left - right.
     * between 1,0,-1
     * @return balance factor
     */
    public int getBalanceFactor() {
        return balanceFactor;
    }

    /**
     * this set the balancing factor
     * @param balanceFactor is the sum of right - left.
     */
    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    /**
     * sets the height of the avl tree
     * @param height gives the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gives the height of Avl Tree
     * @return the height of the avl tree.
     */
    public int getHeight() {
       return height;
    }

}

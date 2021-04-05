package avlTree;

import avlNode.BSTNode;
import avltreeADT.BSTreeADT;
import exception.AvlExceptions;

import java.io.Serializable;

/**
 * @author  Parnpreet Kanwar
 * @param <E> place holder for any kind of data type
 */

public class AvlTree<E extends Comparable<? super E>>implements BSTreeADT<E>, Serializable {
   private static final long serialVersioUID = -4858484L;
   private BSTNode<E> root;
   private int size;

    /**
     * Creat's a new Balanced binary tree with no root node and size 0
     */
   public AvlTree() {
       root = null;
       size = 0;
   }

    /**
     * Creat's a new Balanced binary tree with a given parameter as the root
     * @param element that will be the initial root of the tree
     */
   public AvlTree(E element) {
       root = new BSTNode<E>(element);
       size = 1;

   }

    /**
     * The node at the root of the balanced Binary tree
     * @return gives the root node of the balanced binary tree
     * @throws AvlExceptions if the root is empty
     */
    @Override
    public BSTNode<E> getRoot() throws AvlExceptions {
       if (root == null)
           throw new AvlExceptions(" AVL Tree is empty");
     return root;
    }

    /**
     * Gives the height of the tree
     * @return the value of tree height as a Integear
     */
    @Override
    public int getHeight() {
       if(root != null)
           return root.getHeight();
       else
           return 0;
    }

    /**
     * Gives the running count of element inserted into the Balanced Binary Tree
     * @return number of element currently stowed in Balanced Binary Tree
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Check to see if the Balance Binary tree is empty
     * @return a boolean value based whether the tree is empty of not.
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Delete all element in Tree
     */
    @Override
    public void clear() {
       root = null;
       size = 0;
    }

    /**
     * Check to see if the current tree if the element that is being passed is it stored in the
     * in the element depending on the search result it will return a true if the boolean is found
     * or false if the value is not found.
     * @param entry the element in three that needs to be checked
     * @return a boolean whether the search have found the element or not.
     * @throws AvlExceptions throws exception if the value being passed is null or empty
     */
    @Override
    public boolean contains(E entry) throws AvlExceptions{
       if(root == null)
           throw new AvlExceptions("Tree doesn't have a root. Tree is Empty");
       if(entry == null)
           throw new AvlExceptions("Node cannot be a null");
       else 
           return recursionContain(entry, root);
    }

    /**
     * Recursive way to find the node in the give tree.
     * @param entry parameter that is being asked to search
     * @param node root node to search in
     * @return boolean if the whether parameter is found
     */
    private boolean recursionContain(E entry, BSTNode<E> node) {
       boolean found = false;
       if(node.getElement().compareTo(entry) == 0)
            return true;
        if(node.getElement().compareTo(entry) > 0 && node.getLeftChild() != null)
            found = recursionContain(entry, node.getLeftChild());
        else if(node.getElement().compareTo(entry) < 0 && node.getRightChild() != null)
            found = recursionContain(entry, node.getRightChild());
        return found;
    }

    /**
     * Retrieves a node from the tree.
     * @param entry element that is being asked to searched
     * @return the node with the element that is asked to search, return
     * null of not found
     * @throws AvlExceptions throw exception if the tree is empty
     * */
    @Override
    public BSTNode<E> search(E entry) throws AvlExceptions{
       if(root == null)
           throw new AvlExceptions("Tree doesn't have a root. Tree is Empty");
        if(entry == null)
            throw new AvlExceptions("Node cannot be a null");
        return RecursiveSearch(entry, root);
    }

    /**
     * Recursive search the node in the give tree and retrieves it.
     * @param entry parameter that is being asked to searched
     * @param node root node to search in
     * @return the node with element that is asked to searched for
     */
    private BSTNode<E> RecursiveSearch(E entry, BSTNode<E> node) {
       BSTNode<E> found = null;
        if(node.getElement().compareTo(entry) == 0)
            return node;

        if(node.getElement().compareTo(entry) > 0 && node.getLeftChild() != null)
            found = RecursiveSearch(entry, node.getLeftChild());
        else if(node.getElement().compareTo(entry) < 0 && node.getRightChild() != null)
            found = RecursiveSearch(entry, node.getRightChild());
        return found;

    }


    /**
     * This function add the element into the tree
     * @param newEntry parameter that will be added to the tree
     * @return a boolean whether if the element is added or not
     * @throws NullPointerException if the parameter being passed is null
     */
    @Override
    public boolean add(E newEntry) throws NullPointerException{
       if(newEntry == null)
        throw new NullPointerException("Node cannot be a null ");
//        if(!contains()) {
//            root.setElement(newEntry);
//            update(root);
//            size++;
//        }
       root = recursiveAdd(newEntry, root);
       size++;
       return true;

    }

    /**
     * Recursive way of adding node in the give tree and retrieves it.
     * Update the height and update the balance factor for each node,
     * and determines whether it need to balance the tree.
     * @param newEntry parameter that is being asked to searched
     * @param node root node to search in
     * @return the node adding it to.
     */
    private BSTNode<E> recursiveAdd(E newEntry, BSTNode<E> node) {
       if(node == null)
           return new BSTNode(newEntry);
        if(node.getElement().compareTo(newEntry) <=0) {
            node.setRightChild(recursiveAdd(newEntry, node.getRightChild()));
        } else {
            node.setLeftChild(recursiveAdd(newEntry, node.getLeftChild()));
        }

       update(node);
       return balance(node);
    }

    /**
     *This method takes in a element and remove it from the tree
     * and re-balanced the entire binary search tree using the Balance
     * factor.
     * @param newEntry parameter that will be removed from the tree
     * @return the boolean based on the whether parameter was removed
     */
    @Override
    public boolean remove(E newEntry) {
            if(newEntry == null)
            throw new NullPointerException("Node cannot be a null ");
        if(recursionContain(newEntry, root)) {
            root = recursiveRemoveNode(newEntry, root);
            size--;
            return true;
        }
        return false;
    }

    /**
     * Recursive way to remove the node from the given root.
     * Update the height and update the balance factor for each node,
     * and determines whether it need to balance the tree.
     * @param newEntry parameter that will be removed from the tree
     * @param node root node to removed it from .
     * @return updated the root node with the given parameter removed.
     */
    private BSTNode<E> recursiveRemoveNode(E newEntry, BSTNode<E> node) {
       if(node == null) return null;
       int compareSionNumber = newEntry.compareTo(node.getElement());

       if(compareSionNumber < 0 ) { // For the deep left subtree
           BSTNode<E> leftSideNode = recursiveRemoveNode(newEntry, node.getLeftChild());
//           if(leftSideNode == null) return null;
            node.setLeftChild(leftSideNode);
       } else if (compareSionNumber > 0) {
           BSTNode<E> rightSideNode = recursiveRemoveNode(newEntry, node.getRightChild());
//           if(rightSideNode == null) return null;
           node.setRightChild(rightSideNode);
        } else { // node found and wish to remove
           if(node.getLeftChild() == null) {
               return node.getRightChild();
           } else if(node.getRightChild() == null) { // simple swap to remove the element and this is the case where there is no subtrees
               return node.getLeftChild();
           } else {
               //selection to remove a side
               if(node.getLeftChild().getHeight() > node.getRightChild().getHeight()) {
                   //swap the value of the succeor
                   E succorVal = findMax(node.getLeftChild());
                   node.setElement(succorVal);

                   BSTNode<E> nodeToReplace = recursiveRemoveNode(succorVal, node.getLeftChild());
//                   if(nodeToReplace == null) return null;
                   node.setLeftChild(nodeToReplace);
               } else  {
                   E succorVal = findMin(node.getRightChild());
                   node.setElement(succorVal);

                   BSTNode<E> nodeToReplace = recursiveRemoveNode(succorVal, node.getRightChild());
//                   if(nodeToReplace == null) return null;
                   node.setRightChild(nodeToReplace);
               }
           }
       }

       update(node);
        return balance(node);
    }

    /**
     * Update the height of the tree and set the balance factor for the given node.
     * @param node root node that will be updated.
     */
    private void update(BSTNode<E> node) {
       int leftNodeHeight = (node.getLeftChild() == null) ? -1: node.getLeftChild().getHeight();
       int rightNodeHeight = (node.getRightChild() == null) ?-1 : node.getRightChild().getHeight();

       node.setHeight( 1 + Math.max(leftNodeHeight, rightNodeHeight));

       node.setBalanceFactor(rightNodeHeight - leftNodeHeight); // Balance factor
    }

    /**
     * Re-balanced the Balanced binary search tree if the balance factor is
     * +2 or -2
     * @param node root the being passed in to be balanced
     * @return the balanced the parameter
     */
    private BSTNode<E> balance(BSTNode<E> node) {
       if(node.getBalanceFactor() == -2) {
           if(node.getLeftChild().getBalanceFactor() <=0 ) // left - left case
               return leftLeftCase(node);
           else
               return leftRightCase(node); // left - right case
       } else if(node.getBalanceFactor() == +2 ) {
           if(node.getRightChild().getBalanceFactor() >= 0)
               return rightRightCase(node);
           else
               return rightLeftCase(node);
       }
       return node;
    }

    /**
     *left left case
     * @param node root the being passed to be balanced
     * @return rotated tree and balanced
     */
    private BSTNode<E> leftLeftCase(BSTNode<E> node) {
       return rightRotation(node);
    }

    /**
     *left right case
     * @param node root the being passed to be balanced
     * @return rotated tree and balanced
     */
    private BSTNode<E> leftRightCase(BSTNode<E> node) {
       node.setLeftChild(leftRotation(node.getLeftChild()));
       return leftLeftCase(node);
    }

    /**
     *right right case
     * @param node root the being passed to be balanced
     * @return rotated tree and balanced
     */
    private BSTNode<E> rightRightCase(BSTNode<E> node) {
        return leftRotation(node);
    }

    /**
     * right left case
     * @param node root the being passed to be balanced
     * @return rotated tree and balanced
     */
    private BSTNode<E> rightLeftCase(BSTNode<E> node) {
       node.setRightChild(rightRotation(node.getRightChild()));
       return rightRightCase(node);

    }

    /**
     * For the left rotation
     * @param node root the being passed to be balanced
     * @return the rotated  root
     */
    private BSTNode<E> leftRotation(BSTNode<E> node) {
       BSTNode<E> leftRotationNode = node.getRightChild(); //1
       node.setRightChild( leftRotationNode.getLeftChild()); // 2
       leftRotationNode.setLeftChild(node); //3
       update(node);
       update(leftRotationNode);
       return leftRotationNode;

    }

    /**
     * For the right rotation
     * @param node root the being passed to be balanced
     * @return the rotated root
     */
    private BSTNode<E> rightRotation(BSTNode<E> node) {
       BSTNode<E> rightRotationNode = node.getLeftChild();
       node.setLeftChild(rightRotationNode.getRightChild());
       rightRotationNode.setRightChild(node);
       update(node);
       update(rightRotationNode);

       return rightRotationNode;
    }

    /**
     * find the biggest value in the a give tree
     * @param node root node find it in
     * @return max value in the given tree.
     */
    //Helper function to find the max element
    private E findMax (BSTNode<E> node){
       while (node.getRightChild() !=null)
           node = node.getRightChild();
       return node.getElement();
    }

    /**
     * find the biggest value in the a give tree
     * @param node root node find it in
     * @return max value in the given tree.
     */
    //Helper function to find the max element
    private E findMin(BSTNode<E> node) {
       while(node.getLeftChild() != null)
           node = node.getLeftChild();
       return node.getElement();
    }

    /**
     *Print the nodes in the pre-order iteration.
     */
    public void preOrder() {
       preOrder(root);
    }

    /**
     * Recursively traverse the tree in pre-order fashion.
     * @param root root to print form
     */
    private void preOrder(BSTNode<E> root) {
       if(root != null) {
           System.out.println(root.getElement()+ "  ");
           preOrder(root.getLeftChild());
           preOrder(root.getRightChild());
       }
    }

    /**
     *Print the nodes in the post-order iteration.
     */
    public void postOrder() {
       postOrder(root);
    }

    /**
     * Recursively traverse the tree in pre-order fashion.
     * @param root root to print form
     */
    private void postOrder(BSTNode<E> root) {
       if(root != null) {
           postOrder(root.getLeftChild());
           postOrder(root.getRightChild());
           System.out.println(root.getElement()+ " ");
       }
    }

}

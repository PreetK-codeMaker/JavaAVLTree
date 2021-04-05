package avltreeADT;

import java.io.Serializable;
import avlNode.BSTNode;
import exception.AvlExceptions;

/**
 * @author Kanwar, Parnpreet
 * @Version 2.2
 * Created: March 10, 2021
 * Updated: April 5,  2021
 *
 * Class Description: Abstract data type specification for
 * Balanced Binary tree (AVL tree) implementation.
 */
public interface BSTreeADT<E extends Comparable<? super E>>  extends Serializable {

    /**
     * The node at the root of the balanced Binary tree
     * @return gives the root node of the balanced binary tree
     * @throws AvlExceptions if the root is empty
     */
    public BSTNode<E> getRoot() throws AvlExceptions;

    /**
     * Gives the height of the tree
     * @return the value of tree height as a Integear
     */
    public int getHeight();

    /**
     * Gives the running count of element inserted into the Balanced Binary Tree
     * @return number of elememt currently stowed in Balanced Binary Tree
     */
    public int getSize();


    /**
     * Check to see if the Balance Binary tree is empty
     * @return a boolean value based wheather the tree is empty of not.
     */
    public boolean isEmpty();

    /**
     * Delete all element in Tree
     */
    public void clear();

    /**
     * Check to see if the current tree if the element that is being passed is it stored in the
     * in the element depending on the search result it will return a true if the boolean is found
     * or false if the value is not found.
     * @param entry the element in three that needs to be checked
     * @return a boolean whether the search have found the element or not.
     * @throws AvlExceptions throws exception if the value being passed is null or empty
     */
    public boolean contains(E entry) throws AvlExceptions;

    /**
     * Retrieves a node from the tree.
     * @param entry element that is being asked to searched
     * @return the node with the element that is asked to search, return
     * null of not found
     * @throws AvlExceptions throw exception if the tree is empty
     * */
    public BSTNode<E> search(E entry) throws AvlExceptions;

    /**
     * This function add the element into the tree
     * @param newEntry parameter that will be added to the tree
     * @return a boolean whether if the element is added or not
     * @throws NullPointerException if the parameter being passed is null
     */
    public boolean add(E newEntry) throws NullPointerException;

    /**
     *This method takes in a element and remove it from the tree
     * and re-balanced the entire binary search tree using the Balance
     * factor.
     * @param entry parameter that will be removed from the tree
     * @return the boolean based on the whether parameter was removed
     * @throws NullPointerException if the parameter being passed is null
     */
    public boolean remove(E entry ) throws NullPointerException;


}

import java.util.NoSuchElementException;
/**
 * This is a class that creates a Deque using the ListNode
 * class. All functions are similar to those that are found
 * in Java's default Deque. This Deque can handle any data type.
 *
 * @author Harish Kandaswamy (3265)
 * @version 9 May 2019
 */
public class Deque20<E> {
    private ListNode<E> front;  // Reference to the front of the list
    private ListNode<E> back;   // Reference to the back of the list
    private int numElems;

    /**
     * This is the constructor for the Deque. Initializes the
     * front and back nodes to 'null' and sets the number of 
     * elements to zero.
     *
     * @param front references the front of the Deque.
     * @param back references the back of the Deque.
     * @param numElems represents the number of elements.
     */
    public Deque20() {
        front = null;
        back = null;
        numElems = 0;
    }
    
    /**
     * This method pushes the passed data into the front
     * of the Deque.
     *
     * @param x represents the data trying to be pushed.
     * @param front references the front of the Deque.
     * @param back references the back of the Deque.
     * @param temp is the new node holding the passed data.
     * @param numElems represents the number of elements.
     */
    public void push(E x) {
        if(numElems == 0) {
                front = new ListNode<E>();
                back = new ListNode<E>();
                front.data = x;
                back = front;
                numElems++;
        }
        else {       
                ListNode<E> temp = new ListNode<E>();
                temp.data = x;
                temp.next = front;
                front = temp;
                numElems++;
         }
    }
    
    /**
    * This method removes the node at the front of the Deque
    * and returns its data.
    *
    * @throws NoSuchElementException when the number of elements is zero.
    * @param front references the front of the Deque.
    * @param back references the back of the Deque.
    * @param temp contains the data from the front.
    * @param numElems represents the number of elements.
    * @return the data from the front of the Deque.
    */
    public E pop() {
        if(numElems == 0) {
                throw new NoSuchElementException();
        }
        else {
                E temp = front.data;
                front = front.next;
                numElems--;
                return temp;
        }
    }
    
    /**
     * This method adds the passed data to the back of
     * the Deque. It then updates the reference to the
     * node at the back of the Deque.
     *
     * @param front references the front of the Deque.
     * @param back references the back of the Deque.
     * @param temp is the new node holding the passed data.
     * @param numElems represents the number of elements.
     */
    public void add(E x) {
        if(numElems == 0) {
                front = new ListNode<E>();
                front.data = x;
                back = new ListNode<E>();
                back = front;
                numElems++;
        } 
        else {
                ListNode<E> temp = new ListNode<E>();
                temp.data = x;
                back.next = temp;
                back = back.next;
                numElems++;
        }
    }
    
    /**
    * This method removes the node at the front of the Deque
    * and returns its data.
    *
    * @throws NoSuchElementException when the number of elements is zero.
    * @param front references the front of the Deque.
    * @param back references the back of the Deque.
    * @param temp contains the data from the front.
    * @param numElems represents the number of elements.
    * @return the data at the front of the Deque.
    */
    public E remove() {
        if(numElems == 0) {
                throw new NoSuchElementException();
        }
        else {
                E temp = front.data;
                front = front.next;
                numElems--;
                return temp;
        }
    }
    
    /**
     * This method returns the data that is at the front
     * of the Deque without removing it.
     * 
     * @throws NoSuchElementException when the number of elements is zero.
     * @param front references the front of the Deque.
     * @param numElems represents the number of elements.
     * @return the data at the front of the Deque.
     */
    public E peek() {
        if(numElems == 0) {
                throw new NoSuchElementException();
        }
        else {
                return front.data;
        }
    }
    
    /**
     * This method returns true if the Deque is empty and
     * false if the Deque is not empty.
     *
     * @param numElems represents the number of elements.
     * @return true if the Deque is empty and false if it isn't.
     */
    public boolean isEmpty() {
        if(numElems == 0) {
                return true;
        }
        else {
                return false;
        }
    }
    
    /**
     * This method returns the size of the Deque as an integer.
     *
     * @param numElems represents the number of elements.
     * @return numElems, which represents the size of the Deque.
     */
    public int size() {
        return numElems;
    }
}
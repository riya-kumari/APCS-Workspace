import java.util.NoSuchElementException;


/**
 * Implements a singly-linked list with a tail.
 *
 * @author Riya Kumari
 * @version 12/13/18
 * @author Period: 5
 * @author Assignment: JMCh20_5LinkedListWithTail
 *
 * @author Sources: TODO List collaborators
 */
public class LinkedListWithTail<E>
{
    private ListNode<E> head, tail;


    /**
     * Constructs an empty list.
     */
    public LinkedListWithTail()
    {
        head = null;
        tail = null;
    }


    /**
     * Returns true if this list is empty; otherwise returns false.
     * 
     * @return true if this list contains no elements false otherwise
     */
    public boolean isEmpty()
    {
        return head == null;
    }


    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * 
     * @return the head of this list, or null if this list is empty
     */
    public E peek()
    {
        if ( isEmpty() )
            return null;
        else
            return head.getValue();

    }


    /**
     * Appends the specified element to the end of this list.
     * 
     * @param obj
     *            - element to be appended to this list
     * @return true if this collection changed as a result of the call
     */
    public boolean add( E obj )
    {
        if ( this.isEmpty() )
        {
            head = new ListNode<E>( obj, tail );
            tail = head;
            return true;
        }
        else
        {
            ListNode<E> a = new ListNode<E>( obj, null );

            tail.setNext( a );
            tail = a;
            return true;
        }

    }


    /**
     * Retrieves and removes the head (first element) of this list.
     * 
     * @return the head of this list
     * @throws NoSuchElementException
     *             - if this list is empty
     */
    public E remove()
    {
        // System.out.println( this );
        if ( isEmpty() )
            throw new NoSuchElementException();
        E toReturn = head.getValue();
        head = head.getNext();
        return toReturn;
    }


    /**
     * Exercise 20.12
     * 
     * Appends otherList at the end of this list. Append should work in O(1)
     * time, regardless of the list sizes, and it should work properly when
     * either list is empty or both list are empty
     * 
     * @param otherList
     *            list to be appended to the end of this list
     */
    public void append( LinkedListWithTail<E> otherList )
    {
        ListNode<E> a;

        if ( isEmpty() )
        {
            a = otherList.head;
            head = a;
        }
        else if ( ( otherList.isEmpty() ) )
        {
            return;
        }

        else
        {
            tail.setNext( otherList.head );
        }

    }


    /**
     * *** FOR TESTING PURPOSES ONLY ***
     *
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        String str = "[", separator = "";

        for ( ListNode<E> node = head; node != null; node = node
            .getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}

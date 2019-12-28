import java.util.Iterator;


/**
 * Implements a singly-linked list.
 * 
 * @author Riya Kumari
 * @version 12/12/18
 * 
 * @author Period - 5
 * @author Assignment - Singly-Linked List
 * @author Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;

    private int nodeCount;


    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }


    /**
     * Constructor: creates a list that contains all elements from the array
     * values, in the same order
     * 
     * @param values
     *            array containing all elements for this list
     */
    public SinglyLinkedList( E[] values )
    {
        ListNode<E> tail = null;
        for ( E value : values ) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>( value, null );
            if ( head == null )
                head = node;
            else
                tail.setNext( node );
            tail = node; // update tail
        }

        nodeCount = values.length;
    }


    /**
     * Return true if this list is empty; otherwise returns false.
     * 
     * @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {

        return nodeCount == 0;
    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements in this list.
     */
    public int size()
    {

        return nodeCount;
    }


    /**
     * Returns true if this list contains an Object equal to obj; otherwise
     * returns false.
     * 
     * @return true if this list contains an Object equal to obj
     */
    public boolean contains( Object obj )
    {

        return ( indexOf( obj ) != -1 );
    }


    /**
     * Returns the index of the first Object equal to obj; if not found, returns
     * -1.
     * 
     * @param obj
     *            Object to find
     * @return the index of the first Object in equal to obj; if not found,
     *         returns -1.
     */
    public int indexOf( Object obj )
    {

        Iterator<E> t = this.iterator();
        int count = 0;
        while ( t.hasNext() )
        {
            if ( t.next().equals( obj ) )
                return count;
            else
                count++;
        }

        return -1;
    }


    /**
     * Adds obj to this collection. Returns true if successful; otherwise
     * returns false.
     * 
     * @param obj
     *            element to add to this collection
     * @return true if successful; otherwise returns false.
     */
    public boolean add( E obj )
    {
        this.head = new ListNode<E>( obj, head );
        ListNode<E> a = new ListNode<E>( obj, null );
        ListNode<E> b = this.head;

        if ( nodeCount == 0 )
        {
            head = a;
            nodeCount++;
            return true;
        }
        else
        {
            while ( b.getNext() != null )
            {
                b = b.getNext();
            }
            nodeCount++;
            b.setNext( a );
        }
        return true;
    }


    /**
     * Removes the first element that is equal to obj, if any. Returns true if
     * successful; otherwise returns false.
     * 
     * @param obj
     *            element to remove
     * @return true if successful; otherwise returns false.
     */
    public boolean remove( E obj )
    {
        int i = indexOf( obj );
        try
        {
            this.remove( i );
            return true;
        }
        catch ( Exception someException )
        {
            return false;
        }
    }


    /**
     * Returns the i-th element.
     * 
     * @param i
     *            element to get from the list
     * @return element at index i
     * @throws IndexOutOfBoundsException
     */
    public E get( int i )
    {
        int a = 0;
        for ( E element : this )

            if ( i == a )
                return element;

            else
                a++;
        throw new IndexOutOfBoundsException();

    }


    /**
     * Replaces the i-th element with obj and returns the old value.
     * 
     * @param i
     *            index of element to replace
     * @param obj
     *            replacement element of element at index i
     * @return old value previously located at index i
     * @throws IndexOutOfBoundsException
     */
    public E set( int i, E obj )
    {
        if ( i < 0 || i >= nodeCount )
            throw new IndexOutOfBoundsException();

        ListNode<E> a = head;
        // int b = i-1;
        for ( int b = 0; b < i; b++ )
        {
            a = a.getNext(); // traverse the list to get to required node
        }
        E temp = a.getValue();
        // replacement element of element at index i
        a.setValue( obj );
        return temp;
    }


    /**
     * Inserts obj to become the i-th element. Increments the size of the list
     * by one.
     * 
     * @param i
     *            insertion point in list for obj
     * @param obj
     *            element to insert into list
     * @throws IndexOutOfBoundsException
     */
    public void add( int i, E obj )
    {

        if ( i > nodeCount || i < 0 )
            throw new IndexOutOfBoundsException();

        if ( this.size() == 0 )
            head = ( new ListNode<E>( obj, null ) );

        ListNode<E> a = head;
        for ( int b = 0; b < i; b++ )
            a = a.getNext();

        {
            nodeCount++;
            ListNode<E> add = new ListNode<E>( obj, a.getNext() );
            a.setNext( add );

        }

    }


    /**
     * Removes the i-th element and returns its value. Decrements the size of
     * the list by one.
     * 
     * @param i
     *            index of element to remove
     * @return element removed from this list
     */
    public E remove( int i )
    {
        if ( i == 0 )
        {
            E temp = head.getValue();
            head.setValue( null );
            nodeCount--;
            return temp;
        }
        if ( i < 0 || i >= nodeCount )
        {
            throw new IndexOutOfBoundsException();
        }

        ListNode<E> h = head;
        E nextNode = null;

        for ( int x = 0; x < i - 1; x++ )
        {
            h = h.getNext();
            nextNode = h.getNext().getValue();
        }

        h.setNext( h.getNext().getNext() );
        nodeCount--;

        return nextNode;
    }


    /**
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        String result = "";
        for ( E node : this )
        {
            result += node.toString();
        }
        return result;
    }


    /**
     * Returns an iterator for this collection.
     * 
     * @return an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>( head );
    }
}

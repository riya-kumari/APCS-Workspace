import java.util.*;


/**
 * Implements a priority queue based on a min-heap.
 * 
 * @author TODO Your Name
 * @version Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class HeapPriorityQueue
{
    private static final int DFLT_CAPACITY = 101;

    private Object[] items;

    private int numItems;

    private final Comparator<Object> comparator;


    public HeapPriorityQueue()
    {
        this( DFLT_CAPACITY, null );
    }


    public HeapPriorityQueue( Comparator<Object> c )
    {
        this( DFLT_CAPACITY, c );
    }


    public HeapPriorityQueue( int initialCapacity )
    {
        this( initialCapacity, null );
    }


    public HeapPriorityQueue( int initialCapacity, Comparator<Object> c )
    {
        items = new Object[initialCapacity + 1];
        comparator = c;
    }


    /**
     * Returns true if this priority queue is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return numItems == 0;
    }


    /**
     * Returns the highest priority element without removing it from this
     * priority queue.
     */
    public Object peek()
    {
        if ( numItems == 0 )
        {
            throw new NoSuchElementException();
        }
        return items[1];
    }


    /**
     * Adds obj to this priority queue; returns true.
     */
    public boolean add( Object obj )
    {
        numItems++;
        if ( numItems >= items.length ) // items[0] is not used
            growCapacity();
        items[numItems] = obj;
        reheapUp();
        return true;
    }


    /**
     * Removes and returns the highest priority item.
     */
    public Object remove()
    {
        if ( numItems == 0 )
        {
            throw new NoSuchElementException();
        }

        Object minObject = items[1];
        items[1] = items[numItems];
        numItems--;
        reheapDown();
        return minObject;
    }


    // **************************************************************************

    private boolean lessThan( Object obj1, Object obj2 )
    {
        if ( comparator != null )
            return comparator.compare( obj1, obj2 ) < 0;
        else
            return ( (Comparable)obj1 ).compareTo( obj2 ) < 0;
    }


    public void reheapDown()
    {
        /*
         * if items is less than half the total number of items if items[2i + 1
         * ] is less than2i value is 2i+1 else its 2i
         * 
         * if items[value , current item] switch them
         * 
         * else return
         */

        for ( int i = 1; i <= numItems / 2; i++)
        {
            int ahead = 2 * i + 1;
            int curr = 2 * i;
            int val = 0;
            
            if ( lessThan( items[ahead], items[curr] ) )
            {
                val = ahead;
            }
            else
            {
                val = curr;

            }

            if ( lessThan( items[val], items[i] ) )
            {
                Object a = items[i];
                items[i] = items[val];
                items[val] = a;
                i = val;
            }
            else
            {
                break;
            }

        }
    }


    public void reheapUp()
    {
        // start from the end
        for ( int i = numItems - 1; i > 1; i /= 2 )
        {
            if ( lessThan( items[i], items[i / 2] ) )
            {
                Object a = items[i / 2];
                items[i / 2] = items[i];
                items[i] = a;
            }
            else
                break;

        }
    }


    private void growCapacity()
    {
        Object[] tempItems = new Object[2 * items.length - 1];
        System.arraycopy( items, 0, tempItems, 0, items.length );
        items = tempItems;
    }


    /**
     * returns the String containing all the elements in level order
     * 
     * @return the String containing all the elements in level order
     */
    public String toString()
    {
        String result = "";
        int i = 0;
        while ( i < numItems - 1 )
        {
            result += items[i];
            i++;
        }
        return result;
    }
}

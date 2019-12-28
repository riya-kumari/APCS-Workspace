import java.util.*;


public class Ch25Exercises
{
    /**
     * Exercise 21.
     * 
     * An array
     * 
     * Object[] completeTree;
     * 
     * represents a complete tree with completeTree[0] holding the number of
     * nodes in the tree and completeTree[1] holding the root value. Write a
     * method removeLeaves(Object[] completeTree) that removes all the leaves
     * from this tree.
     * 
     * @param completeTree
     *            represents a complete tree with completeTree[0] holding the
     *            number of nodes in the tree and completeTree[1] holding the
     *            root value
     */
    public void removeLeaves( Object[] completeTree )
    {
        // System.out.println( completeTree[0] );
        int n = completeTree.length - 1;
        int leaves = ( n + 1 ) / 2;
        for ( int i = n; i > n - leaves; i-- )
        {
            completeTree[i] = null;
        }
        int i = 0;
        Object a = completeTree[0];
        completeTree[0] = (Integer)a - ( (Integer)a + 1 ) / 2;
        // System.out.println( completeTree[0] );
    }


    /**
     * Exercise 22.
     * 
     * Suppose a complete binary tree is rooted at root and has numNodes nodes.
     * Write a method
     * 
     * public Object[] toArray(TreeNode root, int numNodes)
     * 
     * that takes root and numNodes as parameters, stores that tree in an array
     * of length numNodes + 1, starting at the element with index 1, and returns
     * that array. The resulting array should hold the values in the order of a
     * level-by-level traversal of the tree. Write and use a recursive helper
     * method
     * 
     * private void toArray(TreeNode node, Object[] values, int i)
     * 
     * that places the value from node into values[i] and the rest of the values
     * from the (sub)tree rooted at node into the appropriate locations in
     * values.
     * 
     * @param root
     *            base of a complete binary tree
     * @param numNodes
     *            number of nodes in the tree
     * @return an array that holds the values of the binary tree in the order of
     *         a level-by-level traversal of the tree
     */
    public Object[] toArray( TreeNode root, int numNodes )
    {
        Object[] a = new Object[numNodes + 1];

        toArray( root, a, 1 );
        return a;
    }


    /**
     * toArray helper method.
     * 
     * @param node
     *            base of a complete binary tree
     * @param values
     *            an array that holds the values of the binary tree in the order
     *            of a level-by-level traversal of the tree
     * @param i
     *            current location in the values array
     */
    private void toArray( TreeNode node, Object[] values, int i )
    {
        if ( node == null )
            return;
        values[i] = node.getValue();
        toArray( node.getLeft(), values, 2 * i );
        toArray( node.getRight(), values, 2 * i + 1 );
    }


    /**
     * Exercise 23.
     * 
     * Write a boolean method isHeap. This method assumes that items represents
     * a complete binary tree with numNodes, with its root value stored in
     * items[1]. isHeap should return true if and only if this tree is a
     * min-heap. Do not use recursion, stacks, or temporary lists or arrays.
     * 
     * @param items
     *            a complete binary tree with numNodes nodes
     * @param numNodes
     *            number of nodes in the items array
     * @return true if and only if this tree is a min-heap
     */
    public boolean isHeap( Integer[] items, int numNodes )
    {
        // check if the node is less than the parent
        if ( items == null )
            return false;
        for ( int i = numNodes; i > 0; i-- )
        {
            if ( items[i] < items[i / 2] )
                return i==1;
        }
        return false;
    }


    /**
     * Exercise 24.
     * 
     * A min-heap is represented in Integer[] items, with the root value in
     * items[1]. Suppose the root value has been replaced by the last leaf.
     * Write a method reheapDown that repairs the heap. numNodes is the total
     * number of nodes in the heap.
     * 
     * @param items
     *            a min-heap with the root value in items[1]
     * @param numNodes
     *            total number of nodes in the heap
     */
    public void reheapDown( Integer[] items, int numNodes )
    {
        for ( int i = 1; i < numNodes; i++ )
        {
            if ( numNodes > 2 * i + 1 && numNodes > 2 * i )
            {
                // if it's already less than its children
                if ( items[i] < items[2 * i]
                    && items[i] < items[2 * i + 1] )
                    break;
                // if the root is greater than left or right
                if ( items[i] > items[2 * i]
                    || items[i] > items[2 * i + 1] )
                {
                    // if the left is less than right
                    if ( items[2 * i] < items[2 * i + 1] )
                    {
                        int temp = items[i];
                        items[i] = items[2 * i];
                        items[2 * i] = temp;
                        i = 2 * i;

                    }
                    else
                    // if the right is less than left and its less than root
                    if ( items[2 * i] > items[2 * i + 1]
                        && items[i] > items[2 * i + 1] )
                    {
                        int temp = items[i];
                        items[i] = items[2 * i + 1];
                        items[2 * i + 1] = temp;
                        i = 2 * i + 1;

                    }
                }
            }

        }
    }


    /**
     * Exercise 25.
     * 
     * Messages are Comparable objects. The same message can belong to two
     * priority queues, q1 and q2. Write a method exclude that creates and
     * returns a new priority queue that consists of all messages in q1 that are
     * not in q2 (that is, not msg1 == msg2). exclude should leave q1 and q2
     * empty. Do not use any temporary arrays, lists, or other data structures.
     * 
     * Precondition: no two messages in q2 have the same priority
     * 
     * @param q1
     *            PriorityQueue of Message
     * @param q2
     *            PriorityQueue of Message
     * @return all messages in q1 that are not in q2
     */
    public PriorityQueue<Message> exclude(
        PriorityQueue<Message> q1,
        PriorityQueue<Message> q2 )
    {
        // create a new priority queue
        PriorityQueue<Message> a = new PriorityQueue<Message>();

        // add messages to exclude that isn't in q2 but is in q1
        for ( Message x : q1 )
        {
            for ( Message y : q2 )
            {
                if ( !q2.contains( x ) )
                    if ( x != y )
                        if ( !a.contains( x ) )
                            a.add( x );
            }
        }
        // returns the new priority queue
        return a;
    }


    /**
     * Testing method: instantiates a Ch25Exercises object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        Ch25Exercises ex = new Ch25Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println(
                "   (1) 25-21 removeLeaves( Object[] completeTree )" );
            System.out.println(
                "   (2) 25-22 toArray( TreeNode root, int numNodes )" );
            System.out.println(
                "   (3) 25-23 isHeap( Integer[] items, int numNodes )" );
            System.out.println(
                "   (4) 25-24 reheapDown( Integer[] items, int numNodes )" );
            System.out.println(
                "   (5) 25-25 exclude( PriorityQueue<Message> q1,PriorityQueue<Message> q2 )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        Integer[] compTree = { 7, 1, 3, 2, 7, 5, 6, 4 };
                        for ( int i = 1; i <= compTree[0]; i++ )
                        {
                            System.out.print( compTree[i] + " " );
                        }
                        System.out.println();

                        ex.removeLeaves( compTree );

                        for ( int i = 1; i <= compTree[0]; i++ )
                        {
                            System.out.print( compTree[i] + " " );
                        }
                        System.out.println();
                        break;
                    case '2':
                        TreeNode<Integer> root = new TreeNode<Integer>( 1,
                            new TreeNode<Integer>( 3,
                                new TreeNode<Integer>( 7, null, null ),
                                new TreeNode<Integer>( 5, null, null ) ),
                            new TreeNode<Integer>( 2,
                                new TreeNode<Integer>( 6, null, null ),
                                new TreeNode<Integer>( 4, null, null ) ) );
                        Object[] minHeap = ex.toArray( root, 7 );
                        for ( int i = 0; i < minHeap.length; i++ )
                        {
                            System.out.print( minHeap[i] + " " );
                        }
                        System.out.println();
                        break;
                    case '3':
                        Integer[] items = { 7, 1, 3, 2, 7, 5, 6, 4 };
                        System.out.println( "isHeap( items, items[0] ) = "
                            + ex.isHeap( items, items[0] ) );
                        break;
                    case '4':
                        Integer[] heapDown = { 6, 4, 3, 2, 7, 5, 6 };
                        for ( int i = 1; i <= heapDown[0]; i++ )
                        {
                            System.out.print( heapDown[i] + " " );
                        }
                        System.out.println();
                        ex.reheapDown( heapDown, heapDown[0] );
                        for ( int i = 1; i <= heapDown[0]; i++ )
                        {
                            System.out.print( heapDown[i] + " " );
                        }
                        System.out.println();
                        break;
                    case '5':
                        Message msg1 = new Message( "msg1" );
                        Message msg2 = new Message( "msg2" );
                        Message msg3 = new Message( "msg3" );
                        Message msg4 = new Message( "msg4" );

                        Message msg0 = new Message( "msg0" );
                        Message msg5 = new Message( "msg5" );
                        Message msg6 = new Message( "msg6" );

                        PriorityQueue<Message> pq1 = new PriorityQueue<Message>();
                        pq1.add( msg1 );
                        pq1.add( msg2 );
                        pq1.add( msg3 );
                        pq1.add( msg4 );
                        System.out.println( pq1 );

                        PriorityQueue<Message> pq2 = new PriorityQueue<Message>();
                        pq2.add( msg0 );
                        pq2.add( msg1 );
                        pq2.add( msg4 );
                        pq2.add( msg5 );
                        pq2.add( msg6 );
                        System.out.println( pq2 );

                        PriorityQueue<Message> pq3 = ex.exclude( pq1,
                            pq2 );

                        System.out.println( pq3 );

                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );

    }
}

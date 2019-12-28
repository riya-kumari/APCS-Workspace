
import java.awt.Graphics;


/**
 * Implements the list of messages for teletext
 * 
 * @author Riya Kumari
 * @version Jan 9, 2019
 * @author Period: 5
 * @author Assignment: JMCh20_7Teletext
 */
public class TeletextList
{
    private ListNode2<String> heading;

    private ListNode2<String> topNode;


    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines
     *            Strings to add to circular list
     */
    public TeletextList( String[] headlines )
    {
        ListNode2<String> random;
        // setting next node
        heading = new ListNode2<String>( "Today's headlines", null, null );

        ListNode2<String> next = new ListNode2<String>( "",
            heading,
            null );
        heading.setNext( next );
        // setting previous node
        ListNode2<String> finalNext = new ListNode2<String>( "",
            null,
            heading );
        heading.setPrevious( finalNext );
        random = next;
        // adding the other headlines
        for ( String a : headlines )
        {

            random.setNext( new ListNode2<String>( a, random, null ) );

            random = random.getNext();

        }
        // connecting everything
        random.setNext( finalNext );
        topNode = heading;

    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert( String msg )
    {
        addAfter( heading.getNext(), msg );
    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {

        if ( !topNode.getNext().equals( heading )
            && !topNode.equals( heading )
            && !topNode.getPrevious().equals( heading ) )

            remove( topNode.getNext() );

    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }


    /**
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     * 
     * @param node
     *            that is to be added
     * @param msg
     *            in the node
     * @return the node added
     */
    private ListNode2<String> addBefore(
        ListNode2<String> node,
        String msg )
    {
        ListNode2<String> newNode = new ListNode2<String>( msg,
            node.getPrevious(),
            node );
        node.getPrevious().setNext( newNode );
        node.setPrevious( newNode );
        return newNode;
    }


    /**
     * Adds a new node with msg to the headlines list after a given node.
     * Returns a referenece to the added node.
     * 
     * @param node
     *            is the new node
     * @param msg
     *            is on the new node
     * @return the newnode that has been added
     */
    private ListNode2<String> addAfter(
        ListNode2<String> node,
        String msg )
    {
        ListNode2<String> a = node.getNext();
        ListNode2<String> newNode = new ListNode2<String>( msg, node, a );
        node.setNext( newNode );
        a.setPrevious( newNode );

        return newNode;
    }


    /**
     * Removes a given node from the list.
     * 
     * @param node
     *            to remove
     */
    private void remove( ListNode2<String> node )
    {

        // ListNode2<String> temp = node.getPrevious();

        node.getPrevious().setNext( node.getNext() );
        node.getNext().setPrevious( node.getPrevious() );

    }


    /**
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * 
     * @param g
     *            variable
     * @param x
     *            variable
     * @param y
     *            variable
     * @param lineHeight
     *            variable
     * @param nLines
     *            variable
     */
    public void draw(
        Graphics g,
        int x,
        int y,
        int lineHeight,
        int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node
            .getNext() != heading; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}

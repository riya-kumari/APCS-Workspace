
import java.util.Stack;


/**
 * Browses several lines of text.
 *
 * @author Riya K
 * @version Jan 20, 2019
 * @author Period: 5
 * @author Assignment: JMCh21_3Browsing
 */
public class BrowserModel
{
    private BrowserView view;

    private Stack<Integer> backStk;

    private Stack<Integer> forwardStk;

    private int topLine;


    /**
     * Constructor
     * 
     * @param view
     *            is what you see
     */
    public BrowserModel( BrowserView view )
    {

        this.view = view;
        this.backStk = new Stack<Integer>();
        this.forwardStk = new Stack<Integer>();

        view.update( 0 );
    }


    /**
     * Goes back to the previous line
     */
    public void back()
    {
        forwardStk.push( topLine );
        if ( hasBack() )
        {
            topLine = (int)backStk.pop();
        }
        else
        {

            view.update( topLine );
        }
        view.update( topLine );
        // System.out.println( "backStk : " + backStk );

    }


    /**
     * Goes to the next line
     */
    public void forward()
    {

        backStk.push( topLine );
        if ( hasForward() )
        {
            topLine = (int)forwardStk.pop();
            view.update( topLine );
        }
        // else
        // {
        // //view.update( 0 );
        // }

        // System.out.println( "ford.: " + forwardStk );

    }


    /**
     * Returns to the starting line
     */
    public void home()
    {
        backStk.push( topLine );
        topLine = 0;
        view.update( 0 );
        // backStk.clear();
        // forwardStk.removeAllElements();
        // System.out.println( "backStk : " + backStk );
    }


    /**
     * Follows the line to the next one
     * 
     * @param n
     *            is the next line
     */
    public void followLink( int n )
    {

        // forwardStk.removeAllElements();

        // System.out.println( n );

        backStk.push( topLine );
        topLine = n;
        view.update( topLine );
        // forwardStk.removeAllElements();

    }


    /**
     * If backStk has a back
     * 
     * @return true or false
     */
    public boolean hasBack()
    {
        return !backStk.isEmpty();

    }


    /**
     * If forwardStk has a back
     * 
     * @return true or false
     */
    public boolean hasForward()
    {
        return !forwardStk.isEmpty();

    }


    /**
     * getter method
     * 
     * @return the backStk
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * Getter method
     * 
     * @return the forwardStk
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * Gets the Top Line of the browser
     * 
     * @return topLine of the browser
     */
    public int getTopLine()
    {
        return topLine;
    }
}

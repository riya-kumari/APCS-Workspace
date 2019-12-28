//Tim
import java.lang.reflect.*;
import java.util.*;

/**
 *  Represents a stock trader.
 *
 *  @author  Tim Zou
 *  @version Mar 28, 2019
 *  @author  Period: 5
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources: None
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;
    private String screenName, password;
    
    private TraderWindow myWindow;
    private Queue<String> mailbox;

    /**
     * Constructs a new trader, affiliated with a given brokerage, with a 
     * given screen name and password.
     * @param brokerage the affiliated brokerage
     * @param name name of trader
     * @param pswd password of trader
     */
    public Trader (Brokerage brokerage, String name, String pswd)
    {
        this.brokerage = brokerage;
        screenName = name;
        password = pswd;
        mailbox = new LinkedList<String>();
    }
    
    /**
     * Returns the screen name for this trader. 
     * @return the screen name for this trader.
     */
    public String getName()
    {
        return screenName;
    }
    
    /**
     * Returns the password for this trader. 
     * @return the pasword for this trader.
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Compares this trader to another by comparing their screen names case 
     * blind.
     * @param other the reference to a trader with which to compare. 
     * @return the result of the comparison of this trader and other.
     */
    public int compareTo(Trader other)
    {
        return getName().compareToIgnoreCase( other.getName() );
    }
    
    /**
     * Indicates whether some other trader is "equal to" this one, based on 
     * comparing their screen names case blind. This method will throw a 
     * ClassCastException if other is not an instance of Trader. 
     * @param other the reference to an object with which to compare.
     * @return boolean true if this trader's screen name is the same as other's
     * ; false otherwise.
     */
    public boolean equals(Object other)
    {
        if (other instanceof Trader)
        {
            return compareTo((Trader) other) == 0;
        }
        throw new ClassCastException();
    }
    
    /**
     * Creates a new TraderWindow for this trader and saves a reference to it 
     * in myWindow. Removes and displays all the messages, if any, from this 
     * trader's mailbox by calling myWindow.show(msg) for each message.
     */
    public void openWindow()
    {
        myWindow = new TraderWindow(this);
        while (mailbox.peek() != null)
        {
            myWindow.showMessage(mailbox.peek());
            mailbox.remove();
        }
    }
    
    /**
     * Helper getter method
     * @return TraderWindow myWindow
     */
    public TraderWindow getWindow()
    {
        return myWindow;
    }
    
    /**
     * Helper getter method
     * @return Queue<String> mailbox
     */
    public Queue<String> getMailbox()
    {
        return mailbox;
    }
    
    /**
     * Returns true if this trader has any messages in its mailbox. 
     * @return boolean true if this trader has messages; false otherwise.
     */
    public boolean hasMessages()
    {
        return !mailbox.isEmpty();
    }
    
    /**
     * Adds msg to this trader's mailbox and displays all messages. If this 
     * trader is logged in (myWindow is not null) removes and shows all the 
     * messages in the mailbox by calling myWindow.showMessage(msg) for each 
     * msg in the mailbox. 
     * @param msg a message to be added to this trader's mailbox.
     */
    public void receiveMessage(String msg)
    {
        mailbox.add( msg );
        if (myWindow == null)
        {
            return;
        }
        while (mailbox.peek() != null)
        {
            myWindow.showMessage(mailbox.peek());
            mailbox.remove();
        }
    }
    
    /**
     * Requests a quote for a given stock symbol from the brokerage by 
     * calling brokerage's getQuote. 
     * @param symbol a stock symbol for which a quote is requested.
     */
    public void getQuote(String symbol)
    {
        brokerage.getQuote(symbol, this);
    }
    
    /**
     * Places a given order with the brokerage by calling brokerage's 
     * placeOrder. 
     * @param order a trading order to be placed.
     */
    public void placeOrder(TradeOrder order)
    {
        brokerage.placeOrder(order);
    }
    
    /**
     * Logs out this trader. Calls brokerage's logout for this trader. Sets m
     * yWindow to null (this method is called from a TraderWindow's window 
     * listener when the "close window" button is clicked).
     */
    public void quit()
    {
        brokerage.logout(this);
        myWindow = null;
    }
    
    //
    // The following are for test purposes only
    //
    /**
     * Test
     * @return Queue<String> test
     */
    protected Queue<String> mailbox()
    {
        return mailbox;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                if ( field.getType().getName().equals( "Brokerage" ) )
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                else
                    str += separator + field.getType().getName() + " "
                        + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}

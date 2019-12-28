import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock exchange. A <code>StockExchange</code> keeps a
 * <code>HashMap</code> of stocks, keyed by a stock symbol. It has methods to
 * list a new stock, request a quote for a given stock symbol, and to place a
 * specified trade order.
 */
/**
 * 
 * Represents a stock exchange. A StockExchange keeps a HashMap of stocks, keyed
 * by a stock symbol. It has methods to list a new stock, request a quote for a
 * given stock symbol, and to place a specified trade order.
 * 
 * @author Riya Kumari
 * @version Apr 2, 2019
 * @author Period: TODO
 * @author Assignment: JMCh19_SafeTrade
 *
 */
public class StockExchange
{
    private Map<String, Stock> listedStocks;


    /**
     * Constructor
     */
    public StockExchange()
    {
        listedStocks = new HashMap<String, Stock>();
    }


    /**
     * Returns a quote for a given stock.
     * 
     * @param symbol
     *            - the key
     * @return a quote string for this stock.
     */
    public java.lang.String getQuote( java.lang.String symbol )
    {
        // stock is supposed to have a method getQuote()
        return listedStocks.get( symbol ).getQuote();

    }


    /**
     * Adds a new stock with given parameters to the listed stocks.
     * 
     * @param symbol
     *            is the stock symbol
     * @param name
     *            is the full company name
     * @param price
     *            opening stock price
     */
    public void listStock(
        java.lang.String symbol,
        java.lang.String name,
        double price )
    {
        Stock stk = new Stock( symbol, name, price );
        listedStocks.put( symbol, stk );
    }


    /**
     * 
     * Places a trade order by calling stock.placeOrder for the stock specified
     * by the stock symbol in the trade order
     * 
     * @param order
     *            a trading order to be placed with this stock exchange.
     */
    public void placeOrder( TradeOrder order )
    {
        if ( order != null )
        {
            listedStocks.get( order.getSymbol() ).placeOrder( order );
        }
        

    }


    /**
     * 
     * The following are for test purposes only
     * 
     * @return Map<String, Stock>
     */
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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

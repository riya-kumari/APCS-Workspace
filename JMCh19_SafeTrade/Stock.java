//Hanting
import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 */
public class Stock
{
    public static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice, hiPrice, lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders, sellOrders;


    /**
     * Constructs a new stock with a given symbol, company name, and starting
     * price. Sets low price, high price, and last price to the same opening
     * price. Sets "day" volume to zero. Initializes a priority qieue for sell
     * orders to an empty PriorityQueue with a PriceComparator configured for
     * comparing orders in ascending order; initializes a priority queue for buy
     * orders to an empty PriorityQueue with a PriceComparator configured for
     * comparing orders in descending order.
     * 
     * @param symbol
     *            the stock symbol
     * @param name
     *            full company name
     * @param price
     *            opening price for this stock
     */
    public Stock ( String symbol, String name, double price )
    {
        stockSymbol = symbol;
        companyName = name;

        loPrice = price;
        hiPrice = price;
        lastPrice = price;

        volume = 0;

        buyOrders = new PriorityQueue<TradeOrder>(
            new PriceComparator( true ) );
        sellOrders = new PriorityQueue<TradeOrder>(
            new PriceComparator( false ) );
    }


    /**
     * Returns a quote string for this stock. The quote includes: the company
     * name for this stock; the stock symbol; last sale price; the lowest and
     * highest day prices; the lowest price in a sell order (or "market") and
     * the number of shares in it (or "none" if there are no sell orders); the
     * highest price in a buy order (or "market") and the number of shares in it
     * (or "none" if there are no buy orders).
     * 
     * @return the quote for this stock
     */
    public String getQuote()
    {

        String info = companyName + "(" + stockSymbol + ")\nPrice: "
            + lastPrice + "  hi: " + hiPrice + "  lo: " + loPrice
            + "  vol: " + volume + "\n";

        String sellOrder, buyOrder;
        String marketOrLimit;
        if ( sellOrders.isEmpty() )
        {
            sellOrder = "Ask: none";
        }
        else
        {
            if ( sellOrders.peek().isMarket() )
            {
                marketOrLimit = "market";
            }
            else
            {
                marketOrLimit = "" + sellOrders.peek().getPrice();
            }
            sellOrder = "Ask: " + marketOrLimit + "  size: "
                + sellOrders.peek().getShares();
        }

        if ( buyOrders.isEmpty() )
        {
            buyOrder = "  Bid: none";
        }
        else
        {
            if ( buyOrders.peek().isMarket() )
            {
                marketOrLimit = "market";
            }
            else
            {
                marketOrLimit = "" + buyOrders.peek().getPrice();
            }
            buyOrder = "  Bid: " + marketOrLimit + "  size: "
                + buyOrders.peek().getShares();
        }

        return info + sellOrder + buyOrder;
    }


    /**
     * Places a trading order for this stock. Adds the order to the appropriate
     * priority queue depending on whether this is a buy or sell order. Notifies
     * the trader who placed the order that the order has been placed, by
     * sending a message to that trader.
     * 
     * @param order
     *            a trading order to be placed
     */
    public void placeOrder( TradeOrder order )
    {
        if (order == null)
            return;
        
        String buyOrSell, price;
        if ( order.isSell() )
        {
            sellOrders.add( order );
            buyOrSell = "sell";
        }
        else
        {
            buyOrders.add( order );
            buyOrSell = "buy";
        }
        
        if ( order.isMarket() )
        {
            price = "market";
        }
        else
        {
            price = "" + order.getPrice();
        }

        order.getTrader()
            .receiveMessage( "New Order: " + buyOrSell + " " + stockSymbol
                + " (" + companyName + ")\n" + order.getShares()
                + " shares at " + price );
        
        executeOrder();
    }
    
    
    /**
     * 
     * Executes as many pending orders as possible. 
     * 1. Examines the top sell
     * order and the top buy order in the respective priority queues.
     * i) If both
     * are limit orders and the asking price is less than or equal to the
     * selling price, executes the order (or a part of it) at the sell order
     * price. 
     * ii) If one order is limit and the other is market, executes the
     * order (or a part of it) at the limit order price 
     * iii) If both orders are
     * market, executes the order (or a part of it) at the last sale price. 2.
     * Figures out how many shares can be traded, which is the smallest of the
     * numbers of shares in the two orders. 
     * 3. Subtracts the traded number of
     * shares from each order; Removes each of the orders with 0 remaining
     * shares from the respective queue. 
     * 4. Updates the day's low price, high
     * price, and volume. 
     * 5. Sends a message to each of the two traders involved
     * in the transaction. For example: You bought: 150 GGGL at 38.00 amt
     * 5700.00 
     * 6. Repeats steps 1-5 for as long as possible, that is as long as
     * there is any movement in the buy / sell order queues. (The process gets
     * stuck when the top buy order and sell order are both limit orders and the
     * ask price is higher than the bid price.)
     */
    public void executeOrder()
    {
        if ( sellOrders.isEmpty() || buyOrders.isEmpty() )
        {
            return;
        }
        
        TradeOrder buyOrder = buyOrders.peek();
        TradeOrder sellOrder = sellOrders.peek();

        double transactionPrice;

        while ( !( sellOrder.isLimit() && buyOrder.isLimit()
            && sellOrder.getPrice() > buyOrder.getPrice() ) )
        {
            int toBeExchanged = Math.min( sellOrder.getShares(),
                buyOrder.getShares() );

            sellOrder.subtractShares( toBeExchanged );
            buyOrder.subtractShares( toBeExchanged );
            volume += toBeExchanged; // Updates day's volume

            if ( sellOrder.isLimit() )
            {
                transactionPrice = sellOrder.getPrice();
            }
            else if ( buyOrder.isLimit() )
            {
                transactionPrice = sellOrder.getPrice();
            }
            else
            {
                transactionPrice = lastPrice;
            }
            
            // Updates the day's low price, high price
            if ( loPrice > transactionPrice )
            {
                loPrice = transactionPrice;
            }

            if ( hiPrice < transactionPrice )
            {
                hiPrice = transactionPrice;
            }

            // Updates order queue
            if ( sellOrder.getShares() == 0 )
            {
                sellOrders.remove();
            }

            if ( buyOrder.getShares() == 0 )
            {
                buyOrders.remove();
            }
            
            // Sends messages to each trade in the transaction
            sellOrder.getTrader()
                .receiveMessage( "You sold: " + toBeExchanged + " "
                    + companyName + " at " + transactionPrice + " amt "
                    + ( transactionPrice * toBeExchanged ) );
            buyOrder.getTrader()
                .receiveMessage( "You bought: " + toBeExchanged + " "
                    + companyName + " at " + transactionPrice + " amt "
                    + ( transactionPrice * toBeExchanged ) );
            
            // Checks in queues are empty
            if ( sellOrders.isEmpty() || buyOrders.isEmpty() )
            {
                return;
            }
            
            // Moves to next orders
            buyOrder = buyOrders.peek();
            sellOrder = sellOrders.peek();
        }
    }


    //
    // The following are for test purposes only
    //
/**
 * 
 * Getter Method
 * @return stockSymbol
 */
    protected String getStockSymbol()
    {
        return stockSymbol;
    }

    /**
     * Getter Method
     * @return company name
     */
    protected String getCompanyName()
    {
        return companyName;
    }

    /**
     * Getter Method
     * @return low price
     */
    protected double getLoPrice()
    {
        return loPrice;
    }

    /**
     * Getter Method
     * @return high price
     */
    protected double getHiPrice()
    {
        return hiPrice;
    }

    /**
     * Getter Method
     * @return last price
     */
    protected double getLastPrice()
    {
        return lastPrice;
    }

    /**
     * Getter Method
     * @return volume
     */
    protected int getVolume()
    {
        return volume;
    }

    /**
     * Getter Method
     * @return buyOrders
     */
    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }

    /**
     * Getter Method
     * @return sellOrders
     */
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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

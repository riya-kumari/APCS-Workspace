import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author Tim Zou
 * @author Hanting Zhang
 * @author Riya Kumari
 * @version 3/27/19
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: None
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;


    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" )
                && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares )
                && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNull(
            "<< TradeOrder: " + to.getTrader() + " should be null >>",
            to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertTrue(
            "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder
                + " >>",
            to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertFalse(
            "<< TradeOrder: " + to.isSell() + " should be " + !buyOrder
                + " >>",
            to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.isMarket() + " should be " + marketOrder
                + " >>",
            to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertFalse(
            "<< TradeOrder: " + to.isLimit() + " should be " + !marketOrder
                + ">>",
            to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.getShares() + " should be " + numShares
                + ">>",
            numShares == to.getShares()
                || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be "
            + price + ">>", price, to.getPrice(), 0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        to.subtractShares( numToSubtract );
        assertEquals(
            "<< TradeOrder: subtractShares(" + numToSubtract
                + ") should be " + ( numShares - numToSubtract ) + ">>",
            numShares - numToSubtract,
            to.getShares() );
    }


    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }


    // --Test PriceComparator
    // Tim
    /**
     * Trader tests: constructor 1 - checks ascending to true value constructor
     * 2 - checks ascending to true value compare - test all 4 major cases (last
     * one split in 2)
     */

    @Test
    public void priceComparatorConstructor1()
    {
        PriceComparator pc = new PriceComparator();
        assertTrue( pc != null && pc.getAscending() );
    }


    @Test
    public void priceComparatorConstructor2()
    {
        PriceComparator pc = new PriceComparator( false );
        assertTrue( pc != null && pc.getAscending() == false );
    }


    // --Test Trader
    // Tim
    /**
     * Trader tests: constructor - constructs Trader then compares toString
     * getName - compares value returned to constructed value getPassword -
     * compares value returned to constructed value compareTo - constructs
     * Trader, compares value returned to expected value equals - constructs
     * Trader, compares value returned to expected value openWindow - ensures
     * window isn't null, checks empty mailbox hasMessages - compares value
     * returned to expected value receiveMessage - getQuote - placeOrder - quit
     * - checks if trader has quit and isn't logged on toString - check toString
     * not null
     */
    @Test
    public void traderConstructor()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );
        String toStr = t.toString();

        assertTrue( toStr.contains( "Brokerage brokerage" )
            && toStr.contains( "java.lang.String screenName:" + name )
            && toStr.contains( "java.lang.String password:" + pswd ) );
    }


    @Test
    public void traderGetName()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        assertEquals( name, t.getName() );
    }


    @Test
    public void traderGetPassowrd()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        assertEquals( pswd, t.getPassword() );
    }


    @Test
    public void traderCompareTo()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        StockExchange se2 = new StockExchange();
        Brokerage brokerage2 = new Brokerage( se2 );
        String name2 = "name2";
        String pswd2 = "pswd";
        Trader t2 = new Trader( brokerage2, name2, pswd2 );
        assertEquals( name.compareToIgnoreCase( name2 ),
            t.compareTo( t2 ) );
    }


    @Test
    public void traderEquals()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        StockExchange se2 = new StockExchange();
        Brokerage brokerage2 = new Brokerage( se2 );
        String name2 = "name2";
        String pswd2 = "pswd";
        Trader t2 = new Trader( brokerage2, name2, pswd2 );

        StockExchange se3 = new StockExchange();
        Brokerage brokerage3 = new Brokerage( se3 );
        String name3 = "name";
        String pswd3 = "pswd";
        Trader t3 = new Trader( brokerage3, name3, pswd3 );

        assertTrue( t.equals( t3 ) );
        assertFalse( t.equals( t2 ) );
    }


    @Test
    public void traderOpenWindow()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        assertNull( t.getWindow() );
        t.openWindow();
        assertNotNull( t.getWindow() );
        assertTrue( t.getMailbox().isEmpty() );
    }


    @Test
    public void traderHasMessages()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        assertFalse( t.hasMessages() );
        t.getMailbox().add( "test" );
        assertTrue( t.hasMessages() );
    }


    @Test
    public void traderReceiveMessage()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        t.openWindow();
        t.receiveMessage( "test" );
        assertTrue( t.getMailbox().isEmpty() );
    }


    @Test
    public void traderGetQuote()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        try
        {
            t.getQuote( "test" );
        }
        catch ( NullPointerException e )
        {
            this.brokerageGetQuote();
        }
    }


    @Test
    public void traderPlaceOrder()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );
        TradeOrder to = new TradeOrder( t, "test", false, false, 10, 10 );
        try
        {
            t.placeOrder( to );
        }
        catch ( NullPointerException e )
        {
            this.brokeragePlaceOrder();
        }
    }


    @Test
    public void traderQuit()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        t.openWindow();
        t.quit();
        assertNull( t.getWindow() );
        assertFalse( brokerage.getLoggedTraders().contains( t ) );
    }


    @Test
    public void traderToString()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        assertNotNull( t.toString() );
    }


    // --Test Brokerage
    // Tim
    /**
     * Brokerage tests: constructor - constructs Broker then compares toString
     * addUser - checks return for all 4 cases and map of traders login - checks
     * return for all 4 cases and logged traders,window,messages logout - checks
     * logged traders getQuote - checks trader's receive method placeOrder -
     * uses stockExchange's test toString - check toString not null
     */

    @Test
    public void brokerageConstructor()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );

        assertTrue( brokerage.getTraders().isEmpty()
            && brokerage.getLoggedTraders().isEmpty() );
    }


    @Test
    public void brokerageAddUser()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );

        assertTrue( brokerage.addUser( "t", "test" ) == -1 );
        assertTrue( brokerage.addUser( "test", "t" ) == -2 );
        brokerage.addUser( "test", "test" );
        assertTrue( brokerage.getTraders().containsKey( "test" ) );
        assertTrue( brokerage.addUser( "test", "test" ) == -3 );
    }


    @Test
    public void brokerageLogin()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );

        assertTrue( brokerage.login( "test", "test" ) == -1 );
        brokerage.addUser( "test", "test" );
        assertTrue( brokerage.login( "test", "notTest" ) == -2 );
        assertTrue( brokerage.login( "test", "test" ) == 0 );
        assertTrue( brokerage.getLoggedTraders()
            .contains( brokerage.getTraders().get( "test" ) ) );
        assertTrue( brokerage.login( "test", "test" ) == -3 );
    }


    @Test
    public void brokerageLogout()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );

        brokerage.addUser( "test", "test" );
        brokerage.login( "test", "test" );
        assertTrue( brokerage.getLoggedTraders()
            .contains( brokerage.getTraders().get( "test" ) ) );
        brokerage.logout( brokerage.getTraders().get( "test" ) );
        assertFalse( brokerage.getLoggedTraders()
            .contains( brokerage.getTraders().get( "test" ) ) );
    }


    @Test
    public void brokerageGetQuote()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );

        t.openWindow();
        try
        {
            brokerage.getQuote( "test", t );
        }
        catch ( NullPointerException e )
        {
            this.StockExchangeGetQuote();
        }
    }


    @Test
    public void brokeragePlaceOrder()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );
        String name = "name";
        String pswd = "pswd";
        Trader t = new Trader( brokerage, name, pswd );
        TradeOrder to = new TradeOrder( t, "test", false, false, 10, 10 );
        try
        {
            brokerage.placeOrder( to );
        }
        catch ( NullPointerException e )
        {
            this.stockExchangePlaceOrder();
        }
    }


    @Test
    public void brokerageToString()
    {
        StockExchange se = new StockExchange();
        Brokerage brokerage = new Brokerage( se );

        assertNotNull( brokerage.toString() );
    }


    // --Test StockExchange
    // Riya
    
    @Test
    public void stockExchangeConstructor()
    {

        StockExchange stock = new StockExchange();
        assertNotNull( stock );
    }


    @Test
    public void stockExchangePlaceOrder()
    {
        StockExchange stock = new StockExchange();
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "mstrade",
            "bigsecret" );
        TradeOrder a = new TradeOrder( trader, "DS", true, true, 2, 0.0 );
        StockExchange test = new StockExchange();
        test.listStock( "DS", "DanceStudios.com", 12.33 );
        test.placeOrder( a );
        assertTrue( "Error in PlaceOrder", trader.hasMessages() );
    }


    @Test
    public void stockExchangeListStock()
    {
        StockExchange test = new StockExchange();

        test.listStock( "DS", "DanceStudios.com", 12.33 );

        assertTrue( "StockExchange: return value should be true",
            test.getListedStocks().containsKey( "DS" ) );

    }


    @Test
    public void StockExchangeGetQuote()
    {
        StockExchange stock = new StockExchange();
        stock.listStock( "DS", "DanceStudios.com", 12.33 );
        assertFalse( "No StockExchange getQuote",
            stock.getQuote( "DS" ) == null );
    }


    @Test
    public void StockExchangeToStringTest()
    {
        StockExchange stock = new StockExchange();
        assertNotNull( stock.toString() );
    }


    

    // --Test Stock
    // Hanting
    Trader bill = new Trader( null, "Bill", "iambill" );


    @Test
    public void stockConstructor()
    {
        Stock giggle = new Stock( symbol, "Giggle.com", price );
        String toStr = giggle.toString();

        assertTrue(
            toStr.contains( "java.lang.String stockSymbol:" + symbol )
                && toStr
                    .contains( "java.lang.String companyName:Giggle.com" )
                && toStr.contains( "double lastPrice:" + price ) );
    }


    @Test
    public void stockGetQuoteAndPlaceOrderAndExecuteOrder()
    {
        Stock giggle = new Stock( symbol, "Giggle.com", price );

        assertTrue( giggle.getQuote().contains( "Ask: none" )
            && giggle.getQuote().contains( "Bid: none" )
            && giggle.getSellOrders().isEmpty()
            && giggle.getBuyOrders().isEmpty() );

        TradeOrder sellOrder = new TradeOrder( bill,
            symbol,
            false,
            marketOrder,
            numShares,
            price );
        TradeOrder buyOrder = new TradeOrder( bill,
            symbol,
            true,
            marketOrder,
            numShares,
            price );

        giggle.placeOrder( sellOrder );

        assertTrue(
            giggle.getQuote().contains( "Ask: market  size: " + numShares )
                && giggle.getQuote().contains( "Bid: none" )
                && giggle.getSellOrders()
                    .peek()
                    .toString()
                    .contains( "New Order: sell GGGL (Giggle.com)\n"
                        + numShares + " shares at market" ) );

        giggle.placeOrder( buyOrder );
        giggle.placeOrder( buyOrder );

        assertTrue( giggle.getQuote().contains( "Ask: none" )
            && giggle.getQuote().contains( "Bid: market  size: 0" )
            && giggle.getVolume() == numShares
            && giggle.getBuyOrders()
                .peek()
                .toString()
                .contains(
                    "New Order: buy GGGL (Giggle.com)\n0 shares at market" ) );

        giggle.placeOrder( sellOrder );

        sellOrder = new TradeOrder( bill,
            symbol,
            false,
            !marketOrder,
            0,
            price );
        buyOrder = new TradeOrder( bill,
            symbol,
            true,
            !marketOrder,
            0,
            price );

        giggle.placeOrder( sellOrder );

        assertTrue(
            giggle.getQuote().contains( "Ask: " + price + "  size: 0" )
                && giggle.getQuote().contains( "Bid: none" )
                && giggle.getSellOrders()
                    .peek()
                    .toString()
                    .contains(
                        "New Order: sell GGGL (Giggle.com)\n0 shares at "
                            + price ) );

        giggle.placeOrder( buyOrder );
        giggle.placeOrder( buyOrder );

        assertTrue( giggle.getQuote().contains( "Ask: none" )
            && giggle.getQuote().contains( "Bid: " + price + "  size: 0" )
            && giggle.getBuyOrders()
                .peek()
                .toString()
                .contains( "New Order: buy GGGL (Giggle.com)\n0 shares at "
                    + price ) );
    }


    @Test
    public void stockToString()
    {
        Stock giggle = new Stock( symbol, "Giggle.com", price );
        assertNotNull( giggle.toString() );
    }
    // Remove block comment below to run JUnit test in console


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( JUSafeTradeTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUSafeTradeTest" );
    }

}

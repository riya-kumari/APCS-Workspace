import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 * 
 * @author Riya Kumari
 * @version 10/2/2018
 * 
 * @author Period - 5
 * @author Assignment - Java Methods Ch09 - SnackBar
 * 
 * @author Sources - TODO list collaborators
 */
public class Vendor
{
    // Fields:
    private int stock;

    private int price;

    private int deposit;

    private int change;

    private static double totalSales = 0;


    /**
     * Returns the total sales in double
     * 
     * @return double total sales
     */
    public static double getTotalSales()
    {
        double total = totalSales;
        totalSales = 0.0;
        return total;
    }


    /**
     * Constructor
     * 
     * @param price
     *            of a single item in cents
     * 
     * @param num
     *            of items to place in stock
     */
    public Vendor( int price, int num )
    {
        this.price = price;
        this.stock = num;
        deposit = 0;
        change = 0;
    }


    /**
     * Sets the quantity of items in stock.
     * 
     * @param num
     *            of items to place in stock.
     */
    public void setStock( int num )
    {
        this.stock = num;
    }


    /**
     * Returns the number of items currently in stock.
     * 
     * @return int stock
     */
    public int getStock()
    {
        return stock;
    }


    /**
     * Adds a specified amount (in cents) to the deposited amount.
     * 
     * @param cents to add to deposit
     * 
     */
    public void addMoney( int cents )
    {

        if ( stock == 0 )
        {
            return;
        }
        deposit += cents;
    }


    /**
     * Returns the currently deposited amount in cents.
     * 
     * @return int deposit
     */
    public int getDeposit()
    {
        return deposit;
    }


    /**
     * Implements a sale. If there are items in stock and the deposited amount
     * is greater than or equal to the single item price, then adjusts the stock
     * and calculates and sets change and returns true; otherwise refunds the
     * whole deposit (moves it into change) and returns false. Parameters: None
     * 
     * @return boolean successful sale (true) or failure (false)
     */
    public boolean makeSale()
    {
        if ( getStock() > 0 && deposit >= price )
        {
            stock--;
            change = ( deposit - price );
            deposit = 0;
            totalSales += (double)price / 100.0;
            return true;
        }
        change = deposit;
        deposit = 0;
        return false;

    }


    /**
     * Returns the zeroes out the amount of change
     * 
     * @return int number of cents in current change
     */
    public int getChange()
    {

        int balance = change;
        change = 0;
        return balance;

    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Vendor.
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
                str += separator + field.getName() + ":"
                    + field.get( this );
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

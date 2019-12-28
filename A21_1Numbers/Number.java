import java.util.*;


/**
 * A number class that represents a number with a given base.
 * 
 * @author Riya Kumari
 * @version 4/5/19
 * 
 * @author Period - 5
 */
public class Number
{
    private int base = 0;

    private int value = 0;

    private ArrayList<Digit> digits;


    /**
     * Constructor
     */
    public Number()
    {
        base = 10;
        value = 0;
        digits = new ArrayList<Digit>();
        digits.add( new Digit( 0, 10 ) );

    }


    /**
     * accepts a decimal value and a base
     * 
     * @param val
     *            is the given value
     * @param base
     *            is the given base
     */
    public Number( int val, int base )
    {
        this.base = base;
        value = val;
        digits = new ArrayList<Digit>();
        while ( value > 0 )
        {
            int remainder = value % base;
            value /= base;
            Digit newDigit = new Digit( remainder, base );
            digits.add( 0, newDigit );
        }
    }


    /**
     * Increments the number
     */
    public void increment()
    {

        // loop through and if u can't increment further then return

        for ( int i = digits.size() - 1; i >= 0; i-- )
        {
            Digit num = digits.get( i );
            if ( !num.increment() )
            {
                return;
            }
        }
        digits.add( 0, new Digit( 1, base ) );
    }


    /**
     * Prints the number in String
     * 
     * @return String of the number
     */
    public String toString()
    {
        String num = "";
        for ( Digit a : digits )
        {
            num += a.toString();
        }
        return num;

    }
}

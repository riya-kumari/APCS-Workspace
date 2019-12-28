/**
 * A digit class that represents a single digit with a given base.
 * 
 * @author Riya Kumari
 * @version 4/5/19
 * 
 * @author Period - 5
 */
public class Digit
{
    private int base = 0;

    private int value = 0;


    /**
     * Constructor
     */
    public Digit()
    {

        base = 10;
        value = 0;
    }


    /**
     * Constructor
     * 
     * @param val
     *            is the given value
     * @param base
     *            is the given base
     */
    public Digit( int val, int base )
    {
        this.base = base;
        value = val;
    }


    /**
     * Increments the number
     * 
     * @return true if it increments and false otherwise
     */
    public boolean increment()
    {
        if ( value != base - 1 ) // if base is 10 and value is
                                 // 14
        {
            value++;
            return false;

        }
        else
        {

            value = 0;
            return true;
        }

    }


    /**
     * Prints the number
     * 
     * @return toString
     */
    public String toString()
    {

        if ( value > 9 )
        {
            // ascii uppercase starts at A
            char c = (char)( value - 10 + 'A' );
            return "" + c;

        }

        return "" + value;
    }
}

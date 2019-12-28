import java.lang.reflect.Field;
import java.util.Scanner;


/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author TODO Riya Kumari
 * @version TODO Sep 6
 * @author Period:5 APCS-A
 * 
 * @author Assignment: Lab Activity 3.2 - Coins
 * 
 * @author Sources: TODO: list collaborators
 */
public class Coins
{
    private int myChange;


    /**
     * Stores the value of cents the user enters
     * 
     * @param change
     *            is the user's change
     */
    public Coins( int change )
    {
        myChange = change;
    }

    /**
     * Calculates the number of quarters, dimes, and nickels.
     */
    public void calculate()
    {
        System.out.println( myChange + " cents =>" );

        int quarter = myChange / 25;
        System.out.println( "Quarter(s) " + quarter );

        int dime = ( myChange % 25 ) / 10;
        System.out.println( "Dime(s)    " + dime );

        int nickel = ( ( myChange % 25 ) % 10 ) / 5;
        System.out.println( "Nickel(s)  " + nickel );

        int penny = ( ( ( myChange % 25 ) % 10 ) % 5 ) / 1;
        System.out.println( "Penny(s)   " + penny );

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
     * @return a string representation of this Easter.
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
                              + field.getName() + ":"
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


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}

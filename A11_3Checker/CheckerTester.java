/**
 *  Instantiate and test various Checker objects.
 *
 *  @author  George Peck
 *  @version Oct 14, 2014
 *  @author  Period: 1-7
 *  @author  Assignment: A2008Q4_Checker
 *
 *  @author  Sources: TODO
 */
public class CheckerTester
{
    /**
     * Test checker objects.
     * @param args command line arguments (not used)
     */
    public static void main( String[] args )
    {
        Checker aChecker = new SubstringChecker( "artichokes" );
        Checker kChecker = new SubstringChecker( "kale" );
        Checker yumChecker;

        /*** Part (d) ***/

        /* TODO code to construct and assign to yumChecker */

        /****************/

        System.out.println( yumChecker.accept( "chocolate truffles" ) );
        System.out.println( yumChecker.accept( "kale is great" ) );
        System.out.println( yumChecker.accept( "Yuck: artichokes & kale" ) );
    }
}

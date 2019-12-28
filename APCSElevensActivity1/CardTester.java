/**
 * This is a class that tests the Card class.
 *
 * @author Name : Riya Kumari
 * @version Date : Sept. 6
 * @author Period:5 APCS-A
 * @author Assignment: APCSElevensActivity1
 *
 * @author Sources: TODO list collaborators
 */
public class CardTester
{
    /**
     * The main method in this class checks the Card operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        Card aceClubs1 = new Card( "ace", "clubs", 1 );
        Card aceClubs2 = new Card( "ace", "clubs", 1 );
        Card sixHearts6 = new Card( "6", "hearts", 6 );

        System.out.println( "**** ace of clubs #1 Tests ****" );
        System.out.println( "  rank: " + aceClubs1.rank() );
        System.out.println( "  suit: " + aceClubs1.suit() );
        System.out.println( "  pointValue: " + aceClubs1.pointValue() );
        System.out.println( "  toString: " + aceClubs1.toString() );
        System.out.println();

        System.out.println( "**** ace of clubs #2 Tests ****" );
        System.out.println( "  rank: " + aceClubs2.rank() );
        System.out.println( "  suit: " + aceClubs2.suit() );
        System.out.println( "  pointValue: " + aceClubs2.pointValue() );
        System.out.println( "  toString: " + aceClubs2.toString() );
        System.out.println();

        System.out.println( "**** six of hearts Tests ****" );
        System.out.println( "  rank: " + sixHearts6.rank() );
        System.out.println( "  suit: " + sixHearts6.suit() );
        System.out.println( "  pointValue: " + sixHearts6.pointValue() );
        System.out.println( "  toString: " + sixHearts6.toString() );
        System.out.println();

        System.out.println( "**** matches Tessts ****" );
        System.out.println( "matching: " + aceClubs1.matches( aceClubs2 ) );
        System.out.println( "not matching: " 
                            + aceClubs1.matches( sixHearts6 ) );

    }

}
/*
 **** ace of clubs #1 Tests **** 
 *rank: ace 
 *suit: clubs 
 *pointValue: 1 toString: ace
 * of clubs (point value = 1)
 **** 
 * ace of clubs #2 Tests **** 
 * rank: ace 
 * suit: clubs 
 * pointValue: 1 
 * toString: ace
 * of clubs (point value = 1)
 **** 
 * six of hearts Tests **** 
 * rank: 6 
 * suit: hearts 
 * pointValue: 6 
 * toString: 6 of
 * hearts (point value = 6)
 **** 
 * matches Tests **** 
 * matching: true 
 * not matching: false
 */

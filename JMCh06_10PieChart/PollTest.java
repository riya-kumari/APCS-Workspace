/**
 * Tests the PollDisplayPanel class.
 *
 * @author Riya Kumari
 * @version 8/12
 * @author Period:5
 * @author Assignment: JMCh06_10PieChart
 *
 */
public class PollTest
{
    /**
     * Tests the Poll Display Panel
     * 
     * @param args takes an array
     *
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new PollDisplayPanel( "Tami",
            "Brian",
            "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}

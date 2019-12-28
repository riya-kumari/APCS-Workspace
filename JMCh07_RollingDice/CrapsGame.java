/**
 * Implements the game of Craps logic.
 *
 * @author TODO your Name
 * @version TODO date
 * @author Period: TODO your period
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: TODO collaborators
 */
public class CrapsGame
{
    private int point = 0;


    /**
     * Calculates the result of the next dice roll in the Craps game. The
     * @param total is the sum of dots on two dice. point is set to the saved
     * total, if the game continues, or 0, if the game has ended. Returns 1 if
     * player won, -1 if player lost, 0 if player continues rolling.
     * @return  Returns 1 if player won, -1 if player lost, 0 if player 
     * continues rolling.
     */
    public int processRoll( int total )
    {
        int result;

        if ( point == 0 )
        {
            switch ( total )

            {
                case 7:
                case 11:
                    result = 1;
                    break;

                case 2:
                case 3:
                case 12:
                    result = -1;
                    break;

                default:
                    result = 0;
                    point = total;

            }
        }
        else
        {
            if ( total == point )
            {
                result = 1;
                point = 0;
            }
            else if ( total == 7 )
            {
                result = -1;

                point = 0;
            }
            else
            {
                result = 0;
            }
        }
        return result;
    }


    /**
     * @return Returns the saved point
     */
    public int getPoint()
    {
        return point;
    }
}
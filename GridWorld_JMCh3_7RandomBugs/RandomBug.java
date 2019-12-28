import info.gridworld.actor.Bug;
import java.awt.Color;

/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move

 * @author   Your Name : Riya Kumari
 * @version  Date : Sep 2,2018
 *
 * @author  Period - 5 APCS-A
 * @author  Assignment - Random Bugs - UTurnBug
 *
 * @author  Sources - TODO list collaborators
 */
public class RandomBug extends Bug
{
    public RandomBug()
    {
        setColor( Color.YELLOW );
    }

    public RandomBug( Color bugColor )
    {
        setColor( bugColor );
    }

    public void turn(int angle)
    {
        angle = 45 * (int)(Math.random() * 8);
        turn();
        turn();
        turn();
        turn(); // Or: setDirection(getDirection() + 180);
    }

    // Overrides Bug's act method
    public void act()
    {
        if ( canMove() ) {
            move();
            
        }
        else {
            turn();
        }
        
    }
}

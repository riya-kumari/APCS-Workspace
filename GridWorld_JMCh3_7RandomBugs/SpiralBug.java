import info.gridworld.actor.Bug;

/**
 *  The Spiral Bug drops flowers in a spiral pattern.
    Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  Riya Kumari
   @version Sep 2

   @author  5 - APCS-A
   @author  Assignment - GridWorld Part 2, Exercise 2 - SpiralBug

   @author  Sources - TODO list collaborators
 */
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;

    public SpiralBug( int n )
    {
        steps = 0;
        sideLength = n;
    }

    public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            sideLength++;
        }
    }
}
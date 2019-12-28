import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;


/**
 * Test the Jumper class.
 * 
 * @author Riya and Hanting
 * @version 10/26/18
 * @author Period: 5
 * @author Assignment: GridWorld_Part3_Jumper
 *
 * @author Sources: TODO
 */
public class JumperRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        Jumper a = new Jumper();
        Flower f1 = new Flower();
        Bug b1 = new Bug();
        Jumper b = new Jumper();
        world.add( new Location( 1, 1 ), a );
        world.add( new Location( 2, 1 ), f1 );
        world.add( new Location( 5, 1 ), b1 );
        world.add( new Location( 6, 1 ), b );
        world.show();
    }
}
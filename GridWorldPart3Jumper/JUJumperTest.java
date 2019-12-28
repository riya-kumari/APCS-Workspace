import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Color;


/**
 * Jumper tests:. test01 - jumper next to edge of grid - should turn test02 -
 * jumper 2 from edge of grid - should turn test03 - jumper jumps two spaces
 * when there is something in its path test04 - jumper turns if there is
 * anything obstructing its path test05 - jumper eats edible objects test06 -
 * jumper turns 45 degrees test07 - jumper jumps over object immediately in
 * front of it http://205.173.41.10/GridWorld/Narrative/gridworld-part3.html
 * https://codeshare.io/5DBrEW?fbclid=IwAR1XpE3UWKm2ElcqCvwuywjWX__l3EFdsWFgwCvEr7LN1DJBIiJ34GUTGSY
 * 
 * @author TODO Riya Kumari
 * @version TODO 10/26/18
 *
 * @author Period: 5
 * @author Assignment - GridWorld Part 3 Jumper
 *
 * @author Sources: TODO
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;

    private ActorWorld world;

    private Jumper jumper1, jumper2;

    private Flower flower1, flower2, flower3;


    /**
     * Invoked before each test to instantiate the objects used for every test.
     */
    @Before
    public void initialize()
    {
        grid = new BoundedGrid<Actor>( 8, 8 );
        world = new ActorWorld( grid );
        jumper1 = new Jumper( Color.red );
        jumper2 = new Jumper( Color.BLUE );
        flower1 = new Flower();
        flower2 = new Flower();
        flower3 = new Flower();
    }


    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location( 0, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location( 1, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test03 - jumper jumps 2 spaces
     */
    @Test
    public void jumperShouldJump2Spaces()
    {
        Location loc = new Location( 3, 5 );
        world.add( loc, jumper1 );

        jumper1.act();

        assertTrue( testOccupied( new Location( 1, 5 ),
            jumper1,
            Location.NORTH ) );

    }


    /**
     * test04 -Jumper turns if there is anything obstructing its path
     */
    @Test
    public void test04()
    {

        Location loc = new Location( 2, 0 );
        world.add( loc, jumper1 );
        world.add( new Location( 0, 0 ), flower1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );

    }


    /**
     * jumper eats edible objects
     */
    @Test
    public void test05()
    {
        world.add( new Location( 0, 0 ), jumper1 );
        world.add( new Location( 2, 0 ), jumper2 );

        jumper2.act();

        assertTrue( testOccupied( new Location( 0, 0 ),
            jumper2,
            Location.NORTH ) );

    }


    /**
     * test06 - Jumper turns 45 degrees
     */
    @Test
    public void test06()
    {
        world.add( new Location( 0, 0 ), jumper1 );
        jumper1.act();

        assertTrue( testOccupied( new Location( 0, 0 ),
            jumper1,
            Location.NORTHEAST ) );
    }


    /**
     * test07 - jumper jumps over object immediately in front of it
     */
    @Test
    public void test07()
    {
        world.add( new Location( 2, 1 ), jumper1 );
        world.add( new Location( 1, 1 ), flower1 );
        jumper1.act();

        assertTrue( testOccupied( new Location( 0, 1 ),
            jumper1,
            Location.NORTH ) );
    }


    /**
     * Test helper method to test for empty location.
     *
     * @param loc
     *            null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty( Location loc )
    {
        Actor empty = grid.get( loc );
        assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );

        return true;
    }


    /**
     * Test helper method to test that object is in a location, and has a
     * consistent loc, and direction dir.
     *
     * @param loc
     *            location that should be occupied
     * @param a
     *            actor that should be in location loc
     * @param dir
     *            direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied( Location loc, Actor a, int dir )
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>",
            a,
            found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>",
            loc,
            found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>",
            dir,
            found.getDirection() );

        return true;
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUJumperTest" );
    }
}
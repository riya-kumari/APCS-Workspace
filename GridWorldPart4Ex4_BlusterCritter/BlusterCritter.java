import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;


/**
 * TODO Write a one-sentence summary of your class here TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Riya Kumari
 * @version 11/13/18
 * @author Period 5
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 * @author Sources: TODO I received help from ...
 */
public class BlusterCritter extends Critter
{
    private int courage = 0;

    private static final double DARKENING_FACTOR = 0.05;


    /**
     * Constructor
     * 
     * @param c
     *            is the courage
     */
    public BlusterCritter( int c )
    {

        courage = c;

    }


    /**
     * TODO Write your method description here <br />
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {

        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location l = getLocation();

        for ( int row = l.getRow() - 2; row <= l.getRow() + 2; row++ )
        {
            for ( int col = l.getCol() - 2; col <= l.getCol() + 2; col++ )
            {

                Location current = new Location( row, col );

                if ( gr.isValid( current ) )
                {
                    Actor a = gr.get( current );
                    if ( a != null && a != this )
                    {
                        actors.add( a );
                    }
                }

            }
        }

        // System.out.print( actors.size() );

        return actors;

    }


    /**
     * TODO Write your method description here <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors
     *            the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        int process = 0;
        for ( Actor a : actors )
        {

            if ( a instanceof Critter )
            {
                process++;
            }

        }
        if ( process < courage )
        {
            lighten();
        }
        else
        {
            darken();
        }
    }


    /**
     * Darkens the color of the critter.
     */
    private void darken()
    {
        Color c = getColor();
        int red = (int)( c.getRed() * ( 1 - DARKENING_FACTOR ) );
        int green = (int)( c.getGreen() * ( 1 - DARKENING_FACTOR ) );
        int blue = (int)( c.getBlue() * ( 1 - DARKENING_FACTOR ) );

        setColor( new Color( red, green, blue ) );
    }


    /**
     * Lightens the color of the critter
     */
    private void lighten()
    {

        Color c = getColor();

        int red = (int)( c.getRed() * ( 1 + DARKENING_FACTOR ) );

        int green = (int)( c.getGreen() * ( 1 + DARKENING_FACTOR ) );

        int blue = (int)( c.getBlue() * ( 1 + DARKENING_FACTOR ) );

        if ( red > 255 )
        {
            red = 225;
        }
        if ( green > 255 )
        {
            green = 225;
        }
        if ( blue > 255 )
        {
            blue = 225;
        }
        setColor( new Color( red, green, blue ) );
        
    }
}

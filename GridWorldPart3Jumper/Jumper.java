import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author Hanting Zhang
 * @version 10/26/18
 * @author Period: 5
 * @author Assignment: GridWorld_Part3_Jumper
 */
public class Jumper extends Bug implements Edible
{
    /**
     * Cyan best color!
     */
    public Jumper()
    {
        setColor( Color.CYAN );
    }


    /**
     * 
     * @param bugColor
     *            what color do you want the bug to be?
     */
    public Jumper( Color bugColor )
    {
        setColor( bugColor );
    }


    /**
     * 
     * Jumps if it can or turns
     */
    public void act()
    {
        if ( canMove() )
        {
            move();
        }
        else
        {
            turn();
        }
    }


    /**
     * 
     * Overrides Bug's move method by checking 2 spaces over instead of one.
     * Also checks if it can eat the space it jumps on
     */
    @Override
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
        {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() )
            .getAdjacentLocation( getDirection() );
        if ( gr.isValid( next ) || gr.get( loc ) instanceof Edible )
        {
            moveTo( next );
        }
        else
        {
            removeSelfFromGrid();
        }
    }


    /**
     * 
     * Overrides Bug's canMove method to check 2 space over instead of one Also
     * checks if it can eat the space it's moving to
     * 
     * @return if it can move
     */
    @Override
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
        {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() )
            .getAdjacentLocation( getDirection() );
        if ( !gr.isValid( next ) )
        {
            return false;
        }
        Actor neighbor = gr.get( next );
        return ( neighbor == null ) || ( neighbor instanceof Edible );
    }

}
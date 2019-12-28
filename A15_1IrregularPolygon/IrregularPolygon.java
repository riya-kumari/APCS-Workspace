
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Riya Kumari
 * @version 11/7/18
 *
 * @author Period - 5
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class IrregularPolygon
{
    private DrawingTool pen; // = new DrawingTool(new SketchPad(300, 300, 0));

    private ArrayList<Point2D.Double> myPolygon;


    /**
     * Constructor
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }


    /**
     * Adds the point
     * 
     * @param aPoint
     *            is added to the arrayList
     */

    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }


    /**
     * Finds the perimeter of the irregular polygon
     * 
     * @return perimeter in double
     */
    public double perimeter()
    {

        double perimeter = 0.0;
        if ( myPolygon.isEmpty() )
        {
            return 0;
        }
        Point2D.Double firstPoint = myPolygon.get( 0 );

        for ( Point2D.Double i : myPolygon )
        {
            perimeter += firstPoint.distance( i );
            firstPoint = i;

        }

        perimeter += firstPoint.distance( myPolygon.get( 0 ) );
        return perimeter;
    }


    /**
     * Finds the area of the irregular polygon
     * 
     * @return area in double
     */
    public double area()
    {
        double area = 0.0;
        double product = 0.0;
        if ( !myPolygon.isEmpty() )
        {
            for ( int i = 0; i < myPolygon.size() - 1; i++ )
            {
                double x = myPolygon.get( i ).getX();
                double y = myPolygon.get( i + 1 ).getY();
                double y2 = myPolygon.get( i ).getY();
                double x2 = myPolygon.get( i + 1 ).getX();
                product += x * y - x2 * y2;

            }
            product += myPolygon.get( myPolygon.size() - 1 ).getX()
                * myPolygon.get( 0 ).getY();
            product -= myPolygon.get( myPolygon.size() - 1 ).getY()
                * myPolygon.get( 0 ).getX();
            area = product / 2;
        }
        return Math.abs( area );
    }


    /**
     * Draws the polygon
     */
    public void draw()
    {
        if ( myPolygon.isEmpty() )
        {
            return;
        }
        pen.up();
        Point2D.Double index = myPolygon.get( 0 );
        double x = index.getX();
        double y = index.getY();
        pen.move( x, y );
        pen.down();
        for ( int j = 1; j < myPolygon.size() - 1; j++ )
        {
            index = myPolygon.get( j );

            pen.move( x, y );
        }
        index = myPolygon.get( 0 );
        pen.move( x, y );

    }
}

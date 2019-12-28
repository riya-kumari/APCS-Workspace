import java.awt.*;
import javax.swing.*;


/**
 * This program draws an ornament of nested triangles
 * 
 * @author Your Name : Riya Kumari
 * @author Date : 9/19/18
 * 
 * @author Period - 5
 * @author Assignment - Ch04 Ex4-16 Ornament
 */
public class Ornament extends JPanel
{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        drawTriangles( g, 100, 80, 64 );
    }


    /**
     * Draws an ornament made of triangles in Graphics g with the base midpoint
     * at (x, y) and base half-length r
     * @param x is 100 when it is called in paintComponent
     * @param y is 80 when it is called in paintComponent
     * @param r is 64 when it is called in paintComponent
     */
    public void drawTriangles( Graphics g, int x, int y, int r )
    {
        if ( r >= 4 )
        {
            g.drawLine( x, y - r, x - r, y ); // left side
            g.drawLine( x + r, y, x, y - r ); // right side
            g.drawLine( x - r, y, x + r, y ); // base line

            drawTriangles( g, x - r / 2, y, r / 2 );
            drawTriangles( g, x + r / 2, y, r / 2 );

        }

    }


    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Triangles" );
        w.setBounds( 300, 300, 200, 120 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ornament panel = new Ornament();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( false );
        w.setVisible( true );
    }
}

import java.awt.*;
import javax.swing.*;


/**
 * This program draws parallel lines. Uses nested-for loops.
 * 
 * @author Riya Kumari
 * @version Sep 26
 * 
 *          Period - 5 Assignment - A12.6 - ParallelLines
 * 
 *          Sources - TODO list collaborators
 */
public class ParallelLines extends JPanel
{

    private int y = 20;


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * Draws an illusion.
     * 
     * @param g
     * @param width 
     * @param height
     * 
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        for ( int row = 0; row < 8; row++ )
        {
            // calculates the start of the row of squares
            int x = 5;
            int size = width / 14;
            
            // calculates and adds a horizontal offset
            int offset = 3 + x;
            
            switch ( row )
            {
                case 1:
                case 3:
                case 5:
                case 7:
                    x = 15;
                    break;
                case 2:
                case 6:
                    x = 25;
                    break;
                default:
                    x = 5;
            }
                for ( int col = 0; col < 7; col++ )
                {
                // draw the square
                g.fillRect( x, y, size, size );

                // calculate and position for the next square
                x = x + 90;
                }
                
            // calculates the location and draws the line
            g.drawLine( 5, y + size, width, y + size );
            y = y + size;

        }

    }


    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}

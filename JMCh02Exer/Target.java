
//Question 2-13-a

import java.awt.*;
import javax.swing.*;


public class Target extends JPanel
{
public void paintComponent(Graphics g)
{
 super.paintComponent(g);  // Call JPanel's paintComponent method
                           //   to paint the background
 int xCenter = getWidth() / 2;
 int yCenter = getHeight() / 2;
 g.setColor(Color.RED);
 g.fillOval(xCenter-21, yCenter-21, 50, 50);
 
 g.setColor(Color.WHITE);
 g.fillOval(xCenter-14, yCenter-14, 35, 35);
 
 g.setColor(Color.RED);
 g.fillOval(xCenter-4, yCenter-4, 15, 15);
 

}

public static void main(String[] args)
{
 JFrame window = new JFrame("Target");
 window.setBounds(300, 300, 200, 200);
 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 Target panel = new Target();
 panel.setBackground(Color.WHITE);
 Container c = window.getContentPane();
 c.add(panel);
 window.setVisible(true);
}
}


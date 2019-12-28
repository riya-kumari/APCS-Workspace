
public class Rectangle
{
    private int width, height;
    
    //constructor with a given width and height
    public Rectangle(int width, int height) 
    {
     width = 10;
     height = 10;
    }
    
    //constructor that builds a rectangle that is a square of a given size
    public Rectangle(int size)
    {
        this(size,size);
    }
    
    //constructor that builds a square of size 1
    public Rectangle()
    {
        this(1,1);
        
    }
        // checks to see if rectangle is a square
        public boolean isSquare()
        {
            return height == width;
        }
        // finds the area of the triangle and figures the sides of a square
        public void quadratize()
        {
            double area = height * width;
            height = (int)(Math.sqrt( area ) + 0.5) ;
            width = height;
        }
        
    public static void main(String args[]) 
    {
    
        System.out.println(Rectangle.isSquare();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}

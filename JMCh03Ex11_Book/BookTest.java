/**
 *  This is a class that tests the Book class.
 *
 *  @author  TODO Name: Riya Kumari
 *  @version TODO date
 *  @author  Period: 5
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
/**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    
public class BookTest
{
    
    /* TODO *** TO BE IMPLEMENTED *** */
    public static void main( String[] args )
    {
       Book a = new Book(3);
       a.getNumPages();
       System.out.println(a.getNumPages());
       System.out.println(a.getCurrentPage());
       
       a.nextPage();
       System.out.println(a.getCurrentPage());
       a.nextPage();
       System.out.println(a.getCurrentPage());
       a.nextPage();
       System.out.println(a.getCurrentPage());
        }
}
   
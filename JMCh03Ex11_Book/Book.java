/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what
 *       abstraction it represents, and how to use it.
 *
 *  @author  Riya Kumari
 *  @version Aug 30
 *  @author  Period:5 AP Comp. Sci A
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
public class Book
{
    private int numPage;
    private int currentPage;
    
   
       public Book(int page  ) {
        numPage = page;
        currentPage = 1;
          }
    
    public int getNumPages() {
        return numPage;
    }
    
    
    public int getCurrentPage() {
        return currentPage;
    }
    
  
    public void nextPage(){
        if (currentPage < numPage)
        {
         currentPage++;
        }
    }
}

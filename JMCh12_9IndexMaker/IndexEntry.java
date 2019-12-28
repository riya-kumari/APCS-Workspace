import java.util.ArrayList;


/**
 * IndexEntry object represents one index entry
 * 
 *
 * @author Riya Kumari
 * @version Nov 9, 2018
 * @author Period: T5
 * @author Assignment: JMCh12_9IndexMaker
 *
 */
public class IndexEntry
{
    private String word;

    private ArrayList<Integer> numsList;


    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    /**
     * Constructs an IndexEntry for a given word
     * 
     * @param word
     *            is given
     */
    public IndexEntry( String word )
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }


    /**
     * Returns the word of this IndexEntry object.
     * 
     * @return word in String
     */
    public String getWord()
    {

        return word;
    }


    /**
     * If num is not already in the list, adds num at the end of this
     * IndexEntry's list of numbers.
     * 
     * @param num
     *            is the number that is checked
     */
    public void add( int num )
    {
        Integer number = new Integer( num );

        if ( !numsList.contains( number ) )
        {
            numsList.add( number );
        }
    }


    /**
     * Converts this IndexEntry into a string in the following format: the word
     * followed by a space, followed by numbers separated by a comma and a
     * space.
     * 
     * @return the IndexEntry
     */
    public String toString()
    {

        String str = "";
        for ( int i = 0; i < numsList.size(); i++ )
        {
            str += numsList.get( i ) + ", ";
        }
        str = str.trim();

        return word + " " + str.substring( 0, str.length() - 1 );
    }
}

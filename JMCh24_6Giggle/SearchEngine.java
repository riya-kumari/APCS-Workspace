import java.util.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Riya Kumari
 * @version 2/25/19
 * 
 * @author Period - 5
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - TODO list collaborators
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    /**
     * constructor
     * 
     * @param url
     *            is the file name
     */
    public SearchEngine( String url )
    {
        myURL = url;
        myIndex = new HashMap<String, List<String>>( 20000 );
    }


    /**
     * call this method from Giggle to display the name of the file in which
     * hits were found
     * 
     * @return myUrl
     */
    public String getURL()
    {
        return myURL;
    }


    /**
     * Extracts all words from line, and, for each word, adds line to its list
     * of lines in myIndex
     * 
     * @param line
     *            that the word is extracted from
     */
    public void add( String line )
    {
        Set<String> s = parseWords( line );
        LinkedList<String> a = new LinkedList<String>();
        for ( String str : s )
        {
            a = new LinkedList<String>();
            if ( !myIndex.containsKey( str ) )
            {
                myIndex.put( str, a );
            }

            myIndex.get( str ).add( line );

        }

    }


    /**
     * Returns the list of lines associated with word in myIndex.
     * 
     * @param word
     *            that is
     * @return list of lines
     */
    public List<String> getHits( String word )
    {
        return myIndex.get( word );
    }


    /**
     * Parse words from a line
     * @param line to parse
     * @return set of words
     */
    private Set<String> parseWords( String line )
    {
        String[] a = line.split( "\\W+" );
        TreeSet<String> b = new TreeSet<String>();
        for ( String str : a )
        {
            if ( !str.isEmpty() )
            {
                b.add( str.toLowerCase() );
            }
        }
        return b;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    
    /**
     * 
     * Getter method
     * @return myIndex
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}

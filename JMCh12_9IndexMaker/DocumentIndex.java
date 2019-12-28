import java.util.ArrayList;


/**
 * 
 * A DocumentIndex object represents the entire index for a document: the list
 * of all its index entries.
 * 
 *
 * @author Riya Kumari
 * @version Nov 9, 2018
 * @author Period: 5
 * @author Assignment: JMCh12_9IndexMaker
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{

    /**
     * Converts this IndexEntry into a string in the following format: the word
     * followed by a space, followed by numbers separated by a comma and a
     * space.
     */
    public DocumentIndex()
    {
        super();
    }


    /**
     * Creates an empty DocumentIndex with a given initial capacity.
     * 
     * @param initialCapacity
     *            is the integer value
     */
    public DocumentIndex( int initialCapacity )
    {
        super( initialCapacity );
    }


    /**
     * If word is not yet in this DocumentIndex, creates a new IndexEntry for
     * word, and inserts it into this list in alphabetical order; adds num to
     * this word's IndexEntry by calling its add(num) method.
     * 
     * @param word
     *            is the word to check
     * @param num
     *            is the count
     */
    public void addWord( String word, int num )
    {
        // create a new IndexEntry object
        IndexEntry a = new IndexEntry( word.toUpperCase() );
        boolean same = false;
        foundOrInserted( word );
        boolean second = false;
        // give a - number
        a.add( num );
        // go through every index of a
        for ( IndexEntry i : this )
        {
            String currentWord = i.getWord();
            if ( currentWord.equalsIgnoreCase( word ) )
            {
                i.add( num );
                same = true;
            }

        }
        int x = -1;
        if ( !same )
        {
            for ( int i = 0; ( i < this.size() && !second ); )
            {
                if ( this.get( i )
                    .getWord()
                    .compareToIgnoreCase( word ) > 0 )
                {
                    second = true;
                    x = i;

                }
                i++;
            }
            if ( x == -1 )
            {
                x = 0;
            }
            this.add( x, a );
            this.get( indexOf( a ) ).add( num );

        }

    }


    /**
     * 
     * It adds up all the words
     * 
     * @param str
     *            is the string
     * @param num
     *            is the num position
     */
    public void addAllWords( String str, int num )
    {
        String[] strArray = str.split( "\\W+" ); // Splits the array except
                                                 // the for blank lines
        for ( String s : strArray )
        { 
            if ( !s.equals( "" ) )
            {
                addWord( s, num ); // Adds to the num position
            }

        }
    }


    /**
     * Tries to find an EndexEntry with a given word in this DocumentIndex. If
     * not found, inserts a new EndexEntry for word at the appropriate place (in
     * lexicographical order).
     * 
     * @param word
     *            is the given word
     * @return the index of the found or inserted IndexEntry
     */
    private int foundOrInserted( String word )

    {
        IndexEntry tempWord = new IndexEntry( word );
        for ( IndexEntry a : this )
        {
            if ( a == get( indexOf( a ) ) )
            {
                return 0;
            }
            else if ( word.compareTo( a.getWord() ) > 0 )
            {
                add( indexOf( a ) - 1, tempWord );
                return indexOf( a ) - 1;
            }
        }

        return -1;
    }
}
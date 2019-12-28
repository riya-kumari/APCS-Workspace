/**
 * Implements a sorted list of words
 * 
 * @author Riya Kumari
 * @version 11/28/18
 * 
 * @author Period - 5
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - TODO list collaborators
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * No-args Constructor
     */
    public SortedWordList()
    {
        super();
    }


    /**
     * Constructor
     * 
     * @param initial
     *            is the initial capacity
     */
    public SortedWordList( int initial )
    {
        super( initial );
    }


    /**
     * Redefines contains to use binary search
     * 
     * @param str
     *            the word
     * @return boolean true or false
     */
    public boolean contains( String str )
    {

        int left = 0;
        int right = this.size() - 1;
        int middle;

        while ( left <= right )
        {

            middle = ( left + right ) / 2;

            int diff = str.compareTo( this.get( middle ) );

            if ( diff > 0 )
            {
                left = middle + 1;
            }
            else if ( diff < 0 )
            {
                right = middle - 1;
            }
            else
            {
                return true;
            }
        }
        return false;

    }


    /**
     * Redefines indexOf to use binary search
     * 
     * @param str
     *            is the word
     * @return int of the position of the word
     */
    public int indexOf( String str )
    {
        int left = 0;
        int right = this.size() - 1;
        int middle;

        while ( left <= right )
        {

            middle = ( left + right ) / 2;

            int diff = str.compareTo( this.get( middle ) );

            if ( diff > 0 )
            {
                left = middle + 1;
            }
            else if ( diff < 0 )
            {
                right = middle - 1;
            }
            else
            {
                return middle;
            }
        }
        return -1;
    }


    /**
     * Redefines set to so that it first checks whether word fits alphabetically
     * between the (i -1)-th and (i + 1)-th elements and is not equal to either
     * of them
     * 
     * @param i
     *            is the index
     * @param word
     *            is the word to be set
     * @return String result
     */
    public String set( int i, String word )
    {
        String result;
        if ( i == 0 && 0 > word.compareToIgnoreCase( this.get( i + 1 ) ) )
        {
            result = super.set( i, word );
        }
        else if ( 0 > word.compareToIgnoreCase( this.get( i + 1 ) )
            && 0 < word.compareTo( this.get( i - 1 ) ) )
        {
            result = super.set( i, word );
        }
        else
        {
            throw new IllegalArgumentException(
                "word =" + word + " i =" + i );
        }
        return result;
    }


    /**
     * Adds the word to index i if the word fits alphabetically between the (i -
     * 1 )-th and i-th elements and is not equal to either of them
     * 
     * @param i
     *            is the index
     * @param word
     *            is the word to be added
     */
    public void add( int i, String word )
    {

        if ( i != 0 && 0 < word.compareToIgnoreCase( this.get( i - 1 ) ) )
        {
            super.add( i, word );
        }
        else if ( 0 > word.compareToIgnoreCase( this.get( i + 1 ) ) )
        {
            super.add( i, word );
        }

        else
        {
            throw new IllegalArgumentException(
                "word =" + word + " i =" + i );
        }

    }


    /**
     * Adds the word to the array
     * 
     * @param word
     *            is the word that needs to be added
     * @return boolean true or false
     */
    public boolean add( String word )
    {
        int left = 0;
        int right = this.size() - 1;
        int middle;
        if ( this.contains( word ) )
        {
            return false;
        }
        while ( left <= right )
        {

            middle = ( left + right ) / 2;

            int diff = word.compareTo( this.get( middle ) );

            if ( diff > 0 )
            {
                left = middle + 1;
            }
            else if ( diff < 0 )
            {
                right = middle - 1;
            }

        }
        super.add( right + 1, word );
        return true;

    }


    /**
     * Merge two arrays together
     * 
     * @param additionalWords
     *            is the second array
     */
    public void merge( SortedWordList additionalWords )
    {
        int n = additionalWords.size();

        for ( int i = 0; i < n; i++ )
        {
            add( additionalWords.get( i ) );
        }
    }

}

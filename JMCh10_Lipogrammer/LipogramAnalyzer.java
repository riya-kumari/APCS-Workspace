/**
 * The Lipogram analyzer helps to create and verify lipograms.
 * 
 * @author TODO Riya Kumari
 * @version 10/11018
 * 
 * @author Period - 5
 * @author Assignment - JMCh10 Lipogrammer
 */
public class LipogramAnalyzer
{
    private String text = "";


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text += text;
    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        String s1 = "";
        for ( int i = 0; i < text.length(); i++ )
        {
            char ch = text.charAt( i );
            if ( ch == letter )
            {
                s1 += "#";
            }
            else
            {
                s1 += ch;
            }
        }
        return s1; // !!!Fix this

    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {

        String result = "";

        for ( int i = 0; i < text.length(); i++ )
        {

            char ch = text.charAt( i );
            if ( ch == letter )
            {
                String word = "";

                for ( int left = i; left >= 0; left-- )
                {

                    if ( text.charAt( left ) == ' '
                        || !Character.isLetter( text.charAt( left ) ) )
                    {
                        break;

                    }
                    word = text.charAt( left ) + word;
                }

                for ( int right = i + 1; right <= text.length()
                    - 1; right++ )
                {

                    if ( text.charAt( right ) == ' ' || i == text.length()
                        || !Character.isLetter( text.charAt( right ) ) )
                    {
                        break;

                    }
                    word = word + text.charAt( right );
                }

                if ( !result.contains( word ) )
                {
                    result = result + word + "\n";
                }
                if ( word.contentEquals( "e" ) )
                {
                    result = result + word + "\n";
                }
            }

        }

        return result;
    }


    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace.
     * 
     * @param pos
     *            location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {
        String result = "";

        for ( int i = 0; i < text.length(); i++ )
        {

            if ( i == pos && Character.isLetter( text.charAt( i ) ) )
            {
                String word = "";

                for ( int left = i; left >= 0; left-- )
                {

                    if ( text.charAt( left ) == ' '
                        || !Character.isLetter( text.charAt( left ) ) )
                    {
                        break;

                    }
                    word = text.charAt( left ) + word;
                }

                for ( int right = i + 1; right <= text.length()
                    - 1; right++ )
                {

                    if ( text.charAt( right ) == ' ' || i == text.length()
                        || !Character.isLetter( text.charAt( right ) ) )
                    {
                        break;

                    }
                    word = word + text.charAt( right );
                }

                if ( !result.contains( word ) )
                {
                    result = result + word + "\n";
                }

            }

        }

        return result;

    }

}

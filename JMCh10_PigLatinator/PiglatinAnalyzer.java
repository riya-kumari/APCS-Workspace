import java.util.Scanner;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Riya Kumari
 * @version 10/17/2018
 * 
 * @author Period - 5
 */
public class PiglatinAnalyzer
{
    private String text;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return String piglatin version of text as a String
     */

    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";

        String englishWord = "";
        int currentSpace = 0;
        int nextSpace = 0;
        String word = " ";

        int lastSpace = phraseToTranslate.lastIndexOf( " " );

        while ( currentSpace <= lastSpace )
        {
            nextSpace = phraseToTranslate.indexOf( " ", currentSpace );
            englishWord = phraseToTranslate.substring( currentSpace,
                nextSpace );

            currentSpace = nextSpace + 1;

            String pigLatinWord = wordToPigLatin( englishWord );

            translation = translation + pigLatinWord + " ";

        }
        englishWord = phraseToTranslate.substring( lastSpace + 1 );
        String pigLatinWord = wordToPigLatin( englishWord );
        translation = translation + pigLatinWord;

        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return String piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {

        String pigLatinWord = "";
        char vowel = ' ';
        String end, start = "";

        if ( isVowel( englishWord ) )
        {
            if ( isVowel( englishWord.charAt( 0 ) ) )
            {
                return englishWord + "yay";
            }
            else
            {
                for ( int i = 1; i < englishWord.length(); i++ )
                {
                    vowel = englishWord.charAt( i );
                    if ( isVowel( vowel ) )
                    {
                        i = englishWord.length();
                        break;
                    }
                }

                // Converting the word

                start = englishWord.substring( 0,
                    englishWord.indexOf( vowel ) );
                end = englishWord
                    .substring( englishWord.indexOf( vowel ) );

                // if englishWord is capitalized, then capitalize end and
                // "uncapitalize" start

                if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
                {

                    char E = Character.toUpperCase( end.charAt( 0 ) );
                    char s = Character.toLowerCase( start.charAt( 0 ) );

                    pigLatinWord = E + end.substring( 1 ) + s
                        + start.substring( 1 ) + "ay";

                }
                else
                {
                    pigLatinWord = end + start + "ay";
                }

            }

        }
        else
        {
            pigLatinWord = englishWord + "ay";

        }

        return pigLatinWord;
    }


    public boolean isVowel( String s )
    {
        if ( s.contains( "a" ) || text.contains( "e" )
            || text.contains( "i" ) || text.contains( "o" )
            || text.contains( "u" ) || text.contains( "A" )
            || text.contains( "E" ) || text.contains( "I" )
            || text.contains( "O" ) || text.contains( "U" ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public boolean isVowel( char s )
    {
        if ( s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u'
            || s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U' )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

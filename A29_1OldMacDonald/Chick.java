/**
 * 
 * @author Riya Kumari
 * @version Oct 30, 2018
 * @author Period: 5
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: TODO
 */
class Chick implements Animal
{
    private String myType;

    private String mySound = "";

    private String mySound2 = "";


    /**
     * Constructor
     * 
     * @param type
     *            is the type of chick
     * @param sound
     *            is the sound the chick makes
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Constructor 2
     * 
     * @param type
     *            is the type of chick
     * @param sound
     *            is the sound the chick makes
     * @param sound2
     *            is the other sound the chick could make
     */
    public Chick( String type, String sound, String sound2 )
    {
        myType = type;
        mySound = sound;
        mySound2 = sound2;
    }


    /**
     * Returns the value of mySound or mySound2
     * 
     * @return the sound the chick makes
     */
    public String getSound()
    {
        double a = Math.random();
        if ( a > 0.5 )
        {
            return mySound2;
        }
        return mySound;
    }


    /**
     * Returns the value of myType
     * 
     * @return the type of chick
     */
    public String getType()
    {
        return myType;
    }
}
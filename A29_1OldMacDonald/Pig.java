/**
 * 
 * Creates a pig.
 *
 * @author Riya Kumari
 * @version Oct 30, 2018
 * @author Period: 5
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: TODO
 */
class Pig implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Constructor
     * 
     * @param type
     *            is the type of pig
     * @param sound
     *            is oink
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Returns the value of mySound
     * 
     * @return sound
     */
    public String getSound()
    {
        return mySound;
    }


    /**
     * Returns the value of myType return the type of pig
     * 
     * @return type
     */
    public String getType()
    {
        return myType;
    }
}
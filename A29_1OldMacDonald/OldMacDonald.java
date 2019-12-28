/**
 * Tests if classes cow, pig, and chick work.
 * 
 * @author Riya Kumari
 * @version Oct 30, 2018
 * @author Period: 5
 * @author Assignment: A29_1OldMacDonald
 */
class OldMacDonald
{
   /**
    * This is a main method that creates objects for cow, pig, and chick.
    * @param args default main method
    */
    public static void main( String[] args )
    {

        Farm a = new Farm();
        a.animalSounds();
        Cow c = new Cow( "cow", "moo" );
        System.out.println( c.getType() + " goes " + c.getSound() );

        Pig p = new Pig( "pig", "oink" );
        System.out.println( p.getType() + " goes " + p.getSound() );

        Chick ch = new Chick( "chick", "cluck" );
        System.out.println( ch.getType() + " goes " + ch.getSound() );
    }

}

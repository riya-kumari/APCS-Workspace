import java.util.*;


/**
 * The MailServer class represents a mechanism for queuing and dispatching
 * messages. A MailServer is a queue of messages ( MailServer implements
 * Queue<Message> ), and it has a method to dispatch a message to the
 * appropriate recipient. A MailServer also keeps a set of all “registered”
 * subscribers.
 * 
 * @author Riya Kumari
 * @version 1/23/19
 * 
 * @author Period 6
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;


    /**
     * Constructor
     */
    public MailServer()
    {
        actors = new TreeSet<Actor>();
    }


    /**
     * adds actor to the set of the registered subscribers.
     * 
     * @param actor
     *            is being added
     */
    public void signUp( Actor actor )
    {
        this.actors.add( actor );

    }


    /**
     * either sends msg to the recipient indicated in msg (by calling the
     * recipient’s receive(msg) ), or, if the recipient is null , to all
     * registered subscribers (except the sender)
     * 
     * @param msg
     *            to send
     */
    public void dispatch( Message msg )
    {
        Actor recipient = msg.getRecipient();
        if ( recipient == null )
        {
            for ( Actor a : actors )
            {
                if ( !msg.getSender().equals( a ) )
                {
                    a.receive( msg );
                }
            }

        }
        else
        {
            recipient.receive( msg );
        }
    }


    /**
     * for testing purposes only
     * 
     * @return actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}







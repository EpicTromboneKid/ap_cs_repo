import java.util.*;

/**
 * Mailserver handles the actors and their messages.
 * 
 * @author Chaaruhaas Kandregula
 * @version 1/22/2025
 * 
 * @author Period - 3
 * @author Assignment - ActorsWorld
 * 
 * @author Sources - None
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    
    public MailServer() {
        actors = new TreeSet<Actor>();
    }

    public void signUp(Actor actor) {
        actors.add(actor);
    }

    public void dispatch (Message msg) {
        if (Objects.isNull(msg.getRecipient())) {
            for (Actor actor : actors) {
                actor.receive(msg);
            }
        } else {
            for (Actor actor : actors) {
                if (actor.getName().equals(msg.getRecipient().getName())) {
                    actor.receive(msg);
                }
            }
        }
    }

    
    // for testing purposes only
    protected Set<Actor> getActors()
    {
        return actors;
    }
}

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 *  Testing for Jumper
 *  it represents, and how to use it.
 *
 *  @author  Chaaruhaas Kandregula, Austin Shu
 *  @version 10/31/2024
 *  @author  Period: 3
 *  @author  Assignment: GridWorld_Part3_Jumper
 *
 *  @author  Sources: None;
 */
public class JumperRunner
{
    public static void main( String[] args )
    {

        int x = (int)(Math.random()*100);
        int y = (int)(Math.random()*100);
        ActorWorld world = new ActorWorld(new BoundedGrid<>(x, y));
        Jumper j = new Jumper();
        j.setDirection(90);

        world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Jumper());
        world.add(new Location(0, 0), j);
        world.add(new Location(0, 1), new Rock(Color.red));
        // world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Jumper(Color.red));
        // world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Jumper(Color.green));
        // world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Jumper(Color.PINK));
        // world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Jumper(Color.blue));

        // for (int i = 0; i < (x*y)/4; i++) {            
        //     world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Jumper(Color.white));
        //     if (i % 3 == 0) {
        //         world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Bug(Color.yellow));
        //     }
            
        // }
        world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Rock());
        world.add(new Location((int)(Math.random()*x), (int)(Math.random()*y)), new Rock());


        world.show();

        
    }
}
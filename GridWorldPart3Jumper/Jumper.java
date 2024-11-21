import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 *  A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 *  turn. A jumper can remove another jumper by jumping on them.
 * 
 *  @author  Austin Shu, Chaas Kandregula
 *  @version 10/31/2024
 *  @author  Period: 3
 *  @author  Assignment: GridWorld_Part3_Jumper
 * 
 *  @author  Sources: None
 */
public class Jumper extends Bug implements Edible
{ 
    private Location jumpLocation;
    
    /**
     * no args constructor; everything is set to default
     */
    public Jumper() {
        //this is the no-args constructor 
        //if you don't want to specify object color
    };

    /**
     * constructor that allows you to change the color of the jumper object
     * @param color color of the jumper object
     */
    public Jumper(Color color) {
        this.setColor(color);
    }
    
    /**
     * this method overrides the one in bug; moves only if it can move
     */
    public void act() {
        if (canMove()) {
            move();
        } 
        else {
            this.turn();
        }
    }

    /**
     * edits the move method to make the jumper move 2 blocks instead of 1
     */
    public void move() {
        this.moveTo(jumpLocation);
    }
    
    /**
     * tests if the jumplocation is valid for this jumper
     * @return validity of the jumplocation
     */
    public boolean canMove() { 
        jumpLocation = this.getLocation();
        jumpLocation = jumpLocation.getAdjacentLocation(this.getDirection());
        jumpLocation = jumpLocation.getAdjacentLocation(this.getDirection());
        if ((!(this.getGrid()).isValid(jumpLocation))) {
            return false;
        }
        return ((this.getGrid()).get(jumpLocation) == null || 
                (this.getGrid()).get(jumpLocation) instanceof Edible);        
    }
}
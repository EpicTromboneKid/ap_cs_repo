import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;

/**
 *  The blustercritter class models a critter that changes color
 * based on the number of actors surrounding it
 *
 *  @author  Chaaruhaas Kandregula
 *  @version 11/26/2024
 *  @author  Period: 3
 *  @author  Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 *  @author  Sources: None
 */
public class BlusterCritter extends Critter
{
    private int courage;


    /**
     * Constructs a BlusterCritter with a given courage level
     * @param c the courage level of this blustercritter
     */
    public BlusterCritter( int c )
    {
        courage = c;
    }

    /**
     * gets a list of actors in the grid
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();

        ArrayList<Location> actorLocations = gr.getOccupiedLocations();

        Location myLoc = this.getLocation();

        actorLocations.remove(myLoc);

        for ( Location loc : actorLocations )
        {
            Actor a = gr.get(loc);
            actors.add(a);
        }

        return actors;
    }

    /**
     * counts how many actors surround it and 
     * reduces/increases its brighntess level accordingly
     * <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        ArrayList<Actor> actorList = getActors();

        if (actorList.size() < this.courage)
        {
            lighten();
        }
        else
        {
            darken();

        }
    }

    /**
     * Darkens the BlusterCritter
     */
    private void darken()
    {
        Color current = getColor();
        int red = current.getRed();
        int green = current.getGreen();
        int blue = current.getBlue();

        if (red > 0)
        {
            red--;
        }
        if (green > 0)
        {
            green--;
        }
        if (blue > 0)
        {
            blue--;
        }

        setColor(new Color(red, green, blue));
    }

    /**
     * Lightens the BlusterCritter
     */
    private void lighten()
    {
        Color current = getColor();
        int red = current.getRed();
        int green = current.getGreen();
        int blue = current.getBlue();

        if (red < 255)
        {
            red++;
        }
        if (green < 255)
        {
            green++;
        }
        if (blue < 255)
        {
            blue++;
        }

        setColor(new Color(red, green, blue));
    }
}

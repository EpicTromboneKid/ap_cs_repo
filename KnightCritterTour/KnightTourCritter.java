import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;

/**
 * In the beginning of the 19th century a practical method for solving
 * the  Knight's tour emerged. In "Des Resselsprungs einfachste und
 * allgemeinste Losung" (Schmalkalden, 1823) H. C. Warnsdorff presented
 * his method of constructing knight's tours.
 * 
 * The aim is to avoid creating dead ends - squares from which the
 * knight cannot get further without getting to an already visited
 * square. For that reason the possible squares to be chosen next are
 * examined before every move. One counts the number of free new
 * choices - entrances - every one of them has, and then moves
 * to the square with the lowest number of new choices. <br />
 * 
 * @author Chaaruhaas Kandregula
 * @version 11/28/2024
 * @author Period: 3
 * @author Assignment: KnightCritterTour
 *
 * @author Sources: None
 */
public class KnightTourCritter extends KnightCritter
{
    // An analysis of the accessibility of an 8x8 grid is shown below.
    // A square with an accessibility of 8 means that it can be
    // approached from 8 different other squares. A corner square is
    // rated at 2, while the edges are rated at 3 or 4. It makes sense
    // to try and visit squares with lower accessibility values first,
    // leaving the more accessible middle squares for later in the
    // algorithm.
    public int[][] accessGrid = { { 2, 3, 4, 4, 4, 4, 3, 2 },
                                  { 3, 4, 6, 6, 6, 6, 4, 3 },
                                  { 4, 6, 8, 8, 8, 8, 6, 4 },
                                  { 4, 6, 8, 8, 8, 8, 6, 4 },
                                  { 4, 6, 8, 8, 8, 8, 6, 4 },
                                  { 4, 6, 8, 8, 8, 8, 6, 4 },
                                  { 3, 4, 6, 6, 6, 6, 4, 3 },
                                  { 2, 3, 4, 4, 4, 4, 3, 2 } };

    /**
     * Determines, out of the potential moves, which one moves toward
     * a location with the lowest accessibility. It will return the
     * location with the lowest accessibility. In the case of a tie,
     * it returns the first Location within the ArrayList with 
     * the lowest value.
     *  
     * If all accessibility values are < 0, the method returns null
     * 
     * @param locs valid possible move locations
     * @return location corresponding to the lowest first move
     *         indicated by the accessibility matrix.
     */
    public Location getBestMove( ArrayList<Location> locs )
    {
        Location bestMove = null;

        for ( Location loc : locs ) {
            if (accessGrid[loc.getRow()][loc.getCol()] >= 0) {
                if (bestMove == null) {
                    bestMove = loc;
                }
                else if (accessGrid[loc.getRow()][loc.getCol()] < accessGrid[bestMove.getRow()][bestMove.getCol()]) {
                    bestMove = loc;
                }
            }
        } 

        return bestMove;
    }

    /**
     * loc contains the coordinates of the latest square to be marked
     * on the access grid. The accessibility numbers of all valid moves
     * reachable from loc are decreased by 1. This algorithm will allow
     * accessibility numbers to go negative.
     * 
     * It will also change its own accessibility value to a negative number.
     * 
     * @param loc location of the latest square to be marked on the
     *            access grid
     */
    public void updateAccess( Location loc )
    {
        accessGrid[loc.getRow()][loc.getCol()] = -1;

        ArrayList<Location> locs = getPossibleMoves( loc );

        for ( Location location : locs ) {
            accessGrid[location.getRow()][location.getCol()]--;
        }
    }

    /**
     * Selects the location for the next move. Implemented to pick
     * the possible location with lowest accessibility, or to return
     * the current location (getLocation()) if <code>locs</code> has
     * size 0. After the best move has been chosen, the accessibility
     * of the moves from the current location are updated <br />
     * 
     * Postcondition: (1) The returned location is an element of
     * <code>locs</code>, this critter's current location,
     * or <code>null</code>. (2) The state of all actors is unchanged.
     * 
     * @param locs  the possible locations for the next move
     * @return the location that was selected for the next move.
     */
    public Location selectMoveLocation( ArrayList<Location> locs )
    {
        Location moveLocation = null;
        
        if ( locs.size() > 0 ) {
            moveLocation = getBestMove( locs );
            updateAccess( moveLocation );
        } else {
            moveLocation = getLocation();
        }

        return moveLocation; // fix this!!!
    }
}

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *  Jumper tests:.
 *  test01 - jumper next to edge of grid - should turn
 *  test02 - jumper 2 from edge of grid - should turn
 *  test03 - TODO Description
 *  test04 - TODO Description
 *  test05 - TODO Description
 *  test06 - TODO Description
 *  test07 - TODO Description
 *
 *  @author  TODO Your Name(s)
 *  @version TODO Date
 *
 *  @author  Period: TODO
 *  @author  Assignment - GridWorld Part 3 Jumper
 *
 *  @author  Sources: TODO
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;
    private ActorWorld testWorld;
    private Jumper jumper1;

    /**
     * Invoked before each test to instantiate the objects
     * used for every test.
     */
    @Before public void initialize()
    {
        grid = new BoundedGrid<Actor>(4, 4);
        testWorld = new ActorWorld(grid);
        jumper1 = new Jumper();
    }

    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location(0, 3);
        testWorld.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location(1, 3);
        testWorld.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test03 - Tests if a Jumper will Jump over an Actor
     */
    @Test
    public void test03()
    {
        Location loc1 = new Location(0, 0);
        Location loc2 = new Location(0, 1);
        testWorld.add(loc1, jumper1);
        testWorld.add(loc2, new Rock());
        jumper1.setDirection(90);
        assertEquals(true, jumper1.canMove());
    }

    /**
     * test04 - Tests if a Jumper can move into an unoccupied cell
     */
    @Test
    public void test04()
    {
        Location loc1 = new Location(0, 0);
        testWorld.add(loc1, jumper1);
        jumper1.setDirection(90);
        assertTrue(testEmpty(new Location(0, 2)));
        assertTrue(jumper1.canMove());
    }

    /**
     * test05 - Jumper can jump into a cell occupied by anything that implements Edible
     */
    @Test
    public void test05()
    {
        Location loc1 = new Location(0, 0);
        Location loc2 = new Location(0, 2);
        jumper1.setDirection(90);
        testWorld.add(loc1, jumper1);
        testWorld.add(loc2, new Jumper());
        assertTrue(jumper1.canMove());
    }

    /**
     * test06 - Tests if a jumper moves 2 blocks
     */
    @Test
    public void test06()
    {
        Location loc1 = new Location(0, 0);
        jumper1.setDirection(90);
        testWorld.add(loc1, jumper1);
        jumper1.act();
        assertTrue(testOccupied(new Location(0, 2), jumper1, 90));
    }

    /**
     * test07 - Jumper cannot jump into a cell that has a non-edible object 
     */
    @Test
    public void test07()
    {
        Location loc1 = new Location(0, 0);
        Location loc2 = new Location(0, 2);
        testWorld.add(loc1, jumper1);
        testWorld.add(loc2, new Rock());
        jumper1.setDirection(90);
        assertEquals(false, jumper1.canMove());
    }

    /**
     * Test helper method to test for empty location.
     *
     * @param loc null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty(Location loc)
    {
        Actor empty = grid.get( loc );
        assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );

        return true;
    }

    /**
     * Test helper method to test that object is in a location, and has
     * a consistent loc, and direction dir.
     *
     * @param loc location that should be occupied
     * @param a   actor that should be in location loc
     * @param dir direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied(Location loc, Actor a, int dir)
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>",
            a, found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>",
            loc, found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>",
            dir, found.getDirection() );

        return true;
    }
}
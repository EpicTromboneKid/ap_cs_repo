/**
 *  Implements a rolling die object.
 *
 *  @author  Chaaruhaas Kandregula
 *  @version 9/20/24
 *  @author  Period: 3
 *  @author  Assignment: JMCh07_RollingDice
 *
 *  @author  Sources: None
 */
public class Die
{
    private int numDots;

    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        numDots = (int)((Math.random()*6)+1);
    }
    
    /**
     * Returns the value of the most recent roll.
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots;
    }
}

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
public class CrapsGame
{
  private int point = 0;

  /**
   *  Calculates the result of the next dice roll in the Craps game.
   *  The parameter total is the sum of dots on two dice.
   *  point is set to the saved total, if the game continues,
   *  or 0, if the game has ended.
   *  Returns 1 if player won, -1 if player lost,
   *  0 if player continues rolling.
   */
    public int processRoll( int total )
    {
        int result = 0;

        if ((point == 0 && (total == 7 || total == 11)) || (point != 0 && point == total )) {
            result = 1;
            point = 0;
        } else if ((point == 0 && (total == 2 || total == 3 || total == 12)) || (point != 0 && total == 7)) {
            result = -1;
            point = 0;
        } else if (point == 0){
            point = total;
            return 0;
        } else {
            return 0;
        }
        return result;
    }

    /**
     * Returns the saved point
     */
    public int getPoint()
    {
        return point;
    }
}
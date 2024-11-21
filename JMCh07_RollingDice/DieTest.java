/**
 * this class tests the die to make sure that it prints out a random number * from one to 6.
 */
public class DieTest
{
  public static void main(String[] args)
  {
    Die die = new Die();
    for(int i = 0; i < 100; i++){
      die.roll();
      System.out.println(die.getNumDots());
    }

  }
}

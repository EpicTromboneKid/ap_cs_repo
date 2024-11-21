/**
 * This is a class that tests the Card class.
 *
 *  @author  Chaaruhaas Kandregula
 *  @version 14/9/24
 *  @author  Period: 3
 *  @author  Assignment: APCSElevensActivity1
 *
 *  @author  Sources: None
 */
public class CardTester
{
	/**
	 * The main method in this class checks the Card operations for
	 * consistency.
	 * @param args is not used.
	 */
    public static void main( String[] args )
    {
        Card aceClubs1 = new Card("ace", "clubs", 1);
        Card otherAce = new Card("ace", "clubs", 1);
        Card sixOfHearts = new Card("6", "hearts", 6);
        
        System.out.println("**** ace of clubs #1 Tests ****");
        System.out.println("  rank: " + aceClubs1.rank());
        System.out.println("  suit: " + aceClubs1.suit());
        System.out.println("  pointValue: " + aceClubs1.pointValue());
        System.out.println("  toString: " + aceClubs1.toString());
        System.out.println();

        System.out.println("**** ace of clubs #2 Tests ****");
        System.out.println("  rank: " + otherAce.rank());
        System.out.println("  suit: " + otherAce.suit());
        System.out.println("  pointValue: " + otherAce.pointValue());
        System.out.println("  toString: " + otherAce.toString());
        System.out.println();

        System.out.println("**** six of hearts Tests ****");
        System.out.println("  rank: " + sixOfHearts.rank());
        System.out.println("  suit: " + sixOfHearts.suit());
        System.out.println("  pointValue: " + sixOfHearts.pointValue());
        System.out.println("  toString: " + sixOfHearts.toString());
        System.out.println();

        System.out.println("**** matches Tests ****");
        System.out.println("  matching: " + aceClubs1.matches(otherAce));
        System.out.println("  not matching: " + aceClubs1.matches(sixOfHearts));
        
    }
}
/*
**** ace of clubs #1 Tests ****
rank: ace
suit: clubs
pointValue: 1
toString: ace of clubs (point value = 1)

**** ace of clubs #2 Tests ****
rank: ace
suit: clubs
pointValue: 1
toString: ace of clubs (point value = 1)

**** six of hearts Tests ****
rank: 6
suit: hearts
pointValue: 6
toString: 6 of hearts (point value = 6)

**** matches Tests ****
matching: true
not matching: false
*/
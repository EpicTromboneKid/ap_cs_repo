import java.util.*;

/**
 * RPN Calculator
 *
 * @author Chaaruhaas Kandregula
 * @version 1/17/2025
 * @author Period: 3
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: None
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<>();
        myQ = new LinkedList<>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console) {
        this();
        scan = new Scanner( console );
    }

    /**
     * Calculates the result of the expression, which is read from the console, and prints out the expression in postfix notation
     */
    public void calculate() {
        String out = "";
        while (scan.hasNext()) {
            String s = scan.next();
            if (s.toLowerCase().equals("q")) {
                break;
            }

            myQ.add(s + " ");
        }
        for (String s : myQ) {
            switch (s.trim()) {
                case "+":
                    myStack.push(add(myStack.pop(), myStack.pop()));
                    break;
                case "-":
                    myStack.push(subtract(myStack.pop(), myStack.pop()));
                    break;
                case "*":
                    myStack.push(multiply(myStack.pop(), myStack.pop()));
                    break;
                case "/":
                    myStack.push(divide(myStack.pop(), myStack.pop()));
                    break;
                default:
                    myStack.push(Integer.parseInt(s.trim()));
                    break;
                
            }
            System.out.println(myStack);
            out += s;
        }

        out += "= " + myStack.pop();
        System.out.println(out);        
    }

    int add(int a, int b) {
        // System.out.println("add");
        return a + b;
    }

    int subtract(int a, int b) {
        // System.out.println("subtract");
        return b - a;
    }

    int multiply(int a, int b) {
        // System.out.println("multiply");
        return a * b;
    }

    int divide(int a, int b) {
        // System.out.println("divide");
        return b/a;
    }

    
    /**
     * Instantiate9s an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}
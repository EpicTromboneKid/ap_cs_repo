import java.lang.reflect.*;

/**
   This class implements a vendor that sells one kind of item.
   A vendor carries out sales transactions.

   @author  Chaaruhaas Kandregula
   @version 10/11/24

   @author Period - 3
   @author Assignment - Java Methods Ch09 - SnackBar

   @author Sources - None
 */
public class Vendor
{
    // Fields:
    private int items, price, deposit, change;
    private static double totalSales = 0;

    //  Constructor
    //  Parameters:
    //    int price of a single item in cents
    //    int number of items to place in stock
    public Vendor(int cost, int nOfItems)
    {
        price = cost;
        items = nOfItems;
    }

    /** Sets the quantity of items in stock.
    *  Parameters:
    *    @param nOfItems int number of items to place in stock  
    */    
    public void setStock(int nOfItems)
    {
        items = nOfItems;
    }

    //  Returns the number of items currently in stock.
    //  Parameters:
    //    None
    //  Return:
    //    int number of items currently in stock
    public int getStock()
    {
        return items;
    }

    //  Adds a specified amount (in cents) to the deposited amount.
    //  But, in the case that there is no more stock, return without
    //  adding anything to the deposited amount.
    //  Parameters:
    //    int number of cents to add to the deposit
    //  Return:
    //    None
    public void addMoney(int newDeposit)
    {
        if (items != 0) {
            deposit += newDeposit;
        }
    }

    //  Returns the currently deposited amount (in cents).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current deposit
    public int getDeposit()
    {
        return deposit;
    }

    //  Implements a sale.  If there are items in stock and
    //  the deposited amount is greater than or equal to
    //  the single item price, then adjusts the stock
    //  and calculates and sets change and returns true;
    //  otherwise refunds the whole deposit (moves it into change)
    //  and returns false.
    //  Parameters:
    //    None
    //  Return:
    //    boolean successful sale (true) or failure (false)
    public boolean makeSale()
    {
        if (deposit >= price && items > 0) {
            items -= 1;
            this.change = this.deposit-this.price;
            totalSales += this.price;
            this.deposit = 0;
            // System.out.println(change);
            return true;
        } else {
            this.change = this.deposit;
            this.deposit = 0;
            // System.out.println(change);
            return false;
        } 
        
    }

    //  Returns and zeroes out the amount of change (from the last
    //  sale or refund).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current change
    public int getChange()
    {
        int temp = this.change;
        change = 0;
        return temp;
    }

    //  Returns the total sales and zeroes out it out
    //  Parameters:
    //    None
    //  Return:
    //    double the total sales
    public static double getTotalSales()
    {
        double temp = totalSales;
        totalSales = 0;
        return temp*0.01;
    }

    /**
        Intended only for debugging.
        
        <p>A generic toString implementation that uses reflection to print
        names and values of all fields <em>declared in this class</em>.
        Note that superclass fields are left out of this implementation.</p>
        
        @return  a string representation of this Vendor.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}

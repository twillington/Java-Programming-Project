import java.util.*;
import java.io.*;
/**
 * This interface is implemented by AudioVisual and PrintedItem
 */
public abstract class LibraryItem implements Comparable<LibraryItem>
{
    protected String title;
    protected String itemCode;
    protected int timesBorrowed;
    protected String libraryUserID;
    protected int cost;
    public Library library;
    
    /**
     * Accessor method for title field.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Accessor method for itemCode field.
     */
    public String getItemCode()
    {
        return itemCode;
    }
    
    /**
     * Accessor method for timesBorrowed field.
     */
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }
    
    /**
     * Accessor method for onLoan field.
     */
    public boolean getOnLoan()
    {
        if (libraryUserID == null)
        return false;
        else
        return true;
    }
    
    /**
     * Accessor method for cost field.
     */
    public int getCost()
    {
        return cost;
    }   
   
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
       System.out.println ("The title of this Library Item is " + title + " its item code is " + itemCode + " it has been borrowed " + timesBorrowed + " it is currently");
       
       if (!getOnLoan())
            System.out.print("not ");
            
       System.out.print("on loan. It costs £" + cost + " to rent.");

    }
   
   /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
   public void extractTokens(Scanner scanner)
   {
       title = scanner.next();
       itemCode = scanner.next();
       cost = scanner.nextInt(); 
       timesBorrowed = scanner.nextInt();
       libraryUserID = scanner.next();
   }
    
   /**
     * Accessor method for field variable
     */
    public Library getLibrary()
    {
        return library;
    }
    
    /**
     * Mutator method for field variable
     */
    public void setLibrary(Library newLibrary)
    {
        newLibrary = library;
    }
    
    /**
     * This method changes the fields needed when a user borrows an item
     */
    public void borrowItem(String userID)
    {
        timesBorrowed++;
        libraryUserID = userID;
    }
    
    /**
     * This method changes the fields needed when a user returns an item
     */
    public void returnItem()
    {
        libraryUserID = null;
    }
    
    /**
     * This method orders the print method, this is a comparative method between the two items, 
     * the int returned is either +ve -ve or 0 depending on if it should appear before after or the same. 
     */
    public int compareTo(LibraryItem item)
    {
        return getTitle().compareTo(item.getTitle());
    }
}

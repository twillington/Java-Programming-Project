import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.FileDialog;

/**
 * 
 */
public abstract class LibraryUser
{
    public String surname;
    public String libraryID;
    public ArrayList<String> itemCodes;
    public int noOfItems;
    public Library library;
        
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
         System.out.println ("This users last name is " + surname + " and their library ID is " + libraryID + ".");
         if  (!(noOfItems==0))
         {  System.out.println ("There have also currently borrowed the item(s) with the code(s) " + itemCodes ); }
         
    }
    
    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner)
    {
        surname = scanner.next();
        libraryID = scanner.next();
        noOfItems = scanner.nextInt();
        int k = noOfItems;
        while (k>=2)
        {   
            itemCodes.add(scanner.next());
            k=k-1;
        }
    }
    
      
    /**
     * Accessor for field variable
     */
    public String getLibraryID()
    {
        return libraryID;
    }
       
    /**
     * Accessor for field variable
     */
    public Library getLibrary()
    {
        return library;
    }
    
    /**
     * Mutator for field variable
     */
    public void setLibrary(Library newLibrary)
    {
        newLibrary = library;
    }
    
    /**
     * This is a method which calls another method in library which allows for a user to borrow a item
     */
    public void borrowRequest(LibraryItem libraryItem)
    {
       library.processBorrowRequest(libraryItem, this);
    }
    
    /**
     * This is a method which calls another method in library which allows for a user to return a item
     */
    public void returnRequest(String itemCode)
    {
       library.processReturnRequest(itemCode, this) ;
    }
    
    /**public String getItemCodes()
    {
        for (String itemCode : itemCodes)
        return itemCode;
    }
    
    public void addItemCode(String itemcode)
    {
        itemCodes.add(itemcode);        
    }**/
    
    public void removeItemCode(String itemCode)
    {
        for (String storeditemCode : itemCodes)
        {
           if (itemCode.equalsIgnoreCase(storeditemCode))
           itemCodes.remove(itemCode);
        }
    }
}

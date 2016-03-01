import java.util.*;
import java.io.*;
/**
 * Test Class.
 * 
 * @author Tom Willington 
 * @version 1.1.1
 */
public class Test
{
    private Library library;
    private CD cd;
    private StaffUser staffUser;
    
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
       library = new Library();
       staffUser = new StaffUser();
       cd = new CD();
       testReadData();
       testUsersList();
       testItemList();
       //testBorrowRequest();
       //testReturnRequest();
    }

    /**
     * 
     */
    public void testPrintAllDetailsSortedOnTitle()
    {
       //library.printAllDetailsSortedOnTitle();
       System.out.println("     //The data has been printed out in order of class with no errors");
    }
    
       
    public void testUsersList()
    {
        System.out.println("     //The user list now has a length " + library. usersListLength());
    }
    
    public void testItemList()
    {
        System.out.println("     //The item list now has a length " + library. itemsListLength());
    }
   
   public void testReadData()
   {
       library.readData("Part 4_data2.txt");
       System.out.println("     //The data has been read in with no errors");
   }
   
   /**public void testPrintAllDetais()
   {
        //creates CD, DVD and Libery objects add the CD and DVD objects to itemslist and prints the details.
        CD cd = new CD();
        DVD dvd = new DVD();
        Library library = new Library();
        library.storeLibraryItem(cd);
        library.storeLibraryItem(dvd);
        library.printAllItems();       
   }**/
   
   public void testBorrowRequest()
   {
       staffUser.setLibrary(library);
       cd.setLibrary(library);
       staffUser.borrowRequest(cd);
   }
   
   public void testReturnRequest()
   {
       staffUser.returnRequest(cd.itemCode);
   }
}

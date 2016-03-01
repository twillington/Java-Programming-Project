import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.FileDialog;
/**
 * Library Class holds an Array List of all objects.
 * 
 * @author Tom Willington
 * @version 1.1.1
 */
public class Library
{
    private Map<String, LibraryItem> itemsMap;
    private Map<String, LibraryUser> userMap;
    private JFrame mainWindow;    
    
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
      itemsMap = new TreeMap <String, LibraryItem>();  
      mainWindow = new JFrame("Library Project");
      userMap = new TreeMap <String, LibraryUser>();  
    }

    /**
     * This method is called when a new object is created that should be stored in the itemsList, the method is externally 
     * called and passed a self-referencing pointer. The object that called the method should be added to the ArrayList.
     */
    public void storeLibraryItem(LibraryItem y)
    {
        if (itemsMap.get(y.itemCode)==null)
        {   
            itemsMap.put(y.itemCode, y);
            y.setLibrary(this);
        }
        else
            System.out.println("This item code has already been used by another item");
    }
    
    /**
     * This method is called when a new object is created that should be stored in the itemsList, the method is externally 
     * called and passed a self-referencing pointer. The object that called the method should be added to the ArrayList.
     */
    public void storeLibraryUser(LibraryUser y)
    {
       if (userMap.get(y.libraryID)==null)
       {   
            userMap.put(y.libraryID, y);
            y.setLibrary(this);
       }
       else
        System.out.println("This library ID is already in use by another user");
    }
    
    public int itemsListLength()
    {
        return itemsMap.size();
    }
    
    public int usersListLength()
    {
        return userMap.size();
    }
    
    /**public void  printAllItems()
    {
        // A for each loop which calls the printDetails() method in each object
        for (TypeKey itemCode : itemMap.keySet())
           { String key = itemCode.toString();
             String value = itemMap.get(itemCode).printDetails();
             System.out.println(key + " " + value);               
           }            
    } 
    
    public void printAllUsers()
    {
        // A for each loop which calls the printDetails() method in each object
        for (TypeKey libraryID : userMap.keySet())
           { String key = libraryID.toString();
             String value = userMap.get(libraryID).printDetails();
             System.out.println(key + " " + value);               
           }
    }**/ 
    
    public void readData()
        
    {
        // a call to a method which controls the dialog box, passing back a file name parameter
        File dataFile = new File(openFile());     
        
        try 
        {
           //creates the scanner object and passes it the file
            Scanner scanner = new Scanner(dataFile);
           //initialise the flag which decides whether or not the data is cd or dvd
            String typeOfData = "none";
            
           while (scanner.hasNext())
           {
               //find each line of the file and removes white space at either side  
               String lineOfText = scanner.nextLine();
               lineOfText = lineOfText.trim();
                           
               //removes the lines which are empty or comments                 
               if (lineOfText.isEmpty() || lineOfText.startsWith("//"))
                 {
                     //line not wanted
                 }                 
               //The next lines detect data types and set the flags               
               else if(lineOfText.equalsIgnoreCase("[DVD data]"))
                                
                 {
                     typeOfData = "DVD";
                 }
               else if(lineOfText.equalsIgnoreCase("[CD data]"))
                 {
                     typeOfData = "CD";
                 }               
               else if(lineOfText.equalsIgnoreCase("[Book data]"))
                 {
                     typeOfData = "Book";                     
                 }
               else if(lineOfText.equalsIgnoreCase("[periodical data]" ))
                 {
                     typeOfData = "Periodical";                     
                 }                 
               else if(lineOfText.equalsIgnoreCase("[StaffUser data]"))
                 {
                     typeOfData = "StaffUser";                     
                 }
               
               else if(lineOfText.equalsIgnoreCase("[PGUser data]"))
                 {
                     typeOfData = "PGUser";                     
                 }
                 
                 else if(lineOfText.equalsIgnoreCase("[UGUser data]"))
                 {
                     typeOfData = "UGUser";                     
                 }
                 
               else
               
                 {
                     //prints the line 
                     System.out.println(typeOfData + " " + lineOfText);
                     
                     //creates a scanner and sets the delimter as a comma
                     Scanner scanner1 = new Scanner(lineOfText);
                     scanner1.useDelimiter("[ ]*(,)[ ]*");
                     
                     if((typeOfData.equalsIgnoreCase("CD")) || (typeOfData.equalsIgnoreCase("DVD"))||(typeOfData.equalsIgnoreCase("Book"))||(typeOfData.equalsIgnoreCase("Periodical")))
                     {
                        LibraryItem item = null;
                     
                        if (typeOfData.equalsIgnoreCase("CD"))
                        {
                            item = new CD();                         
                        }
                        else if (typeOfData.equalsIgnoreCase("DVD"))
                        {
                            item = new DVD();
                        }
                        else if (typeOfData.equalsIgnoreCase("Book"))
                        {
                            item = new Book();                         
                        }
                        else if (typeOfData.equalsIgnoreCase("Periodical"))
                        {
                            item = new Periodical();                         
                        }
                        
                        item.extractTokens(scanner1);  
                        storeLibraryItem(item);
                    }
                    
                     if((typeOfData.equalsIgnoreCase("StaffUser")) || (typeOfData.equalsIgnoreCase("UGUser"))||(typeOfData.equalsIgnoreCase("PGUser")))
                    {
                         LibraryUser user = null;
                         
                         if (typeOfData.equalsIgnoreCase("StaffUser"))
                         {
                             user = new StaffUser();                             
                         }
                         else if (typeOfData.equalsIgnoreCase("UGUser"))
                         {
                             user = new UGUser();                             
                         }
                         else if (typeOfData.equalsIgnoreCase("PGUser"))
                         {
                             user = new PGUser();
                         }
                         
                         user.extractTokens(scanner1); 
                         storeLibraryUser(user);
                    }
                     
                     scanner1.close();
                 }       
                                  
           }
           scanner.close();
        }
            catch (FileNotFoundException error)
            {
                System.out.println(error);
            }
           
          /** 
            * catch (EOFException error)
            * {
            *     System.out.println(error);
            *   }
            *   catch (IOException error)
            *   {
            *       System.out.println(error);
            *   }
            */ 
    }   
    
    private String openFile()
    {
        //creates a filedialog, makes it visible and sets the direcotry as current 
        FileDialog fileDialogBox = new FileDialog(mainWindow, "Open", FileDialog.LOAD);
        fileDialogBox.setVisible(true);
        fileDialogBox.setDirectory(".");
        
        //prints the selected files filename and returns it
        System.out.println(fileDialogBox.getFile());
        return fileDialogBox.getFile();
    }    
    
    public void readData(String filename)
        
    {
        // the filename is made into a file and referenced
        File dataFile = new File (filename);     
        
        try 
        {
           //creates the scanner object and passes it the file
            Scanner scanner = new Scanner(dataFile);
           //initialise the flag which decides whether or not the data is cd or dvd
            String typeOfData = "none";
            
           while (scanner.hasNext())
           {
               //find each line of the file and removes white space at either side  
               String lineOfText = scanner.nextLine();
               lineOfText = lineOfText.trim();
                           
               //removes the lines which are empty or comments                 
               if (lineOfText.isEmpty() || lineOfText.startsWith("//"))
                 {
                     //line not wanted
                 }
               else if(lineOfText.equalsIgnoreCase("[DVD data]"))
                                
                 {
                     typeOfData = "DVD";
                 }
               else if(lineOfText.equalsIgnoreCase("[CD data]"))
                 {
                     typeOfData = "CD";
                 }
               
               else if(lineOfText.equalsIgnoreCase("[Book data]"))
                 {
                     typeOfData = "Book";                     
                 }
               else if(lineOfText.equalsIgnoreCase("[periodical data]" ))
                 {
                     typeOfData = "Periodical";                     
                 }                 
               else if(lineOfText.equalsIgnoreCase("[StaffUser data]"))
                 {
                     typeOfData = "StaffUser";                     
                 }
                 else if(lineOfText.equalsIgnoreCase("[StaffUser data]"))
                 {
                     typeOfData = "StaffUser";                     
                 }
                 
               else if(lineOfText.equalsIgnoreCase("[PGUser data]"))
                 {
                     typeOfData = "PGUser";                     
                 }
                 
                 else if(lineOfText.equalsIgnoreCase("[UGUser data]"))
                 {
                     typeOfData = "UGUser";                     
                 }
                 
               else
                 {
                     //prints the line 
                     System.out.println(typeOfData + " " + lineOfText);
                     
                     //creates a scanner and sets the delimter as a comma
                     Scanner scanner1 = new Scanner(lineOfText);
                     scanner1.useDelimiter("[ ]*(,)[ ]*");
                     
                     if((typeOfData.equalsIgnoreCase("CD")) || (typeOfData.equalsIgnoreCase("DVD"))||(typeOfData.equalsIgnoreCase("Book"))||(typeOfData.equalsIgnoreCase("Periodical")))
                     {
                        LibraryItem item = null;
                     
                        if (typeOfData.equalsIgnoreCase("CD"))
                        {
                            item = new CD();                         
                        }
                        else if (typeOfData.equalsIgnoreCase("DVD"))
                        {
                            item = new DVD();
                        }
                        else if (typeOfData.equalsIgnoreCase("Book"))
                        {
                            item = new Book();                         
                        }
                        else if (typeOfData.equalsIgnoreCase("Periodical"))
                        {
                            item = new Periodical();                         
                        }
                        
                        item.extractTokens(scanner1);  
                        storeLibraryItem(item);
                    }
                    
                     if((typeOfData.equalsIgnoreCase("StaffUser")) || (typeOfData.equalsIgnoreCase("UGUser"))||(typeOfData.equalsIgnoreCase("PGUser")))
                     {
                         LibraryUser user = null;
                         
                         if (typeOfData.equalsIgnoreCase("StaffUser"))
                         {
                             user = new StaffUser();                             
                         }
                         else if (typeOfData.equalsIgnoreCase("UGUser"))
                         {
                             user = new UGUser();                             
                         }
                         else if (typeOfData.equalsIgnoreCase("PGUser"))
                         {
                             user = new PGUser();
                         }
                         
                         user.extractTokens(scanner1); 
                         storeLibraryUser(user);
                    }
                     
                     scanner1.close();
                 }      
                                  
           }
           scanner.close();
        }
            catch (FileNotFoundException error)
            {
                System.out.println(error);
            }
           
          /** 
            * catch (EOFException error)
            * {
            *     System.out.println(error);
            *   }
            *   catch (IOException error)
            *   {
            *       System.out.println(error);
            *   }
            */ 
    }   
    
    public void processBorrowRequest(LibraryItem libraryItem, LibraryUser libraryUser)
    {
        if (libraryItem.getOnLoan())
        {
           System.out.println("Item is on Loan");
        }
        else if (!(libraryUser.noOfItems==0))
        {
            System.out.println("User has already borrowed an item");
        }
        else
        {
           libraryUser.itemCodes.add(libraryItem.getItemCode());
           libraryItem.borrowItem(libraryUser.getLibraryID());           
        }
    }
    
    public void processReturnRequest(String itemCode, LibraryUser libraryUser)
    {
        LibraryItem item = getLibraryItem(itemCode);        
                    
        if (!(item.getOnLoan()))
        {
           System.out.println("Item is not on Loan");
        }
        else if (libraryUser.noOfItems==0)
        {
            System.out.println("User has not borrowed an item");
        }
        else
        {
           libraryUser.removeItemCode(itemCode);
           item.returnItem();           
        }
    }
    
    public LibraryItem getLibraryItem(String itemCode)
    {
        return itemsMap.get(itemCode);
    }
    
    public LibraryUser getLibraryUser(String libraryID)
    {
        return userMap.get(libraryID);
    }
    
    
    /**public void printAllDetailsSortedOnTitle()
    {
        List<LibraryItem> newItemsList = itemsMap;
        Collections.sort(newItemsList);
        printAllItems();
    }**/
}


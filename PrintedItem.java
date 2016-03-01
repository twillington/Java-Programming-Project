import java.util.*;
import java.io.*;
/**
 * W
 */
public abstract class PrintedItem extends LibraryItem
{
    protected String publisher;
    protected int noOfPages;
    
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The publisher is " + publisher + " and there are " + noOfPages + " pages.");        
    }
   
    public void extractTokens(Scanner scanner)
    {
      noOfPages = scanner.nextInt();
      publisher = scanner.next();
      super.extractTokens(scanner); 
    }
}

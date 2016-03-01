import java.util.*;
import java.io.*;

/**
 * Write a description of class Book here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Book extends PrintedItem
{
    protected String author;
    protected String isbn;

    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner)
    {
       author = scanner.next();
       isbn = scanner.next();
       super.extractTokens(scanner);
    }
    
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The author is " + author + " and the isbn is " + isbn);        
    }
}

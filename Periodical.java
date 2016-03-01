
import java.util.*;
import java.io.*;

/**
 * Write a description of class Periodical here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Periodical extends PrintedItem
{
    protected String publicationDate;    

    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner)
    {
       publicationDate = scanner.next();
       super.extractTokens(scanner);
    }
    
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The publication date is " + publicationDate);        
    }
}

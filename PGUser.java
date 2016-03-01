import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.FileDialog;

/**
 * 
 */
public class PGUser extends StudentUser
{
   public String supervisorID;
   public static final int manNoOfItems = 8;
    
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("This is a Post-Graduate student and there supervisor has the ID " + supervisorID);
    }
    
    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner)
    {
        supervisorID = scanner.next();
        super.extractTokens(scanner);
    }
}
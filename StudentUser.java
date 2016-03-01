
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.FileDialog;
/**
 * 
 */
public abstract class StudentUser extends LibraryUser
{
   public int rollnumber; 
    
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
       super.printDetails();
       System.out.println("There rollnumber is " + rollnumber + ".");
    }
    
    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner)
    {
        rollnumber = scanner.nextInt();
        super.extractTokens(scanner);
    }
}
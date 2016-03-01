import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.FileDialog;
/**
 * 
 */
public class StaffUser extends LibraryUser
{
   public String staffID;
   public static final int maxNoOfItems = 10;
    
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("This user is Staff and has the ID " + staffID);
    }
    
    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner)
    {
        staffID = scanner.next();
        super.extractTokens(scanner);
    }
}

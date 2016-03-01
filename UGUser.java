import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.FileDialog;
/**
 * 
 */
public class UGUser extends StudentUser
{
   public String courseCode;
    public static final int manNoOfItems = 5;
    

    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("This user is an Undergraduate student and their course code is " + courseCode);
    }
    
    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner)
    {
       courseCode = scanner.next();
        super.extractTokens(scanner); 
    }
}
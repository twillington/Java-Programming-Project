import java.util.*;
import java.io.*;
/**
 * The class DVD is a subclass of AudioVisual.
 * 
 * @author Tom Willington 
 * @version 1.1.1 
 */
public class DVD extends AudioVisual
{
    private String director;
      
    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The name of the director(s) is " + director );
    }
    
    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner1)
    {
       //each token is passed to a variable and is trimmed
       director = scanner1.next();
       super.extractTokens(scanner1);               
      
    }    
}

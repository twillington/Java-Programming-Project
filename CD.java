import java.util.*;
import java.io.*;
import javax.swing.*;
/**
 * CD is a subclass of AudioVisual and inherits some of its methods etc.
 * 
 * @author Tom Willington 
 * @version 1.1.1 03/03/2015
 */
public class CD extends AudioVisual
{
    private String artist;
    private int noOfTracks;

    /**
     * This prints out the details of the object
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The name of the artist(s) is " + artist + " and there are " + noOfTracks + " tracks.");
    }
    
    /**
     * This method is passed a scanner and sets the field variables as the tokens.
     */
    public void extractTokens(Scanner scanner1)
    {
      //each token is passed to a variable and is trimmed
       artist = scanner1.next();
       noOfTracks = scanner1.nextInt();
       super.extractTokens(scanner1);
    }    
}

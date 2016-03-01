import java.util.*;
import java.io.*;
/**
 * The AudioVisual class is a superclass of the subclasses CD and DVD.
 * It holds information which is relevant to both classes.
 * 
 * @author Tom Willington 
 * @version 1.1.1 03/03/2015
 */
public abstract class AudioVisual extends LibraryItem
{
    protected int playingTime;    
    
    /**
     * Accessor method for playingTime field.
     */
    public int getPlayingTime()
    {
        return playingTime;
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println ("the run time is " + playingTime + " minutes. ");
    }
    
    public void extractTokens(Scanner scanner)
    {
        playingTime = scanner.nextInt();   
        super.extractTokens(scanner);           
    }
}

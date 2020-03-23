
/**
 * Command Unkown represents an action which is unknown to the game 
 * and returns a message to player saying this action does nothing
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Quit extends Command
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CommandUnkown
     */
    public cmd_Quit()
    {
        // initialise instance variables
        x = 0;
    }
    
    
    /**
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}

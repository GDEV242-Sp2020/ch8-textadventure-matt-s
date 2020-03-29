
/**
 * Command Unkown represents an action which is unknown to the game 
 * and returns a message to player saying this action does nothing
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class CommandUnknown extends Command
{
    /**
     * Prints message saying the command entered is unknown
     * 
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
        System.out.println("This is not a recognized command");
    }
    
}

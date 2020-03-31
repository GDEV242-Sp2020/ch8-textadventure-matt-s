
/**
 * Command Use represents player using an item they have at their disposal
 * 
 * in order for each item to have their own command it might be better to abstract and extend the Items class 
 *  |-each item shares a method use() which will be unique to its own item as well.
 *  |-Perhaps that is where the item description will be held too instead of a messages class
 *  |- this should be then done with the NPC class
 *  |- maybe room and specialty rooms of type
 *  |- maybe door and specialty doors of type?
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Use extends Command
{

    private Player player;

    /**
     * Constructor for objects of class CommandUnkown
     */
    public cmd_Use(Player player)
    {
        this.player = player;
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
        return y;
    }
}

/**
 * Lists inventory of what is currently being carried by the player
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Items extends Command
{

    private Player player;

    /**
     * Constructor
     * @param Player current Player object
     */
    public cmd_Items(Player player)
    {
       this.player = player;
    }
    
    
    /**
     * Lists all Items player is carrying.
     * 
     * This method performs the class's actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
        System.out.println(player.getItemsString());
        System.out.println(); 
    }
    
}

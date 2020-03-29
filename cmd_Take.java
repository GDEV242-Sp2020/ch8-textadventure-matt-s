
/**
 * Take command picks up an item from the room and adds it to the player's inventory.
 * The player can then move from room to room still having access to that item until dropped.
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Take extends Command
{
    // instance variables - replace the example below with your own
    private Player player;

    /**
     * Constructor
     * @param Player current player
     */
    public cmd_Take(Player player)
    {
        this.player = player;
    }
    
    
    /**
     * Picks up an item from the room if the item can be held
     * 
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
        if (!hasSecondWord()) {
            System.out.println("Take what? (try: take <object>)");
            return;
        }
        
        Room room = player.getCurrentRoom();
        Items item = room.getItem(getSecondWord());
        if (item != null) {
            if (player.takeItem(item)) { //returns true and item is picked up
                room.removeItem(item);
                System.out.println("A " +item.getName() +" has been added to your inventory.");
                System.out.println("You have space for "+ player.invSpaceLeft() +" more items.");
            }
            else {
                System.out.println("You cannot possibly pick this up!");
            }
        }
        else {
            System.out.println("Take what?");
        }        
    }
    
}

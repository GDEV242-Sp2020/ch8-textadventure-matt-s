
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
    private Items localItem;
    private Player player;

    /**
     * Constructor for objects of class CommandUnkown
     */
    public cmd_Use(Player player)
    {
        this.player = player;
    }
    
    
    /**
     * use item in players possession. if there is no item, then player is told
     * 
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
         if (!hasSecondWord()) {
            System.out.println("Use what? Specify an item you have.");
            return;
        }
        
        String itemToUse = getSecondWord();         // Object name to search what to use
        if (itemExists(itemToUse)) 
        { //search is positive
            useItem(localItem);
        } else {
            System.out.println("Take what?");
        }        
    }
        
    
    
    /**
     * check to see if the item exists in the room or on the Player
     * 
     * @param String item name of Items object
     * @return true if item exists locally (inventory, current room) false otherwise
     */
    private boolean itemExists(String itemName)
    {       
        localItem = player.getItem(itemName); //gets item on player
        if(localItem != null)
        return true;
        
        localItem = player.getCurrentRoom().getItem(itemName); // gets item in player's current room
        if(localItem != null)
        return true;
        
        if(localItem == null)
        return false;
    }
    
    /**
     * 
     */
    private void useItem(Items item)
    {
        item.use();
    }
    
}

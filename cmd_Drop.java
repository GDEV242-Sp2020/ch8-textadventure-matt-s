
/**
 * Drop command removes an item from the player's inventory 
 * and adds it to items list for player's current room. The room will hold item until moved.
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Drop extends Command
{
    // instance variables - replace the example below with your own
    private Player player;

    /**
     * Constructor
     * @param Player current player
     */
    public cmd_Drop(Player player)
    {
        this.player = player;
    }
    
    
    /**
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
        if (!hasSecondWord()) { // no second word
            System.out.println("Drop what? (try: drop <item> - Item must be in your inventory)");
            return;
        }     

        // if (item != null && player.haveItem(item)) { //item is held - redundant check
            // player.dropItem(item);
            // room.addItem(item);
            
        // }
        // else {
            // System.out.println("Can't find item to drop");
        // } 
        Room room = player.getCurrentRoom();
        Items item = player.getItem(getSecondWord());
        if (item != null) {
            if (player.dropItem(item)) { //returns true and item is picked up
                room.addItem(item);
                System.out.println("You removed the " +item.getName() +" from your possessions.");
                System.out.println("You now have space to hold "+ player.numSpaceLeft() +" more items.");
            }
            else {
                System.out.println("You cannot drop this!");
            }
        }
        else {
            System.out.println("Drop what? (try: drop <item> - make sure its something you're carrying");
        }        
    }
    

}

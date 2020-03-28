
/**
 * Move command tests to see if player is capable of moving and if so then moves the player
 * to chosen room.
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Move extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords commands;
    private Player player;
    
    /**
     * Constructor
     * @param Player current Player object
     */
    public cmd_Move(Player player)
    {
        this.player = player;
    }
    
    /**
     * Moves the player, if possible, from one room to another
     * 
     * This method performs the action of the command for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
        if (!hasSecondWord()) { // there is no second word
            // if there is no second word, we don't know where to go...
            System.out.println("Go where? Please be more specific");
            return;            
        }   
        String direction = getSecondWord(); //second word found

        // Possible room
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            if (nextRoom.isUnlocked(null)) {
                player.setCurrentRoom(nextRoom);
                System.out.println(player.getCurrentRoom().printLocationInfo());
                System.out.println();
            }
            else {
                System.out.println("This door is locked!");
            }
        }        
    }        
}

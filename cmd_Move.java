
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
            System.out.println("There is no door in that direction");
        }
        else {
            if (!nextRoom.isLocked()) {
                enterRoom(nextRoom);
            }
            //unlock room should now be another action instead
            // else if (nextRoom.isUnlocked(null)) {
                // enterRoom(nextRoom);
            // }
            else {
                System.out.println("This door is locked!");
            }
        }        
    }      
    
    /**
     * Actions performed once player enters a room
     * Checks to see if room isDark, if not the locationInfo is given.
     * @param Room new room that is entered.
     */
    private void enterRoom(Room newRoomEntered)
    {
        
        player.setCurrentRoom(newRoomEntered);
        if(player.getCurrentRoom().isDark()){//check to see if room is dark
            System.out.println("The room is pitchblack and you are unable to see anything");
            System.out.println();
        } else {
            System.out.println(player.getCurrentRoom().printLocationInfo());
            System.out.println();
        }
    }
}

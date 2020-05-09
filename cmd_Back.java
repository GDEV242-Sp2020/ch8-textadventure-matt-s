
/**
 * Back command moves player back to the room they were previous
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Back extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords commands;
    private Player player;
    
    /**
     * Constructor
     * @param Player current Player object
     */
    public cmd_Back(Player player)
    {
        this.player = player;
    }
    
    /**
     * Moves the player back as many steps as indicated. no second word means one step.
     * 
     * This method performs the action of the command for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
        
        if (!hasSecondWord()) {
            if(player.getLastRoom() == null)
            {
                System.out.println("You can not go back any further");
                return;
            }
           
            player.setCurrentRoom(player.getLastRoom());
            System.out.println("You have moved back to previous room.");
            System.out.println(player.getCurrentRoom().printLocationInfo());
            return;
        }
        int stepsBack = -1;
        
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

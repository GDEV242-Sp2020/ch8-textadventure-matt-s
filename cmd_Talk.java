 /**
 * Interacts with character in the room giving player an extra bit of dialogue
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Talk extends Command
{

    private Player player;
    private NPC character;
    private Message message;
    private Command command;
    /**
     * Constructor
     * @param Player current Player object
     */
    public cmd_Talk(Player player)
    {
       this.player = player;
       Message message = new Message(player);
    }
    
    /**
     * Talks to current npc in room and prints dialogue for player to read and interact with.
     * 
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
     if (!hasSecondWord()) {
            System.out.println("Talk to who? - try <npc name>");
       }
        String npcName = getSecondWord();         // Object name to search what to describe
        boolean found = canTalkTo(npcName); // Can talk to this NPC in the room?
        Room currentRoom = new Room("startLocation");
     if (!found){
         System.out.println("You tried to get information from a guard, now you're dead. Next time," +
         " be more carefull to who you talk to.");
        wantToQuit();
         
        }
       else{   
         currentRoom.getNPCString();
         System.out.println("You asked "+npcName+ "where is the bagpack? ");
         System.out.println("Thanks,you replied. ");
        
          }
        
    }
    
    /**
     * Look at the room for an item with the given name and
     * show its description.
     * @return true if the item is found or false if it's not.
     */
    private boolean canTalkTo(String name)
    {
        NPC npc = player.getCurrentRoom().getNPC(name);
        if (npc != null) { // NPC exists in the room
            if(npc.canTalkTo())
                return true;
            else{
                System.out.println("You talked to " +name +". it was not helpful");
                return false;}
        
        }
        else {
            return false;
        }
    }
}

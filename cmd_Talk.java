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
            // look around the room
            System.out.println("Talk who? - try: talk <character> ");
            System.out.println();                    
            return;
        }
        
        String npcName = getSecondWord();         // Object name to search what to describe
        boolean found = canTalkTo(npcName); // Can talk to this NPC in the room?
        
        /**     //nested boolean check from cmd_Look. will delete code when confirmed unusable.
        if (!found) {
            found = canDescribeHeldItem(npcName); // No, then how about Inventory?
            if (!found) {
                found = canDescribeNPC(npcName);  // No, is this a character?
            }
        }
        **/
        
        if (!found) {                             // No that npc name isn't found
            System.out.println("There is no one here who goes by " +npcName);
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
                System.out.println("You try to talk to " +name +". They are unresponsive.");
                return false;}
        
        }
        else {
            return false;
        }
    }
    
    /**
     * Looks in inventory for an item with name.
     * @param String 
     * @return boolean true if found or false if not.
     */
    private boolean canDescribeHeldItem(String name)
    {
        Items item = player.getItem(name);
        if (item != null) {
            System.out.println(item.getDescription());
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Look at a character with the given name and show
     * its description.
     * @return true if the character is found or false if it's not.
     */
    public boolean canDescribeNPC(String name)
    {
        if(player.getCurrentRoom().getNPC(name) != null){
            System.out.println(player.getCurrentRoom().getNPC(name).getDescription());
            return true;
        }
        else {
            return false;
        }        
    }
}

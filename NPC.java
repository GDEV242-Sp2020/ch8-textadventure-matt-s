
/**
 * An NPC is a non player character the player may interact with. 
 * Each NPC has a name, a description, and a basic bit of dialogue 
 * NPCs behave similarly to an Items object which can not be picked up.
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/28/2020
 */
public class NPC
{
    private String name;
    private String description;
    private String dialogue;   //place holder for when ready to implement any dialogue
    private boolean canTalkToPlayer;
    private boolean npcInRoom ;
    /**
     * Constructor
     * @param String name of NPC
     */
    public NPC(String name)
    {
        this.name = name;
        // canTalkToPlayer = talks;
        
    }

    /**
     * Get NPC name
     * @return String name of NPC
     */
    public String getNpcName()
    {
        return name;
    }
   
    /**
     * Get NPC description
     * @return String description of NPC
     */
    public String getNpcDescription()
    {
        return description;
    }
    
    /**
     * Set description for NPC
     * @param String new description given to NPC
     */
    public void setNpcDescription(String description)
    {
        this.description = description;
    }
        
    /**
     * Getter for canTalkTo Boolean
     * @return True if NPC can talk to player
     */
    public boolean canTalkTo()
    {
        return canTalkToPlayer;
    }
    
    /**
     *Is there anyone in this room?
     * @return 
     * True if there is at least one otherperson.
     * False if there is only player
     */
    public boolean npcInRoom()
    {
        return npcInRoom;
    }
    
    /**
     * Set the player's ability to talk to non player character; True or False
     * @param boolean npcInRoom 
     */
    public void setNpcIsInRoom(boolean npcInRoom)
    {
        this.npcInRoom = npcInRoom;
        
    }
}

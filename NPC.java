
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

    /**
     * Constructor
     * @param String name of NPC
     */
    public NPC(String name, boolean talks)
    {
        this.name = name;
        canTalkToPlayer = talks;
        
    }

    /**
     * Get NPC name
     * @return String name of NPC
     */
    public String getName()
    {
        return name;
    }
   
    /**
     * Get NPC description
     * @return String description of NPC
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Set description for NPC
     * @param String new description given to NPC
     */
    public void setDescription(String description)
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
}

import java.util.ArrayList;
/**
 * Items class is for  are objects which can be stored on a player or in a room. 
 * They are created at the beginning of the game with a name, description,
 * boolean is held, location, weight
 *
 * @author Matthew Sheehan and Marcelle Tamegnon
 * @version 3/16/2020
 */
public class Items
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int weight;
    //extra item descriptors:
    private boolean isHeld = false; //no objects start with a player
    private ArrayList<String> otherNames; // a list to give multiple names to object
private boolean canBeHeld = false; //can this object be picked up?

    /**
     * Constructor for objects of class Items
     * @param m_name the name of item
     * @param m_location the starting location
     */
    public Items(String name)
    {
        this.name = name;
        weight = 1;
        
       // setDescription();  figure how to use enums for this.
        
    }
    
    /**
     * gets name String for item.
     * @return name of item.
     */    
    public String getName()
    {
        return name;
    }
    
    
    /**
     * gets description String for item.
     * @return description of item.
     */    
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Sets the description using the stored enum descriptions 
     * correlating to the object's name
     *this method updates the description from initial null status and must 
     *be used at object initialization to prevent null return.
     */    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    
    //Holding functionality : *********************
    /**
     * Check to see if Item is being held
     */
    public boolean isHeld()
    {
        return isHeld;
    }
    
    /**
     * Mark variable as being held in player's Inventory
     */    
    public void setBeingHeld()
    {
        isHeld = true;   
    }    
    
    /**
     * Mark variable as being on the floor in a room
     */
    public void setNotHeld()
    {
        isHeld = false;
    }
      
    /**
     * Can this item be picked up?
     * @return canBeHeld - Can this be held?
     * True if item can be put into player's inventory.
     * False if Items can't store with Player. Just some game objects to investigate in a room
     */
    public boolean canBeHeld()
    {
        return canBeHeld;
    }
    
    /**
     * Set the item's ability to be held; True or False
     * @param canBeHeld boolean sets Items object canBeHeld field.
     */
    public void setCanHoldTo(boolean canBeHeld)
    {
        this.canBeHeld = canBeHeld;
        
    }
    
    /**
     * A use command is expanded upon in classes that extend this class.
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void use()
    {
        System.out.println("Test generic use for item " +name+".");
        System.out.println();
    }
    
    
}

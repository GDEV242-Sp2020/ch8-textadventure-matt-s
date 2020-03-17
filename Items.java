
/**
 * Items class is for  are objects which can be stored on a player or in a room. 
 * They are created at the beginning of the game with a name, description,
 * boolean is held, location, weight
 *
 * @author Matthew Sheehan
 * @version 3/16/2020
 */
public class Items
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int location; //location by room number
    boolean isHeld = false; //no objects start with a player
    

    /**
     * Constructor for objects of class Items
     * @param m_name the name of item
     * @param m_location the starting location
     */
    public Items(String m_name, int m_location)
    {
        name = m_name;
        location = m_location;
        setDescription(); 
        
    }
    
    /**
     * gets description String for item.
     * @return description of item.
     */    
    private String getDescription()
    {
        return description;
    }
    
    /**
     * Sets the description using the stored enum descriptions 
     * correlating to the object's name
     *this method updates the description from initial null status and must 
     *be used at object initialization to prevent null return.
     */    
    private void setDescription()
    {
        description = null;
    }
    
    /**
     * gets description String for item.
     * @return description of item.
     */    
    private int getLocation()
    {
        return location;
    }
    
    /**
     * Sets the location of the item by checking room's location
     */    
    private void setLocation()
    {
    }    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    
    
}

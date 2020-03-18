import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
/**
 * Player class is created at game launch and acts as the player's avatar.
 * The player will have an inventory which will hold items. 
 * tells item it is being held
 * if holding item can use
 * the items will have a limit until weaing back pack
 * The player will be able to check which room it is in. 
 * 
 * @author Matthew Sheehan  
 * @version 3/17/2020
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int itemLimit;
    private int itemsHeld;
    private int currentRoom;
    private HashSet<Items> Inventory;
    private boolean haveBackpack;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        currentRoom = 1; //Starting Room Number 1
        itemsHeld = 0; //Start with no items being held
        itemLimit = 2; // can only hold 2 items until a backpack
        haveBackpack = false; //no backpack at stat
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {

    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod2(int y)
    {

    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod3(int y)
    {

    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod4(int y)
    {
    
    }
}

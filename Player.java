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
    private Room currentRoom;
    private HashSet<Items> Inventory;
    private boolean haveBackpack;

    /**
     * Constructor for objects of class Player
     * @param room  starting location of room object for player
     */
    public Player(Room room)
    {
       Inventory = new HashSet<Items>();
       currentRoom = room; //Starting Room Number 1
        itemsHeld = 0; //Start with no items being held
        itemLimit = 1; // can only hold 2 items until a backpack
        haveBackpack = false; //no backpack at start
    }
    
    //Room functionality: ***********************
    /**
     * current room player is in
     * @return current room
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * set current room player is in
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    
    
    //Backpack Functionality: ****************************
    /**
     * Reflect player picking up backpack
     * haveBackpack = true
     */
    public void getBackpack()
    {
        itemLimit = 3;
        haveBackpack = true;
    }   
    
    /**
     * Reflect player dropping backpack
     * haveBackpack = true
     */
    public void dropBackpack()
    {
        itemLimit = 1;
        haveBackpack = false;
    }
    
    /**
     * is Player wearing backpack?
     * @return haveBackPack 
     */
    public boolean haveBackpack()
    {
        return haveBackpack;
    }
    
    
    //Item Functionality: ****************
    /**
     * Return a string describing the player's items, for example
     * "Items you are holding: lamp, rock".
     * @return Lists room's items or "You are not holding any items".
     */
    private String getItemsString()
    {
        String returnString ="";
        if(Inventory.isEmpty()){
            returnString = "You are not holding any items";
        } else {
            returnString = "Items you are holding:";
            String temp = "";
            for(Items item : Inventory) {
                temp += ", " + item.getName() ; 
            }
            returnString += temp.substring(1);
        }
        return returnString;
    }
    
    /**
     * Check to see if Item is on player
     * @param  item     an Items object
     */
    public boolean haveItem(Items item)
    {
        boolean haveItem = Inventory.contains(item);
        return haveItem;
    }
    
    /**
     * take item and place into Inventory
     * @param  item     an Items object
     */
    public void takeItem(Items item)
    {
        if(!haveItem(item) || currentRoom.haveItem(item)){
            Inventory.add(item);
            currentRoom.removeItem(item);
        }
    }
    
    /**
     * Drop item and remove from Inventory. 
     *
     * @param  item     an Items object
     */
    public void dropItem(Items item)
    {
        if(haveItem(item))
        Inventory.remove(item);
        currentRoom.addItem(item);
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

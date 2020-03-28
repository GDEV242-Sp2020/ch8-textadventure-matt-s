import java.util.Set;
import java.util.HashMap;
import java.util.Map;

import java.util.Stack;

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
    private int itemLimit; //max carry
    private int itemsHeld;
    private Room currentRoom;
    private HashMap<String, Items> Inventory; //key is String. value is Items
    
    private Stack<Room> roomHistory;
    
    //specific item using   == might need refactoring.
    private boolean haveBackpack;
    private boolean usingFlashlight;
    

    /**
     * Constructor for objects of class Player
     * @param room  starting location of room object for player
     */
    public Player(Room room)
    {
       Inventory = new HashMap<String, Items>();
        currentRoom = room; //Starting Room Number 1
        itemsHeld = 0; //Start with no items being held
        itemLimit = 2; // can only hold 2 items until a backpack
        Inventory = new HashMap<String, Items>();
        
        roomHistory = new Stack<Room>();
        
        haveBackpack = false; //no backpack at start
        usingFlashlight = false;
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
        roomHistory.push(currentRoom); //this adds room to history log before changing currentRoom
        currentRoom = room; //changes the currentRoom to the new room player enters
    }
    
    
    
    
    //Item Functionality: ****************
    /**
     * Returns an item from inventory by name
     * @param name String of the item
     * @return the Items object with corresponding name
     */
    public Items getItem(String name)
    {
        return Inventory.get(name);
    }
    
    /**
     * Return a string describing the player's items, for example
     * "Items you are holding: lamp, rock".
     * @return Lists room's items or "You are not holding any items".
     */
    public String getItemsString()
    {
        String returnString ="";
        if(Inventory.isEmpty()){
            returnString = "You are not holding any items";
        } else {
            returnString = "Items you are holding:";
            String temp = "";
            for(Items item : Inventory.values()) {
                temp += ", " + item.getName() ; 
            }
            returnString += temp.substring(1);
        }
        return returnString;
    }
    
    /**
     * Check to see if Item is on player (contained in Inventory)
     * @param  item     an Items object
     */
    public boolean haveItem(Items item)
    {
        //boolean haveItem = Inventory.values().contains(item);
        return Inventory.containsValue(item);
    }
    
    /**
     * take item and place into Inventory
     * @param  item     an Items object
     */
    public void takeItem(Items item)
    {
        if(!haveItem(item) || currentRoom.haveItem(item)){
            if(itemsHeld >= itemLimit) 
                System.out.println("Inventory is full. Drop something first");
            else{
                Inventory.put(item.getName(), item);
                currentRoom.removeItem(item);
                itemsHeld ++; //inventory tracker +1
            }
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
        itemsHeld --; //inventory tracker -1
    }
    
    
    
    
    //BACKPACK
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
    
    
    
    
    //FLASHLIGHT
    /**
     * Flashlight check
     *
     * @return    flashlight state. On = true. Off = false.
     */
    public boolean isFlashlightON()
    {
        return usingFlashlight;
    }
    
    /**
     * Flashlight switch, flips to opposite. defaulted as false.
     * check isHeld is in actions.
     */
    public void flashlightSwitch()
    {
        usingFlashlight = !usingFlashlight;
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

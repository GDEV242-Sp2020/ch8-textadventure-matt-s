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
     * set current room player is in and log the room player left to roomHistory stack
     */
    public void setCurrentRoom(Room room)
    {
        addRoomHistory(currentRoom); //this adds room to history log before changing currentRoom
        currentRoom = room; //changes the currentRoom to the new room player enters
    }
    
    // room history
    public void addRoomHistory(Room currentRoom)
    {
        roomHistory.push(currentRoom);
    }
    
    /**
     * The last room player was in
     * @return Room the last room entered from roomStack 
     */
    public Room getLastRoom() // from my understanding this pops the last entry and replaces it with the one before
    { // might need a if test to prevent a null return and say there are no rooms previous.
        Room room = roomHistory.pop();
        return room;
    }
    
    
    //Item Functionality: ****************
    /**
     * Returns room left in inventory
     * @return int inventory space left.
     */
    public int numSpaceLeft()
    {
        
        return itemLimit - itemsHeld;
    }
    
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
     * @return true if item picked up, false otherwise
     */
    public boolean takeItem(Items item)
    {   
        boolean itemTaken = false;
        if(!haveItem(item) && currentRoom.haveItem(item)){ //if item in room not inventory
            if(!item.canBeHeld()){ // if item can't be held
                System.out.println ("This item can not be picked up");
            }else if(itemsHeld >= itemLimit) { //item can be held but not enough space
                    System.out.println("Inventory is full. Drop something first");
            }else{ //item can be held and there is space in inventory
                Inventory.put(item.getName(), item);
                //currentRoom.removeItem(item);  //responsibility for this is in cmd_take
                itemsHeld ++; //inventory tracker +1
                itemTaken = true;
            }
        }
        return itemTaken;
    }
    
    /**
     * Drop item and remove from Inventory. 
     *
     * @param  item     an Items object
     * @return true if item dropped, false otherwise
     */
    public boolean dropItem(Items item)
    {
        boolean itemDropped = false;
        if(haveItem(item) && !currentRoom.haveItem(item)){ //if item in inventory not room
            
                Inventory.remove(item.getName(), item);
                //currentRoom.removeItem(item);  //responsibility for this is in cmd_take
                itemsHeld --; //inventory tracker -1
                itemDropped = true;
            
        }
        return itemDropped;
        //if(haveItem(item))
        //Inventory.remove(item);
        //itemsHeld --; //inventory tracker -1
    
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

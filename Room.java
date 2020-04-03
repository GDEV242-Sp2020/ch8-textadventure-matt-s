import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Matthew Sheehan
 * @version 3/17/2020
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashSet<Items> roomItems;
    private boolean isDark;//stores the items in this room
    private ArrayList<NPC> npcs; //Non Player Characters list
    private Items reqKey; // required key for room
    private boolean isLocked;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String quickDescription) 
    {
        this.description = quickDescription;
        exits = new HashMap<String, Room>();
        isDark = false;  //all rooms start with light
        roomItems = new HashSet<Items>(); //container to track items in room.
        npcs = new ArrayList<NPC>();
        reqKey = null;
        isLocked = false; 
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String printLocationInfo()
    {
        return "You are " + description + ".\n" +getItemsString() + ".\n" + getExitString();
    }
    
    /** 
     *  DOES THIS METHOD GET USED? 
     * 
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     *
    public String leaveRoom()
    {

        return "You are " + description + ".\n"
                + getItemsString() +". \n"
                + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    //Locked Room Functionality
    /**
     * State of room access, locked or open
     * @param key A key to open the door. default is null. will this be overridden in specialty child classes?
     * @return unlocked 
     * True door is open 
     * False door is locked
     */
    public boolean setUnlock(Items key)
    {
        if(this.reqKey.equals(key)){
            isLocked = false;
            return true; //if the key provided equals key set to room
        }else{ 
            return false; //key given doesnt open door
        } 
    }

    /**
     * Key needed to unlock this door
     * @return Items key required to open door.
     * null by defualt. overRidden in specialty child classes
     */
    public Items getReqKey()
    {
        return reqKey; //default of no item needed to open this door.
    }
    
    /**
     * assigns a new key to the room. can only have one key per room
     * @param Items key used to unlock room.
     */
    public void setReqKey(Items key)
    {
        isLocked = true;
        this.reqKey = key;
    }
    
    /**
     * gets isLocked state
     * @return boolean isLocked
     */
    public boolean isLocked()
    {
        return isLocked;
    }
    
    
    
    //Item Functionality *********************
    
    /**
     * Check to see if this roomItems has specific item
     * @param  item     an Items object
     */
    public boolean haveItem(Items item)
    {
        boolean haveItem = roomItems.contains(item);
        return haveItem;
    }
    
    /**
     * adds objects of Items to room
     * @param item an Items object to be added to the room.
     */
    public void addItem(Items item)
    {
        roomItems.add(item);
    }
    
    /**
     * adds objects of Items to room
     * @param item an Items object to be added to the room.
     */
    public void removeItem(Items item)
    {
        roomItems.remove(item);
    }
    
    /**
     * Searches room for item with a specific name
     * @param name String of item to be returned
     * @return Items object from roomItems set or null if not found.
     */
    public Items getItem(String name)
    {
        for(Items item : roomItems){
                if(item.getName().equals(name))
                    return item;
            }   
        return null;
    }
    
    /**
     * Return a string describing the room's items, for example
     * "Items in room: lamp, rock".
     * @return Lists room's items or "There are no items in this room".
     */
    private String getItemsString()
    {
        String returnString ="";
        if(roomItems.isEmpty()){
            returnString = "There are no items in this room";
        } else {
            returnString = "Items in room:";
            String temp = "";
            for(Items item : roomItems) {
                temp += ", " + item.getName() ; 
            }
            returnString += temp.substring(1);
        }
        return returnString;
    }
    
    // Is Dark Functionality *************
    public boolean isDark(){ //getter for isDark
        return isDark;   
    }
    
    public void setDarkTRUE(){
        isDark = true;
    }
    
    public void setDarkFalse(){
        isDark = false;
    }
    
    
    
    //NPC Functionality ****************

    /**
     * Check to see if this roomItems has specific item
     * @param  item     an Items object
     */
    public boolean haveNPC(Items item)
    {
        boolean haveItem = roomItems.contains(item);
        return haveItem;
    }
    
    /**
     * add NPC of Items to room
     * @param item an Items object to be added to the room.
     */
    public void addNPC(NPC npc)
    {
        npcs.add(npc);
    }
    
    /**
     * remove NPC from room's arraylist of npcs
     * @param item an Items object to be added to the room.
     */
    public void removeNPC(NPC npc)
    {
        npcs.remove(npc);
    }
    
    /**
     * Searches room for NPC with a specific name
     * @param name String matched to NPC object to be returned
     * @return NPC object null if not found.
     */
    public NPC getNPC(String name)
    {
        for(NPC npc : npcs){
                if(npc.getName().equals(name))
                    return npc;
            }   
            
            
        System.out.println("nobody with that name is in this room");
        return null;
    }
    
    /**
     * Return a string listing all the characters in the room
     * "You see 1 person: a man in a hat".
     * @return Lists room's items or "There are no items in this room".
     */
    public String getNPCString()
    {
        if (npcs.size() == 0) { //nobody here
                return "There's no one else here besides you";
        } else if (npcs.size() == 1) { // 1 npc here
                String returnString = "You see 1 person: ";                
                for(NPC chars : npcs) {
                    returnString += " " + chars.getName();
                }
                return returnString;  
        } else { // more than 1 npc here
                String returnString = "You see "+npcs.size()+" people: ";                
                for(NPC chars : npcs) {
                    returnString += " " + chars.getName();
                }
                return returnString;  
        }
    }
}

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

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
    private HashSet<Items> roomItems;   //stores the items in this room
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        roomItems = new HashSet<Items>();
        
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
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
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
    
    //Item Functionality *********************
    
    /**
     * Check to see if this roomItems has item
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
    
}

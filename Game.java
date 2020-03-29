
import java.util.*;

import java.util.HashSet;

/**
 *  This class is the main class of the hotel escape game. 
 *  
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @ Matt Sheehan & Macelle Tamegnon
 * @ 2020/03/19
 */
public class Game 

{
    Room outside,staffRoom ,kitchen,hallway1,hallway2;
    Room stairwell, parking1,parking2,roof,swimmingPool,elevator,restaurant;
    Room stairwell2,stairwell3,occupiedRoom,lobby,hallway3,hallway4;
    Room elevator1,elevator2, room1,room3,room4;
    
    private Room currentRoomG;
    private Room previousRoom;
    private Stack<Room> roomStack;
    private int roomCounter; // player can only evade and stay away from exit for so long before game loss.
    
    public Parser parser;
    private Player player; // public so other classes can react on Player through Game
    
    private Message message; //This message objects holds as much of the long text as possible
    private Room startLocation; //allows player to be created in constructor
    public Items flashlight, rock, map, backpack;
    public HashSet<Items> GameItems;
    
    boolean wantToQuit = false;
    
    //declare rooms here so they can be used game wide
    

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        Stack<Room> roomStack = new Stack<Room>();
        GameItems = new HashSet<Items>();
        message = new Message(player);
        createRooms();
        
        player = new Player(startLocation);  // start in the hallway2(number 12 in the google docs)
        
        
        createValidCommands();
        
        
        
    }
    
    // Still working on room history
    public void pushRoomHistory(Room currentRoom)
    {
        roomStack.push(currentRoom);
    }
    
    
    /**
     * Allows Game's Player object to be accessed elsewhere in package
     @
    */
    public Player player()
    {
    return player;
    }
    
    /**
     * This method allows Game's Player's Room object to be accessed elsewhere in package
     * @return Room Player's room object
     */
    public Room getCurrentRoom()
    {
        return player.getCurrentRoom();
    }
    
    /**
     * Set Game's Player's Room object to be accessed elsewhere in package
     * @param Room Room object used to set Player's current room
     */
    public void setCurrentRoom(Room room)
    {
        player.setCurrentRoom(room);
        //currentRoom = room;
    }
    
    // public  void updateCurrentRoom()
    // {
        // currentRoom = player.getCurrentRoom();
    // }
    
    /**
     * Create all the room objects and initialize all of their characteristics.
     * then create and place a player in a room.
     */
    private void createRooms()
    {
        /**
         * Initialize Rooms Here.  To add a Room declare, initialize, after all init's use methods.
         * room = new Room("Room Description string")
         * methods:
         * setExit("Exit", room) - "Exit": one word String Command, room: object in that direction.
         * setDarkTRUE(); setDarkFALSE(); changes dark boolean, default is false.
         */
        
        outside = new Room(" outside the main entrance of the Hotel.");
        
        lobby= new Room("currently in the" +  
                        "first room of hotel from the main entrance.");
        staffRoom = new Room("in the staff room. look carefully for"+
                    "the hiden back pack.It could be helpful!");
        kitchen = new Room("in the kitchen behind the restaurant with"+ 
        "there only one exits to the restaurant.");
    
        hallway1 = new Room(" in the hallway on the rigth on the first floor");
        hallway2= new Room("in the main hallway of the first floor.");
        hallway3 = new Room("in the hallway on the rigth on the second floor.");
        hallway4= new Room(" in the main hallway of the second floor.");
        
        stairwell = new Room("now  on the stairweel that leads to the first floor");
        stairwell2 = new Room("now on the stairweel that leads to the second floor");
        stairwell3 = new Room("nowon the stairweel that leads to the roof");
        roof = new Room("you're on the roof of the hotel.");
        
        parking1 = new Room("on first floor parking");
        parking2 = new Room("on second floor parking");
       
        swimmingPool = new Room("in the room on the second floor that holds the swimmingpool");
        swimmingPool.setDarkTRUE();
        
        elevator1 = new Room("in the elevator that goes from restaurant to hallway1");
        elevator2 = new Room("in the other elevator that goes from hallway1 to hallway3");
        restaurant = new Room(" in the hotel restaurant.");
        
        //NOTE want to create rooms that cant be accessed. 
        occupiedRoom = new Room("in a hotel room that seems occupied");
        
        room1 = new Room("in first empty room on the first floor");
        room3 = new Room("in second empty room on the  first floor next to stairwell1");
        room4 = new Room("in first room on the second floor that is next to hallway3");
        
        //place all items in all the rooms
        createItems();
        
        // initialise room exits
        outside.setExit("east", restaurant);
        outside.setExit("south", lobby);
        outside.setExit("west", stairwell);

        lobby.setExit("north",outside);
        
        staffRoom.setExit("north",stairwell );
        staffRoom.setExit("east",lobby);
        
        kitchen.setExit("north", restaurant);
        
        hallway1.setExit("south",elevator1);
        hallway1.setExit("east", parking1);
        hallway1.setExit("west", room1);
        
        hallway2.setExit("east", stairwell2);
        hallway2.setExit("north", occupiedRoom);
        hallway2.setExit("south", room3);
        
        hallway3.setExit("south",elevator2);
        hallway3.setExit("east",parking2);
        hallway3.setExit("west",room4);
        
        hallway4.setExit("east", stairwell3);
        hallway4.setExit("north", roof);
        hallway4.setExit("south", swimmingPool);
        
        stairwell.setExit("west",lobby);
        stairwell.setExit("south",staffRoom);
        stairwell.setExit("up", stairwell2);
        
        stairwell2.setExit("west", hallway2);
        stairwell2.setExit("north", stairwell3);        
        stairwell2.setExit("down", stairwell);
        
        stairwell3.setExit("west", hallway4);
        stairwell3.setExit("down", stairwell2);
        
        swimmingPool.setExit("north", hallway4);
        
        roof.setExit("south", hallway4);
        
        parking1.setExit("west", hallway1);
        
        parking2.setExit("west", hallway3);
        
        elevator1.setExit("south", restaurant);
        elevator1.setExit("north", hallway1);
        
        elevator2.setExit("south", hallway1);
        elevator2.setExit("north", hallway3);
        
        occupiedRoom.setExit("south", hallway2);
        
        room1.setExit("east", hallway1);
        
        room3.setExit("north", hallway2);
        
        room4.setExit("east", hallway3);
        
        //currentRoom = hallway2;// start in the hallway2(number 12 in the google docs)
        //previousRoom = hallway2;
    

        startLocation = hallway2;

        
    }
    
    /**
     * Create game commands to be held in a CommandWords object
     * each command is added using commands.addCommand method.
     * each command is stored as a HashMap where 
     *          key is a String,
     *          value is a Command object
     * 
     * addcommands.addCommand(param1, param2) 
     * param1 is String, param2 is a new specific object command extended class.
     * example: commands.addCommand("go", new GoCommand(player));
     */
    private void createValidCommands()
    {
        CommandWords commands = parser.getCommands();
        
        //Universal Game Commands
        commands.addCommand("quit", new cmd_Quit()); 
        commands.addCommand("help", new cmd_Help(commands));   
        
        //Basic Player Actions
        commands.addCommand("go", new cmd_Move(player));
        commands.addCommand("look", new cmd_Look(player));
        commands.addCommand("unlock", new cmd_Unlock(player));
        commands.addCommand("back", new cmd_Back(player));
        
        //Character Interaction
        commands.addCommand("give", new cmd_Give(player));
        commands.addCommand("throw", new cmd_Throw(player));
        
        //Item Commands
        commands.addCommand("inventory", new cmd_Items(player));
        commands.addCommand("take", new cmd_Take(player));
        commands.addCommand("drop", new cmd_Drop(player));
        
    }
    
    /**
     * Create all the items and place them in their starting rooms.
     * Items methods: set/getName ; set/getDescription ; isHeld setBeingHeld setNotBeingHeld
     */
    private void createItems()
    {
        flashlight = new Items("flashlight");
        flashlight.setDescription(message.itemDescription(flashlight));
        flashlight.setCanHoldTo(true);
        GameItems.add(flashlight);
        occupiedRoom.addItem(flashlight);
        
        rock = new Items("Rock");
        GameItems.add(rock);
        
        map = new Items("Map");
        GameItems.add(map);
        
        backpack = new Items("BackPack");
        GameItems.add(backpack);
    }
    
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
    
        message.printWelcome();
    
            // Enter the main command loop.  Here we repeatedly read commands and
            // execute them until the game is over.
        boolean finished = false;
            while (! finished) {
                
                Command command = parser.getCommand(); // gets new command
                
                finished = processCommand(command);     // runs boolean check while decripting commandWord
            }
            System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * A check for wantToQuit status.
     */
    private boolean wantToQuit()
    {
        return wantToQuit;
    }
    /**
     * Changes boolean wantToQuit to true
     */
    public void setQuit(){ wantToQuit = true;}
    
    /**
     * executes unique action method depending on the cmd_* class called.
     */
    private boolean processCommand(Command command)
    {
        
        command.action();
        return command.wantToQuit(); // Overridden in cmd_Quit so when thats launched return true
        
        /** 
           **** This was the old way. Keeping only until everything works without it. ****
         * switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
            
            case DESCRIBE:
            case LOOK:
                lookAround(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case TAKE:
                takeItem(command);
                break;
                
            case USE:
                useItem(command);
                break;
                
            case THROW:
                throwItem(command);    
            case DROP:
                dropItem(command);
                break;
                
            case INVENTORY:
                showInventory();
                break;
                
            }
        return wantToQuit;        
        **/

    }

    
    
    // /** 
     // * Try to go in one direction. If there is an exit, enter the new
     // * room, otherwise print an error message.
     // */
     // public void goRoom(Command command) 
     // {
         // if(!command.hasSecondWord()) {
            // // if there is no second word, we don't know where to go...
            // System.out.println("Go where?");
            // return;
        // }


        // String direction = command.getSecondWord();

        // // Try to leave current room.

        // Room nextRoom = player.getCurrentRoom().getExit(direction);
        
       // if (nextRoom == null) {
            // System.out.println("There is no door!");
        // }
        // else
        // {
           // //previousRoom = currentRoom;
           // // = nextRoom;
           // player.setCurrentRoom(nextRoom);
           // System.out.println(player.getCurrentRoom().printLocationInfo());
        // }
     // }   
    }
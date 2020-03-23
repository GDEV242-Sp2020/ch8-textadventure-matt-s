
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

    private Room currentRoom;
    private Room previousRoom; 
    private Stack<Room> rooms;
    public Parser parser;
    public static Player player; // public so other classes can react on Player through Game
    private Message message;
    private Room startLocation; //allows player to be created in constructor
    public HashSet<Items> GameItems;
    
    //declare rooms here so they can be used game wide
    Room outside,staffRoom ,kitchen,hallway1,hallway2;
    Room stairwell, parking1,parking2,roof,swimmingPool,elevator,restaurant;
    Room stairwell2,stairwell3,occupiedRoom,lobby,hallway3,hallway4;
    Room elevator1,elevator2, room1,room3,room4;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        GameItems = new HashSet<Items>();
        createRooms();
        createItems();
        player = new Player(currentRoom);  // start in the hallway2(number 12 in the google docs)
        parser = new Parser();
        message = new Message();
        rooms = new Stack<Room>();
    }
    
    
    /**
     * This method allows Game's Player object to be accessed elsewhere in package
     */
    static public Player player()
    {
    return player;
    }
    
    
    /**
     * Create all the room objects and link their exits together and
     * then create and place a player in a room.
     */
    private void createRooms()
    {
        //create the rooms
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
        elevator1 = new Room("in the elevator that goes from restaurant to hallway1");
        elevator2 = new Room("in the other elevator that goes from hallway1 to hallway3");
        restaurant = new Room(" in the hotel restaurant.");
        
        occupiedRoom = new Room("you can't open this door the room is occupied");
        room1 = new Room("in first empty room on the first floor");
        room3 = new Room("in second empty room on the  first floor next to stairwell1");
        room4 = new Room("in first room on the second floor that is next to hallway3");

        
        //initialise room exits
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
        
        hallway2.setExit("west", stairwell2);
        hallway2.setExit("north", occupiedRoom);
        hallway2.setExit("south", room3);
        
        hallway3.setExit("south",elevator2);
        hallway3.setExit("east",parking2);
        hallway3.setExit("west",room4);
        
        hallway4.setExit("west", stairwell3);
        hallway4.setExit("north", roof);
        hallway4.setExit("south", swimmingPool);
        
        stairwell.setExit("east",lobby);
        stairwell.setExit("south",staffRoom);
        
        stairwell2.setExit("west", hallway2);
        stairwell2.setExit("north", stairwell3);
        
        stairwell3.setExit("north", roof);
        
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
        
        currentRoom = outside;// start in the hallway2(number 12 in the google docs)
        previousRoom = currentRoom ;
    

        //startLocation = hallway2;


    }
   
    
    /**
     * Create all the items and place them in their starting rooms.
     * Items methods: set/getName ; set/getDescription ; isHeld setBeingHeld setNotBeingHeld
     * 
     */
    private void createItems()
    {
        Items flashlight, rock, map, backpack;
        
        flashlight = new Items("flashlight");
        flashlight.setDescription(new Message().itemDescription(flashlight));
        occupiedRoom.addItem(flashlight);
        GameItems.add(flashlight);
        
        
        rock = new Items("Rock");
        GameItems.add(rock);
        
        map = new Items("Map");
        GameItems.add(map);
        
        backpack = new Items("BackPack");
        GameItems.add(backpack);
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) 
    {
       boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

         switch (commandWord) {
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
                
            case THROW:
                throwItem(command);    
            case DROP:
                dropItem(command);
                break;
                
            case INVENTORY:
                showInventory();
                break;
            case BACK:
                goBack();
                break;
        }
        return wantToQuit;
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     *  Enter the main command loop.  Here we repeatedly read commands and
        execute them until the game is over.
     */
    public void play() 
    {            
        message.printWelcome();
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
     private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.printLocationInfo());
        }
    }
    
     private void lookAround(Command command) 
     {
         System.out.println(currentRoom.printLocationInfo());
    }
    
    /**
     * Goes back to the previous room
     */
    private boolean goBack()
    {
       if (previousRoom == null) {
            System.out.println("There is no door!");
            return false;
        }
        // back one room
       currentRoom =  previousRoom;
       System.out.println("You went back!");
       System.out.println("And now" + currentRoom.printLocationInfo() );
       return true;

    }

    /**
     * Player looks around and describes room.
     * Prints long description of current room
     * 
     * @param command given from player
     */
    private void takeItem(Command command)
    {
        System.out.println("Takes Items");
    }
    
    /**
     * Player looks around and describes room.
     * Prints long description of current room
     * 
     * @param command given from player
     */
    private void throwItem(Command command)
    {
        System.out.println("Throws Items");    
    }
    
    /**
     * Player looks around and describes room.
     * Prints long description of current room
     * 
     * @param command given from player
     */
    private void dropItem(Command command)
    {
        System.out.println("Drops Items");    
    }
    
    /**
     * Player looks around and describes room.
     * Prints long description of current room
     * 
     * @param command given from player
     */
    private void showInventory()
    {
           for(Items items : GameItems){
            System.out.print(items.getName()+ "  \n");    
        }
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
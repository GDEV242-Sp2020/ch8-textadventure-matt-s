import java.util.HashSet;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Matthew Sheehan
 * @version 3/18/2020
 */
public class Game 
{
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
        player = new Player(startLocation);  // start in the hallway2(number 12 in the google docs)
        parser = new Parser();
        message = new Message();
        
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
        
        
        // create the rooms
        outside = new Room("outside the main entrance of the Hotel");
        lobby= new Room("first room of hotel from the main entrance");
        staffRoom = new Room("room at one end of the lobby reserved for staff");
        kitchen = new Room("located behind the restaurant with back door exit");
    
        hallway1 = new Room("hallway 1 on the first floor");
        hallway2= new Room("hallway 2 on the first floor");
        hallway3 = new Room("hallway 1 on the second floor");
        hallway4= new Room("hallway 2 on the second floor");
        
        stairwell = new Room("to the first floor");
        stairwell2 = new Room("the first to second");
        stairwell3 = new Room("leads to the roof");
        roof = new Room("third floor above the second floor");
        
        parking1 = new Room("first floor parking");
        parking2 = new Room("Second floor parking");
       
        swimmingPool = new Room("room on the second floor");
        
        elevator1 = new Room("elevator from restaurant to hallway1");
        elevator2 = new Room("hallway1 to hallway3");
        
        restaurant = new Room("room at the left of the lobby with two exits");
        
        occupiedRoom = new Room("second floor room occupied");
        room1 = new Room("first room on the first floor");
        room3 = new Room("second floor room next to stairwell1");
        room4 = new Room("second floor room next to hallway3");
        
        
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

        startLocation = hallway2;

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
            finished = new Actions().processCommand(command);     // runs boolean check while decripting commandWord
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    
    // /**
     // * Given a command, process (that is: execute) the command.
     // * @param command The command to be processed.
     // * @return true If the command ends the game, false otherwise.
     // */
    // private boolean processCommand(Command command) 
    // {
        // boolean wantToQuit = false;

        // CommandWord commandWord = command.getCommandWord();

        // switch (commandWord) {
            // case UNKNOWN:
                // System.out.println("I don't know what you mean...");
                // break;

            // case HELP:
                // printHelp();
                // break;

            // case GO:
                // goRoom(command);
                // break;
                
            // case LOOK:
                // lookAround(command);
                // break;

            // case QUIT:
                // wantToQuit = quit(command);
                // break;
        // }
        // return wantToQuit;
    // }
    // // implementations of user commands:

    // /**
     // * Print out some help information.
     // * Here we print some stupid, cryptic message and a list of the 
     // * command words.
     // */
    // private void printHelp() 
    // {
        // message.printHelp();
        // parser.showCommands();
    // }

    
    // /** 
     // * Try to go in one direction. If there is an exit, enter the new
     // * room, otherwise print an error message.
     // */
    // private void goRoom(Command command) 
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
        // else {
            // player.setCurrentRoom(nextRoom);
            // System.out.println(player.getCurrentRoom().getLongDescription());
        // }
    // }
   
    
    // /**
     // * Player looks around and describes room.
     // * Prints long description of current room
     // * 
     // * @param command given from player
     // */
    // private void lookAround(Command command) 
    // {
        // System.out.println(player.getCurrentRoom().getLongDescription());
    // }

    
    // /** 
     // * "Quit" was entered. Check the rest of the command to see
     // * whether we really quit the game.
     // * @return true, if this command quits the game, false otherwise.
     // */
    // private boolean quit(Command command) 
    // {
        // if(command.hasSecondWord()) {
            // System.out.println("Quit what?");
            // return false;
        // }
        // else {
            // return true;  // signal that we want to quit
        // }
    // }
}
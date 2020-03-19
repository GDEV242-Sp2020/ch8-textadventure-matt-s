


import java.util.*;
/**
 *  This class is the main class of the hotel escape game. 
 *  
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @ Matt Sheehan & Macelle Tamegnon
 * @ 2020/03/19

 * @author  Matthew Sheehan
 * @version 3/18/2020

 */

public class Game 

{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom; 
    private Stack<Room> roomStack;
    private Player player;
   
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        
        createRooms();
        
        createItems();
        parser = new Parser();
        
    }

    /**
     * Create all the rooms and link their exits together and
     * then create and place a player in a room.
     */
    private void createRooms()
    {
        Room outside,staffRoom ,kitchen,hallway1,hallway2;
        Room stairwell, parking1,parking2,roof,swimmingPool,elevator,restaurant;
        Room stairwell2,stairwell3,occupiedRoom,lobby,hallway3,hallway4;
        Room elevator1,elevator2, room1,room3,room4;
        // create the rooms
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
        
        currentRoom = room3;// start in the hallway2(number 12 in the google docs)
        previousRoom = hallway2;
    

    player = new Player(hallway2);  // start in the hallway2(number 12 in the google docs)

  }
    
    
    /**
     * Create all the items and place them in their starting rooms.
     */
    private void createItems()
    {
        Items flashlight, rock, map, backpack;
        
        flashlight = new Items("FlashLight");
        rock = new Items("Rock");
        map = new Items("Map");
        backpack = new Items("BackPack");
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Escape the hotel game!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();

        System.out.println(currentRoom.printLocationInfo());

        System.out.println(player.getCurrentRoom().printLocationInfo());

    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
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
                
            case LOOK:
                look(command);
                break;
                
            case BACK:
                goBack();
                break;
                
            case MARK: 
                 setRoom(currentRoom); 
                 break;
            /*case BACK:
                back(command);
                break;*/
                
            case STACKBACK:
                stackBack(command);
                break;
                

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

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

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
     // if there is no second word, we don't know where to go...
      if(!command.hasSecondWord()){
         System.out.println("Go where?");
         return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.

        Room nextRoom = currentRoom.getExit(direction);
       if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else
        {
           previousRoom = currentRoom;
           currentRoom = nextRoom;
           System.out.println(currentRoom.printLocationInfo());
        }
     }
    
     private void look(Command command) 
     {
        if (command.hasSecondWord())
        { 
        System.out.println("look what?");  
        return;
      }
        System.out.println(currentRoom.printLocationInfo());
        }
     
        private void back(Command command) 
     {
      if (command.hasSecondWord())
        { 
        System.out.println("Back what?");  
        return;
      }
     
      if (previousRoom == null) {
            System.out.println("Sorry, cannot go back!");
            return;
        }
        roomStack.push(currentRoom);
        Room temp = currentRoom;
        currentRoom = previousRoom;
        previousRoom = temp;
        System.out.println("You gone back to the previous Room.");
        System.out.println("And now" + currentRoom.printLocationInfo() );
     }
     
     private void stackBack(Command command)
     {
         if (command.hasSecondWord())
        { 
          System.out.println("sackBack what?");  
           return;
        }
        
        if (previousRoom == null) {
            System.out.println("Sorry, cannot go stackback!");
            return;
        }
        previousRoom = currentRoom;
        roomStack.push(currentRoom);
        currentRoom = roomStack.pop();
        System.out.println("You have gone Stack back");
        System.out.println("And now" + currentRoom.printLocationInfo() );
     }
        
     private void setRoom(Room room) 
    {
        previousRoom = currentRoom;
        System.out.println("You were went back and now");
     }
    
    private boolean goBack()
    {
       if (previousRoom == null) {
            System.out.println("There is no door!");
            return false;
        }
       currentRoom =  previousRoom;
       System.out.println("You went back!");
       System.out.println("And now" + currentRoom.printLocationInfo() );
       //return true;
    
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().printLocationInfo());
        }
    }
   
    
    /**
     * Player looks around and describes room.
     * Prints long description of current room
     * 
     * @param command given from player
     */
    private void lookAround(Command command) 
    {
        System.out.println(player.getCurrentRoom().printLocationInfo());

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

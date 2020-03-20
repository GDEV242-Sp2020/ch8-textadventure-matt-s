
/**
 * Write a description of class Actions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Actions extends Game
{
    private CommandWords commands;

    /**
     * Constructor for objects of class Actions
     */
    public Actions()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
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
        commands = new CommandWords();
        String tempCommandWords = commands.showAllString();
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(tempCommandWords);
    }

    
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
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
            System.out.print( items.getName()+ " ");    
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

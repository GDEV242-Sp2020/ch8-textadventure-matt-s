
/**
 * The help command prints information to aid the player progress through the game.
 * This is text that may be pulled up at any time through out the game.
 * 
 * This class extends Command and is called when player inputs the help command
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Help extends Command
{
    // instance variables - replace the example below with your own
    private CommandWords commands;

    /**
     * Constructor for objects of class CommandUnkown
     */
    public cmd_Help(CommandWords commands)
    {
        this.commands = commands;
    }
    
    
    /**
     * Action for cmd_Help
     * Prints basic text for the player to know simple boundaries of the game.
     * Lists out commands and explains surroundings.
     * 
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {        
        System.out.println("You are in a hotel. The moment you put down your bags you get a mysterious");
        System.out.println("call telling you that people are coming for you. There was no explanation");
        System.out.println("and perhaps no time to find out. These people seem dangerous. You need to");
        System.out.println("escape and do it quick. It seems like they are only a step behind. One wrong");
        System.out.println("move and they might get to you.");
        System.out.println("Your command words are:");
        System.out.println(commands.showAllString());
    }
}

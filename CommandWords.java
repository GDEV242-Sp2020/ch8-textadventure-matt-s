import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * A map of all the command words in the game is held here.
 *
 * @author Matthew Sheehan , Marcelle Tamegnon
 * @version 2020.03.23
 */

public class CommandWords
{
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, Command> validCommands;

    /**
     * Constructor for object CommandWords which will hold all the validCommands added at game start.
     * no longer found in an enum as old/base versions had.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, Command>(); // holds the commandWords
   
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or a new Unknown command object
     *         if it is not a valid command word.
     */
    public Command getCommand(String commandWord)
    {
        Command command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        }
        else {
            return new CommandUnknown(); // Creates CommandUnknown object
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    
    /**
     * Collects all valid commands to a String
     * @return member String of all valid commands
     */
    public String showAllString(){
        String m_validCommands ="";
        for(String command : validCommands.keySet()) 
        {
            m_validCommands += command + "  ";
        }
        return m_validCommands;
        
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        /**
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }*/
        System.out.println(showAllString());
        System.out.println();
    }
    
    /**
     * Add command Map Items to validCommands to later be accessed by player.
     * each command map item has key of a String and value of a Command object
     * @param keyWord key String used to call the value Command type object in Map validCommands
     * @param associatedCommand value Command type object in Map validCommands
     */
    public void addCommand(String keyWord, Command associatedCommand)
    {
        validCommands.put(keyWord,associatedCommand); //creates a new entry for a valid command
    }
}

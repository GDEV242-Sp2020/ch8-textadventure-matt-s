/**
 * 
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two parts: a CommandWord and a string
 * (for example, if the command was "take map", then the two parts
 * are TAKE and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 *
 * If the command had only one word, then the second word is <null>.
 *
 * This class is an abstract class of more specific command class extensions. 
 * Each Command Class will be specific to its action
 * 
 * 
 * @author  Matthew Sheehan and Marcelle Tamegnon
 * @version 2020.3.22
 */

public abstract class Command
{
    private CommandWord commandWord;
    private String secondWord;
    
    
    //No longer need a constructor. this class is now abstract and only frames what commands are.


    /**
     * Return the command word (the first word) of this command.
     * @return The command word.
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }
    
    /**
     * Sets the second word of the command so the child class can use the variable.
     */
    public void setSecondWord(String word2)
    {
        this.secondWord = word2;
    }
    
    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
    
    public boolean wantToQuit(){
        return false;
    }
    abstract public void action(); //abstract method unique to each command sub
}


/**
 * This class stores String messages 
 * and any methods which print to System.out
 * 
 * @author Matthew Sheehan
 * @version 3/19/2020
 */
public class Message
{
    // instance variables - replace the example below with your own
    private String flashlight;
    /**
     * Constructor initializes all the messages to strings which will be 
     * called in the get method. specifically descriptions
     */
    public Message()
    {
        //ITEM STRINGS:
        flashlight = "This flashlight is one of those heavy, powerful ones. Hopefully it has " 
                   + "enough battery life to serve its function. It's definitely heavy enough to "
                   + "incapacitate someone before grabbing me if I could get a good swing or throw";
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    /**
     * 
     */
    
    /**
     * itemDescription gets a string value for the item
     * @param item which is going to return as a string
     * @return the String value of each item sent in param
     */
    public String itemDescription(String item)
    {
        switch(item){
            
            case "flashlight": return flashlight; //returns field String init'ed in constructor
            
            
            
            
            default: return "No items with this name have a description.";
        
        }
        
    }
    
    /**
     * Print out the opening message for the player.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(Game.player().getCurrentRoom().getLongDescription());
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
}
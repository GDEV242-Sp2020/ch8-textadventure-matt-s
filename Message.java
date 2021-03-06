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
    private Player player;
    private String flashlight;
    private String rock;
    private String map;
    private String key;
    private String backpack;
    
    /**
     * Constructor initializes all the messages to strings which will be 
     * called in the get method. specifically descriptions
     */
    public Message(Player player)
    {
        this.player = player;
        //ITEM STRINGS:
        flashlight  = "This flashlight is one of those heavy, powerful ones. Hopefully it has " 
                    + "enough battery life to serve its function. It's definitely heavy enough to "
                    + "incapacitate someone before grabbing me if I could get a good swing or throw.";
        rock        = "not a very big rock, but something that I could maybe throw for distraction.";
        map         = "A fire exits map you. It got a little torn ripping it from its frame."
                    + "in the wall. It shows the only ways to get to the lower floors "
                    + "are through the stairs or elevator.";
        key         = "This key is metal and shiny. Hopefully unlocks an important door";
        backpack    = "Wearing this backpack should allow me to carry a couple more items";
        
         

    }
    
    /**
     * 
     */
    
    /**
     * itemDescription gets a string value for the item
     * @param item which is going to return as a string
     * @return the String value of each item sent in param
     */
    public String itemDescription(Items item)
    {
        switch(item.getName()){
            
            case "flashlight": return flashlight; //returns field String init'ed in constructor
            
            case "rock": return rock; 
            
            case "map" : return map;
            
            case "key" : return key;
            
            case "backpack" : return backpack;
            
            
            
            default: return "No items with this name have a description.";
        
        }
        
    }
    
    /**
     * Print out the opening message for the player.
     */
    public void printWelcome()
    {
        
        System.out.println();
        System.out.println("Escape from the Hotel");
        System.out.println("======================");
        System.out.println("As you arrive into your room that you just checked into, ");
        System.out.println("you place your bags down, and get a call on your phone. " );
        System.out.println("The number says UNKNOWN and while you normally wouldnt ");
        System.out.println("answer such a call, something urged you to answer anyway.");
        System.out.println("You hear heavy breathing at first. 'Get out!' the person on"); 
        System.out.println("the other line says");
        System.out.println("'I'm sorry what?' you reply, 'who is-'");
        System.out.println("They interrupt, 'Get out now! They are coming for you. They ");
        System.out.println("know you are on the second floor and just checked in. They will");
        System.out.println("be there in the next 90 seconds. Move quickly!");
        System.out.println("The phone line disconnects and now are stuck wondering why their");
        System.out.println("urgency is so believable, maybe you should leave the room and ");
        System.out.println("see if anyone truly is after you.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }
    
    public void setPlayer(Player player)
    {
        this.player = player;
    }
    public Player getPlayer()
    {
        return player;
    }
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        //parser.showCommands();
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
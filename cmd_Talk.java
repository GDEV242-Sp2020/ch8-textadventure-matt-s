 
import java.util.Arrays; 
import java.util.Random;
/**
 * Interacts with character in the room giving player an extra bit of dialogue
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Talk extends Command 
{

    private Player player;
    private NPC character;
    private Message message;
    private Command command;
    private Arrays npcs;
    private Random randomNpc;
    private NPC macy,ed,poppy,ava,guard1,guard2,guard3,guard4;
        
    /**
     * Constructor
     * @param Player current Player object
     */
    public cmd_Talk(Player player)
    {
       this.player = player;
       randomNpc = new Random();
       macy =new NPC("Macy");
       ed = new NPC("Ed");
       poppy = new NPC("Poppy");
        ava= new NPC("Ava");
        guard1 = new NPC("Pitt"); 
        guard2 = new NPC("FP");  
        guard3 = new NPC("Tallboy");  
        guard4 = new NPC("Doug");  
       Message message = new Message(player);
    }
    
    /**
     * Talks to current npc in room and prints dialogue for player to read and interact with.
     * 
     * This method performs the classes actions for Player in Game 
     * This abstract method from Command is contained in each command extension
     */
    public void action() 
    {
       
     // if (!hasSecondWord()) {
           // System.out.println("Talk to who? - try <character name>");
       // }
        NPC[] npcs = new NPC[8];
        npcs[0]= macy; npcs[4]=guard1;
        npcs[1]=ed; npcs[5]=guard2;
        npcs[2]=ava; npcs[6]=guard3;
        npcs[3]=poppy; npcs[7]= guard4;
        
       int index = randomNpc.nextInt(npcs.length);
        
        // Object name to search what to describe
        //boolean foundNpc; // Can talk to this NPC in the room?
        Room currentRoom = new Room("startLocation");
       currentRoom.getNPCString();
        
     if (hasSecondWord()){
        if (index == 0 || index == 1|| index == 2||index == 3){
         currentRoom.getNPCString();
         System.out.println("You asked "+ npcs[index]+ " Where is the bagpack?\n In the kitchen. Hurry" + npcs[index] + "replied");
         System.out.println("Thanks,you replied.");
         System.out.println("Well done you have found an ally and received an important piece of information.");
        }
         
        }
      else if (index == 4|| index == 5|| index == 6 || index ==7){
       
       System.out.println("You tried to get information from a guard, now you're dead. Next time," +
         " be more carefull to who you talk to.");
      wantToQuit();
     }
    }
    
    /**
     * Look at the room for an item with the given name and
     * show its description.
     * @return true if the item is found or false if it's not.
     */
    private boolean canTalkTo(String name)
    {
        NPC npc = player.getCurrentRoom().getNPC(name);
        if (npc != null) { // NPC exists in the room
            if(npc.canTalkTo())
                return true;
            else{
                System.out.println("You talked to " +name +". it was not helpful");
                return false;
            }
        }
        else {
            return false;
        }
    }
  }

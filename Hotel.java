import java.util.*;
/**
 * The Hotel is the Room controller for the game. 
 * The Rooms and Items in the hotel are created on initialization
 * This class is a mediator between the game processes and the objects of the game 
 *
 * @Matthew Sheehan
 * @version (a version number or a date)
 */
public class Hotel
{

    
    //Floors of the Hotel
    private HashMap<String,Room> Rooms;
    
    //floor 1
    private Room fl1_hallwayA, fl1_hallwayB, fl1_lobby, 
                fl1_stairs, fl1_elev;
    //floor 2
    private Room fl2_hallwayA, fl2_hallwayB, fl2_room208, fl2_room207, fl2_room206, 
                fl2_utilRoom, fl2_stairs, fl2_elev;
    //floor 3
    private Room fl3_hallwayA, fl3_hallwayB, fl3_room303, fl3_room304, fl3_swimmingPool, fl3_room306,
                fl3_utilRoom, fl3_stairs, fl3_elev;
    //floor 4
    private Room fl4_hallwayA, fl4_hallwayB, 
                fl4_utilRoom, fl4_stairs, fl4_elev;
    //floor 5
    private Room roof_outside,
                roof_stairs;
                
    //Room Control and State
    private Room currentRoom;
    private Room previousRoom;
    private Stack<Room> roomStack;
    private int roomCounter; // player can only evade and stay away from exit for so long before game loss.
    
    
    private Room playerStartLocation; //allows player to be created in constructor
    //Items in the hotel
    public Items flashlight, rock, map, backpack;
    
    
    public HashSet<Items> GameItems;    
    
    
    /** old Hotel Layout & Room Declare
    private Room outside,staffRoom ,kitchen,hallway1,hallway2;
    private Room stairwell, parking1,parking2,roof,swimmingPool,elevator,restaurant;
    private Room stairwell2,stairwell3,occupiedRoom,lobby,hallway3,hallway4;
    private Room elevator1,elevator2, room1,room3,room4;
    */

    

    /**
     * Constructor for objects of class Hotel
     */
    public Hotel()
    {
        
        //Room Control ********
        //Rooms collection
        HashMap<String,Room> Rooms = new HashMap<String, Room>();
        //Room History
        Stack<Room> roomStack = new Stack<Room>();
        createRooms();
        setRoomExits();

        //Items ********
        GameItems = new HashSet<Items>();
        createItems();
        
        
        setStartLocation(fl2_room208);
        
        roomCounter = 0;

    }
    

    public String getRoomInfo(Room room)
    {
        return room.printLocationInfo();
    }
    
    /**
     *Return start location for player
     */
    public Room getStartLocation()
    {
        return playerStartLocation;
    }
    /**
     *set start location for player
     *@param Room start location
     */
    public void setStartLocation(Room startLocation)
    {
        playerStartLocation = startLocation;
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    //plans to eventually move all room info to a txt file and load it on class initialize then sort here
    //commands to change hotel while making the game, not available to player
    //compile list of rooms 
    private void addRoom(Room room, String roomName)
    {
        
    }
    
    private void removeRoom()
    {
        
    }
    
    
    /**
     * Create all the room objects and initialize all of their characteristics.
     * 
     */
    private void createRooms()
    {
        //for(Room room : RoomsMap){ create each room }
        
    //Floor1    
        fl1_hallwayA = new Room("The first floor hallway to elevator.");
        fl1_hallwayB = new Room("The first floor hallway to stairwell."); 
        fl1_lobby = new Room("The hotel lobby.");
        fl1_stairs = new Room("The first floor stairwell platform.");
        fl1_elev = new Room("Elevator: First Floor.");
    //floor 2
        fl2_hallwayA = new Room("The second floor hallway to elevator.");
        fl2_hallwayB = new Room("The second floor hallway to stairwell.");
        fl2_room208 = new Room("Room 208.  The room you are paying for.");
        fl2_room207 = new Room("Room 207. This looks like someones room. Maybe a construction worker?");
        fl2_room206 = new Room("Room 206. Looks like an empty room.");
        fl2_utilRoom = new Room("The utility Room on the second floor.");
        fl2_stairs = new Room("The second floor stairwell platform.");
        fl2_elev = new Room("Elevator: Second Floor.");
    //floor 3
        fl3_hallwayA = new Room("The third floor hallway to elevator.");
        fl3_hallwayB = new Room("The third floor hallway to stairwell.");
        fl3_room303 = new Room("Room 303.");
        fl3_room304 = new Room("Room 304.");
        fl3_swimmingPool = new Room("The hotel's swimming pool."); 
        fl3_room306 = new Room("Room 306.");
        fl3_utilRoom = new Room("The utility Room on the third floor.");
        fl3_stairs = new Room("The third floor stairwell platform.");
        fl3_elev = new Room("Elevator: Third Floor.");
    //floor 4
        fl4_hallwayA = new Room("The fourth floor hallway to elevator.");
        fl4_hallwayB = new Room("The fourth floor hallway to stairwell.");
        fl4_utilRoom = new Room("The utility Room on the fourth floor.");
        fl4_stairs = new Room("The fourth floor stairwell platform.");
        fl4_elev = new Room("Elevator: Fourth Floor.");
    //floor 5
        roof_outside = new Room("Outside on the roof."); 
        roof_stairs = new Room("Roof access stairwell.");
        
        
        
        /**
         * OLD HOTEL LAYOUT
         * Initialize Rooms Here.  To add a Room declare, initialize, after all init's use methods.
         * room = new Room("Room Description string")
         * methods:
         * setExit("Exit", room) - "Exit": one word String Command, room: object in that direction.
         * setDarkTRUE(); setDarkFALSE(); changes dark boolean, default is false.
         *
        
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
        swimmingPool.setDarkTRUE();
        
        elevator1 = new Room("in the elevator that goes from restaurant to hallway1");
        elevator2 = new Room("in the other elevator that goes from hallway1 to hallway3");
        restaurant = new Room(" in the hotel restaurant.");
        
        //NOTE want to create rooms that cant be accessed. 
        occupiedRoom = new Room("in a hotel room that seems occupied");
        
        room1 = new Room("in first empty room on the first floor");
        room3 = new Room("in second empty room on the  first floor next to stairwell1");
        room4 = new Room("in first room on the second floor that is next to hallway3");
        
        //place all items in all the rooms
        createItems();
        
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
        
        hallway2.setExit("east", stairwell2);
        hallway2.setExit("north", occupiedRoom);
        hallway2.setExit("south", room3);
        
        hallway3.setExit("south",elevator2);
        hallway3.setExit("east",parking2);
        hallway3.setExit("west",room4);
        
        hallway4.setExit("east", stairwell3);
        hallway4.setExit("north", roof);
        hallway4.setExit("south", swimmingPool);
        
        stairwell.setExit("west",lobby);
        stairwell.setExit("south",staffRoom);
        stairwell.setExit("up", stairwell2);
        
        stairwell2.setExit("west", hallway2);
        stairwell2.setExit("north", stairwell3);        
        stairwell2.setExit("down", stairwell);
        
        stairwell3.setExit("west", hallway4);
        stairwell3.setExit("down", stairwell2);
        
        swimmingPool.setExit("north", hallway4);
        
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
        
        //currentRoom = hallway2;// start in the hallway2(number 12 in the google docs)
        //previousRoom = hallway2;
    

        //startLocation = hallway2;
        */
    }
        
    private void setRoomExits()
    {
        /**
         * using cardinal direction where north is up.
         *  Visual representation of hallways:
          ****************************************************************************************
          ** Hallway A:   
          ************* 
                       \NorthWest \  North  / NorthEast/
            West     <- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ->   East
          (Elevator) <- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ->(Hallway B)
                       /SouthWest /  South  \ SouthEast\
                     *****************************************************************************
                                                              ** Hallway B:
                                                              *************          
                                                                          |North|
                                                           NorthWest    <- XXXXX ->
                                                          (Hallway A)   <- XXXXX -> NorthEast
       (room name) = not unique to floor                       _________/  XXXXX  \_________
                                                                   West <- XXXXX -> East
                                                               _________<- XXXXX ->_________
                                                                        \  XXXXX  /
                                                              SouthWest <- XXXXX -> SouthEast
                                                                        <- XXXXX -> (Utility Closet)
                                                                          |South|
                                                                        (StairWell)
         */
        
    //Floor1    
    //     fl1_hallwayA = new Room("The first floor hallway to elevator.");
       fl1_lobby.setExit("west", fl1_hallwayA);
    // fl1_hallwayB = new Room("The first floor hallway to stairwell."); 

        fl1_stairs.setExit("upstairs",fl2_stairs);     fl1_stairs.setExit("up",fl2_stairs);
        // fl1_elev = new Room("Elevator: First Floor.");
    //floor 2
        //hallway a
         fl2_hallwayA.setExit("west",fl2_elev);         fl2_hallwayA.setExit("elevator",fl2_elev); 
         fl2_hallwayA.setExit("northwest",fl2_room208); fl2_hallwayA.setExit("room208",fl2_room208);
         fl2_hallwayA.setExit("northeast",fl2_room206); fl2_hallwayA.setExit("room206",fl2_room206);
         fl2_hallwayA.setExit("south",fl2_room207);     fl2_hallwayA.setExit("room207",fl2_room207);
         fl2_hallwayA.setExit("east",fl2_hallwayB);     fl2_hallwayA.setExit("hallway",fl2_hallwayB);
        //room 208
         fl2_room208.setExit("south",fl2_hallwayA);     fl2_room208.setExit("hallway", fl2_hallwayA);
        //room 207 
         fl2_room207.setExit("north",fl2_hallwayA);     fl2_room207.setExit("hallway", fl2_hallwayA);
        //room 206
         fl2_room206.setExit("south",fl2_hallwayA);     fl2_room206.setExit("hallway", fl2_hallwayA);
        //hallway b
         fl2_hallwayB.setExit("northwest",fl2_hallwayA);fl2_hallwayB.setExit("hallway",fl2_hallwayA); 
         fl2_hallwayB.setExit("south",fl2_stairs);      fl2_hallwayB.setExit("stairs",fl2_stairs);
         fl2_hallwayB.setExit("southeast",fl2_utilRoom);fl2_hallwayB.setExit("utility",fl2_utilRoom);
        //utilRoom
         fl2_utilRoom.setExit("west",fl2_hallwayB);     fl2_utilRoom.setExit("hallway", fl2_hallwayB);
        //stairs
         fl2_stairs.setExit("upstairs",fl3_stairs);     fl2_stairs.setExit("up",fl3_stairs);
         fl2_stairs.setExit("downstairs",fl1_stairs);   fl2_stairs.setExit("down",fl1_stairs);
         fl2_stairs.setExit("north",fl2_hallwayB);      fl2_stairs.setExit("hallway",fl2_hallwayB);
        //elevator
         fl2_elev = new Room("Elevator: Second Floor.");
    //floor 3
                //hallway a
         fl3_hallwayA.setExit("west",fl3_elev);         fl3_hallwayA.setExit("elevator",fl3_elev); 

         fl3_hallwayA.setExit("east",fl3_hallwayB);     fl3_hallwayA.setExit("hallway",fl3_hallwayB);

        //room 306
         fl3_room306.setExit("south",fl3_hallwayA);     fl3_room306.setExit("hallway", fl3_hallwayA);
        //hallway b
         fl3_hallwayB.setExit("northwest",fl3_hallwayA);fl3_hallwayB.setExit("hallway",fl3_hallwayA);
         fl3_hallwayB.setExit("northeast",fl3_room304); fl3_hallwayB.setExit("room304",fl3_room304);
         fl3_hallwayB.setExit("south",fl3_stairs);      fl3_hallwayB.setExit("stairs",fl3_stairs);
         fl3_hallwayB.setExit("southeast",fl3_utilRoom);fl3_hallwayB.setExit("utility",fl3_utilRoom);
        //room 303
         fl3_room303.setExit("east",fl3_hallwayB);     fl3_room303.setExit("hallway", fl3_hallwayB);
        //room 304 
         fl3_room304.setExit("west",fl3_hallwayB);     fl3_room304.setExit("hallway", fl3_hallwayB);
        //utilRoom
         fl3_utilRoom.setExit("west",fl3_hallwayB);     fl3_utilRoom.setExit("hallway", fl3_hallwayB);
        //stairs
         fl3_stairs.setExit("upstairs",fl4_stairs);     fl3_stairs.setExit("up",fl4_stairs);
         fl3_stairs.setExit("downstairs",fl2_stairs);   fl3_stairs.setExit("down",fl2_stairs);
         fl3_stairs.setExit("north",fl3_hallwayB);      fl3_stairs.setExit("hallway",fl3_hallwayB);
        //elevator
        
        // fl3_room303 = new Room("Room 303.");
        // fl3_room304 = new Room("Room 304.");
        // fl3_swimmingPool = new Room("The hotel's swimming pool."); 
        // fl3_room306 = new Room("Room 306.");
        // fl3_utilRoom = new Room("The utility Room on the third floor.");
        
        // fl3_elev = new Room("Elevator: Third Floor.");
    //floor 4
        // fl4_hallwayA = new Room("The fourth floor hallway to elevator.");
        // fl4_hallwayB = new Room("The fourth floor hallway to stairwell.");
        // fl4_utilRoom = new Room("The utility Room on the fourth floor.");
        // fl4_stairs = new Room("The fourth floor stairwell platform.");
        // fl4_elev = new Room("Elevator: Fourth Floor.");
    // //floor 5
        // roof_outside = new Room("Outside on the roof."); 
        // roof_stairs = new Room("Roof access stairwell.");
    }
    
    
    /**
     * Create all the items and place them in their starting rooms.
     * Items methods: set/getName ; set/getDescription ; isHeld setBeingHeld setNotBeingHeld
     * Items created are:
     * Flashlight - goes in occupied room
     * 
     */
    private void createItems()
    {
        flashlight = new Items("flashlight");
        //flashlight.setDescription(message.itemDescription(flashlight));
        flashlight.setCanHoldTo(true);
        GameItems.add(flashlight);
        fl2_room207.addItem(flashlight);
        
        rock = new Items("Rock");
        GameItems.add(rock);
        
        map = new Items("Map");
        GameItems.add(map);
        
        backpack = new Items("BackPack");
        GameItems.add(backpack);
    }
    
    //COUNTER functionality *********
    /**
     * @return int roomCounter
    */
    public int getRoomCtr()
    {
        return roomCounter;
    }
    /**
     * adds a tick to roomCounter
    */
    public void tickRoomCtr()
    {
        roomCounter ++;
    }
    /**
     * removes a tick to roomCounter - functionality just in case
    */
    public void detickRoomCtr()
    {
        roomCounter --;
    }
    //shouldnt be used
    public void resetRoomCtr(){roomCounter = 0;}
}

Escape from the Hotel
A text adventure game by Matthew Sheehan and Marcelle Tamegnon.

Story:
As you are enter your hotel room, just after checking in, you see your room phone ringing so you answer. the call sound dire telling you to quickly exit the hotel because a bunch of armed, dangerous people are coming for you. It seems like your life is on the line for some unknown reason. Better run now and find out questions later!


:: This game began as an assignment for Sp2020 GDEV 242 at RVCC from an exercise file called World of Zuul out of the text book Objects first with BlueJ (6th edition. by David J. Barnes & Michael Kölling) ::

notes for the mechanics included for grade stipulations
There were commits from GitHub first from forks then major uploads to master project during beginning of assignment. At the end of the year as I went to upload extra features I put it all right to master. All commits have descriptions of what has been changed and the though process with how I was thinking about solving a way to layout the game architecture.
-added a look command which returns specific information depending on the target look location. defaults to returning the location info and the items contained therein if nothing is specified.
-added extra commands such as take, drop, throw, use and give for items.
-help will print available commands
- The player can take (add to inventory), drop(put down in room) throw(removes item from inventory and uses object as projectile) or use items.
- Each room can have any amount of items in it. Items have description and weight. 
- Item weight is handled in how much inventory space it takes up. the player can only hold two items at a time until they get a back pack which allows the player to hold a total of four items.
- When printing room info, Items located in the room are also listed so the player knows there can be items interacted with.
- the back command will bring the player back to the room that they came from all the way back to the beginning of the game.
- there are NPCs in some rooms which can be interacted with and talked to.
- there are Key type items which unlock specific doors by having them in inventory and typing the use command.

being added currently
- moving enemies
- ability to lose the game by getting caught
- talking command to NPCs
- putting locked rooms in game
- moving enemy
- Time limit counted by rooms moved to
- finished game play with a victory point.




-------------------------
The hotel floor layout: |____________________________________________ 
there are two hallways on each floor of the hotel which connect to each other(except for the first floor where there is only one connected to a lobby). 
the way the level design was considered was that each room has 8 points of exit unless otherwise explained in order for the player to naturally understand orientation. 

Each of the floors above the first floor and below the roof have the same floor plan

======================================================================
General Hallway A Floor Plan (where # is floor number):
------------------------------------------------------
          (NorthWest)     (North)    (NorthEast)
                rm.#08  | rm.#06  | rm.#04
      XXXXXXXXX -----D--------D---------D---------.........
(West)X Elvtr.X |                                |   HwB  . (East)
      XXXXXXXXX -----D--------D---------D---------.   |   .
                 rm.#07  | rm.Misc | rm.#05       .   V   .
           (SouthWest)     (South)    (SouthEast)
 
Elvtr. = Elevator (multi floor choice transit)
======================================================================
General Hallway B Floor Plan (where # is floor number):
------------------------------------------------------	
                          (North)
        .D......D.......___________
      (Northwest)                 |        (NorthEast)
             Hallway A            D  Cleaning Closet 	
        .D......D.......|         |
      (West)            |         |             (East)
                rm.#03  D         D  rm.#02  
                        |         |
                rm.#01  D         D  Utility Room
      (SouthWest)       |__     __|        (SouthEast)
                         XXXXXXXXX
                         X Stair X
                         X -well X
                         XXXXXXXXX	
                          (South)

______________________________________________________________________

EC ideas listed on assignment page:
    one way trap door

    charged transporter (beamer)

    locked doors and keys

    random transporter (discuss with others about implementation)

    non-player characters with clues/items for trade

    make npc's move 

    rudimentary health system


        implement an item
        allow player to take item
        allow player to drop item
        implement a collection of items as Inventory so player may have multiple items
        Add inventory to room so room can hold multiple items
        Add weight to items so player can only carry specified weight, 
    are all separate and count as 5 points per feature provided I see individual commits and progress over time



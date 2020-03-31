   
    // /**
     // * Given a command, process (that is: execute) the command.
     // * @param command The command to be processed.
     // * @return true If the command ends the game, false otherwise.
     // */
    // public boolean processCommand(Command command) 
    // {
        // boolean wantToQuit = false;

        // CommandWord commandWord = command.getCommandWord();

        // switch (commandWord) {
            // case UNKNOWN:
                // System.out.println("I don't know what you mean...");
                // break;

            // case HELP:
                // printHelp();
                // break;

            // case GO:
                // goRoom(command);
                // break;
            
            // case DESCRIBE:
            // case LOOK:
                // lookAround(command);
                // break;

            // case QUIT:
                // wantToQuit = quit(command);
                // break;
                
            // case TAKE:
                // takeItem(command);
                // break;
                
            // case USE:
                // useItem(command);
                // break;
                
            // case THROW:
                // throwItem(command);    
            // case DROP:
                // dropItem(command);
                // break;
                
            // case INVENTORY:
                // showInventory();
                // break;
                
        // }
        // return wantToQuit;
    // }
   
    
    // // implementations of user commands:
    
    // //GO ROOM
    // /** 
     // * Try to go in one direction. If there is an exit, enter the new
     // * room, otherwise print an error message.
     // */
    // // private void goRoom(Command command) 
    // // {
        // // if(!command.hasSecondWord()) {
            // // // if there is no second word, we don't know where to go...
            // // System.out.println("Go where?");
            // // return; //exit
        // // }

        // // String direction = command.getSecondWord(); // set direction word

        // // // Try to leave current room.
        // // Room nextRoom = getCurrentRoom().getExit(direction); //stores room request

        // // if (nextRoom == null) { //Room requested doesnt exist.
            // // System.out.println("There is no door!");
        // // }
        // // else { //Room request found. Player moves into new room.
            // // //pushRoomHistory(nextRoom);
            // // setCurrentRoom(nextRoom);
            // // super.player.setCurrentRoom(nextRoom);
            // // System.out.println(super.getCurrentRoom().printLocationInfo());
        // // }
    // // }
   
    
    
    // //LOOK AROUND
    // /**
     // * Player looks around and describes room.
     // * Prints long description of current room
     // * 
     // * @param command given from player
     // */
    // private void lookAround(Command command) 
    // {
        // if(player.getCurrentRoom().isDark()){ //if players currentRoom isDark = true
            // System.out.println("It's too dark in here to see anything.");
        // }else{
            // System.out.println(player.getCurrentRoom().printLocationInfo());
        // }
    // }

    // /**
     // * action to use an item
     // * 
     // * @param command given from player
     // */
    // private void useItem(Command command)
    // {
        // System.out.println("Uses Item");
        // if(!command.hasSecondWord()) {
            // // if there is no second word, we don't know where to go...
            // System.out.println("Use What?");
            // return;
        // }

        // String item = command.getSecondWord();
        
        // switch(item){ //
            // case "flashlight" :
            // if(flashlight.isHeld()){ //flashlight is being held
            
            // }
                // break;
            
            // default : 
                // System.out.println("This item does not have a use.");
        // }
    // }
    
    
    // /**
     // * Player looks around and describes room.
     // * Prints long description of current room
     // * 
     // * @param command given from player
     // */
    // private void takeItem(Command command)
    // {
        // System.out.println("Takes Item");
        // if(!command.hasSecondWord()) {
            // // if there is no second word, we don't know where to go...
            // System.out.println("Go where?");
            // return;
        // }

        // String direction = command.getSecondWord();

        // // Try to leave current room.
        // Room nextRoom = player.getCurrentRoom().getExit(direction);
        
        
        // //LOCKED else if.
        
        // if (nextRoom == null) {
            // System.out.println("There is no door!");
        // }
        // else {
            // player.setCurrentRoom(nextRoom);
            // System.out.println(player.getCurrentRoom().printLocationInfo());
        // }
    // }
    
    // /**
     // * Player looks around and describes room.
     // * Prints long description of current room
     // * 
     // * @param command given from player
     // */
    // private void throwItem(Command command)
    // {
        // System.out.println("Throws Item");
        // if(!command.hasSecondWord()) {
            // // if there is no second word, we don't know where to go...
            // System.out.println("Go where?");
            // return;
        // }

        // String direction = command.getSecondWord();

        // // Try to leave current room.
        // Room nextRoom = player.getCurrentRoom().getExit(direction);

        // if (nextRoom == null) {
            // System.out.println("There is no door!");
        // }
        // else {
            // player.setCurrentRoom(nextRoom);
            // System.out.println(player.getCurrentRoom().printLocationInfo());
        // }    
    // }
    
    // /**
     // * Player looks around and describes room.
     // * Prints long description of current room
     // * 
     // * @param command given from player
     // */
    // private void dropItem(Command command)
    // {
        // System.out.println("Drops Item");
        // if(!command.hasSecondWord()) {
            // // if there is no second word, we don't know where to go...
            // System.out.println("Go where?");
            // return;
        // }

        // String direction = command.getSecondWord();

        // // Try to leave current room.
        // Room nextRoom = player.getCurrentRoom().getExit(direction);

        // if (nextRoom == null) {
            // System.out.println("There is no door!");
        // }
        // else {
            // player.setCurrentRoom(nextRoom);
            // System.out.println(player.getCurrentRoom().printLocationInfo());
        // }    
    // }
    
    // /**
     // * Player looks around and describes room.
     // * Prints long description of current room
     // * 
     // * @param command given from player
     // */
    // private void showInventory()
    // {
        // System.out.println("Shows Inventory");    
    // }
    
    
    
    // //HELP
    

    // /**
     // * Print out some help information.
     // * Here we print some stupid, cryptic message and a list of the 
     // * command words.
     // */
    // private void printHelp() 
    // {
        // commands = new CommandWords();
        // String tempCommandWords = commands.showAllString();
        // System.out.println("You are lost. You are alone. You wander");
        // System.out.println("around at the university.");
        // System.out.println();
        // System.out.println("Your command words are:");
        // System.out.println(tempCommandWords);
    // }

    
    // //QUIT

    // /** 
     // * "Quit" was entered. Check the rest of the command to see
     // * whether we really quit the game.
     // * @return true, if this command quits the game, false otherwise.
     // */
    // private boolean quit(Command command) 
    // {
        // if(command.hasSecondWord()) {
            // System.out.println("Quit what?");
            // return false;
        // }
        // else {
            // return true;  // signal that we want to quit
        // }
    // }
// }


/**
 * This command will tell the Game that the player wishes to quit
 *
 * @author Matthew Sheehan, Marcelle Tamegnon
 * @version 03/23/2020
 */
public class cmd_Quit extends Command
{
    
    public void action()
    {
    }
    
    @Override //over rides the wantToQuit. not made abstract since only one command uses this method
    public boolean wantToQuit()
    {
        return true;
    }
}

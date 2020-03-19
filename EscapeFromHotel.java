
/**
 * Escape From Hotel is a Text Adventure game where the player needs to 
 * type their way out of the maze which is a hotel. 
 * 
 * This Class executes the main String starts the game.
 *
 * @author Matthew Sheehan and Marcelle Tamegnon
 * @version 3/18/2020
 */
public class EscapeFromHotel
{
    private Game HotelEscape;

    /**
     * Launch EscapeFromHotel
     */
    public static void main(String[] args){
        Game HotelEscape = new Game();
        HotelEscape.play();
    }
}

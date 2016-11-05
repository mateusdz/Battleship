package battleship;

import java.util.ArrayList;

/**
 * @author Mateusz
 */
public class Player
{
    private final String name;
    private final ArrayList<Ship> ships; 
    private final ArrayList<Coordinat> previousGuesses;

    /**
     * @param name Name of the player.
     */
    public Player(String name)
    {
        this.name = name; 
        ships = new ArrayList<>();
        previousGuesses = new ArrayList<>();
    }
    
    /**
     * @return Name of this player
     */
    public String getName()
    {
        return name;
    }
    
    public void setShip(Ship ship)
    {
        ships.add(ship);
    }
    
    public ArrayList<Ship> getPlayerAllShips()
    {
        return ships;
    }
    
    /**
     * @param ship Ship to be sett on board
     * @param coordinat The upper /left coordinat to the ship 
     * @param direction HORIZONTAL or VERTICAL
     * @return True if ship have been places, false otherwise. 
     */
    public boolean placeShipOnBoard(Ship ship, Coordinat coordinat, Ship.Direction direction)
    {        
        Coordinat tempCoordinat = null;
        for( Ship s: ships)
        {
            for( Coordinat c: s.getCoordinatsForThisShip() )
            {
                for (int i = 0; i < ship.getSize(); i++) 
                {
                    // Checking which direction current ship is placed on board
                    if( direction == Ship.Direction.VERTICAL )
                        tempCoordinat = new Coordinat(coordinat.getX(), coordinat.getY()+i);
                    else 
                        tempCoordinat = new Coordinat(coordinat.getX()+i, coordinat.getY());
                    
                    if( c.equals(coordinat) ) return false;
                }
            }
        }        
        return ships.add(ship);
    }
    
    /**
     * @param coordinat Coordinat player want to shoot on 
     * @return True if player has tried this coordinat/place before, false if not. 
     */
    public boolean triedThisCoordinatBefore(Coordinat coordinat)
    {
        return previousGuesses.stream().anyMatch( (x) -> x.equals(coordinat));
    }
    
    /**
     * Prints out players ships
     */
    public void showAllShipsFromThisPlayer()
    {   
        System.out.println("********************************************");
        System.out.println("Player " + name + ": ");
        ships.stream().forEach( (s) -> System.out.println("Baat: " + s.toString()));
        System.out.println("********************************************");

        System.out.println("");
        
    }
}

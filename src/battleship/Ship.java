package battleship;

import java.util.ArrayList;
/**
 * @author Mateusz
 */

public abstract class Ship
{ 
    private final int size;
    private int lifeCount; 
    private Coordinat startPosition; 
    protected enum Direction{ 
        VERTICAL, 
        HORIZONTAL
    };
    private Direction directionOfThisShip;
    private final ArrayList<Coordinat> coordinates; //An ArrayList for holding of coodrinates for this ship
    
    /**
     * @param size Size of current ship, which is also eaqual to this ship lifes
     */
    public Ship(int size)
    {
        this.size = size;
        this.lifeCount = size;
        coordinates = new ArrayList<>();
    }
    
    /**
     * @return Size of current ship.
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * @param startCoordinates Contains upper left coordinat of current ship
     * @param direction Indicates direction of current ship. VERTICAL or HORIZONTAL
     */
    public void setShip(Coordinat startCoordinates, Direction direction )
    {
        startPosition = startCoordinates;        
        directionOfThisShip = direction;
    }

    /**
     * @return Returns an ArrayList with coordrinates of this ship.
     */
    public ArrayList<Coordinat> getCoordinatsForThisShip()
    {
        generateCoordinatsForThisShip();
        return coordinates; // List of coordinates which this ship is placed on
    }
       
    /**
     * @return Number of remaining lives after a hit
     */
    public int hit() // reduceLifeCount()
    {
        return --lifeCount;
    }
    
    /**
    * Generates an ArrayList with coordrinates of current ship.
    */
    public void generateCoordinatsForThisShip() 
    {      
        //Iterates "size" times which is size of current ship
        for (int i = 0; i < size; i++) 
        {
            // Checking which direction current ship is placed on board
            if( directionOfThisShip == Direction.VERTICAL )
                coordinates.add(new Coordinat(startPosition.getX(), startPosition.getY()+i));
            else 
                coordinates.add(new Coordinat(startPosition.getX()+i, startPosition.getY()));
        }
    }
}
package battleship;

/**
 * @author Mateusz
 */
public class Coordinat
{
    //Variable to store coordinat values
    private final int x, y;
    
    /**
     * @param x value of fist axis, can be both + or -.
     * @param y value of second axis, can be both + or -.
     */
    public Coordinat(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * @return x value of this coordinate
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * @return y value of this coordinate
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * @param coordinat Object to compare with.
     * @return True if equals, false otherwise.
     */
    public boolean equals(Coordinat coordinat)
    {
        return x == coordinat.getX() && y == coordinat.getY();
    }
    
    /**
     * @return Coordinat in string form: (x,y)
     */
    @Override
    public String toString()
    {
        return "(" + x + "," + y + ") ";
    }
}

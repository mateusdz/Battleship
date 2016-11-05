package battleship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mateusz
 */
public class Game
{
    private final HashMap<Integer, Ship> shipsTypes;
    protected final ArrayList<Player> players;
    private final Scanner input;
    
    public Game()
    {
        shipsTypes = new HashMap<>();
        players = new ArrayList<>();
        input = new Scanner(System.in);
        initializateShipsTypes();
        initializatePlayers();
        distributeShipsToPlayer();
        showAllPlayersAndTheirsShips();
        letPlayersSetShipsOnBoard();
    }
    
    /**
     * Adds differents types of ships to an hashmap of ships.
     * Key - Integer - gives count of given/corresponding ship.
     * Value - Ship - Different ships (length of the ships are different).
     */
    private void initializateShipsTypes()
    {
        shipsTypes.put(1, new Carrier());
        shipsTypes.put(2, new Battleship());
        shipsTypes.put(3, new Cruiser());
        shipsTypes.put(4, new Submarine());
        shipsTypes.put(5, new Destroyer());
    }    
    
    /**
     * 
     */
    private void initializatePlayers()
    {
        int numberOfPlayers = 0;
        
        System.out.println("How many players will play? Choose from 2 to 9: ");

        while( !input.hasNext("[2-9]") )
        {
            System.out.println("Wrong number of players! Choose again!");
            System.out.println("How many players will play? Choose from 2 to 9: ");
            input.next();
        }
        numberOfPlayers = Integer.parseInt( input.next() );

        for (int i = 0; i < numberOfPlayers; i++) 
        {
            System.out.println("Name of player nr " + (i+1) + ": ");
            while( !input.hasNext("[a-zA-ZøæåÅØÆ]+") )
            {
                System.out.println("Name have to be a string which can be followed by a number. Try again!");
                System.out.println("Name of player nr " + (i+1) + ": ");
                input.next();
            }
            players.add(new Player( input.next() ));
        }
    }

    /**
     *
     */
    private void distributeShipsToPlayer()
    {
        for( Integer myInt : shipsTypes.keySet())
        {
            for (int i = 0; i < myInt; i++) 
            {
                players.stream().forEach((p) -> {
                    try {
                        p.setShip(shipsTypes.get(myInt).getClass().newInstance() );
                    }
                    catch (InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
 
            }
        }
    }
    
    private void letPlayersSetShipsOnBoard()
    {
        String userInput = "";
        String userSpacedInput[] = new String[4];

        for(Player p : players)
        {
            System.out.println("Assigning ships for " + p.getName() + ": ");
            System.out.println("In this maner \"x y direction\" e.g., 10 4 H");

            for( Ship s : p.getPlayerAllShips() )
            {
                System.out.println("Place ship of length " + s.getSize() + " on board: ");
                while( !input.hasNext("\\d+[ ]\\d+[ ][vhVH]") )
                {
                    System.out.println("Wrong input format! Try again!");
                    System.out.println("Place ship of length " + s.getSize() + " on board: ");
                    input.next();
                }
                userInput = input.next();
                userSpacedInput = userInput.split(" ");
                System.out.println(userSpacedInput[0] + " " + userSpacedInput[1] + " " + userSpacedInput[2]);
                //p.placeShipOnBoard(s, new Coordinat(0,0) , Ship.Direction.VERTICAL);

                System.out.println("FINITO");
            }
        }
    }

    private void showAllPlayersAndTheirsShips()
    {
        players.stream().forEach((p) -> {
            p.showAllShipsFromThisPlayer();
        });
    }
}
 

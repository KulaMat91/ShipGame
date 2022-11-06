package org.example.ShipGame;

import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private GameBoard playerGameBoard;
    private GameBoard enemyGameBoard;
    private List<Ship> shipsToDeploy =
            Arrays.asList(
                    Ship.ONE, Ship.ONE, Ship.ONE, Ship.ONE,
                    Ship.TWO, Ship.TWO,
                    Ship.THREE, Ship.THREE,
                    Ship.FOUR);

}

package org.example.ShipGame;

import java.util.Arrays;
import java.util.LinkedList;

public class Player {
    private String name;
    private GameBoard playerGameBoard;
    private GameBoard enemyGameBoard;

    private LinkedList<Ship> shipsToDeploy = new LinkedList<>(
            Arrays.asList(
                    Ship.ONE, Ship.ONE, Ship.ONE, Ship.ONE,
                    Ship.TWO, Ship.TWO,Ship.TWO,
                    Ship.THREE, Ship.THREE,
                    Ship.FOUR));

    public LinkedList<Ship> getShipsToDeploy() {
        return shipsToDeploy;
    }

    public String getName() {
        return name;
    }

    public GameBoard getPlayerGameBoard() {
        playerGameBoard = new GameBoard(10);
        return playerGameBoard;
    }

    public GameBoard getEnemyGameBoard() {
        return enemyGameBoard;
    }
}


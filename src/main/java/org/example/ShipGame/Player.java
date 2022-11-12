package org.example.ShipGame;

import org.example.ShipGame.Board.GameBoard;

public class Player {
    private String name;
    private GameBoard playerGameBoard;
    private GameBoard enemyGameBoard;


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


package org.BattleShipGame;
/*
    Class Player has logic responsible for handling shot.
    Class Player has field of type List<ShipType>.
    Class Player has a method isAlive to check if player has not lost all ships and returns true or false accordingly.
 */


import org.BattleShipGame.Ship.Ship;
import org.BattleShipGame.Square.Square;
import org.BattleShipGame.Square.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;

    private Board playerBoard;
    private Board enemyBoard;

    private List<Ship> listOfShips = new ArrayList<>();


    public Player(String name) {
        this.name = name;
        this.playerBoard = new Board(10);
        this.enemyBoard = new Board(10);
    }

    public String getName() {
        return name;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public void showPlayerBoard(Board playerBoard) {
        Display.printBoard(playerBoard);
    }

    public void showEnemyBoard(Board enemyBoard) {
        Display.printBoard(enemyBoard);
    }

    public Boolean isPlayerAlive() {
        for (Square[] squareArray : playerBoard.getOcean()) {
            for (Square square : squareArray) {
                if (square.getSquareStatus().equals(SquareStatus.SHIP)) {
                    return true;
                }
            }
        }
        return false;
    }

    //TODO handling shot

}

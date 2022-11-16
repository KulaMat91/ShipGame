package org.BattleShipGame;
/*
    Class Player has logic responsible for handling shot.
    Class Player has field of type List<ShipType>.
    Class Player has a method isAlive to check if player has not lost all ships and returns true or false accordingly.
 */


import org.BattleShipGame.Ship.Ship;
import org.BattleShipGame.Ship.ShipList;
import org.BattleShipGame.Square.Square;
import org.BattleShipGame.Square.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class Player implements Cloneable {

    private final String name;
    private Board playerBoard;
    private Board enemyBoard;
    private List<Ship> listOfShips = new ArrayList<>();


    public Player(String name) {
        this.name = name;
        this.enemyBoard = new Board(10);
    }

    public String getName() {
        return name;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public void addShipToPlayerList(Ship ship) {
        listOfShips.add(ship);
    }

    public void setPlayerBoard(Board playerBoard) {
        this.playerBoard = playerBoard;
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

    public Boolean shotCheckIfHit(Board enemyBoard) {
        Integer[] shotCoordinates = Input.getShotCoordinates();
        if (enemyBoard.getOcean()[shotCoordinates[0]][shotCoordinates[1]]
                .getSquareStatus().getCharacter().equals(SquareStatus.SHIP.getCharacter())) {
            return true;
        } else {
            return false;
        }
    }

    public void addListOfShips() {
        this.listOfShips = this.playerBoard.deployShips(ShipList.getShips());
    }

    public List<Ship> getListOfShips() {
        return listOfShips;
    }
}

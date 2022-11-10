package Player;
/*
    Class Player has logic responsible for handling shot.
    Class Player has field of type List<ShipType>.
    Class Player has a method isAlive to check if player has not lost all ships and returns true or false accordingly.
 */

import Ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;

    private Board playerBoard;
    private Board enemyBoard;

    private List<Ship> listOfShips = new ArrayList<>();


    public Player(String name) {
        this.name = name;
        this.playerBoard = new Board();
    }

    public String getName() {
        return name;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public void showPlayerBoard(Board playerBoard) {
        playerBoard.showBoard;
    }

    public void showEnemyBoard(Board enemyBoard) {
        enemyBoard.showBoard;
    }

    public int sizeOfShip(List<Ship> ships){
        int size = 0;
        for(Ship ship : ships){
            size += ship.getShipType().length;
        }
        return size;
    }


}

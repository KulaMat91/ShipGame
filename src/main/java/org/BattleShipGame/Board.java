package org.BattleShipGame;

import org.BattleShipGame.Ship.ShipType;
import org.BattleShipGame.Square.Square;
import org.BattleShipGame.Square.SquareStatus;

import java.util.LinkedList;
import java.util.Scanner;

public class Board {
    private Square[][] ocean;
    private int boardSize;
    Display display = new Display();

    public Board(int boardSize) {
        this.boardSize = boardSize;
        ocean = new Square[boardSize][boardSize];
        for (int rows = 0; rows < boardSize; rows++) {
            for (int columns = 0; columns < boardSize; columns++) {
                this.ocean[rows][columns] = new Square(rows, columns, SquareStatus.WATER);
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public boolean checkIsPlacementOk(Integer[] coordinates, int shipSize) {
        if (this.ocean[coordinates[0]][coordinates[1]].getSquareStatus() == SquareStatus.WATER) {
            switch (coordinates[2]) {
                case 1: // HORIZONTAL
                    if (shipSize + coordinates[0] <= boardSize && checkIfIsFreeSpaceBetweenShips(coordinates, shipSize)) {
                        return true;
                    }
                case 0: // VERTICAL
                    if (shipSize + coordinates[1] <= boardSize && checkIfIsFreeSpaceBetweenShips(coordinates, shipSize)) {
                        return true;
                    }
                default:
                    return false;
            }
        } else {
            System.out.println("Another Yours ship is here, find different place!");
        }
        Display.printBoard(this);
        return false;
    }

    public boolean checkIfIsFreeSpaceBetweenShips(Integer[] coordinates, int shipSize) {
        int row = coordinates[0];
        int column = coordinates[1];
        int orientation = coordinates[2];
        int counter = 0;
        switch (orientation) {
            case 1: // HORIZONTAL
                for (int l = 0; l < 3; l++) {
                    for (int i = 0; i < shipSize + 2; i++) {
                        int xPrim = row - 1 + l;
                        int yPrim = column + i - 1;
                        boolean outOfBounds = (yPrim < 0) || (yPrim > boardSize) || (xPrim < 0) || (xPrim > boardSize);
                        if (outOfBounds || this.ocean[xPrim][yPrim].getSquareStatus().equals(SquareStatus.WATER)) {
//                            if (!outOfBounds) {
//                                this.ocean[xPrim][yPrim].setSquareStatus(SquareStatus.TEST);
//                            }
                            counter++;
                        }
                    }
                }
                break;
            case 0: // VERTICAL
                for (int k = 0; k < shipSize + 2; k++) {
                    for (int i = 0; i < 3; i++) {
                        int xPrim = row - 1 + k;
                        int yPrim = column + i - 1;
                        boolean outOfBounds = (yPrim < 0) || (yPrim >= boardSize) || (xPrim < 0) || (xPrim >= boardSize);
                        if (outOfBounds || this.ocean[xPrim][yPrim].getSquareStatus().equals(SquareStatus.WATER)) {
                            counter++;
                        }
                    }
                }
                break;
            default:
                System.out.println("error");
                break;
        }
        return counter == (3 * (shipSize + 2));
    }

    public Square[][] deployShips(LinkedList<ShipType> shipsToDeploy) {
        while (!shipsToDeploy.isEmpty()) {
            Integer[] coordinates = Input.getCoordinates(shipsToDeploy.get(0));
            if (checkIsPlacementOk(coordinates, shipsToDeploy.get(0).shipSize)) {
                switch (coordinates[2]) {
                    case 1: // HORIZONTAL
                        for (int i = 0; i < shipsToDeploy.get(0).shipSize; i++) {
                            this.ocean[coordinates[0]][coordinates[1] + i].setSquareStatus(SquareStatus.SHIP);
                        }
                        // PLAYER.shipList.add
                        shipsToDeploy.remove(0);
                        break;
                    case 0: // VERTICAL
                        for (int i = 0; i < shipsToDeploy.get(0).shipSize; i++) {
                            this.ocean[coordinates[0] + i][coordinates[1]].setSquareStatus(SquareStatus.SHIP);
                        }
                        shipsToDeploy.remove(0);
                        break;
                    default:
                        Display.printMessage("Invalid input");
                        break;
                }
            }
            System.out.println();
            Display.printBoard(this);
        }
        return this.ocean;
    }
}


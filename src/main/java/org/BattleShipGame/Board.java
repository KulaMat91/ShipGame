package org.BattleShipGame;

import org.BattleShipGame.Ship.ShipType;
import org.BattleShipGame.Square.Square;
import org.BattleShipGame.Square.SquareStatus;

import java.util.LinkedList;
import java.util.Scanner;

public class Board {
    private Square[][] ocean;
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        ocean = new Square[boardSize][boardSize];
        for (int rows = 0; rows < boardSize; rows++) {
            for (int columns = 0; columns < boardSize; columns++) {
                this.ocean[rows][columns] = new Square(rows, columns, SquareStatus.WATER);
            }
        }
    }

    public void printTable() {
        for (int i = 0; i <= boardSize; i++) {
            System.out.print(i + "  ");
        }
        for (int rows = 1; rows <= boardSize; rows++) {
            System.out.printf("\n%d  ", rows);
            for (int columns = 0; columns < boardSize; columns++) {
                System.out.print(ocean[rows - 1][columns].getSquareStatus() + "  ");
            }
        }
    }

    public boolean checkIsPlacementOk(int[] coordinates, int shipSize) {
        if (this.ocean[coordinates[0]][coordinates[1]].getSquareStatus() == SquareStatus.WATER) {
            switch (coordinates[2]) {
                case 1: // HORIZONTAL
                    if (shipSize + coordinates[0] <= boardSize && checkIfIsFreeSpaceBetweenShips(coordinates, shipSize)) { // było zamienione
                        return true;
                    }
                case 2: // VERTICAL
                    if (shipSize + coordinates[1] <= boardSize && checkIfIsFreeSpaceBetweenShips(coordinates, shipSize)) {
                        return true;
                    }
                default:
                    return false;
            }
        } else {
            System.out.println("Another Yours ship is here, find different place!");
        }
        this.printTable();
        return false;
    }


    public boolean checkIfIsFreeSpaceBetweenShips(int[] coordinates, int shipSize) {
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
            case 2: // VERTICAL
                for (int k = 0; k < shipSize + 2; k++) {
                    for (int i = 0; i < 3; i++) {
                        int xPrim = row - 1 + k;
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
            default:
                System.out.println("error");
                break;
        }
        return counter == (3 * (shipSize + 2));
    }

    public Square[][] deployShips(LinkedList<ShipType> shipsToDeploy) {
        while (!shipsToDeploy.isEmpty()) {
            System.out.printf("\nPodaj koordynaty początku statku + orientacje (1 v or 2 h) dla %s ship\n", shipsToDeploy.get(0).name());
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt() - 1; // zmienic na coordinates [0]
            int y = scanner.nextInt() - 1; // zmienic na coordinates [0]
            int orientation = scanner.nextInt();
            int[] arr = {x, y, orientation}; // temporary
            if (checkIsPlacementOk(arr, shipsToDeploy.get(0).shipSize)) {
                switch (orientation) {
                    case 1: // HORIZONTAL
                        for (int i = 0; i < shipsToDeploy.get(0).shipSize; i++) {
                            this.ocean[x][y + i].setSquareStatus(SquareStatus.SHIP);
                        }
                        // PLAYER.shipList.add
                        shipsToDeploy.remove(0);
                        break;
                    case 2: // VERTICAL
                        for (int i = 0; i < shipsToDeploy.get(0).shipSize; i++) {
                            this.ocean[x + i][y].setSquareStatus(SquareStatus.SHIP);
                        }
                        shipsToDeploy.remove(0);
                        break;
                    default:
                        System.out.println("Input invalid");
                        break;
                }
            }
//            System.out.println("Another Yours ship is here, find different place!");
            System.out.println();
            this.printTable();
        }
        return this.ocean;
    }
}


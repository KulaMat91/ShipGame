package org.example.ShipGame.Board;

import org.example.ShipGame.Ship.ShipType;
import org.example.ShipGame.Square.Square;
import org.example.ShipGame.Square.SquareStatus;

import java.util.LinkedList;
import java.util.Scanner;

public class newBoard {
    private Square[][] ocean;
    private int boardSize;

    public newBoard(int boardSize) {
        this.boardSize = boardSize;
        ocean = new Square[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.ocean[i][j] = new Square(i, j, SquareStatus.WATER);
            }
        }
    }

    public void printTable() {
        for (int i = 0; i <= boardSize; i++) {
            System.out.print(i + "  ");
        }
        for (int i = 1; i <= boardSize; i++) {
            System.out.printf("\n%d  ", i);
            for (int j = 0; j < boardSize; j++) {
                System.out.print(ocean[i - 1][j].getSquareStatus() + "  ");
            }
        }
    }

    public boolean checkIfIsFree(int[] coordinates, int shipSize) {
        int x = coordinates[0];
        int y = coordinates[1];
        int orientation = coordinates[2];
        int counter = 0;
        int times;
        switch (orientation) {
            case 1:
                for (int l = 0; l < 3; l++) {
                    for (int i = 0; i < shipSize + 2; i++) {
                        int xPrim = x - 1;
                        int yPrim = y + i - 1;
                        boolean outOfBounds = (yPrim < 0) || (yPrim > boardSize) || (xPrim < 0) || (xPrim > boardSize);
                        if (outOfBounds || this.ocean[xPrim][yPrim].getSquareStatus().equals(SquareStatus.WATER)) {
                            counter++;
                        }
                    }
                }
                break;
            case 2:
                for (int k = 0; k < shipSize + 2; k++) {
                    for (int i = 0; i < 3; i++) {
                        int xPrim = x - 1;
                        int yPrim = y + i - 1;
                        boolean outOfBounds = (yPrim < 0) || (yPrim > boardSize) || (xPrim < 0) || (xPrim > boardSize);
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
            System.out.printf("\nPodaj koordynaty początku statku + orientacje (1 v or 2 h) dla %s ship\n", shipsToDeploy.get(0).name());
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int orientation = scanner.nextInt();
            int[] arr = {x - 1, y - 1, orientation};
            if (this.ocean[x - 1][y - 1].getSquareStatus() == SquareStatus.WATER) {
                switch (orientation) {
                    case 1:
                        if (shipsToDeploy.get(0).shipSize + y <= boardSize && checkIfIsFree(arr, shipsToDeploy.get(0).shipSize)) {
                            for (int i = 0; i < shipsToDeploy.get(0).shipSize; i++) {
                                this.ocean[x - 1][y + i - 1].setSquareStatus(SquareStatus.SHIP);
                            }
                            shipsToDeploy.remove(0);
                        }
                        break;
                    case 2:
                        if (shipsToDeploy.get(0).shipSize + x <= boardSize && checkIfIsFree(arr, shipsToDeploy.get(0).shipSize)) {
                            for (int i = 0; i < shipsToDeploy.get(0).shipSize; i++) {
                                this.ocean[x + i - 1][y - 1].setSquareStatus(SquareStatus.SHIP);
                            }
                            shipsToDeploy.remove(0);
                        }
                        break;
                    default:
                        System.out.println("Wprowadz poprawne dane:");
                        break;
                }
                this.printTable();
            } else {
                System.out.println("To pole jest zajęte, wybierz inne:");
                continue;
            }
        }
        return this.ocean;
    }
}

//        public boolean isPlacementOk ( int[] coordinates, int shipSize){
//            int x = coordinates[0] - 1;
//            int y = coordinates[1] - 1;
//            int orientation = coordinates[2];
//
//            if (this.ocean[x][y].equals(SquareStatus.WATER)) {
//                switch (orientation) {
//                    case '1': // "1" - VERTICAL
//                        if (shipSize + y <= boardSize) { // tutaj dodać sprawdzenie czy następne kratki są '~'
//                            for (int i = 0; i <= shipSize; i++) {
//                                this.gameField[x][y + i] = SquareStatus.SHIP.getCharacter();          // tutaj trzeba dodac "obrysowanie" statku '-'
//                            }
//                            break;
//                        }
//                    case '2': // "2" - HORIZONTAL
//                        if (shipSize + x <= boardSize) {
//                            for (int i = 0; i <= shipSize; i++) {
//                                this.gameField[x + i - 1][y - 1] = SquareStatus.SHIP.getCharacter();
//                            }
//                            break;
//                        }
//                    default:
//                        System.out.println("Wprowadz poprawne dane:");
//                        break;
//                }
//                this.printTable();
//            } else {
//                System.out.println("You cannot deploy this ship here, choose another place:");
//            }
//            return false;
//        }


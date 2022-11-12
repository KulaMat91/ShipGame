package org.example.ShipGame.Board;

import org.example.ShipGame.Ship.ShipType;
import org.example.ShipGame.Ship.ShipList;
import org.example.ShipGame.Square.SquareStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayerBoard extends Board {

    public PlayerBoard(Integer size) {
        super(size);
    }

    public boolean isOneBoxSpace(int[] coordinates, int shipSize) {
        return true;
    }

    public boolean isPlacementOk(int[] coordinates, int shipSize) {
        int x = coordinates[0] - 1;
        int y = coordinates[1] - 1;
        int orientation = coordinates[2];

        if (this.gameField[x][y].equals(SquareStatus.WATER.getCharacter())) {
            switch (orientation) {
                case '1': // "1" - VERTICAL
                    if (shipSize + y <= size) { // tutaj dodać sprawdzenie czy następne kratki są '~'
                        for (int i = 0; i <= shipSize; i++) {
                            this.gameField[x][y + i] = SquareStatus.SHIP.getCharacter();          // tutaj trzeba dodac "obrysowanie" statku '-'
                        }
                        break;
                    }
                case '2': // "2" - HORIZONTAL
                    if (shipSize + x <= size) {
                        for (int i = 0; i <= shipSize; i++) {
                            this.gameField[x + i - 1][y - 1] = SquareStatus.SHIP.getCharacter();
                        }
                        break;
                    }
                default:
                    System.out.println("Wprowadz poprawne dane:");
                    break;
            }
            this.printTable();
        } else {
            System.out.println("You cannot deploy this ship here, choose another place:");
        }
        return false;
    }

    public Character[][] deployShips() {
        List<ShipType> shipsToDeploy = ShipList.getShips();
        while (!shipsToDeploy.isEmpty()) {
            System.out.printf("\nPodaj koordynaty początku statku + orientacje (V or H) dla %s ship\n", shipsToDeploy.get(0).name());
            Scanner scanner = new Scanner(System.in);
            char[] coordinates = scanner.next().toUpperCase().toCharArray();   // może dodać jakiegoś regexa
            int y = Character.getNumericValue(coordinates[1]);
            int x = Character.getNumericValue(coordinates[0]);                 // chyba tu trzeba będzie dać 3 scannery bo nie wiem jak inaczej obsłużyc 10;
            char orientation = coordinates[2];

        }
        for (Character[] characters : gameField) {
            if (characters.equals('-')) {
                Arrays.fill(characters, '~');
            }
        }
        return this.gameField;
    }
}

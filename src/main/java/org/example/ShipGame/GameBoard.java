package org.example.ShipGame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class GameBoard {
    private Integer size;

    private final Character WATER = '~';
    private final Character WATER_BUT_SHIP_CANNOT_BE_DEPLOYED = '-';
    private final Character SHIP = 's';
    private final Character HITTED = 'x';
    private final Character MISSED = 'o';

    private Character[][] gameField;

    public GameBoard(Integer size) {
        this.size = size;
        gameField = new Character[size][size];
        createEmptyField();
    }

    public void printTable() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + "  ");
        }
        for (int i = 1; i <= size; i++) {
            System.out.printf("\n%d  ", i);
            for (int j = 0; j < size; j++) {
                System.out.print(gameField[i - 1][j] + "  ");
            }
        }
    }

    public Character[][] createEmptyField() {
        for (Character[] characters : gameField) {
            Arrays.fill(characters, WATER);
        }
        return this.gameField;
    }

    public Character[][] deployShips(LinkedList<Ship> shipsToDeploy) {
        while (!shipsToDeploy.isEmpty()) {
            System.out.printf("\nPodaj koordynaty początku statku + orientacje (V or H) dla %s ship\n", shipsToDeploy.get(0).name());
            Scanner scanner = new Scanner(System.in);
            char[] coordinates = scanner.next().toUpperCase().toCharArray();   // może dodać jakiegoś regexa
            int y = Character.getNumericValue(coordinates[1]);
            int x = Character.getNumericValue(coordinates[0]);                 // chyba tu trzeba będzie dać 3 scannery bo nie wiem jak inaczej obsłużyc 10;
            char orientation = coordinates[2];
            if (this.gameField[x - 1][y - 1].equals('~')) {
                switch (orientation) {
                    case 'V':
                        if (shipsToDeploy.get(0).shipSize + y <= size) { // tutaj dodać sprawdzenie czy następne kratki są '~'
                            for (int i = 0; i <= shipsToDeploy.get(0).shipSize; i++) {
                                this.gameField[x - 1][y + i - 1] = 's';          // tutaj trzeba dodac "obrysowanie" statku '-'
                            }
                            shipsToDeploy.remove(0);
                            break;
                        }
                    case 'H':
                        if (shipsToDeploy.get(0).shipSize + x <= size) {
                            for (int i = 0; i <= shipsToDeploy.get(0).shipSize; i++) {
                                this.gameField[x + i - 1][y - 1] = 's';
                            }
                            shipsToDeploy.remove(0);
                            break;
                        }
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
        for (Character[] characters : gameField) {
            if (characters.equals('-')) {
                Arrays.fill(characters, '~');
            }
        }
        return this.gameField;
    }
}


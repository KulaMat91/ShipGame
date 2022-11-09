package org.example.ShipGame.Board;

import org.example.ShipGame.Ship.Ship;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Board {

        Integer size;
        Character[][] gameField;

        public Board(Integer size) {
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
                Arrays.fill(characters, FieldStatus.WATER.getCharacter());
            }
            return this.gameField;
        }
}

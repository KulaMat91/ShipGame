package org.example.ShipGame.Board;

import org.example.ShipGame.Square.SquareStatus;

import java.util.Arrays;

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
                Arrays.fill(characters, SquareStatus.WATER.getCharacter());
            }
            return this.gameField;
        }
}

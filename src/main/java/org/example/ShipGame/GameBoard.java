package org.example.ShipGame;

import java.util.Arrays;

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
        for (int i = 1; i <= size; i++){
            System.out.printf("\n%d  " , i);
            for (int j = 0; j < size ; j++){
                System.out.print(gameField[i - 1][j] + "  ");
            }
        }
    }
    public Character[][] createEmptyField(){
        for (Character[] characters : gameField) {
            Arrays.fill(characters, WATER);
        }
        return gameField;
    }

//    public Character[][] deployShips(List<Ship> shipsToDeploy){
//        while (!shipsToDeploy.isEmpty()){
//
//        }
//    }

}

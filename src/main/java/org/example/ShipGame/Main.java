package org.example.ShipGame;

import org.example.ShipGame.Board.Board;
import org.example.ShipGame.Ship.ShipList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10);
        Scanner scanner  = new Scanner(System.in);
        board.deployShips(ShipList.getShips());
//        for (;;){
//            System.out.println();
//            board.printTable();
//            int[] coordinates = new int [3];
//            System.out.println();
//            System.out.println("PODAJ");
//            coordinates[0] = scanner.nextInt() - 1;
//            coordinates[1] = scanner.nextInt() - 1;
//            coordinates[2] = scanner.nextInt();
//
//            board.checkIfIsFreeSpaceBetweenShips(coordinates,2);
//            System.out.println();
//            board.printTable();
//        }
    }
}

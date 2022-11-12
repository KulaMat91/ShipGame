package org.example.ShipGame;

import org.example.ShipGame.Board.newBoard;
import org.example.ShipGame.Ship.ShipList;

public class Main {
    public static void main(String[] args) {


        int [] examplecoordinates = {5,5,2};
        int [] examplecoordinates2 = {6,2,1};
        int [] examplecoordinates3= {9,9,2};

        newBoard newBoard = new newBoard(9);
        newBoard.printTable();

        newBoard.deployShips(ShipList.getShips());

    }
}

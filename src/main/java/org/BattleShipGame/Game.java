package org.BattleShipGame;

import org.BattleShipGame.Ship.ShipList;

public class Game {

    /*
    1. Battleship.start();
    2. Start gry -> Podanie nicków graczy:
    -Player 1
    -Player 2
    3. Rozłożenie statków:
    -Player 1 (playerBoard
    -Player 2
    4. Rozpoczęcie fazy strzelania (pętla):
    -Player 1 (pętla, aż nie trafi)
    -Player 2 (pętla, aż nie trafi)
    Po każdym strzale sprawdzenie czy pozostały jakieś statki
    5. Jeśli jakiś z graczy straci wszystkie statki to przegrywa.
    6. Wyświetlenie wyniku gry
     */

    public static void game() {
        Player player1 = new Player(Input.getString("Insert Player 1 name: "));
        Player player2 = new Player(Input.getString("Insert Player 2 name: "));
        Board player1Board = new Board(10);
        Board player2Board = new Board(10);
        player1Board.deployShips(ShipList.getShips());
        player2Board.deployShips(ShipList.getShips());
        player1.setPlayerBoard(player1Board);
        player2.setPlayerBoard(player2Board);
        while (player1.isPlayerAlive() || player2.isPlayerAlive()) {

        }

    }

}

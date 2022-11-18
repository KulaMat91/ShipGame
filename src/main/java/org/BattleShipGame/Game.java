package org.BattleShipGame;

import org.BattleShipGame.Ship.Ship;
import org.BattleShipGame.Ship.ShipList;
import org.BattleShipGame.Square.Square;
import org.BattleShipGame.Square.SquareStatus;

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

    public static void testGame() {
        Player player1 = new Player(Input.getString("Insert Player 1 name: "));
        Board player1Board = new Board(10);
        player1.setPlayerBoard(player1Board);
        player1.addListOfShips();
        Player player2 = new Player(Input.getString("\nInsert Player 2 name: "));
        Board player2Board = new Board(10);
        player2.setPlayerBoard(player2Board);
        player2.addListOfShips();
        player1.setEnemy(player2);
        player2.setEnemy(player1);
        shootingPhase(player1);
    }

    public static void shootingPhase(Player player) {
        Integer[] tempCoordinates = Input.getShotCoordinates();
        if (player.shotCheckIfHit(tempCoordinates)) {
            Ship shipHit = new Ship();
            // player enemyBoard
            // player getEnemy getPlayerBoard getOcean[][] = character of hit
            // player getEnemy getListOfShips. // osobna metoda
            for (Ship ship : player.getEnemy().getListOfShips()) {
                shipHit.setShipSquares(ship.getShipSquaresByCoordinates(tempCoordinates).getShipSquares());
                if (shipHit != null) {
                    //changing status of the hit square to HIT
                    shipHit.getShipSquares().stream().findFirst()
                            .filter(s -> s.getSquareCoordinates().equals(tempCoordinates))
                            .get().setSquareStatus(SquareStatus.HIT);
                    break;
                }
            }
            if(shipHit.isShipAlive()){
                //if ship is alive change square on player enemyBoard and enemy playerBoard to HIT
                player.getEnemyBoard()
                        .getOcean()[tempCoordinates[0]][tempCoordinates[1]].setSquareStatus(SquareStatus.HIT);
                player.getEnemy().getPlayerBoard()
                        .getOcean()[tempCoordinates[0]][tempCoordinates[1]].setSquareStatus(SquareStatus.HIT);
            } else {
                //change ship squares status to sunk
                //change all ship squares to sunk on both boards
                for (Square square : shipHit.getShipSquares()){
                    Integer[] squareCoordinates = square.getSquareCoordinates(); // [x,y]
                    square.setSquareStatus(SquareStatus.SUNK);
                    player.getEnemyBoard()
                            .getOcean()[squareCoordinates[0]][squareCoordinates[1]].setSquareStatus(SquareStatus.SUNK);
                    player.getEnemy().getPlayerBoard()
                            .getOcean()[squareCoordinates[0]][squareCoordinates[1]].setSquareStatus(SquareStatus.SUNK);
                }
            }
            //shootingPhase(player);
        }
        //next player turn
    }
    //TODO
//    public void changeStatusToSunk(Player player) {
//        for (Ship ship : player.getEnemy().()) {
//            if (!ship.isShipAlive()) {
//                ship.getShipSquares().forEach(s -> s.setSquareStatus(SquareStatus.SUNK));
//            }
//        }
//    }
//    public void changeStatusOnOcean(Player player){
//        player.getEnemy().getPlayerBoard().getOcean().
//    }
}

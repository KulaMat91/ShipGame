package org.example.ShipGame;

public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        player.getPlayerGameBoard().createEmptyField();
        player.getPlayerGameBoard().printTable();
        player.getPlayerGameBoard().deployShips(player.getShipsToDeploy());

    }
}

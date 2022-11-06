package org.example.ShipGame;

public class Game {
    private static Game game;

    public static Game runGame(){
        if (game == null){
            return new Game();
        }
        return game;
    }



}

package org.BattleShipGame;

import org.BattleShipGame.Display;

import java.util.Scanner;

public class Battleship {
    private Display display;
//    private Game game;
//    private Input input;

    public Battleship(){
        display = new Display();
    }

    public void start(){
        display.printStartLabel();
        playerMenuChoose();
    }

    public void exitGame(){
        display.printExitGameInformation();
        System.exit(0);
    }

    public void playerMenuChoose(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean exit = false;
//        input = new Input();

        while(!exit){
            display.printMenuOptions();

            System.out.println("Press number which you prefere: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println();
                    display.printMessage("You choose information about game...");
                    display.printInformationAboutGame();
                    break;
                case 2:
                    System.out.println();
                    display.printMessage("You choose to play the game...");
//                    game.game();
                    break;
                case 3:
                    System.out.println();
                    display.printMessage("You choose to exit the game...");
                    exitGame();
                    break;
                case 4:
                    System.out.println();
                    display.printMessage("You choose to information about authors...");
                    display.printInformationAboutAuthors();
                    break;
            }
        }

    }
}

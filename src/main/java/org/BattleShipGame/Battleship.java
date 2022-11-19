package org.BattleShipGame;

import org.BattleShipGame.Display;

import java.util.Scanner;
//TODO change class name
public class Battleship {

    public static void start(){
        Display.printStartLabel();
        playerMenuChoose();
    }

    public static void exitGame(){
        Display.printExitGameInformation();
        System.exit(0);
    }

    public static void playerMenuChoose(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean exit = false;
//        input = new Input();

        while(!exit){
            Display.printMenuOptions();

            System.out.println("Press number which you prefer: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println();
                    Display.printMessage("You choose information about game...");
                    Display.printInformationAboutGame();
                    break;
                case 2:
                    System.out.println();
                    Display.printMessage("You choose to play the game...");
//                    game.game();
                    break;
                case 3:
                    System.out.println();
                    Display.printMessage("You choose to exit the game...");
                    exitGame();
                    break;
                case 4:
                    System.out.println();
                    Display.printMessage("You choose to information about authors...");
                    Display.printInformationAboutAuthors();
                    break;
            }
        }

    }
}

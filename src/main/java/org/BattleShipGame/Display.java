package org.BattleShipGame;

import org.BattleShipGame.Square.SquareStatus;

public class Display {


    public static void printStartLabel() {
        System.out.println();
        System.out.println("\t\tHELLO IN BATTLESHIP GAME!");
        System.out.println("\n" + "                          )___(\n" +
                "                           _______/__/_\n" +
                "                  ___     /===========|   ___\n" +
                " ____       __   [\\\\\\]___/____________|__[///]   __\n" +
                " \\   \\_____[\\\\]__/___________________________\\__[//]___\n" +
                "  \\40A                                BATTLESHIP GAME |\n" +
                "   \\                                                  /\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void printMenuOptions() {
        System.out.println();
        System.out.println("MENU: ");
        System.out.println("1 - Information about game");
        System.out.println("2 - Play game");
        System.out.println("3 - Exit game");
        System.out.println("4 - Information about game authors");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printExitGameInformation() {
        System.out.println("Thank you and see you next time!");
    }

    public static void printInformationAboutGame() {
        System.out.println();
        System.out.println("RULES:");
        System.out.println("The game is played on four grids, two for each player. The grids are typically square - " +
                "usually 10x10 - and the individual squares in the grid are identified by letter and number." +
                "On one grid the player arranges ships and records the shots by the opponent. On the other grid, " +
                "the player records their own shots.\n" +
                "\nBefore play begins, each player secretly arranges their ships on their primary grid. Each ship occupies" +
                " a number of consecutive squares on the grid, arranged either horizontally or vertically. The number of" +
                " squares for each ship is determined by the type of ship. The ships cannot overlap (i.e., only one ship " +
                "can occupy any given square in the grid). The types and numbers of ships allowed are the same for each " +
                "player. These may vary depending on the rules. The ships should be hidden from players sight and it's " +
                "not allowed to see each other's pieces. The game is a discovery game which players need to discover " +
                "their opponents ship positions.\n" +
                "\nAfter the ships have been positioned, the game proceeds in a series of rounds. In each round, each player " +
                "takes a turn to announce a target square in the opponent's grid which is to be shot at. The opponent " +
                "announces whether or not the square is occupied by a ship. If it is a \"hit\", the player who is hit " +
                "marks this on their own or \"ocean\" grid (with a red peg in the pegboard version). The attacking player " +
                "marks the hit or miss on their own \"tracking\" or \"target\" grid with a pencil marking in the paper " +
                "version of the game, or the appropriate color peg in the pegboard version (red for \"hit\", white " +
                "for \"miss\"), in order to build up a picture of the opponent's fleet.\n" +
                "\nWhen all of the squares of a ship have been hit, the ship's owner announces the sinking of the Carrier, " +
                "Submarine, Cruiser/Destroyer/Patrol Boat, or the titular Battleship. If all of a player's ships have " +
                "been sunk, the game is over and their opponent wins. If all ships of both players are sunk by the end " +
                "of the round, the game is a draw.");
    }

    public static void printBoard(Board board) {
        for (int i = 0; i < board.getBoardSize(); i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            System.out.print((char) (i + 65) + "  ");

        }
        for (int rows = 1; rows <= board.getBoardSize(); rows++) {
            System.out.printf("\n%2d  ", rows);
            for (int columns = 0; columns < board.getBoardSize(); columns++) {
                System.out.print(board.getOcean()[rows - 1][columns].getSquareStatus() + "  ");
            }
        }
    }

    public static void printInformationAboutAuthors() {
        System.out.println();
        System.out.println("AUTHORS: ");
        System.out.println("Marcin Majewski - Java Developer");
        System.out.println("Karol Piecuch - Java Developer");
        System.out.println("Mateusz Kulinski - Java Developer");
        System.out.println("Filip Sokolowski - Java Developer");
    }

    public static void playerTurnInformation(Player player) {
        System.out.printf("Now it's %s turn!\n", player.getName());
    }

    public static void shotResultInformation(SquareStatus squareStatus) {
        switch (squareStatus) {
            case HIT -> System.out.println("Ship has been hit!");
            case MISS -> System.out.println("You missed!");
            default -> System.out.println("Default message");
        }
    }

    public static void printSunkStatus() {
        System.out.println("You destroyed the ship!");
    }

    public static void printWinner(Player player) {
        System.out.printf("Player %s won the game!", player.getName());
    }


}

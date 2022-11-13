package org.BattleShipGame;

import org.BattleShipGame.Ship.ShipType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String message) {
        Display.printMessage(message);
        return scanner.next();
    }

    public static Integer getInt(String message) {
        Display.printMessage(message);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return getInt("Provided Value is incorrect, please try again: ");
        }
    }

    public static boolean verifyInput(String playerInput) {
        return playerInput.length() < 7 && playerInput.chars().filter(ch -> ch == ',').count() == 2;
    }

    private static Integer[] convertInputToCoordinates(String playerInput) throws IllegalArgumentException {
        Integer[] convertedInput = new Integer[3];
        String[] splitPlayerInput = playerInput.split(",");
        for (int i = 0; i < convertedInput.length; i++) {
            /*
            1.X coordinate (convert String that contains int to integer)
            2.Y coordinate (convert String that contains char to integer ex. A -> 0, B -> 1 etc.)
            3. Vertical/Horizontal alignment (V -> returns 0, H -> returns 1)
             */
            switch (i) {
                case 0:
                    if (checkFirstCoordinate(splitPlayerInput[i])) {
                        convertedInput[i] = Integer.parseInt(splitPlayerInput[i]) - 1;
                    } else {
                        throw new IllegalArgumentException();
                    }
                    break;
                case 1:
                    if (checkSecondCoordinate(splitPlayerInput[i])) {
                        convertedInput[i] = (int) splitPlayerInput[i].charAt(0) - 65;
                    } else {
                        throw new IllegalArgumentException();
                    }
                    break;
                case 2:
                    if (checkOrientation(splitPlayerInput[i])) {
                        convertedInput[i] = convertOrientationToInt(splitPlayerInput[i]);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    break;
                default:
                    Display.printMessage("Converted Array is longer than 3, which is not possible");
            }
        }
        return convertedInput;
    }

    private static boolean checkFirstCoordinate(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //try to convert String to char and check if it's in range : A -> 65... Z -> 90
    private static boolean checkSecondCoordinate(String string) {
        return Character.isLetter(string.charAt(0)) && (int) string.charAt(0) > 64 && (int) string.charAt(0) < 91;
    }

    private static boolean checkOrientation(String string) {
        return string.equals("H") || string.equals("V");
    }

    private static Integer convertOrientationToInt(String string) {
        return switch (string.toUpperCase()) {
            case "V" -> 0;
            default -> 1;
        };
    }

    public static Integer[] getCoordinates(ShipType shipType) {
        String coordinates = getString("\nInsert coordinates for " + shipType.toString() + " in (XX,Y,Orientation) format where: " +
                "\n- X is in 1-10 range" +
                "\n- Y is in A-J range" +
                "\n- Orienataion (H)orizontal, (V)ertical");
        if (verifyInput(coordinates)) {
            return convertInputToCoordinates(coordinates);
        }
        return null;
    }

    //TODO Get Shot coordinates XX,Y
    public static Integer[] getShotCoordinates(){
        return null;
    }
}

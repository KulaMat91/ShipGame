package Input;

import Display.*;

import java.util.Arrays;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private Display display = new Display();

    public String getString(String message) {
        display.printMessage(message);
        return scanner.next();
    }

    public Integer getInt(String message) {
        display.printMessage(message);
        return scanner.nextInt();
    }

    public void getUserMenuSelection(String message, String messageIfIncorrectInput) {
        switch (getInt(message)) {
            case 1 -> display.printInformationAboutGame();
            //case 2 -> game.startGame();
            case 3 -> display.printExitGameInformation();
            case 4 -> display.printInformationAboutAuthors();
            default -> display.printMessage(messageIfIncorrectInput);
        }
    }

    public boolean verifyInput(String playerInput) {
        return playerInput.length() < 7 && playerInput.chars().filter(ch -> ch == ',').count() == 2;
    }

    public Integer[] convertInputToCoordinates(String playerInput) throws IllegalArgumentException {
        Integer[] convertedInput = new Integer[3];
        String[] splitPlayerInput = playerInput.split(",");
        System.out.println(Arrays.toString(splitPlayerInput));
        for (int i = 0; i < convertedInput.length; i++) {
            /*
            1.X coordinate (convert String that contains int to integer)
            2.Y coordinate (convert String that contains char to integer ex. A -> 0, B -> 1 etc.)
            3. Vertical/Horizontal alignment (V -> returns 0, H -> returns 1)
             */
            switch (i) {
                case 0:
                    if (checkFirstCoordinate(splitPlayerInput[i])) {
                        convertedInput[i] = Integer.parseInt(splitPlayerInput[i]);
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
                    display.printMessage("Converted Array is longer than 3, which is not possible");
            }
        }
        return convertedInput;
    }

    private boolean checkFirstCoordinate(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //try to convert String to char and check if it's in range : A -> 65... Z -> 90
    private boolean checkSecondCoordinate(String string) {
        return Character.isLetter(string.charAt(0)) && (int) string.charAt(0) > 64 && (int) string.charAt(0) < 91;
    }

    private boolean checkOrientation(String string) {
        return string.equals("H") || string.equals("V");
    }

    private Integer convertOrientationToInt(String string) {
        return switch (string.toUpperCase()) {
            case "V" -> 0;
            default -> 1;
        };
    }
}

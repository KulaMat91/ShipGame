public class Main {
    public static void main(String[] args) {
        Integer width = 10;
        Integer height = 10;
        String[][] board = getCleanBoard(width, height);
        displayBoard(board);

    }

    public static String[][] getCleanBoard(Integer width, Integer height) {
        String[][] board = new String[height][width];

        for (Integer i = 0; i < board.length; i++) {
            for (Integer j = 0; j < board[i].length; j++) {
                board[i][j] = "#";
            }
        }

        return board;
    }
    public static void displayBoard(String[][] board) {
        System.out.print("  ");
        for (Integer i = 0; i < board[0].length; i++) {
            char letter = (char)(i + 65);
            System.out.printf("%2s",letter);
        }
        System.out.println();

        for (Integer i = 0; i < board.length; i++) {
            System.out.printf("%2d",i + 1);
            for (Integer j = 0; j < board[i].length; j++) {
                System.out.printf("%2s",board[i][j]);
            }
            System.out.println();
        }
    }
}

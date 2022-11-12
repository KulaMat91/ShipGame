import java.util.List;

public class Player {

    private Board board;
    private List<Ship> listOfShips;
    private int remainingShip = 0;


    public Player(List<Ship> listOfShips, Board board) {
        this.listOfShips = listOfShips;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public int numberOfSquaresOfShips(List<Ship> ships){
        int sumSquares = 0;
        for(Ship ship : ships){
            sumSquares += ship.getShipType().length;
        }
        return sumSquares;
    }

    public boolean handleShot(int x, int y){
        for(Ship ship : listOfShips){
            for(Square square : ship.getSquares()){
                if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.SHIP)){
                    square.setSquareStatus(SquareStatus.HIT);
                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    return true;
                } else if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.HIT)){
                    square.setSquareStatus(SquareStatus.HIT);
                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("It's already hit!");
                    return false;
                }
            }
        }
        board.getSquare(x,y).setSquareStatus(SquareStatus.MISSED);
        System.out.println("You missed!");
        return false;
    }

//    public void showPlayerBoard(Board playerBoard) {
//        playerBoard.showBoard;
//    }
//
//    public void showEnemyBoard(Board enemyBoard) {
//        enemyBoard.showBoard;
//    }
}